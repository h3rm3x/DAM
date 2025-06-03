document.addEventListener("DOMContentLoaded", function () {    
    const menuButton = document.getElementById("menu");
    const closeButton = document.getElementById("cerrar-menu");
    const menu = document.getElementById("lista-paginas");
    const BASE_URL = window.location.hostname === "127.0.0.1" ? "" : "/Activitats_LMSGI_Alan";    
    const nba = document.getElementsByClassName("NBA");
    const acb = document.getElementsByClassName("ACB");
    const euroliga = document.getElementsByClassName("Euroliga");
    const inicio = document.getElementsByClassName("Inicio");
    const articulos = document.getElementsByClassName("read-more");
    const admin = document.getElementById("admin");
    const logoutButton = document.querySelector(".logout-button");

    // añadir el atibuto href a los enlaces de la barra de navegación y a los enlaces de los articulos
    let i;
    for (i= 0; i < acb.length; i++) {
        acb[i].href = `${BASE_URL}../views/ACB.html`;
    }
    for (i= 0; i < euroliga.length; i++) {
        euroliga[i].href = `${BASE_URL}../views/Euroliga.html`;
    }
    for (i= 0; i < inicio.length; i++) {
        inicio[i].href = `${BASE_URL}../root/index.html`;
    }
    for (i= 0; i < articulos.length; i++) {
        articulos[i].href = `${BASE_URL}../views/Articulo.html`;
    }
    for (i= 0; i < nba.length; i++) {
        nba[i].href = `${BASE_URL}../views/NBA.html`;
    }


    logoutButton.addEventListener("click", function() {
        // Eliminar el usuario logueado del localStorage
        localStorage.removeItem("usuarioLogeado");
        // Redirigir al usuario a la página de inicio
        window.location.href = `${BASE_URL}../root/index.html`;


    });
    
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
        window.open(`../views/login.html`);
    });

    if (localStorage.getItem("usuarioLogeado")) {
        
        const usuario = JSON.parse(localStorage.getItem("usuarioLogeado"));
        loginButton.style.display = "none"; // Ocultar el botón de login si hay un usuario logueado
        logoutButton.style.display = "block"; // Mostrar el botón de logout si hay un usuario logueado    
        // Si hay usuarios logueados, mostrar el enlace de admin
        if (usuario && usuario.rol === "admin") {
            admin.style.display = "block";
        } else {
            // Si no hay usuarios logueados, ocultar el enlace de admin
            admin.style.display = "none";
        }    
    } else  {            
        localStorage.removeItem("usuarioLogeado"); // Clear invalid data
        admin.style.display = "none";
        loginButton.style.display = "block"; // Mostrar el botón de login si no hay un usuario logueado
        logoutButton.style.display = "none"; // Ocultar el botón de logout si no hay un usuario logueado
    }
    

});

