import './App.css'
import { Routes, Route, Navigate } from 'react-router-dom'
import Inici from './pages/Inici.jsx'
import Vocabulari from './pages/vocabulari/Vocabulari.jsx'
import Preguntes from './pages/preguntes/Preguntes.jsx'
import Menu from './components/Menu.jsx'
import Animals from './pages/vocabulari/Animals.jsx'
import Aliments from './pages/vocabulari/Aliments.jsx'
import Futbol from './pages/preguntes/Futbol.jsx'
import Geografia from './pages/preguntes/Geografia.jsx'
import AnimalDetall from './pages/vocabulari/AnimalDetall.jsx'
import RutaProtegida from './auth/RutaProtegida.jsx'
import Login from './pages/Login.jsx'
import PanelAdmin from './pages/PanelAdmin.jsx'
import Progress from './pages/Progress.jsx'


function App() {

  return (
    <div>
      <h1>Aprèn Català jugant</h1>
      

      <Menu />



      <Routes>
        <Route path="/admin" element={
          <RutaProtegida rol="admin">
            <PanelAdmin />
          </RutaProtegida>
        }></Route>
        <Route path="/" element={<Inici />} />
        <Route path="/vocabulari" element={
          <RutaProtegida>
            <Vocabulari />
          </RutaProtegida>
          } >
          <Route index element={<Navigate to="animals" replace />} />
          <Route path="animals" element={<Animals />} />
          <Route path="animals/:id" element={<AnimalDetall />} />
          <Route path='aliments' element={<Aliments />} />
        </Route>
        <Route path="/preguntes" element={<Preguntes />} >
          <Route path="futbol" element={<Futbol/>} />
          <Route path="geografia" element={<Geografia/>} />
        </Route>
        <Route path="/login" element={<Login />} />
        <Route path="/progress" element={
          <RutaProtegida>
            <Progress />
          </RutaProtegida>
        } />
      </Routes>
    </div>
  )
}

export default App
