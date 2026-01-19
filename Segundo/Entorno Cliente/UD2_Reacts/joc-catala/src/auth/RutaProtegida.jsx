import { Navigate } from "react-router-dom";
import { useAuth } from "./AuthProvider";

export default function RutaProtegida({ children }) {
    const { usuari } = useAuth();

    if (!usuari) {
        return <Navigate to="/login" replace />;
    }
  return (
    children
  )
}
