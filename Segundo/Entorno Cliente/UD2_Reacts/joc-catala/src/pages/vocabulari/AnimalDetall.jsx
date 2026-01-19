import { useParams, useNavigate } from "react-router-dom"
import vocabulari from "../../data/vocabulari"
import { useEffect } from "react";

export default function AnimalDetall() {

    const { id } = useParams();

    const animal = vocabulari.find((a) => a.id === Number(id));

    const navigate = useNavigate();

    useEffect(() => {
        if (!animal) {
            navigate('/vocabulari/animals');
            return <Navigate to="/vocabulari/animals" replace />;
        }
    }, [])
    
    if (!animal) {
        return null;
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
