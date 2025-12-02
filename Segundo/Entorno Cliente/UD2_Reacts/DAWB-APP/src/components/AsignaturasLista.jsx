import { useState } from 'react'
import './AsignaturasLista.css'
import { useFetch } from '../hooks/useFetch.jsx'

export default function AsignaturasLista() {
    // const [asignaturas, setAsignaturas] =  useState([])
    const [url, setUrl] = useState('http://localhost:3000/asignaturas')
    const [datos, cargando, error] = useFetch(url)
    
    // const fetchAsignaturas = useCallback(async () => {
    //   const response = await fetch(url);
    //  cre const json = await response.json();
    //   setAsignaturas(json);
    // }, [url]);
    // useEffect(() => {
    //   fetchAsignaturas();
    // }, [fetchAsignaturas]) // el array es una rray de dependencias, en el que especificaremos cuando queremos que se ejecute el codigo
    // // console.log("Asignaturas: ", asignaturas)
  return (
    <div className='asignaturas-lista'>
      <h2>Listado de Asignaturas</h2>
      {cargando && <div>Cargando Asignaturas...</div>}
      {error && <div className="error">{error}</div>}
      <ul>
        {datos && datos.map((asignatura) => (
            <li key={asignatura.id}>
                <h3>{asignatura.nombre}</h3>
                <p>Horas totales: {asignatura["horas-totales"]}</p>
            </li>
        ))}
      </ul>
      <div className='filtros'>
        <button onClick={() => setUrl('http://localhost:3000/asignaturas?idioma=Inglés')}>Ingles</button>
        <button onClick={() => setUrl('http://localhost:3000/asignaturas')}>Todos</button>
      </div>
    </div>
  )
}
