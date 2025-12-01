import { useState, useEffect} from 'react'

export const useFetch = (url) => {

    const [datos, setDatos] =  useState(null);
    const [cargando, setCargando] = useState(false);
    const [error, setError] = useState(null);
    
    useEffect(() => {
        const fetchDatos = async () => {
            setCargando(true);
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw new Error(response.statusText);
                }
                const json = await response.json();
                setDatos(json);
                setError(null);
            } catch (error) {
                setCargando(false);
                setError("no se pudieron obtener los datos");
                console.log(error.message);
            }
            setCargando(false);
        };
        fetchDatos();
    }, [url]);
    return [datos, cargando, error];
}

