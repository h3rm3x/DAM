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
let partidas = localStorage.getItem("partidas") ? JSON.parse(localStorage.getItem("partidas")) : [];
let categoria = document.querySelector(".categoria").value || "informatica";
let adivinarPalabra = document.querySelector(".adivinar-palabra");
let letras = document.querySelectorAll(".letra");

// Funciones del juego
function manejarLetra(letra) {
    // Ignorar si ya fue intentada
    if (letrasAdivinadas.includes(letra)) return null;

    if (palabraSecreta.includes(letra)) {
        letrasAdivinadas.push(letra);
        actualizarPantalla();
        return true;
    } else {
        intentosRestantes--;
        actualizarPantalla();
        return false;
    }
}

function partidaGanada() {
    mensajeElemento.textContent = "¡Felicidades! Has ganado. Lo has completado en " + tiempoElemento.textContent.split(": ")[1];
    mensajeElemento.style.color = "green";
    clearInterval(tiempo);
    document.querySelectorAll(".letra").forEach(b => b.disabled = true);
    tiempoElemento.textContent = "Tiempo transcurrido: " + tiempoElemento.textContent.split(": ")[1];
    partidas.push({
        palabra: palabraSecreta,
        tiempo: tiempoElemento.textContent.split(": ")[1],
        errores: 6 - intentosRestantes,
        estado: "ganada"
    });
    localStorage.setItem("partidas", JSON.stringify(partidas));
}

function partidaPerdida() {
    mensajeElemento.textContent = `¡Has perdido! La palabra era: ${palabraSecreta}`;
    mensajeElemento.style.color = "red";
    document.querySelectorAll(".letra").forEach(boton => boton.disabled = true);
    clearInterval(tiempo);
    partidas.push({
        palabra: palabraSecreta,
        tiempo: tiempoElemento.textContent.split(": ")[1],
        errores: 6,
        estado: "perdida"
    });
    localStorage.setItem("partidas", JSON.stringify(partidas));
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
document.addEventListener("DOMContentLoaded", () => { // para asegurar que el DOM esté cargado
    // Inicializar el juego
    if (!localStorage.getItem("partidas")) {
        localStorage.setItem("partidas", JSON.stringify([]));
    }
    cargarPalabras(categoria);
    palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];
    letrasAdivinadas = [];
    intentosRestantes = 6;
    tiempoInicio = Date.now();
    tiempo = actualizarTiempo();

    actualizarPantalla();
    
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

    // Eventos
    letras.forEach(letra => {
        letra.addEventListener("click", (event) => {

            const letra = event.target.textContent.toLowerCase();
            const resultado = manejarLetra(letra);
            if (resultado === null) return; // ya intentada
            if (resultado === true) {
            event.target.classList.add("acertada");
            if (!palabraElemento.textContent.includes("_")) {
                partidaGanada();
            }
        } else {
            letra.classList.add("erronea");
            if (intentosRestantes <= 0) {
                partidaPerdida();
            }
        }
        });
    });

    categoria[0].addEventListener("change", (event) => {
        categoriaSeleccionada = event.target.value;
        cargarPalabras(categoriaSeleccionada);
        palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];
        letrasAdivinadas = [];
        intentosRestantes = 6;
        tiempoInicio = Date.now();
        clearInterval(tiempo);
        tiempoElemento.textContent = "Tiempo transcurrido: 00:00";
        tiempo = setInterval(() => { // Actualizar el tiempo transcurrido cada segundo
            const tiempoTranscurrido = Math.floor((Date.now() - tiempoInicio) / 1000);
            const horas = String(Math.floor(tiempoTranscurrido / 3600)).padStart(2, "0"); // horas teniendo en cuenta más de 3600 segundos
            const minutos = String(Math.floor((tiempoTranscurrido % 3600) / 60)).padStart(2, "0");  // minutos teniendo en cuenta más de 60 segundos
            const segundos = String(tiempoTranscurrido % 60).padStart(2, "0"); // segundos
            tiempoElemento.textContent = `Tiempo transcurrido: ${horas}:${minutos}:${segundos}`; // Formato HH:MM:SS
        }, 1000 );
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
                partidaGanada();
            } else {
                intentosRestantes--;
                actualizarPantalla();
                if (intentosRestantes <= 0) {
                    partidaPerdida();
                }
            }
            e.target.value = "";
        }

    });

}); // fin del DOMContentLoaded