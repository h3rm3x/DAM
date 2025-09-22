let frase = 'Esto es una frase de prueba para contar palabras y caracteres';
function mostrarFrase (frase){
    console.log(frase.length);
    let palabras = frase.split(" ");
    console.log(palabras.length);
    console.log(frase.toUpperCase());
}

mostrarFrase(frase);