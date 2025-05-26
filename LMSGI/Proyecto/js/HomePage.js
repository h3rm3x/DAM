document.addEventListener("DOMContentLoaded", function() {
    const BASE_URL = window.location.hostname === "127.0.0.1"? "" : "/Activitats_LMSGI_Alan";
    const nba = document.getElementById ("NBA")
    const acb = document.getElementById("ACB")
    const euroliga = document.getElementById("Euroliga")
    const readMore = document.getElementsByClassName("read-more")
    const admin = document.getElementById("admin");
    const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];
    
    // añadir el atibuto href a los enlaces de la barra de navegación
    nba.href = `${BASE_URL}NBA.html`;
    acb.href = `${BASE_URL}ACB.html`;
    euroliga.href = `${BASE_URL}Euroliga.html`;
    admin.href = `${BASE_URL}Admin.html`;

    for (value of usuarios) {
        if (value.login && value.rol === "admin") {
            // Si el usuario ha iniciado sesión, ocultar el enlace de admin

            admin.style.display = "block";
            break;
        } else {
            // Si no hay usuarios logueados, mostrar el enlace de admin
            admin.style.display = "none";
        }
    }
    
    // añadir el atibuto href a los enlaces de los articulos
    for (let i = 0; i < readMore.length; i++) {
        readMore[i].href = `${BASE_URL}Articulo.html`;
    }




});