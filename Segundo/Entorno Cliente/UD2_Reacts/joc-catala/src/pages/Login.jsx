import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext'

export default function Login() {

    const {login, register} = useAuth();
    const navigate = useNavigate();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);

    async function handleLogin(e){
      e.preventDefault();

      try{
        await login (email, password);
        navigate('/vocabulari');
      }catch (err){
        setError('Error al iniciar sessió: ' + err.message);
      }
    }

    async function handleRegister(e){
      e.preventDefault();

      try{
        await register (email, password);
        navigate('/vocabulari');
      }catch (err){
        setError('Error al registrar-se: ' + err.message);
      }
    }

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
      <form action="">
        <input type="email" placeholder='email' value={email} onChange={e => setEmail(e.target.value)} />
        <input type="password" placeholder='password' value={password} onChange={e => setPassword(e.target.value)} />
        {error && <p style={{color: 'red'}}>{error}</p>}
        <button onClick={handleLogin}>Iniciar sessió</button>
        <button onClick={handleRegister}>Registrar-se</button>
      </form>
    </div>
  )
}
