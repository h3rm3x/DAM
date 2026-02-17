import { useEffect, useState } from 'react';
import { obtenerPremios, guardarPremioGanado } from '../services/dbService';
import './Ruleta.css';

export default function Ruleta({ juego, puntuacion, onCerrar }) {
  const [premios, setPremios] = useState([]);
  const [girando, setGirando] = useState(false);
  const [premioGanado, setPremioGanado] = useState(null);
  const [rotacion, setRotacion] = useState(0);
  const [cargando, setCargando] = useState(true);

  // Cargar premios de la base de datos
  useEffect(() => {
    const cargarPremios = async () => {
      setCargando(true);
      const premiosDB = await obtenerPremios();
      setPremios(premiosDB);
      setCargando(false);
    };
    cargarPremios();
  }, []);

  // Girar la ruleta
  const girarRuleta = () => {
    if (girando || premios.length === 0) return;

    setGirando(true);
    setPremioGanado(null);

    // Seleccionar premio aleatorio
    const indiceGanador = Math.floor(Math.random() * premios.length);
    const premioSeleccionado = premios[indiceGanador];

    // Calcular rotación
    const angulosPorSeccion = 360 / premios.length;
    const anguloGanador = indiceGanador * angulosPorSeccion;
    const vueltasCompletas = 5; // 5 vueltas completas
    const rotacionFinal = vueltasCompletas * 360 + (360 - anguloGanador) + (angulosPorSeccion / 2);

    setRotacion(rotacionFinal);

    // Después de la animación, mostrar el premio
    setTimeout(async () => {
      setGirando(false);
      setPremioGanado(premioSeleccionado);
      
      // Guardar premio en la base de datos
      await guardarPremioGanado(premioSeleccionado, juego);
    }, 5000);
  };

  // Calcular el color de fondo para cada sección
  const obtenerColorSeccion = (index) => {
    const coloresDefault = [
      '#FFD700', '#FF6347', '#4CAF50', '#2196F3',
      '#9C27B0', '#FF9800', '#E91E63', '#00BCD4'
    ];
    return premios[index]?.color || coloresDefault[index % coloresDefault.length];
  };

  if (cargando) {
    return (
      <div className="ruleta-modal">
        <div className="ruleta-contenido">
          <div className="cargando">Cargando premios...</div>
        </div>
      </div>
    );
  }

  return (
    <div className="ruleta-modal">
      <div className="ruleta-contenido">
        <div className="ruleta-header">
          <h2>🎉 ¡Felicitaciones!</h2>
          <p className="felicitacion">
            ¡Has ganado el juego de {juego === 'memory' ? 'memoria' : 'palabras'}!
          </p>
          <p className="puntuacion">
            {juego === 'memory' ? `Turnos: ${puntuacion}` : `Errores: ${puntuacion}`}
          </p>
        </div>

        <div className="ruleta-seccion">
          <h3>🎰 Gira la Ruleta para tu Premio</h3>
          
          <div className="ruleta-container">
            <div className="flecha-indicador">▼</div>
            
            <div 
              className="ruleta"
              style={{
                transform: `rotate(${rotacion}deg)`,
                transition: girando ? 'transform 5s cubic-bezier(0.17, 0.67, 0.12, 0.99)' : 'none'
              }}
            >
              {premios.map((premio, index) => {
                const angulosPorSeccion = 360 / premios.length;
                const angulo = index * angulosPorSeccion;

                return (
                  <div
                    key={premio.id}
                    className="seccion-premio"
                    style={{
                      transform: `rotate(${angulo}deg)`,
                      backgroundColor: obtenerColorSeccion(index)
                    }}
                  >
                    <div className="contenido-premio" style={{ transform: `rotate(${angulosPorSeccion / 2}deg)` }}>
                      <div className="premio-texto">
                        {premio.tipo === 'cupon' ? '💰' : '🎁'}
                        <span className="premio-valor">
                          {premio.tipo === 'cupon' ? `${premio.valor}€` : `${premio.valor}%`}
                        </span>
                      </div>
                    </div>
                  </div>
                );
              })}
              
              <div className="centro-ruleta">
                <div className="circulo-centro"></div>
              </div>
            </div>
          </div>

          <button 
            className="btn-girar"
            onClick={girarRuleta}
            disabled={girando || premioGanado !== null}
          >
            {girando ? '⏳ Girando...' : premioGanado ? '🎉 Premio Ganado' : '🎰 Girar Ruleta'}
          </button>
        </div>

        {premioGanado && (
          <div className="premio-ganado-seccion">
            <div className="premio-ganado-card">
              <div className="premio-ganado-icono">
                {premioGanado.tipo === 'cupon' ? '💰' : '🎁'}
              </div>
              <h3>¡Has Ganado!</h3>
              <div className="premio-ganado-nombre">{premioGanado.nombre}</div>
              <p className="premio-ganado-descripcion">
                {premioGanado.tipo === 'cupon' 
                  ? `Cupón de descuento de ${premioGanado.valor}€` 
                  : `${premioGanado.valor}% de descuento en tu próxima compra`
                }
              </p>
              <div className="premio-ganado-codigo">
                Código: <strong>PROMO{Math.random().toString(36).substr(2, 8).toUpperCase()}</strong>
              </div>
            </div>
          </div>
        )}

        <div className="ruleta-acciones">
          <button className="btn-cerrar" onClick={onCerrar}>
            {premioGanado ? '✓ Aceptar y Continuar' : '✕ Cerrar'}
          </button>
        </div>
      </div>
    </div>
  );
}
