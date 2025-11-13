const urlPalabrasEndpoint = 'http://localhost:3000/palabras';
// cargar el conteniido segun la pagina en la que nos encontremos
const url = window.location.pathname;
if (url.includes('palabras.html')){
    cargarPalabras();
} else if (url.includes('palabras-edit.html')) {
    const parametros = new URLSearchParams(window.location.search);
    const parametrosID = parametros.get('id');
    if (parametrosID) {
        cargarPalabra(parametrosID);
    }

}

async function cargarPalabras() {
    try {
        const response = await fetch(urlPalabrasEndpoint);
        const palabras = await response.json();

        const listadoPalabras = document.getElementById('listado-palabras');
        if (palabras != null && palabras.length > 0) {
            listadoPalabras.innerHTML = palabras.map(palabra => `<div><p>${palabra.palabra} - Dificultad: ${palabra.dificultad}</p></div>
            <button class="editar" onclick="editarPalabra(${palabra.id})">Editar</button>
            <button class="eliminar" onclick="eliminarPalabra(${palabra.id})">Eliminar</button>
            `).join('');
        }else {
            listadoPalabras.innerHTML = '<p>No hay palabras disponibles.</p>';
        }

    } catch (error) {
        console.error('Error al cargar las palabras:', error);
        document.getElementById('listado-palabras').innerHTML = '<p>Error al cargar las palabras.</p>';
        return;
    }   
}

document.getElementById('palabras-form')?.addEventListener('submit', guardarPalabra);
async function guardarPalabra(e) {
    e.preventDefault();

    // Determinar si estamos añadiendo o editando
    let id = new URLSearchParams(window.location.search).get('id');
    const metodo = id ? 'PUT' : 'POST';
    const url = id ? `${urlPalabrasEndpoint}/${id}` : urlPalabrasEndpoint;
    const palabra = {
        id: 0,
        palabra: document.getElementById('palabra').value,
        dificultad: document.getElementById('dificultad').value
    };
    fetch(`${urlPalabrasEndpoint}`).then((response) => {
        response.json().then((datos) => {
            if (metodo === 'POST') {
                palabra.id =  + datos[datos.length - 1].id + 1;
                palabra.id+= ""; 
                console.log("añadiendo: " + palabra.id);
            } else {
                palabra.id = +palabra.id;
                palabra.id += "";
                console.log("Editando: " + palabra.id);
            } 
            return fetch(`${url}`, {
                method: metodo,
                body: JSON.stringify(palabra),
                headers: {
                    'Content-Type': 'application/json'
                }
            });
        }).then(() => { window.location.href = 'listado-palabras.html';
        }).catch((error) => { console.log("error al guardar la palabra: ", error); });
    });
}

function editarPalabra(id) {
    window.location.href = `palabras-edit.html?id=${id}`;
}

async function cargarPalabra(id) {
    fetch(urlPalabrasEndpoint).then((response)=> {
        response.json().then((datos) => {
            const palabra = datos.find(p => p.id == id);
            if (palabra) {
                document.getElementById('palabra').value = palabra.palabra;
                document.getElementById('dificultad').value = palabra.dificultad;
            }
        });
    }).catch((error) => { console.log("error al cargar la palabra: ", error); });
}

async function eliminarPalabra(id) {
    console.log("eliminando...");
    try {
        await fetch(`${urlPalabrasEndpoint}/${id}`, {method: 'DELETE'});
        cargarPalabras();
    } catch (error) {
        console.error('Error al eliminar la palabra:', error);  
        return;
    }
    
}

async function eliminarPalabra(id) {
    const urlDelete = `${urlPalabrasEndpoint}/${id}`;
    console.log("Eliminar " + urlDelete);
    fetch(urlDelete, { 
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        } })
    .then(response => { response.json(); })
    .then(() => cargarPalabras())
    .catch(error => console.error('Error al eliminar la palabra:', error));
}
