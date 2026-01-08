import {NavLink} from 'react-router-dom'
import './Menu.css'

export default function Menu() {
  return (
    <nav className='menu'>
      <ul>
        <li><NavLink to="/" className='menu-link'> Inici</NavLink></li>
        <li><NavLink to="/vocabulari" className='menu-link'>
          Vocabulari </NavLink></li>
        <li><NavLink to="/preguntes" className='menu-link'>
          Preguntes</NavLink></li>
      </ul>
    </nav>
  )
}
