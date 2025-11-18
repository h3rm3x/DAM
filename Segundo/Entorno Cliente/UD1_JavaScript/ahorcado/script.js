// Variables globales
const enpointPalabras = "http://localhost:3000/palabras";
const debug = ["alan"];
const arrayPalabras = [];
let palabraSecreta = "";
let letrasAdivinadas = [];
let intentosRestantes = 6;
const palabraElemento = document.querySelector(".palabra");     
const intentosElemento = document.querySelector(".intentos");
const mensajeElemento = document.querySelector(".mensaje");
const tiempoElemento = document.querySelector(".tiempo");
const tiempoIntentoElemento = document.querySelector(".tiempo-intento");
let tiempoInicio;
let tiempo;
let tiempoIniciado = false;
let tiempoIntento;
let partidas; 
const categoriaSelect = document.querySelector(".categoria");
let categoria = categoriaSelect ? categoriaSelect.value : "informatica";
let categoriaSeleccionada = categoria;
let letras = document.querySelectorAll(".letra");
let btnReiniciar = document.querySelector(".reiniciar-juego");
let introduccion = document.querySelector(".introduccion");
let contenedorJuego = document.querySelector(".contenedor-juego");
let btnIniciar = document.querySelector(".iniciar-juego");
let InputNombreUsuario = document.querySelector(".nombre-usuario");
let nombreUsuario = "";
let usuarios = [];
let btnVerEstadisticas = document.querySelector(".ver-estadisticas");
let contenedorEstadisticas = document.querySelector(".estadisticas");
let btnCerrarEstadisticas = document.querySelector("#cerrar-estadisticas");


// Inicializar el juego
btnIniciar.addEventListener("click", (event) => {
    event.preventDefault();
    introduccion.style.display = "none";
    contenedorJuego.style.display = "flex";
    btnIniciar.style.display = "none";
    InputNombreUsuario.disabled = true;
    nombreUsuario = InputNombreUsuario.value;
});
if (!localStorage.getItem("partidas")) {
    localStorage.setItem("partidas", JSON.stringify({})); 
}
// Cargar partidas existentes como objeto/Map: { usuario: { timestamp: partidaObj } }
partidas = JSON.parse(localStorage.getItem("partidas")) || {};
// obtener lista de usuarios desde las claves del mapa `partidas`
usuarios = Object.keys(partidas || {});
// Cargar palabras (async). Después de cargar, seleccionar una palabra aleatoria.
cargarPalabras(categoria).then(() => {
    if (arrayPalabras.length > 0) {
        palabraSecreta = arrayPalabras[Math.floor(Math.random() * arrayPalabras.length)];
        palabraSecreta = palabraSecreta.toLowerCase();
    } else {
        palabraSecreta = "";
    }
    letrasAdivinadas = [];
    intentosRestantes = 6;
    actualizarPantalla();
}).catch(err => {
    console.error('Error al inicializar palabras:', err);
    palabraSecreta = "";
    letrasAdivinadas = [];
    intentosRestantes = 6;
    actualizarPantalla();
});




// Funciones del juego
function manejarLetra(letra) {

    if (palabraSecreta.includes(letra)) { // si la palabra secreta contiene la letra ponemos la letra en el array de letras adivinadas y actualizamos la pantalla
        letrasAdivinadas.push(letra);
        actualizarPantalla();
        return true;
    } else {
        intentosRestantes--;
        actualizarPantalla();
        return false;
    }
}

