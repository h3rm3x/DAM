import './Carta.css';

export default function Carta({carta, handleEleccion, volteada, deshabilitado}) {

  const handleClick = () => {
    // Solo permitir click si no está deshabilitado y la carta no está volteada
    if(!deshabilitado && !volteada){
      handleEleccion(carta);
    }
  }

  return (
    <div className='carta'>
      <div className={volteada ? "volteada" : ""}>
        <img className="delante" src={carta.src} alt={carta.nombre} />
        <img className="detras" src="/img/logo_con_slogan.PNG" onClick={handleClick} alt="carta" />
      </div>
    </div>
  )
}
