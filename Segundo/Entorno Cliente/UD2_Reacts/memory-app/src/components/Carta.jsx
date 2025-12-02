import 'Carta.css'
export default function Carta(carta, handleEleccion) {
    const handleClick = () => {
        handleEleccion(carta)
    }
  return (
    <div className='carta' onClick={handleClick}>
        <div>
            <img className='delante' src={carta.src} />
            <img className='detras' src="/img/reverso.png" />
        </div>
    </div>
  )
}
