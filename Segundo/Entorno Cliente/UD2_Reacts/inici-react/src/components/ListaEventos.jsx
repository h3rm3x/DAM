export default function ListaEventos({eventos, handleClick}) {
    return (
        eventos.map((evento, index) =>(
        <div key={evento.id}>
            <h2 >{index} - {evento.titulo}</h2>
          <button onClick={()=> handleClick(evento.id)}>Eliminar Evento</button>
        </div>
        ))
    )
}