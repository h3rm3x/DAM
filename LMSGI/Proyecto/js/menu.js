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
    const loginButton = document.querySelector(".login-button");
    const logoutButton = document.querySelector(".logout-button");
    const articulosDataid = document.querySelectorAll("[data-id]");
    

    articulosDataid.forEach(function(articulo) {
        localStorage.setItem(articulo.dataset.id, ("articulo" + articulo.dataset.id));
    });
    

    // añadir el atributo href a los enlaces de la barra de navegación y a los enlaces de los articulos
    let i;
    for (i = 0; i < acb.length; i++) {
        acb[i].href = `${BASE_URL}../views/ACB.html`;
    }
    for (i = 0; i < euroliga.length; i++) {
        euroliga[i].href = `${BASE_URL}../views/Euroliga.html`;
    }
    for (i = 0; i < inicio.length; i++) {
        inicio[i].href = `${BASE_URL}../root/index.html`;
    }
    for (i = 0; i < articulos.length; i++) {
        articulos[i].href = `${BASE_URL}../views/Articulo.html`;
    }
    for (i = 0; i < nba.length; i++) {
        nba[i].href = `${BASE_URL}../views/NBA.html`;
    }

    // Evento para el botón de logout
    if (logoutButton) {
        logoutButton.addEventListener("click", function() {
            // Eliminar el usuario logueado del localStorage
            localStorage.removeItem("usuarioLogeado");
            // Redirigir al usuario a la página de inicio
            window.location.href = `${BASE_URL}../root/index.html`;
        });
    }
    
    // añadir evento click al boton de menu
    if (menuButton) {
        menuButton.addEventListener("click", function() {
            menu.classList.remove("menu-hidden");
            menu.classList.add("menu-visible");
        });
    }
    
    // añadir evento click al boton de cerrar menu
    if (closeButton) {
        closeButton.addEventListener("click", function() {
            menu.classList.remove("menu-visible");
            menu.classList.add("menu-hidden");
        });
    }
    
    // añadir evento click al boton de login
    if (loginButton) {
        loginButton.addEventListener("click", function() {
            window.open(`../views/login.html`);
        });
    }

    // Función para actualizar la visibilidad de los botones
    function actualizarBotonesUsuario() {
        const usuarioLogeado = localStorage.getItem("usuarioLogeado");
        
        if (usuarioLogeado) {
            try {
                const usuario = JSON.parse(usuarioLogeado);
                
                // Hay usuario logueado - mostrar logout, ocultar login
                if (loginButton) {
                    loginButton.style.display = "none";
                }
                if (logoutButton) {
                    logoutButton.style.display = "block";
                }
                
                // Mostrar admin solo si el usuario es admin
                if (admin) {
                    if (usuario && usuario.rol === "admin") {
                        admin.style.display = "block";
                    } else {
                        admin.style.display = "none";
                    }
                }
                
            } catch (error) {
                // Si hay error al parsear, limpiar localStorage y mostrar login
                console.error("Error al parsear usuario logueado:", error);
                localStorage.removeItem("usuarioLogeado");
                mostrarEstadoSinUsuario();
            }
        } else {
            // No hay usuario logueado
            mostrarEstadoSinUsuario();
        }
    }

    // Función para mostrar el estado cuando no hay usuario logueado
    function mostrarEstadoSinUsuario() {
        if (loginButton) {
            loginButton.style.display = "block";
        }
        if (logoutButton) {
            logoutButton.style.display = "none";
        }
        if (admin) {
            admin.style.display = "none";
        }
    }

    // Ejecutar la función al cargar la página
    actualizarBotonesUsuario();

    // Opcional: Escuchar cambios en localStorage para actualizar la UI automáticamente
    window.addEventListener('storage', function(e) {
        if (e.key === 'usuarioLogeado') {
            actualizarBotonesUsuario();
        }
    });
});