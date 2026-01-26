import { NavLink } from "react-router-dom";
import "./Menu.css";
import { useAuth } from "../auth/AuthContext";
export default function Menu() {
  const { usuari, logout } = useAuth();
  return (
    <nav className="menu">
      <ul>
        <li>
          <NavLink to="/" className="menu-link">
            {" "}
            Inici
          </NavLink>
        </li>
        <li>
          <NavLink to="/vocabulari" className="menu-link">
            Vocabulari{" "}
          </NavLink>
        </li>
        <li>
          <NavLink to="/preguntes" className="menu-link">
            Preguntes
          </NavLink>
        </li>
        <li>
          <NavLink to="/progress" className="menu-link">
            Progrés
          </NavLink>
        </li>
      </ul>
      {usuari ? <button onClick={logout}>Sortir</button> : null}
    </nav>
  );
}
