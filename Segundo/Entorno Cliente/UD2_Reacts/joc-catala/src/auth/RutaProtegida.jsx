import { Navigate } from "react-router-dom";
import { useAuth } from "./AuthContext";

export default function RutaProtegida({ children }) {
    const { usuari, rol } = useAuth();

    if (!usuari) {
      return <Navigate to="/login" replace />;
    }

    if (rol && rol !== usuari.rol) {
      return <Navigate to="/" replace />;
    }
  return (
    children
  )
}
