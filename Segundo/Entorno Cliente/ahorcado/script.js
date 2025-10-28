// Variables globales
const informatica = ["javascript", "html", "css", "programacion", "desarrollo", "frontend", "backend", "fullstack", "variable", "funcion", "objeto", "arreglo", "metodo", "clase", "herencia", "polimorfismo", "encapsulamiento", "abstraccion"];
const deportes = ["futbol", "baloncesto", "tenis", "voleibol", "natacion", "ciclismo", "atletismo", "golf", "rugby", "hockey", "boxeo", "esgrima", "karate", "judo", "taekwondo", "surf", "esqui", "snowboard"];
const animales = ["elefante", "jirafa", "tigre", "leon", "cebra", "rinoceronte", "hipopotamo", "cocodrilo", "serpiente", "camaleon", "delfin", "ballena", "tiburon", "pulpo", "medusa", "estrella", "cangrejo"];
const frutas = ["manzana", "banana", "naranja", "fresa", "kiwi", "mango", "piña", "cereza", "uva", "pera", "durazno", "ciruela", "melon", "sandia", "coco", "limon", "mandarina"];
const palabras = [];
let palabraSecreta = "";
let letrasAdivinadas = [];
let intentosRestantes = 6;
const palabraElemento = document.querySelector(".palabra");     
const intentosElemento = document.querySelector(".intentos");
const mensajeElemento = document.querySelector(".mensaje");
const tiempoElemento = document.querySelector(".tiempo");
let tiempoInicio;
let tiempo;
let tiempoIniciado = false;
let partidas = localStorage.getItem("partidas") ? JSON.parse(localStorage.getItem("partidas")) : []; // cargamos el historial de partidas desde localStorage, en caso que no exista inicializamos un array vacío
const categoriaSelect = document.querySelector(".categoria");
let categoria = categoriaSelect ? categoriaSelect.value : "informatica";
let categoriaSeleccionada = categoria;
let adivinarPalabra = document.querySelector(".adivinar-palabra");
let letras = document.querySelectorAll(".letra");
let btnReiniciar = document.querySelector(".reiniciar-juego");

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

function reiniciarJuego() {
    cargarPalabras(categoriaSeleccionada); // cargar palabras de la categoría seleccionada
    palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)]; // generamos la nueva palabra secreta
    // reiniciamos variables y el cronometro
    letrasAdivinadas = []; 
    intentosRestantes = 6;
    // do not start timer here: start only when the player clicks a letter
    clearInterval(tiempo);
    tiempoIniciado = false;
    tiempoElemento.textContent = "Tiempo transcurrido: 00:00:00";
    actualizarPantalla();
    letras.forEach(boton => { // habilitar todos los botones de letras y quitar clases de acierto/error
        boton.disabled = false;
        boton.classList.remove("acertada", "erronea");
    });
    mensajeElemento.textContent = "";

}

function partidaGanada() {
    mensajeElemento.textContent = "¡Felicidades! Has ganado. Lo has completado en " + tiempoElemento.textContent.split(": ")[1]; // mostrar mensaje de victoria con tiempo en verde
    mensajeElemento.style.color = "green";
    clearInterval(tiempo);
    document.querySelectorAll(".letra").forEach(b => b.disabled = true); // deshabilitar botones de letras
    tiempoElemento.textContent = "Tiempo transcurrido: " + tiempoElemento.textContent.split(": ")[1]; // mantener el tiempo final una vez ganada la partida 
    partidas.push({ // guardar partida en el historial
        palabra: palabraSecreta,
        tiempo: tiempoElemento.textContent.split(": ")[1],
        errores: 6 - intentosRestantes,
        estado: "ganada"
    });
    localStorage.setItem("partidas", JSON.stringify(partidas));
        setTimeout(() => {  // esperar 3 segundos antes de reiniciar el juego
        reiniciarJuego();
    }, 5000);

}

