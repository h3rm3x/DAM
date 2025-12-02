import './App.css'
import { useEffect, useState } from 'react'

function App() {

  const [cartas, setCartas] = useState([])
  const [intentos, setIntentos] = useState(0)
  const [eleccion1, setEleccion1] = useState(null)
  const [eleccion2, setEleccion2] = useState(null)

  const handleEleccion = (carta) => {
    console.log(carta)
    eleccion1 ? setEleccion2(carta) : setEleccion1(carta)
  }

  useEffect(() => {

  }, [])

  const imagenesCartas = [
    {src: "/img/jokic.png"},
    {src: "/img/Haliburton.png"},
    {src: "/img/lebron.png"},
    {src: "/img/kd.png"},
    {src: "/img/curry.png"},
    {src: "/img/luka.png"},
  ]

  const barajar = () => {
    const cartasBajadas = [...imagenesCartas, ...imagenesCartas]
      .sort(() => Math.random() - 0.5)
      .map((carta) => ({...carta, id: Math.random()*10}))
    setCartas(cartasBajadas)
  }


  return (
    <div className='App'>
      <h1>Memory App</h1>
      <button onClick={barajar}>Nueva Partida</button>
      <div className='grid-cartas'>
        {
          cartas.map((carta) => (
            <Carta key={carta.id} carta={carta} />
          ))
        }  
      </div>
    </div>
  )
}

export default App
