document.addEventListener("DOMContentLoaded", function () {
    const BASE_URL = window.location.hostname === "127.0.0.1" ? "" : "/Activitats_LMSGI_Alan";
    const acb = document.getElementsByClassName("ACB");
    const euroliga = document.getElementsByClassName("Euroliga");
    const inicio = document.getElementsByClassName("Inicio");
    const articulos = document.getElementsByClassName("read-more");

    // añadir el atibuto href a los enlaces de la barra de navegación
    for (let i = 0; i < acb.length; i++) {
        acb[i].href = `${BASE_URL}ACB.html`;
    }
    for (let i = 0; i < euroliga.length; i++) {
        euroliga[i].href = `${BASE_URL}Euroliga.html`;
    }
    for (let i = 0; i < inicio.length; i++) {
        inicio[i].href = `${BASE_URL}HomePage.html`;
    }
    // añadir el atibuto href a los enlaces de los articulos
    for (let i = 0; i < articulos.length; i++) {
        articulos[i].href = `${BASE_URL}Articulo.html`;
    }
});

