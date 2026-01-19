import { useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthProvider'

export default function Login() {

    const {login} = useAuth();
    const navigate = useNavigate();

    function handleLogin() {

    }

  return (
    <div>
      <h2>Login</h2>
      <p>Login super fake per accedir als minijocs</p>
      <button onClick={handleLogin}>Entrar</button>
    </div>
  )
}
