const urlPalabrasEndpoint = 'http://localhost:3000/palabras';

cargarPalabras();

async function cargarPalabras() {
    try {
        const response = await fetch(urlPalabrasEndpoint);
        const palabras = await response.json();

        console.log(response);
        console.log(palabras);

    } catch (error) {
        console.error('Error al cargar las palabras:', error);
        document.getElementById('listado-palabras').innerHTML = '<p>Error al cargar las palabras.</p>';
        return;
    }   
}