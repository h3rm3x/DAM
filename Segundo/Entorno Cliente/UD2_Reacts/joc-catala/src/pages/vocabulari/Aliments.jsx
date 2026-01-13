import { useEffect, useState } from "react"
import { fetchVocabulariAnimals } from "../../data/fetchVocabulari";
export default function Aliments() {

  const [paraules, setParaules] = useState([]);
  const [carregant, setCarregant] = useState(true);

  useEffect(() => {
    fetchVocabulariAnimals(2).then((dades)=>{
      setParaules(dades);
      setCarregant(false);
    });
  }, []);
  if (carregant) {
    return <p>Carregant vocabulari...</p>
  }
  return (
    <div>
      <h3>Vocabulari d'Aliments</h3> 
      <ul>
        {paraules.map((paraula) => (
          <li key={paraula.id}> 
            <strong>{paraula.catala}</strong> - {paraula.castella}
          </li>
        ))}
      </ul>
    </div>
  )
}
