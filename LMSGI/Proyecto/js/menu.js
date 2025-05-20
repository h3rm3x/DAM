document.addEventListener("DOMContentLoaded", function() {
    const BASE_URL = window.location.hostname === "127.0.0.1"? "" : "/Activitats_LMSGI_Alan";
    const menuButton = document.getElementById("menu");
    const closeButton = document.getElementById("cerrar-menu");
    const menu = document.getElementById("lista-paginas");
    const nba = document.getElementById ("NBA")
    const acb = document.getElementById("ACB")
    const euroliga = document.getElementById("Euroliga")

    menuButton.addEventListener("click", function() {
        menu.classList.remove("menu-hidden");
        menu.classList.add("menu-visible");
    });

    closeButton.addEventListener("click", function() {
        menu.classList.remove("menu-visible");
        menu.classList.add("menu-hidden");
    });
});