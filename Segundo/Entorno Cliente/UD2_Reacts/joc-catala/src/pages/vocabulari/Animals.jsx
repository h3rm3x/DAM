import { useEffect, useState } from "react"
import { fetchVocabulariAnimals } from "../../data/fetchVocabulari";
import { Link, useSearchParams } from "react-router-dom";
import {useAuth} from "../../auth/AuthContext";
import { getProgresAnimals } from "../../firebase/services/progressServices";

export default function Animals() {

  const [paraules, setParaules] = useState([]);
  const [carregant, setCarregant] = useState(true);
  const [searchParams, setSearchParams] = useSearchParams();
  const { usuari } = useAuth();
  const [vistos, setVistos] = useState([]);
  const nivell = searchParams.get('nivell');

  useEffect(() => {
    fetchVocabulariAnimals().then((dades)=>{
      setParaules(dades);
      setCarregant(false);
    });
  }, []);

  useEffect(() => {
    async function carregarProgres() {
      if (usuari){
        const dades = await getProgresAnimals(usuari.uid);
        setVistos(dades);
      }
    }
    carregarProgres();
  }, [usuari]);
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
        {paraulesFiltrades.map((paraula) => {
          const jaVist = vistos.includes(paraula.id);
        
          return(
            <li key={paraula.id}> 
              <span>{jaVist ? "✓" : ""}</span>
              <Link to={`/vocabulari/animals/${paraula.id}`}>
                <strong>{paraula.catala}</strong>
              </Link>
            </li>
          )})
        }
      </ul>
        <h4>Filtrar per nivell</h4>
        <button onClick={() => filtrar('fàcil')}>Fàcil</button>
      <button onClick={() => filtrar('mitja')}>Mitja</button>
      <button onClick={() => filtrar('difícil')}>Difícil</button>
      <button onClick={() => setSearchParams({})}>Tots</button>
    </div>
  )
}
