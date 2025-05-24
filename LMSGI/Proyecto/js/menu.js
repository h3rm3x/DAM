document.addEventListener("DOMContentLoaded", function () {    
    const menuButton = document.getElementById("menu");
    const closeButton = document.getElementById("cerrar-menu");
    const menu = document.getElementById("lista-paginas");


    // añadir evento click al boton de menu
    menuButton.addEventListener("click", function() {
        menu.classList.remove("menu-hidden");
        menu.classList.add("menu-visible");
    });
    // añadir evento click al boton de cerrar menu
    closeButton.addEventListener("click", function() {
        menu.classList.remove("menu-visible");
        menu.classList.add("menu-hidden");
    });
    // añadr evento click al boton de login
    const loginButton = document.querySelector(".login-button");
    loginButton.addEventListener("click", function() {
        window.open(`./login.html`);
    });

});