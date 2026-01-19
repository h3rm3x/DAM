import { createContext, useContext, useState } from "react"
const AuthContext = createContext();

export default function AuthProvider({ children }) {

    const [usuari, setUsuari] = useState(null);

    function login() {
        setUsuari({ nom: "Alan" });
    }

    function logout() {
        setUsuari(null);
    }

  return (
    <div>
      <AuthContext.Provider value={{ usuari, login, logout}}>
        {children}
      </AuthContext.Provider>
    </div>
  )
}

export function useAuth() {
    return useContext(AuthContext);
}
