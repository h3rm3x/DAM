import { useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext'

export default function Login() {

    const {login} = useAuth();
    const navigate = useNavigate();

    //function handleLogin() {
      //login();
      //navigate('/vocabulari');
    //}
    function entrarComAlumnat() {
      login("alumnat");
      navigate('/vocabulari');
    }
    function entrarComAdmin() {
      login("admin");
      navigate('/vocabulari');
    }
    

  return (
    <div>
      <h2>Login</h2>
      <p>Login super fake per accedir als minijocs</p>
      <button onClick={entrarComAlumnat}>Entrar com Alumnat</button>
      <button onClick={entrarComAdmin}>Entrar com Admin</button>
    </div>
  )
}
