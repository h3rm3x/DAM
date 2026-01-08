import './App.css'
import { Routes, Route } from 'react-router-dom'
import Inici from './pages/Inici.jsx'
import Vocabulari from './pages/Vocabulari.jsx'
import Preguntes from './pages/Preguntes.jsx'
import Menu from './components/Menu.jsx'

function App() {

  return (
    <div>
      <h1>Aprèn Català jugant</h1>
      

      <Menu />



      <Routes>
        <Route path="/" element={<Inici />} />
        <Route path="/vocabulari" element={<Vocabulari />} />
        <Route path="/preguntes" element={<Preguntes />} />
      </Routes>
    </div>
  )
}

export default App
