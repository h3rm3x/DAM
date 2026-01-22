import { useParams, useNavigate } from "react-router-dom"
import vocabulari from "../../data/vocabulari"
import { useEffect } from "react";
import { guardarProgresAnimals } from "../../firebase/services/progressServices";
import { useAuth } from "../../auth/AuthContext";


export default function AnimalDetall() {

    const { id } = useParams();

    const animal = vocabulari.find((a) => a.id === Number(id));

    const navigate = useNavigate();
    const { usuari } = useAuth();

    useEffect(() => {
        if (usuari && animal) {
            guardarProgresAnimals(usuari.uid, animal.id);
        }
    }, [usuari, animal]);
    
    if (!animal) {
        return <p>Animal no trobat</p>;
    }
  return (
    <div>
        <h3>Fitxa de l'animal</h3>
        <p><strong>En Català:</strong> {animal.catala}</p>
        <p><strong>En Castellà:</strong> {animal.castella}</p>

        <button onClick={() => navigate('/vocabulari/animals')}>Tornar</button>
    </div>
    )
    }
