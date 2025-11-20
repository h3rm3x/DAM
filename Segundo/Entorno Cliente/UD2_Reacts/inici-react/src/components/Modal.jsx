import React from 'react'
import './Modal.css'

export default function Modal({children, handleCerrar}) {
  return (
    
    <div className="modal-fondo">
      <div className="modal">
        {children}
        <button onClick={handleCerrar}>Cerrar</button>
      </div>
    </div>
  )
}