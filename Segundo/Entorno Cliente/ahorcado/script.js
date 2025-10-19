document.addEventListener("DOMContentLoaded", () => { // para asegurar que el DOM esté cargado
    // Variables globales
    const palabras = ["javascript", "html", "css", "programacion", "desarrollo", "frontend", "backend", "fullstack", "variable", "funcion", "objeto", "arreglo", "metodo", "clase", "herencia", "polimorfismo", "encapsulamiento", "abstraccion"];
    let palabraSecreta = "";
    let letrasAdivinadas = [];
    let intentosRestantes = 6;
    const palabraElemento = document.querySelector(".palabra");     
    const intentosElemento = document.querySelector(".intentos");
    const mensajeElemento = document.querySelector(".mensaje");
    const tiempoElemento = document.querySelector(".tiempo");
    let tiempoInicio;

    // Inicializar el juego
    palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];
    letrasAdivinadas = [];
    intentosRestantes = 6;
    tiempoInicio = Date.now();
    tiempo = setInterval(() => {
        const tiempoTranscurrido = Math.floor((Date.now() - tiempoInicio) / 1000);
        const horas = String(Math.floor(tiempoTranscurrido / 3600)).padStart(2, "0");
        const minutos = String(Math.floor((tiempoTranscurrido % 3600) / 60)).padStart(2, "0");
        const segundos = String(tiempoTranscurrido % 60).padStart(2, "0");
        tiempoElemento.textContent = `Tiempo transcurrido: ${horas}:${minutos}:${segundos}`;
    }, 1000);
    actualizarPantalla();
    

    function actualizarPantalla() {
    // Mostrar la palabra con letras adivinadas y guiones bajos
    palabraElemento.textContent = palabraSecreta.split("").map(letra => (letrasAdivinadas.includes(letra) ? letra : "_")).join(" ");
        intentosElemento.textContent = `Le quedan ${intentosRestantes} intentos`;
        mensajeElemento.textContent = `Has cometido ${6 - intentosRestantes} errores`;
       
    }

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

    // Eventos
    document.addEventListener("click", (event) => {
        if (event.target.classList && event.target.classList.contains("letra")) {
            const letra = event.target.textContent.toLowerCase();
            const resultado = manejarLetra(letra);
            if (resultado === null) return; // ya intentada
            if (resultado === true) {
                event.target.classList.add("acertada");
                if (!palabraElemento.textContent.includes("_")) {
                    mensajeElemento.textContent = "¡Felicidades! Has ganado.";
                    mensajeElemento.style.color = "green";
                    document.querySelectorAll(".letra").forEach(b => b.disabled = true);
                }
            } else {
                event.target.classList.add("erronea");
                if (intentosRestantes <= 0) {
                    mensajeElemento.textContent = `¡Has perdido! La palabra era: ${palabraSecreta}`;
                    mensajeElemento.style.color = "red";
                    document.querySelectorAll(".letra").forEach(boton => boton.disabled = true);
                }
            }
        }
    });




});