import { useEffect, useState } from "react"
import { fetchVocabulariAnimals } from "../../data/fetchVocabulari";
import { Link, useSearchParams } from "react-router-dom";
export default function Animals() {

  const [paraules, setParaules] = useState([]);
  const [carregant, setCarregant] = useState(true);
  const [searchParams, setSearchParams] = useSearchParams();
  const nivell = searchParams.get('nivell');

  useEffect(() => {
    fetchVocabulariAnimals().then((dades)=>{
      setParaules(dades);
      setCarregant(false);
    });
  }, []);
  if (carregant) {
    return <p>Carregant vocabulari...</p>
  }

  const paraulesFiltrades = nivell ? paraules.filter(paraula => paraula.nivell === nivell) : paraules;
  
  function filtrar(nivell) {
    setSearchParams({ nivell });
  }
  return (
    <div>
      <h3>Vocabulari d'Animals</h3> 
      <ul>
        {paraulesFiltrades.map((paraula) => (
          <li key={paraula.id}> 
            
            <Link to={`/vocabulari/animals/${paraula.id}`}>
              <strong>{paraula.catala}</strong>
            </Link>
          </li>
        ))}
      </ul>
      <h4>Filtrar per nivell</h4>
      <button onClick={() => filtrar('facil')}>Fàcil</button>
      <button onClick={() => filtrar('mitja')}>Mitja</button>
      <button onClick={() => filtrar('dificil')}>Dificil</button>
      <button onClick={() => setSearchParams({})}>Tots</button>
    </div>
  )
}
