import { useEffect, useState } from "react";
import { useAuth } from "../auth/AuthContext";
import { getProgresAnimals } from "../firebase/services/progressServices";
import vocabulariAnimals from "../data/vocabulari";


export default function Progress() {
    const { user } = useAuth();
    const [vistos, setVistos] = useState([]);
    useEffect(() => {
    async function carregarProgres() {
      if (user){
        const dades = await getProgresAnimals(user.uid);
        setVistos(dades);
      }
    }
    carregarProgres();
  }, [user]);

  const total = vocabulariAnimals.length;
  const totalVistos = vistos.length;
  return (
    <div>
      <h2>Progrés</h2>
      <p>Animals vistos {totalVistos}/{total}</p>
      <ul>
        {vocabulariAnimals.map((animal) => {
            (
                <li key={animal.id}>
                {vistos.includes(animal.id) ? ("v" ) : ("")} {animal.catala}
                </li>
            )
        })}
      </ul>
    </div>
  )
}
