// Seleccionar los elementos del DOM
const contenedor = document.querySelector('.contenedor');
// Use all seats for stable indexing (so stored indices always map correctly)
const asientos = document.querySelectorAll('.fila .asiento');
const contador = document.getElementById('contador');
const total = document.getElementById('total');
const peliculaSelect = document.getElementById('peliculas');
let precioDelTicket = peliculaSelect.value;
let btnReservar = document.getElementById('btn-reservar');
// We'll persist occupied seats as indices in localStorage; no need for this initial NodeList
let asientosOcupados = document.querySelectorAll('.fila .asiento.ocupado');
llenarUI();

// FUNCIONES
function actualizaSeleccionAsientos(){
    const asientosSeleccionados = document.querySelectorAll('.fila .asiento.seleccionado');

    // haremos 3 cosas
    // 1. Copiar los asientos seleccionados en un array
    // 2. Mapear los datos a lo largo del array
    // 3. Devolver unos nuevos indices del array
    const asientosIndex = [...asientosSeleccionados].map((asiento )=>[...asientos].indexOf(asiento));

    localStorage.setItem('asientosSeleccionados', JSON.stringify(asientosIndex));
    const contadorAsientosSeleccionados = asientosSeleccionados.length;
    contador.innerText = contadorAsientosSeleccionados;
    total.innerText = contadorAsientosSeleccionados * precioDelTicket;

};

function guardarInfoPelicula(indicePelicula, precioPelicula){
    localStorage.setItem('indicePeliculaSeleccionada', indicePelicula);
    localStorage.setItem('precioPeliculaSeleccionada', precioPelicula);
}

function llenarUI(){
    // Restaurar asientos seleccionados (almacenados como índices)
    const asientosSeleccionados = JSON.parse(localStorage.getItem('asientosSeleccionados')) || [];
    if(asientosSeleccionados !== null && asientosSeleccionados.length > 0){
        asientosSeleccionados.forEach((index) => {
            if(asientos[index]){
                asientos[index].classList.add('seleccionado');
            }
        });
    }
    // Restaurar asientos ocupados (almacenados como índices)
    const asientosOcupadosLS = JSON.parse(localStorage.getItem('asientosOcupados')) || [];
    if(asientosOcupadosLS !== null && asientosOcupadosLS.length > 0){
        asientosOcupadosLS.forEach((index) => {
            if(asientos[index]){
                asientos[index].classList.add('ocupado');
            }
        });
    }
    const indicePeliculaSeleccionada = localStorage.getItem('indicePeliculaSeleccionada');
    if(indicePeliculaSeleccionada !== null){
        peliculaSelect.selectedIndex = indicePeliculaSeleccionada;
    }

    const precioPeliculaSeleccionada = localStorage.getItem('precioPeliculaSeleccionada');
    if(precioPeliculaSeleccionada !== null){
        peliculaSelect.value = precioPeliculaSeleccionada;
    }
    precioDelTicket = peliculaSelect.value;
    actualizaSeleccionAsientos();
}


// EVENTOS
// Evento para la selección de asientos
contenedor.addEventListener('click', (e)=>{
    if(e.target.classList.contains('asiento') && !e.target.classList.contains('ocupado')){
        e.target.classList.toggle('seleccionado');

        actualizaSeleccionAsientos();
    }
});

// Evento para la selección de películas
peliculaSelect.addEventListener('change', (e)=>{
    precioDelTicket = +e.target.value;
    guardarInfoPelicula(e.target.selectedIndex, e.target.value);
    actualizaSeleccionAsientos();
});

// Evento para el botón de reservar
btnReservar.addEventListener('click', ()=>{
    // Recuperar índices de asientos seleccionados (si no hay, salir)
    const asientosSeleccionados = JSON.parse(localStorage.getItem('asientosSeleccionados'));
    if(!asientosSeleccionados || asientosSeleccionados.length === 0) return;

    // Convertir índices en elementos DOM y marcar como ocupados
    asientosSeleccionados.forEach((index) => {
        const asientoElem = asientos[index];
        if(asientoElem){
            asientoElem.classList.remove('seleccionado');
            asientoElem.classList.add('ocupado');
        }
    });

    actualizaSeleccionAsientos();

    // Combinar con los ya ocupados en localStorage (almacenamos índices)
    const ocupadosLS = JSON.parse(localStorage.getItem('asientosOcupados')) || [];
    const nuevoOcupados = Array.from(new Set([...ocupadosLS, ...asientosSeleccionados]));
    localStorage.setItem('asientosOcupados', JSON.stringify(nuevoOcupados));
    localStorage.removeItem('asientosSeleccionados');

});

    


