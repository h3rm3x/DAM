import './Titulo.css';
export default function  Ttitulo({ titulo, subtitulo }) {
    return (
        // fragmentos
        <>
            <div className="titulo-componente">
                <h1 className="titulo">{titulo}</h1> 
                <br />
                <h2 className="subtitulo">{subtitulo}</h2>   
            </div>
        </>
    )
        
    
}