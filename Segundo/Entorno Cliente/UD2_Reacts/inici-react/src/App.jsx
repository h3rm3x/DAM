import './App.css'

// HOOKS
// MÚLTIPLES COMPONENTES
// PROPS
// CHILDREN PROPS
// FUNCIONES COMO PROPS
import { useState } from 'react';
import Titulo from './components/titulo';
import Modal from './components/Modal';
import EventoNuevoForm from './components/EventoNuevoForm';
import ListaEventos from './components/ListaEventos';

const App = () => {

  /* const [nombre, setNombre] = useState('Josep'); */

  const [eventos, setEventos] = useState([]);

  const [mostrarEventos, setMostrarEventos] = useState(false);
  const [muestraModal, setMuestraModal] = useState(false);

  const addEvento = (evento) =>{
    setEventos((eventosPrevios) => {
      return [...eventosPrevios, evento];
    });

    setMuestraModal(false);
  }

  const subtitulo = "Todos los eventos para Desarrollo de Aplicaciones Web";

  const handleClick = (id) => {
    /* setNombre('Josep Falagán'); */

    /* setEventos(eventos.filter((evento) => {
      return id !== evento.id;
    })); */

    setEventos((eventosPrevios) => {
      return eventosPrevios.filter((evento) => {
        return id != evento.id;
      })
    });
  }

  const handleCerrar = () => {
    setMuestraModal(false);
  }



  return (
    <div className="App">
      {/* <h1>Mi nombre es {nombre}</h1> */}
      <Titulo titulo="Eventos de DAW" subtitulo={subtitulo}/>
      {!mostrarEventos && (
        <div>
          <button onClick={() => setMostrarEventos(true)}>Mostrar Eventos</button>
        </div>
      )}

      {mostrarEventos && (
        <div>
          <button onClick={() => setMostrarEventos(false)}>Ocultar Eventos</button>
        </div>
      )}
      {/* <button onClick={handleClick}>Cambiar nombre</button> */}
      {mostrarEventos && <ListaEventos eventos={eventos} handleClick={handleClick}></ListaEventos>}
      {muestraModal && <Modal handleCerrar={handleCerrar}>
          <EventoNuevoForm addEvento={addEvento}/>
        </Modal>
      }
      <div>
        <button onClick={() => setMuestraModal(true)}>Crear Nuevo Evento</button>
      </div>
    </div>
  )
}

export default App