function verEstadisticas() {
    // función para ver estadísticas del juego (no implementada)
    const divPartidas = document.querySelector(".partidas");
    if (!divPartidas) return;
    divPartidas.textContent = "";

    let tiempoUltima = Infinity;
    let numeropartidas = 0;
    let mediaErrores = 0;
    let mediaTiempo = 0;
    let numGanadas = 0;
    let numPerdidas = 0;
    let mintiempo = Infinity;
    let partidaMasRapida = null; 
    let ultimapartida = "";
    let partidaMasPerfecta = null;
    // para cada usuario, listar sus partidas (timestamp -> datos) 
    usuarios.forEach(usuario => {
        const userPartidas = partidas[usuario] || {};
        const spanUsuario = document.createElement("span");
        divPartidas.appendChild(spanUsuario);
        spanUsuario.innerHTML += `<h3> Partidas de ${usuario}: </h3> `;
        Object.keys(userPartidas).forEach(ts => {
            const p = userPartidas[ts];
            const fechaPartida = new Date(parseInt(ts));
            const compararfecha = Date.now() - fechaPartida.getTime();
            // guardar última partida
            if (compararfecha < tiempoUltima) {
                ultimapartida = `\n <p> Ultima Partida: Palabra: ${p.palabra} | Tiempo: ${p.tiempo} | Errores: ${p.errores} | Estado: ${p.estado} | Fecha: ${new Date(p.fecha).toLocaleString()}</p>`;
                tiempoUltima = compararfecha;
            } 
            let PartesTiempo = p.tiempo.split(":").map(Number);
            let tiemposeg = PartesTiempo[0] * 3600 + PartesTiempo[1] * 60 + PartesTiempo[2];
            // guardar partida más perfecta (0 errores y menos tiempo)
            if (p.errores == 0 && tiemposeg < mintiempo){
                partidaMasPerfecta = `\n <p>Partida Mas Perfecta: Palabra: ${p.palabra} | Tiempo: ${p.tiempo} | Errores: ${p.errores} | Estado: ${p.estado} | Fecha: ${new Date(p.fecha).toLocaleString()}</p>`;
            }
            // guardar partida más rápida
            if (tiemposeg < mintiempo && p.estado == "ganada") {
                partidaMasRapida = `\n <p>Partida Mas Rapida: Palabra: ${p.palabra} | Tiempo: ${p.tiempo} | Errores: ${p.errores} | Estado: ${p.estado} | Fecha: ${new Date(p.fecha).toLocaleString()}</p>`;
                mintiempo = tiemposeg;
            }
            numeropartidas++;
            mediaErrores += p.errores;
            const tiempoParts = p.tiempo.split(":").map(Number);
            const tiempoSegundos = tiempoParts[0] * 3600 + tiempoParts[1] * 60 + tiempoParts[2];
            mediaTiempo += tiempoSegundos;
            if (p.estado === "ganada") numGanadas++;
            if (p.estado === "perdida") numPerdidas++;
        });
        // mostrar estadísticas del usuario
        spanUsuario.innerHTML += `\n <p>Número de partidas: ${numeropartidas}\n</p>`;
        spanUsuario.innerHTML += `<p>Media de errores: ${(mediaErrores / numeropartidas).toFixed(2)}</p>`;
        const mediaTiempoHoras = Math.floor((mediaTiempo / numeropartidas) / 3600);
        const mediaTiempoMinutos = Math.floor(((mediaTiempo / numeropartidas) % 3600) / 60);
        const mediaTiempoSegundos = Math.floor((mediaTiempo / numeropartidas) % 60);
        spanUsuario.innerHTML += `<p>Media de tiempo: ${String(mediaTiempoHoras).padStart(2, "0")}:${String(mediaTiempoMinutos).padStart(2, "0")}:${String(mediaTiempoSegundos).padStart(2, "0")}</p>`;
        spanUsuario.innerHTML += `<p>Partidas ganadas: ${numGanadas}</p>`;
        spanUsuario.innerHTML += `<p>Partidas perdidas: ${numPerdidas}</p>`;
        // si hay partida más perfecta, mostrarla
        if (partidaMasPerfecta) {
            spanUsuario.innerHTML += partidaMasPerfecta + "\n";
        } else {
            spanUsuario.innerHTML += "<p>No hay partida perfecta</p>\n";
        }
        spanUsuario.innerHTML += ultimapartida + "\n";
        spanUsuario.innerHTML += partidaMasRapida + "\n";
        // resetear contadores para el siguiente usuario
        tiempoUltima = Infinity;
        numeropartidas = 0;
        mediaErrores = 0;
        mediaTiempo = 0;
        numGanadas = 0;
        numPerdidas = 0;
        mintiempo = Infinity;
        partidaMasRapida = null;
        partidaMasPerfecta = null;
        divPartidas.innerHTML += "\n";
        //navUsuario.style.width = `calc(100% / ${usuarios.length} - 20px)`;
    });
}
async function reiniciarJuego() {
    await cargarPalabras(categoriaSeleccionada); // cargar palabras para la categoría seleccionada y luego elegir palabra
    palabraSecreta = arrayPalabras.length > 0 ? arrayPalabras[Math.floor(Math.random() * arrayPalabras.length)] : "";
    // reiniciamos variables y el cronometro
    letrasAdivinadas = []; 
    intentosRestantes = 6;
    // resetear el estado de los temporizadores
    // no los iniciamos hasta que se haga clic en una letra
    clearInterval(tiempo);
    tiempoIniciado = false;
    tiempoElemento.textContent = "Tiempo transcurrido: 00:00:00";
    clearInterval(tiempoIntento);
    tiempoIntentoElemento.textContent = "Tiempo en el intento actual: 10 segundos";
    actualizarPantalla();
    letras.forEach(boton => { // habilitar todos los botones de letras y quitar clases de acierto/error
        boton.disabled = false;
        boton.classList.remove("acertada", "erronea");
    });
    mensajeElemento.textContent = "";

}
// función para manejar las acciones al ganar la partida
function partidaGanada() {
    mensajeElemento.textContent = "¡Felicidades! Has ganado. Lo has completado en :" ; // mostrar mensaje de victoria con tiempo en verde
    mensajeElemento.style.color = "green";
    tiempoElemento.textContent = "Tiempo transcurrido: " + tiempoElemento.textContent.split(": ")[1]; // mantener el tiempo final una vez ganada la partida
    clearInterval(tiempo);
    clearInterval(tiempoIntento); // detener el temporizador del intento actual
    document.querySelectorAll(".letra").forEach(b => b.disabled = true); // deshabilitar botones de letras
    const entry = {
        palabra: palabraSecreta,
        nombreUsuario: nombreUsuario,
        tiempo: tiempoElemento.textContent.split(": ")[1],
        errores: 6 - intentosRestantes,
        estado: "ganada",
        fecha: new Date().toISOString()
    };
    // usar nombre de usuario como clave; si está vacío usar 'anon'
    const userKey = nombreUsuario && nombreUsuario.trim() ? nombreUsuario.trim() : 'anon';
    const timeKey = Date.now().toString();
    if (!partidas[userKey]) partidas[userKey] = {};
    partidas[userKey][timeKey] = entry;
    localStorage.setItem("partidas", JSON.stringify(partidas));
    setTimeout(() => {  // esperar 3 segundos antes de reiniciar el juego
        reiniciarJuego();
    }, 5000);

}

