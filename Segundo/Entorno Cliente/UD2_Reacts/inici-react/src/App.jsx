import './App.css'
// hooks
import { useState } from 'react'

const App = () => {
  const [eventos, setEventos] = useState([
    { titulo: 'Examen DWEC', id: 1 },
    { titulo: "Concurso Programa-Me", id: 2 },
    { titulo: "Puente de la Constitución", id: 3 },
  ]);

  const [mostrarEventos, setMostrarEventos] = useState(false);

  const handleClick = (id) => {
    // setEventos(eventos.filter(evento => {
    //   return evento.id !== id;
    // }));

    setEventos( (prevEventos) => {
      return prevEventos.filter(evento => evento.id !== id);
    });
  };
  return (
    <div className="App">
      <button onClick={() => setMostrarEventos(true)}>Mostrar Eventos</button>
      {mostrarEventos && eventos.map((evento, index) => 
        <div key={evento.id}>
          <h2 >{index} - {evento.titulo}</h2>
          <button onClick={()=> handleClick(evento.id)}>Eliminar Evento</button>
        </div>
      )}
    </div>
  )
}

export default App
