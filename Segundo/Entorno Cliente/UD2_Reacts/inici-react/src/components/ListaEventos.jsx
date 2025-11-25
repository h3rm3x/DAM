import estilos from './ListaEventos.module.css';
export default function ListaEventos({eventos, handleClick}) {
    return (
        eventos.map((evento, index) =>(
        <div key={evento.id} className={estilos.tarjeta}>
            <h2 >{index} - {evento.titulo}</h2>
          <button onClick={()=> handleClick(evento.id)}>Eliminar Evento</button>
        </div>
        ))
    )
}