// función para manejar las acciones al perder la partida
function partidaPerdida() {
    mensajeElemento.textContent = `¡Has perdido! La palabra era: ${palabraSecreta}`; // mostrar mensaje de derrota con la palabra correcta en rojo
    mensajeElemento.style.color = "red";
    document.querySelectorAll(".letra").forEach(boton => boton.disabled = true); // deshabilitar botones de letras 
    tiempoElemento.textContent = "Tiempo transcurrido: " + tiempoElemento.textContent.split(": ")[1]; // mantener el tiempo final una vez perdida la partida
    clearInterval(tiempo); // detener el temporizador
    clearInterval(tiempoIntento); // detener el temporizador del intento actual
   
    const entry = {
        palabra: palabraSecreta,
        tiempo: tiempoElemento.textContent.split(": ")[1],
        errores: 6 - intentosRestantes,
        estado: "perdida",
        fecha: new Date().toISOString()
    };
    // usar nombre de usuario como clave; si está vacío usar 'anon'
    const userKey = nombreUsuario && nombreUsuario.trim() ? nombreUsuario.trim() : 'anon';
    const timeKey = Date.now().toString();
    if (!partidas[userKey]) partidas[userKey] = {};
    partidas[userKey][timeKey] = entry;
    localStorage.setItem("partidas", JSON.stringify(partidas));
    setTimeout(() => {  // esperar 5 segundos antes de reiniciar el juego
        reiniciarJuego();
    }, 5000);
}

// manejar el temporizador del juego
function actualizarTiempo() {
    return setInterval(() => { // Actualizar el tiempo transcurrido cada segundo
        const tiempoTranscurrido = Math.floor((Date.now() - tiempoInicio) / 1000);
        const horas = String(Math.floor(tiempoTranscurrido / 3600)).padStart(2, "0"); // horas teniendo en cuenta más de 3600 segundos
        const minutos = String(Math.floor((tiempoTranscurrido % 3600) / 60)).padStart(2, "0"); // minutos teniendo en cuenta más de 60 segundos
        const segundos = String(tiempoTranscurrido % 60).padStart(2, "0"); // segundos
        tiempoElemento.textContent = `Tiempo transcurrido: ${horas}:${minutos}:${segundos}`; // Formato HH:MM:SS
    }, 1000); 
}

// manejar el temporizador del intento actual
function actualizarTiempoIntento() {
    let tiempoIntento = 10;
    return setInterval(() => { // Actualizar el tiempo del intento actual cada segundo
        tiempoIntento --;
        tiempoIntentoElemento.textContent = `Tiempo en el intento actual: ${tiempoIntento} segundos`;
        if (tiempoIntento <= 0) {
            intentosRestantes--;
            actualizarPantalla();
            if (intentosRestantes <= 0) {
                partidaPerdida();
            }
            clearInterval(tiempoIntento);
            tiempoIntentoElemento.textContent = `Tiempo en el intento actual: 10 segundos`;
            tiempoIntento = 10;
        }
    }, 1000);
}