function partidaPerdida() {
    mensajeElemento.textContent = `¡Has perdido! La palabra era: ${palabraSecreta}`; // mostrar mensaje de derrota con la palabra correcta en rojo
    mensajeElemento.style.color = "red";
    document.querySelectorAll(".letra").forEach(boton => boton.disabled = true); // deshabilitar botones de letras
    clearInterval(tiempo); // detener el temporizador
    partidas.push({ // guardar partida en el historial
        palabra: palabraSecreta,
        tiempo: tiempoElemento.textContent.split(": ")[1],
        errores: 6,
        estado: "perdida"
    });
    localStorage.setItem("partidas", JSON.stringify(partidas));
    setTimeout(() => {  // esperar 5 segundos antes de reiniciar el juego
        reiniciarJuego();
    }, 5000);
}

function actualizarTiempo() {
    return setInterval(() => { // Actualizar el tiempo transcurrido cada segundo
        const tiempoTranscurrido = Math.floor((Date.now() - tiempoInicio) / 1000);
        const horas = String(Math.floor(tiempoTranscurrido / 3600)).padStart(2, "0"); // horas teniendo en cuenta más de 3600 segundos
        const minutos = String(Math.floor((tiempoTranscurrido % 3600) / 60)).padStart(2, "0"); // minutos teniendo en cuenta más de 60 segundos
        const segundos = String(tiempoTranscurrido % 60).padStart(2, "0"); // segundos
        tiempoElemento.textContent = `Tiempo transcurrido: ${horas}:${minutos}:${segundos}`; // Formato HH:MM:SS
    }, 1000); 
}

function cargarPalabras(categoria) {
    palabras.length = 0; // Limpiar el array de palabras
    switch (categoria) {
        case "informatica":
            palabras.push(...informatica);
            break;
        case "deportes":
            palabras.push(...deportes);
            break;
        case "animales":
            palabras.push(...animales);
            break;
        case "frutas":
            palabras.push(...frutas);
            break;
        default:
            palabras.push(...informatica);
    }
}

function actualizarPantalla() {
    // Mostrar la palabra con letras adivinadas y guiones bajos
    palabraElemento.textContent = palabraSecreta.split("").map(letra => (letrasAdivinadas.includes(letra) ? letra : "_")).join(" ");
    intentosElemento.textContent = `Le quedan ${intentosRestantes} intentos`;
    mensajeElemento.textContent = `Has cometido ${6 - intentosRestantes} errores`;
       
}

document.addEventListener("DOMContentLoaded", () => { // para asegurar que el DOM esté cargado
    // Inicializar el juego
    if (!localStorage.getItem("partidas")) {
        localStorage.setItem("partidas", JSON.stringify([]));
    }
    cargarPalabras(categoria);
    palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];
    letrasAdivinadas = [];
    intentosRestantes = 6;
    
    actualizarPantalla();
    
    
    // Eventos
    letras.forEach(btn => {
        btn.addEventListener("click", (event) => {
            // start the timer on the first valid click
            if (!tiempoIniciado && !event.target.disabled) {
                tiempoInicio = Date.now();
                tiempo = actualizarTiempo();
                tiempoIniciado = true;
            }
            const letraClickeada = event.target.textContent.toLowerCase();
            const resultado = manejarLetra(letraClickeada);
            if (resultado === true) { // letra acertada
                event.target.classList.add("acertada");
                if (!palabraElemento.textContent.includes("_")) { // si no quedan guiones bajos, se ha ganado
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
        cargarPalabras(categoriaSeleccionada);
    palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];
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
        });
    

    adivinarPalabra.addEventListener("keypress", (e) => {
        if (e.key === "Enter") {
            const intento = e.target.value.toLowerCase().trim();
            if (intento === palabraSecreta) {
                palabraElemento.textContent = palabraSecreta.split("").join(" ");
                partidaGanada();
            } else {
                intentosRestantes--;
                actualizarPantalla();
                if (intentosRestantes <= 0) {
                    partidaPerdida();
                }
            }
            e.target.value = "";
            e.preventDefault();
        }

    });
    
    btnReiniciar.addEventListener("click", (e) => {
        e.preventDefault();
        reiniciarJuego();
    });

}); // fin del DOMContentLoaded