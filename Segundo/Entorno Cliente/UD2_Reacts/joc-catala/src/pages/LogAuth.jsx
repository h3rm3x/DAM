import { useAuth } from '../auth/AuthContext'

export default function LogAuth() {
    const {usuari, logout} = useAuth();
  return (
    <div>
      {usuari && <button onClick={logout}>Logout</button>}
    </div>
  )
}
