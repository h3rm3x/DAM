document.addEventListener("DOMContentLoaded", function () {
    const BASE_URL = window.location.hostname === "127.0.0.1" ? "" : "/Activitats_LMSGI_Alan";
    const nba = document.getElementById("NBA");
    const acb = document.getElementById("ACB");
    const euroliga = document.getElementById("Euroliga");
    const inicio = document.getElementById("Inicio");
    const articulos = document.getElementsByClassName("articulo");

    // añadir el atibuto href a los enlaces de la barra de navegación
    nba.href = `${BASE_URL}NBA.html`;
    acb.href = `${BASE_URL}ACB.html`;
    euroliga.href = `${BASE_URL}Euroliga.html`;
    inicio.href = `${BASE_URL}HomePage.html`;
    // añadir el atibuto href a los enlaces de los articulos
    for (let i = 0; i < articulos.length; i++) {
        articulos[i].href = `${BASE_URL}Articulo.html`;
    }
});

