import { useState } from 'react';
import './App.css';
import JuegoMemory from './pages/JuegoMemory';
import JuegoPalabras from './pages/JuegoPalabras';
import Ruleta from './components/Ruleta';

function App() {
  const [vistaActual, setVistaActual] = useState('menu'); // 'menu', 'memory', 'palabras'
  const [mostrarRuleta, setMostrarRuleta] = useState(false);
  const [datosJuegoGanado, setDatosJuegoGanado] = useState(null);

  // Manejar cuando un juego es ganado
  const handleJuegoGanado = (juego, puntuacion) => {
    setDatosJuegoGanado({ juego, puntuacion });
    setMostrarRuleta(true);
  };

  // Cerrar ruleta y volver al menú
  const handleCerrarRuleta = () => {
    setMostrarRuleta(false);
    setDatosJuegoGanado(null);
    setVistaActual('menu');
  };

  // Renderizar el menu principal
  const renderMenu = () => (
    <div className="menu-principal">
      <div className="menu-header">
        <h1 className="titulo-principal">🎮 Minijuegos</h1>
        <p className="subtitulo">¡Juega y gana premios increíbles!</p>
      </div>

      <div className="menu-juegos">
        <div className="carta-juego" onClick={() => setVistaActual('memory')}>
          <div className="icono-juego">🎴</div>
          <h2>Juego de Memoria</h2>
          <p>Encuentra los pares de productos de nuestra tienda</p>
          <button className="btn-jugar">Jugar Ahora</button>
        </div>

        <div className="carta-juego" onClick={() => setVistaActual('palabras')}>
          <div className="icono-juego">📝</div>
          <h2>Juego de Palabras</h2>
          <p>Adivina la palabra antes de completar el dibujo</p>
          <button className="btn-jugar">Jugar Ahora</button>
        </div>
      </div>

      <div className="menu-info">
        <div className="info-card">
          <h3>🎁 ¿Cómo funciona?</h3>
          <ol>
            <li>Selecciona un minijuego</li>
            <li>Completa el desafío</li>
            <li>¡Gira la ruleta y gana premios!</li>
          </ol>
        </div>
      </div>
    </div>
  );

  return (
    <div className="App">
      {vistaActual === 'menu' && renderMenu()}
      
      {vistaActual === 'memory' && (
        <div className="juego-contenedor">
          <button className="btn-volver" onClick={() => setVistaActual('menu')}>
            ← Volver al Menú
          </button>
          <JuegoMemory onJuegoGanado={handleJuegoGanado} />
        </div>
      )}
      
      {vistaActual === 'palabras' && (
        <div className="juego-contenedor">
          <button className="btn-volver" onClick={() => setVistaActual('menu')}>
            ← Volver al Menú
          </button>
          <JuegoPalabras onJuegoGanado={handleJuegoGanado} />
        </div>
      )}

      {mostrarRuleta && datosJuegoGanado && (
        <Ruleta 
          juego={datosJuegoGanado.juego}
          puntuacion={datosJuegoGanado.puntuacion}
          onCerrar={handleCerrarRuleta}
        />
      )}
    </div>
  );
}

export default App;
