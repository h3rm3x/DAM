addEventListener("DOMContentLoaded", function() {
    const anadirElemento = document.getElementById("btn");

    anadirElemento.addEventListener("click",() => {
        const userInput = prompt("Por favor, introduce texto:");
        if (userInput) {
            const nuevoElemento = document.createElement("li")
            nuevoElemento.textContent = userInput;
            const lista = document.getElementById("lista");
            lista.appendChild(nuevoElemento);

        } else {
            alert("No se ha introducido texto.");
        }
    });

    const eliminarPrimerElemento = document.getElementById("btn2");
    eliminarPrimerElemento.addEventListener("click",() => {
        const lista = document.getElementById("lista");
        if (lista.firstElementChild) {
            lista.removeChild(lista.firstElementChild);
        } else {
            alert("No hay elementos para eliminar.");
        }
    });

    const eliminarUltimo = document.getElementById("btn3");
    eliminarUltimo.addEventListener("click",() => {
        const lista = document.getElementById("lista");
        if (lista.lastElementChild) {
            lista.removeChild(lista.lastElementChild);
        } else {
            alert("No hay elementos para eliminar.");
        }
    });

    
});