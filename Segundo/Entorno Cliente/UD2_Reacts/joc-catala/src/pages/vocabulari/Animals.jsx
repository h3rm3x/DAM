import { useEffect, useState } from "react"
import { fetchVocabulariAnimals } from "../../data/fetchVocabulari";
import { Link } from "react-router-dom";
export default function Animals() {

  const [paraules, setParaules] = useState([]);
  const [carregant, setCarregant] = useState(true);

  useEffect(() => {
    fetchVocabulariAnimals().then((dades)=>{
      setParaules(dades);
      setCarregant(false);
    });
  }, []);
  if (carregant) {
    return <p>Carregant vocabulari...</p>
  }
  return (
    <div>
      <h3>Vocabulari d'Animals</h3> 
      <ul>
        {paraules.map((paraula) => (
          <li key={paraula.id}> 
            
            <Link to={`/vocabulari/animals/${paraula.id}`}>
              <strong>{paraula.catala}</strong>
            </Link>
          </li>
        ))}
      </ul>
    </div>
  )
}
