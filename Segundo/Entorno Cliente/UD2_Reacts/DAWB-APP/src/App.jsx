import './App.css'
import AsignaturasLista from './components/AsignaturasLista'
import { useState } from 'react'
function App() {
  const [muestraAsignaturas, setMuestraAsignaturas] = useState(true)
  
  return (
    <div>
      <button onClick={() => setMuestraAsignaturas(false)}>Esconde asignaturas</button>
      <button onClick={() => setMuestraAsignaturas(true)}>Muestra asignaturas</button>
      {muestraAsignaturas && <AsignaturasLista />}
    </div>
  )
}

export default App
