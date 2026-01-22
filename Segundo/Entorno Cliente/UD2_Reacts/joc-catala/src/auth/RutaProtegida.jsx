import { Navigate } from "react-router-dom";
import { useAuth } from "./AuthContext";

export default function RutaProtegida({ children }) {
  const { usuari, carregant } = useAuth();
  if (carregant) {
    return <div>Carregant...</div>;
  }

  if (!usuari) {
    return <Navigate to="/login" replace />;
  }
  return children;
}
