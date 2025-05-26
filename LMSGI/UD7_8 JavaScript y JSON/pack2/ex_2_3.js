document.addEventListener("DOMContentLoaded", () => {
    const btnMostrar = document.getElementById("btnMostrar");
    const boton = document.getElementById("boton");
    const btnAceptar = document.getElementById("btnAceptar");
    const btnCancelar = document.getElementById("btnCancelar");

    const contenedor = document.getElementById("contenedor");

    // Mostrar el modal
    btnMostrar.addEventListener("click", () => {
        boton.classList.remove("hidden");
        boton.classList.add("visible");
        document.body.classList.add("modal-open");
        btnMostrar.classList.add("hidden");
        btnMostrar.classList.remove("visible");
        // eliminar mensaje anterior
        const mensajeAnterior = contenedor.querySelector(".confirmacion");
        if (mensajeAnterior) {
            contenedor.removeChild(mensajeAnterior);
        }
    });

    // Aceptar acción
    btnAceptar.addEventListener("click", () => {
        boton.classList.remove("visible");
        boton.classList.add("hidden");
        document.body.classList.remove("modal-open");
        btnMostrar.classList.remove("hidden");
        btnMostrar.classList.add("visible");
        
        

        // Mostrar mensaje en la página
        const mensaje = document.createElement("p");
        mensaje.textContent = "Has aceptado el mensaje.";
        mensaje.classList.add("confirmacion");
        contenedor.appendChild(mensaje);
    });

    // Cancelar acción
    btnCancelar.addEventListener("click", () => {
        boton.classList.remove("visible");
        boton.classList.add("hidden");
        document.body.classList.remove("modal-open");
        btnMostrar.classList.remove("hidden");
        btnMostrar.classList.add("visible");
    });
});