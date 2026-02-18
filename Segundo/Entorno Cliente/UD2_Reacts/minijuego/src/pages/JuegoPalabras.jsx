import { useEffect, useState } from 'react';
import { obtenerPalabras } from '../services/dbService';
import './JuegoPalabras.css';

export default function JuegoPalabras({ onJuegoGanado }) {
  const [palabras, setPalabras] = useState([]);
  const [palabraActual, setPalabraActual] = useState(null);
  const [letrasAdivinadas, setLetrasAdivinadas] = useState([]);
  const [intentosRestantes, setIntentosRestantes] = useState(6);
  const [juegoIniciado, setJuegoIniciado] = useState(false);
  const [cargando, setCargando] = useState(true);
  const [estadoJuego, setEstadoJuego] = useState('jugando'); // 'jugando', 'ganado', 'perdido'
  const [juegoFinalizado, setJuegoFinalizado] = useState(false);

  const abecedario = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'.split('');

  // Cargar palabras de la base de datos
  useEffect(() => {
    const cargarPalabras = async () => {
      setCargando(true);
      const palabrasDB = await obtenerPalabras();
      setPalabras(palabrasDB);
      setCargando(false);
    };
    cargarPalabras();
  }, []);

  // Iniciar nueva partida
  const nuevaPartida = () => {
    if (palabras.length === 0) return;
    
    const palabraAleatoria = palabras[Math.floor(Math.random() * palabras.length)];
    setPalabraActual(palabraAleatoria);
    setLetrasAdivinadas([]);
    setIntentosRestantes(6);
    setJuegoIniciado(true);
    setEstadoJuego('jugando');
    setJuegoFinalizado(false);
  };

  // Manejar selección de letra
  const handleLetraClick = (letra) => {
    if (letrasAdivinadas.includes(letra) || estadoJuego !== 'jugando') return;

    setLetrasAdivinadas([...letrasAdivinadas, letra]);

    // Verificar si la letra está en la palabra
    if (!palabraActual.palabra.includes(letra)) {
      setIntentosRestantes(intentosRestantes - 1);
    }
  };

  // Verificar si el juego ha sido ganado o perdido
  useEffect(() => {
    if (!palabraActual || !juegoIniciado) return;

    const palabraArray = palabraActual.palabra.split('');
    const palabraAdivinada = palabraArray.every(letra => letrasAdivinadas.includes(letra));

    if (palabraAdivinada && estadoJuego === 'jugando' && !juegoFinalizado) {
      setEstadoJuego('ganado');
      setJuegoFinalizado(true);
      setTimeout(() => {
        onJuegoGanado('palabras', 6 - intentosRestantes);
      }, 1000);
    } else if (intentosRestantes === 0 && estadoJuego === 'jugando') {
      setEstadoJuego('perdido');
    }
  }, [letrasAdivinadas, intentosRestantes, palabraActual, juegoIniciado, estadoJuego, juegoFinalizado, onJuegoGanado]);

  // Renderizar palabra con letras ocultas/mostradas
  const renderPalabra = () => {
    if (!palabraActual) return null;
    
    return palabraActual.palabra.split('').map((letra, index) => (
      <span key={index} className="letra-caja">
        {letrasAdivinadas.includes(letra) ? letra : '_'}
      </span>
    ));
  };

  // Dibujo del ahorcado
  const renderAhorcado = () => {
    const errores = 6 - intentosRestantes;
    const partes = [
      '0', // cabeza
      '|',  // cuerpo
      '/',  // brazo izquierdo
      '\\', // brazo derecho
      '/',  // pierna izquierda
      '\\', // pierna derecha
    ];

    return (
      <div className="ahorcado">
        <div className="horca">
          <div className="poste-superior"></div>
          <div className="poste-vertical"></div>
          <div className="base"></div>
          <div className="cuerda"></div>
          
          <div className="figura">
            {errores >= 1 && <div className="cabeza">{partes[0]}</div>}
            {errores >= 2 && <div className="cuerpo">{partes[1]}</div>}
            {errores >= 3 && <div className="brazo-izq">{partes[2]}</div>}
            {errores >= 4 && <div className="brazo-der">{partes[3]}</div>}
            {errores >= 5 && <div className="pierna-izq">{partes[4]}</div>}
            {errores >= 6 && <div className="pierna-der">{partes[5]}</div>}
          </div>
        </div>
      </div>
    );
  };

  if (cargando) {
    return (
      <div className="juego-palabras">
        <div className="cargando">Cargando palabras...</div>
      </div>
    );
  }

  return (
    <div className="juego-palabras">
      <div className="juego-header">
        <h2>📝 Juego de Palabras</h2>
        <p className="descripcion">
          ¡Adivina la palabra antes de que se complete el dibujo!
        </p>
      </div>

      <div className="juego-controles">
        <button className="btn-juego" onClick={nuevaPartida}>
          {juegoIniciado ? '↻ Nueva Palabra' : '▶ Comenzar Juego'}
        </button>
        {juegoIniciado && (
          <div className="intentos">
            <span className="intentos-label">Intentos restantes:</span>
            <span className="intentos-numero">{intentosRestantes}</span>
          </div>
        )}
      </div>

      {juegoIniciado && palabraActual && (
        <div className="juego-contenido">
          <div className="seccion-ahorcado">
            {renderAhorcado()}
          </div>

          <div className="seccion-palabra">
            <div className="pista">
              <strong>💡 Pista:</strong> {palabraActual.pista}
            </div>

            <div className="palabra-display">
              {renderPalabra()}
            </div>

            {estadoJuego === 'ganado' && (
              <div className="mensaje mensaje-ganado">
                🎉 ¡Felicitaciones! ¡Has adivinado la palabra!
              </div>
            )}

            {estadoJuego === 'perdido' && (
              <div className="mensaje mensaje-perdido">
                😢 Perdiste. La palabra era: <strong>{palabraActual.palabra}</strong>
              </div>
            )}

            <div className="teclado">
              {abecedario.map((letra) => (
                <button
                  key={letra}
                  className={`tecla ${letrasAdivinadas.includes(letra) ? 'usada' : ''} ${
                    letrasAdivinadas.includes(letra) && !palabraActual.palabra.includes(letra) 
                      ? 'incorrecta' 
                      : letrasAdivinadas.includes(letra) 
                      ? 'correcta' 
                      : ''
                  }`}
                  onClick={() => handleLetraClick(letra)}
                  disabled={letrasAdivinadas.includes(letra) || estadoJuego !== 'jugando'}
                >
                  {letra}
                </button>
              ))}
            </div>
          </div>
        </div>
      )}

      {!juegoIniciado && (
        <div className="mensaje-inicio">
          <p>👆 Haz clic en "Comenzar Juego" para empezar</p>
        </div>
      )}
    </div>
  );
}