// cargar palabras desde el endpoint según la categoría seleccionada
async function cargarPalabras(categoria) {
    const animales= [];
    const deportes= [];
    const frutas= [];
    const informatica= [];
    const deportistas= [];
    try {
        const response = await fetch(enpointPalabras);
        const palabras = await response.json();
        
        if (palabras != null && palabras.length > 0) {
            palabras.forEach(p => {
                switch (p.categoria) {
                    case "informatica":
                        p.palabras.forEach(palabra => informatica.push(palabra.palabra));
                        break;
                    case "deportes":
                        p.palabras.forEach(palabra => deportes.push(palabra.palabra));
                        break;
                    case "animales":
                        p.palabras.forEach(palabra => animales.push(palabra.palabra));
                        break;
                    case "frutas":
                        p.palabras.forEach(palabra => frutas.push(palabra.palabra));
                        break;
                    case "deportistas":
                        p.palabras.forEach(palabra => deportistas.push(palabra.palabra));
                        break;
            }
        });
        } 
    }catch (error) {
        console.error('Error al cargar las palabras:', error);
        return;
    }   
    arrayPalabras.length = 0; // limpiar el array antes de cargar nuevas palabras
    switch (categoria) {
        case "informatica":
            arrayPalabras.push(...informatica);
            //console.log("informatica") DEBUGGING
            break;
        case "deportes":
            arrayPalabras.push(...deportes);
            //console.log("deportes") DEBUGGING
            break;
        case "animales":
            arrayPalabras.push(...animales);
            //  console.log("animales")  DEBUGGING
            break;
        case "frutas":
            arrayPalabras.push(...frutas);
            //console.log("frutas") DEBUGGING
            break;
        case "deportistas":
            arrayPalabras.push(...deportistas);
            break;
        default:
            arrayPalabras.push(...informatica);
    }

}
// funcion para actualizar los errores, intentos y palabra en pantalla
function actualizarPantalla() {
    const display = palabraSecreta ? palabraSecreta.split("").map(letra => (letrasAdivinadas.includes(letra) ? letra : "_")).join(" ") : "";
    if (palabraElemento) palabraElemento.textContent = display;
    if (intentosElemento) intentosElemento.textContent = `Le quedan ${intentosRestantes} intentos`;
    if (mensajeElemento) mensajeElemento.textContent = `Has cometido ${6 - intentosRestantes} errores`;
}

// Eventos

// manejar clics en las letras
letras.forEach(btn => {
    btn.addEventListener("click", (event) => {
        // iniciar el temporizador al hacer clic en la primera letra
        if (!tiempoIniciado && !event.target.disabled) {
            tiempoInicio = Date.now();
            tiempo = actualizarTiempo();
            tiempoIniciado = true;
        }
        clearInterval(tiempoIntento); // reiniciar el temporizador del intento actual
        tiempoIntento = actualizarTiempoIntento(); // iniciar el temporizador del intento actual
        const letraClickeada = event.target.textContent.toLowerCase();
        const resultado = manejarLetra(letraClickeada);
        if (resultado === true) { // letra acertada
            event.target.classList.add("acertada");
            if (palabraElemento && !palabraElemento.textContent.includes("_")) { // si no quedan guiones bajos, se ha ganado
                partidaGanada();
            }
        } else { // letra errónea
            event.target.classList.add("erronea");
            if (intentosRestantes <= 0) {
                partidaPerdida();
            }
        }
    });
});
    
    
categoriaSelect.addEventListener("change", (event) => {
    // actualizar la variable 'categoria' con el valor seleccionado
    categoria = event.target.value;
    categoriaSeleccionada = event.target.value;
    // cargar palabras y luego inicializar la nueva palabra
    cargarPalabras(categoriaSeleccionada).then(() => {
        palabraSecreta = arrayPalabras.length > 0 ? arrayPalabras[Math.floor(Math.random() * arrayPalabras.length)] : "";
        letrasAdivinadas = [];
        intentosRestantes = 6;
        // reset timer state - do not start until a letter is clicked
        clearInterval(tiempo);
        tiempoIniciado = false;
        tiempoElemento.textContent = "Tiempo transcurrido: 00:00:00";
        document.querySelectorAll(".letra").forEach(boton => {
            boton.disabled = false;
            boton.classList.remove("acertada", "erronea");
        });
        actualizarPantalla();
    }).catch(err => {
        console.error('Error al cambiar categoría:', err);
    });
});

// manejar el reinicio del juego
btnReiniciar.addEventListener("click", (e) => {
    e.preventDefault();
    reiniciarJuego();
});

// manejar la visualización de estadísticas
btnVerEstadisticas.addEventListener("click", (e) => {
    e.preventDefault();
    verEstadisticas();
    contenedorEstadisticas.style.display = "flex";

});

btnCerrarEstadisticas.addEventListener("click", (e) => {
    e.preventDefault();
    contenedorEstadisticas.style.display = "none";
});