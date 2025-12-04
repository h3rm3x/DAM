import { useEffect, useState } from 'react';
import './App.css'
import Carta from './components/Carta';

function App() {

  const [cartas, setCartas] = useState([]);
  const [turnos, setTurnos] = useState(0);
  const [eleccionUno, setEleccionUno] = useState(null);
  const [eleccionDos, setEleccionDos] = useState(null);
  const [deshabilitado, setDeshabilitado] = useState(false);

  const imagenesCartas = [
    {src: "/img/jokic.png", "encontrada": false},
    {src: "/img/Haliburton.png", "encontrada": false},
    {src: "/img/lebron.png", "encontrada": false},
    {src: "/img/kd.png", "encontrada": false},
    {src: "/img/curry.png", "encontrada": false},
    {src: "/img/luka.png", "encontrada": false}
  ]

  const barajar = () => {
    const cartasBarajadas = [...imagenesCartas, ...imagenesCartas]
      .sort(() => Math.random()-0.5)
      .map((carta) => ({...carta, id:Math.random()}));
    
    setCartas(cartasBarajadas);
    setTurnos(0);
  };

  const handleEleccion = (carta) => {
    console.log(carta);
    eleccionUno ? setEleccionDos(carta) : setEleccionUno(carta);
  }

  const resetear = () => {
    setEleccionUno(null);
    setEleccionDos(null);
    setTurnos(turnosPrevios => turnosPrevios + 1);
    setDeshabilitado(false);
  }

  useEffect(() => {
    if(eleccionUno && eleccionDos){
      setDeshabilitado(true);
      if(eleccionDos.src === eleccionUno.src){
        setCartas(cartasPrevias => {
          return cartasPrevias.map((carta) => {
            if(carta.src === eleccionUno.src){
              return {...carta, encontrada: true}
            }else {
              return carta;
            }
          });
        });
        resetear();
      } else {
        setTimeout(() => {
          resetear();
        },1000)
      }
    }
  }, [eleccionUno, eleccionDos]);


  return (
    <div className='App'>
      <h1>Memory App</h1>
      <button onClick={barajar}>Nueva Partida</button>

      <div><p>Turnos: {turnos}</p></div>
      <div className="grid-carta">
        {
          cartas.map((carta) => (
            <Carta 
              carta={carta}
              key={carta.id}
              handleEleccion={handleEleccion}
              volteada={carta===eleccionUno || carta===eleccionDos || carta.encontrada}
              deshabilitado={deshabilitado}
            />
          ))
        }
      </div>
      
    </div>
  )
}

export default App
