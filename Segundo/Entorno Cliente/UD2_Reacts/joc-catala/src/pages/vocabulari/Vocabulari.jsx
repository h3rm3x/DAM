import {NavLink, Outlet} from 'react-router-dom'

export default function Vocabulari() {
  return (
    <div>
        <h2>Jocs de Vocabulari</h2>
        <p>Selecciona un joc per aprendre nou vocabulari en català.</p>

        <nav className="sub-menu">
          <NavLink to="animals" className="sub-link">Animals</NavLink>
          <NavLink to="aliments" className="sub-link">Aliments</NavLink>
        </nav>

        <Outlet />
    </div>
  )
}
