import { useState, useEffect} from 'react'

export const useFetch = (url) => {

    const [datos, setDatos] =  useState(null);
    useEffect(() => {
        const fetchDatos = async () => {
            const response = await fetch(url);
            const json = await response.json();
            setDatos(json);
        };
        fetchDatos();
    }, [url]);
    return datos;
}

