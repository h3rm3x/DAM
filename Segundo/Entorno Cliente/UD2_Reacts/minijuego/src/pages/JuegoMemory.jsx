import { useEffect, useState } from 'react';
import Carta from '../components/Carta';
import { obtenerProductos } from '../services/dbService';
import './JuegoMemory.css';

export default function JuegoMemory({ onJuegoGanado }) {
  const [cartas, setCartas] = useState([]);
  const [turnos, setTurnos] = useState(0);
  const [eleccionUno, setEleccionUno] = useState(null);
  const [eleccionDos, setEleccionDos] = useState(null);
  const [deshabilitado, setDeshabilitado] = useState(false);
  const [productos, setProductos] = useState([]);
  const [cargando, setCargando] = useState(true);
  const [juegoIniciado, setJuegoIniciado] = useState(false);
  const [juegoFinalizado, setJuegoFinalizado] = useState(false);

  const normalizarSrcProducto = (imagen, id, index) => {
    if (typeof imagen === 'string' && imagen.trim() !== '') {
      if (imagen.startsWith('http://') || imagen.startsWith('https://')) {
        return imagen;
      }
      return imagen.startsWith('/') ? imagen : `/${imagen}`;
    }

    const fallbackId = Number.isFinite(Number(id)) ? Number(id) : index + 1;
    const imagenId = ((fallbackId - 1) % 8) + 1;
    return `/img/producto${imagenId}.jpg`;
  };

  // Cargar productos de la base de datos
  useEffect(() => {
    const cargarProductos = async () => {
      setCargando(true);
      const productosDB = await obtenerProductos();
      // Seleccionar solo 6 productos para el juego
      const productosSeleccionados = productosDB.slice(0, 6);
      setProductos(productosSeleccionados.map((p, index) => ({
        src: normalizarSrcProducto(p.imagen, p.id, index),
        nombre: p.nombre,
        encontrada: false
      })));
      setCargando(false);
    };
    cargarProductos();
  }, []);

  // Barajar las cartas
  const barajar = () => {
    const cartasBarajadas = [...productos, ...productos]
      .sort(() => Math.random() - 0.5)
      .map((carta) => ({ ...carta, id: Math.random() }));
    
    setCartas(cartasBarajadas);
    setTurnos(0);
    setEleccionUno(null);
    setEleccionDos(null);
    setJuegoIniciado(true);
    setJuegoFinalizado(false);
  };

  // Manejar la elección de una carta
  const handleEleccion = (carta) => {
    eleccionUno ? setEleccionDos(carta) : setEleccionUno(carta);
  };

  // Resetear las elecciones
  const resetear = () => {
    setEleccionUno(null);
    setEleccionDos(null);
    setTurnos(turnosPrevios => turnosPrevios + 1);
    setDeshabilitado(false);
  };

  // Verificar si el juego ha sido ganado
  useEffect(() => {
    if (!juegoFinalizado && cartas.length > 0 && cartas.every(carta => carta.encontrada)) {
      setJuegoFinalizado(true);
      setTimeout(() => {
        onJuegoGanado('memory', turnos);
      }, 500);
    }
  }, [cartas, juegoFinalizado, onJuegoGanado, turnos]);

  // Comparar las cartas seleccionadas
  useEffect(() => {
    if (eleccionUno && eleccionDos) {
      setDeshabilitado(true);
      // Verificar que sean cartas diferentes con la misma imagen
      if (eleccionDos.src === eleccionUno.src && eleccionUno.id !== eleccionDos.id) {
        setCartas(cartasPrevias => {
          return cartasPrevias.map((carta) => {
            if (carta.src === eleccionUno.src) {
              return { ...carta, encontrada: true };
            } else {
              return carta;
            }
          });
        });
        resetear();
      } else {
        setTimeout(() => {
          resetear();
        }, 1000);
      }
    }
  }, [eleccionUno, eleccionDos]);

  if (cargando) {
    return (
      <div className="juego-memory">
        <div className="cargando">Cargando productos...</div>
      </div>
    );
  }

  return (
    <div className="juego-memory">
      <div className="juego-header">
        <h2>Juego de Memoria - Productos</h2>
        <p className="descripcion">
          ¡Encuentra todos los pares de productos para ganar un premio!
        </p>
      </div>

      <div className="juego-controles">
        <button className="btn-juego" onClick={barajar}>
          {juegoIniciado ? '↻ Nueva Partida' : '▶ Comenzar Juego'}
        </button>
        {juegoIniciado && (
          <div className="turnos">
            <span className="turnos-label">Turnos:</span>
            <span className="turnos-numero">{turnos}</span>
          </div>
        )}
      </div>

      {cartas.length > 0 && (
        <div className="grid-carta">
          {cartas.map((carta) => (
            <Carta 
              carta={carta}
              key={carta.id}
              handleEleccion={handleEleccion}
              volteada={carta === eleccionUno || carta === eleccionDos || carta.encontrada}
              deshabilitado={deshabilitado}
            />
          ))}
        </div>
      )}

      {!juegoIniciado && cartas.length === 0 && (
        <div className="mensaje-inicio">
          <p>👆 Haz clic en "Comenzar Juego" para empezar</p>
        </div>
      )}
    </div>
  );
}
