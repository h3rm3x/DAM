import './App.css'
import { Routes, Route } from 'react-router-dom'
import Inici from './pages/Inici.jsx'
import Vocabulari from './pages/vocabulari/Vocabulari.jsx'
import Preguntes from './pages/preguntes/Preguntes.jsx'
import Menu from './components/Menu.jsx'
import Animals from './pages/vocabulari/Animals.jsx'
import Aliments from './pages/vocabulari/Aliments.jsx'
import Futbol from './pages/preguntes/Futbol.jsx'
import Geografia from './pages/preguntes/Geografia.jsx'


function App() {

  return (
    <div>
      <h1>Aprèn Català jugant</h1>
      

      <Menu />



      <Routes>
        <Route path="/" element={<Inici />} />
        <Route path="/vocabulari" element={<Vocabulari />} >
          <Route path="animals" element={<Animals />} />
          <Route path='aliments' element={<Aliments />} />
        </Route>
        <Route path="/preguntes" element={<Preguntes />} >
          <Route path="futbol" element={<Futbol/>} />
          <Route path="geografia" element={<Geografia/>} />
        </Route>
      </Routes>
    </div>
  )
}

export default App
