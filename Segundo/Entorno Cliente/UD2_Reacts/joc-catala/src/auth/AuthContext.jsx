import { createContext, useContext, useState, useEffect } from "react"
import { login as firebaselogin, logout as firebaselogout, register as firebaseregister, listenAuthChange } from "../firebase/services/authService";
import { createUser, getUser } from "../firebase/services/userService";
import { use } from "react";
const AuthContext = createContext();

export default function AuthProvider({ children }) {

  const [usuari, setUsuari] = useState(null);
  const [carregant, setCarregant] = useState(true);

  useEffect(() => {
    const unsubscribe = listenAuthChange(async (firebaseUser) => {
      if (firebaseUser) {
        const userData = await getUser(firebaseUser.uid);
      

        if (!userData) {
          await createUser(firebaseUser.uid, firebaseUser.email);
        }
        setUsuari({uid: firebaseUser.uid, email: firebaseUser.email, rol: userData?.rol || "alumnat"});
      } else {
        setCarregant(null);
      }
      setCarregant(false);
    })
    return unsubscribe;
  }, []);

  return (
    <div>
      <AuthContext.Provider value={{ usuari, login, logout }}>
        {children}
      </AuthContext.Provider>
    </div>
  )
}

export function useAuth() {
  return useContext(AuthContext);
}
