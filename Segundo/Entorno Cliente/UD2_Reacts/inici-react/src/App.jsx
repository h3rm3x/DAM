// CHILDREN PROPS

import './App.css'
import { useState } from 'react'
import Ttitulo from './components/titulo';
import Modal from './components/Modal';
import ListaEventos from './components/ListaEventos';
const App = () => {
  const [eventos, setEventos] = useState([
    { titulo: 'Examen DWEC', id: 1 },
    { titulo: "Concurso Programa-Me", id: 2 },
    { titulo: "Puente de la Constitución", id: 3 },
  ]);

  const [mostrarEventos, setMostrarEventos] = useState(false);
  const subtitulo = "Todos los eventos para Desarrollo de Aplicaciones Web";
  const [mostrarModal, setMostrarModal] = useState(false);

  const handleClick = (id) => {
    // setEventos(eventos.filter(evento => {
    //   return evento.id !== id;
    // }));

    setEventos( (prevEventos) => {
      return prevEventos.filter(evento => evento.id !== id);
    });
  };
  console.log(mostrarModal)
  const handleCerrar = () => {
    setMostrarModal(false);
  };
  return (
    <div className="App">
      <Ttitulo titulo="Eventos de DAW" subtitulo={subtitulo} />


      {
        mostrarEventos ? <button onClick={() => setMostrarEventos(false)}>Ocultar Eventos</button> 
        : <button onClick={() => setMostrarEventos(true)}>Mostrar Eventos</button> 
      }

      {mostrarEventos &&  
        ListaEventos({eventos, handleClick})
      }
      <div>
        <button onClick={() => setMostrarModal(true)}>Mostrar Modal</button>
      </div>

      {
        mostrarModal && <Modal handleCerrar={handleCerrar} esExterno={true}>
        <h2>STEM Talks</h2>
        <p>No te lo pierdas!</p>
        </Modal>
      }
      
    </div>
  )
}

export default App
