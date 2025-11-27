import { useState } from 'react';
import './EventoNuevoForm.css';

export default function EventoNuevoForm() {
    const [titulo, setTitulo] = useState();
    const [fecha, setFecha] = useState();
    const [ciudad, setCiudad] = useState();

    const resetForm = () => {
        setTitulo('')
        setFecha('')
    }

    const HandleSubmit = (e) =>{
        e.preventDefault()
        const evento = {
            titulo: titulo,
            fecha: fecha,
            id: Math.floor(Math.random() * 100000)
        }

        console.log(evento)
        resetForm()
    }
  return (
    <form className="evento-nuevo-form">
        <label>
            <span>Título del Evento:</span>
            <input type="text" onChange= {(e) => setTitulo(e.target.value)} />
        </label>
        <label>
            <span>Fecha del Evento:</span>
            <input type="date" onChange= {(e) => setFecha(e.target.value)} />
        </label>  
        <label>
            <span>Lugar del Evento:</span>
            <select onChange={(e)=> {
                setCiudad(e.target.value)
                
            }} value={ciudad}>
                <option value="Mahon">Mahon</option>
                <option value="Es Castell">Es Castell</option>
                <option value="Es Mercadal">Es Mercadal</option>
                <option value="Es Migjorn">Es Migjorn</option>
                <option value="Alaior">Alaior</option>
                <option value="Sant Lluís">Sant Lluís</option>
                <option value="Ciutadella">Ciutadella</option>
                <option value="Ferreries">Ferreries</option>
            </select>
        </label>  
        <button type="submit">Crear Evento</button>
        <p>Titulo: {titulo} -- Fecha: {fecha} -- Ciudad: {ciudad}</p>
        <p onClick={resetForm}></p>
    </form>
  )
}
