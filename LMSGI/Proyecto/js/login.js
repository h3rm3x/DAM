const nombreUsuario = document.getElementById("username");
const contrasena = document.getElementById("password");
const form = document.getElementsByTagName("form")[0];
const submitButton = document.getElementById("submit");
const errorMessage = document.getElementById("error-message");
const BASE_URL = window.location.hostname === "127.0.0.1" ? "" : "/Activitats_LMSGI_Alan";    
const registerLink = document.querySelector(".register-link a");
document.addEventListener("DOMContentLoaded", function () {

    // Añadir el atributo href al enlace de registro
    registerLink.href = `${BASE_URL}Register.html`;


    submitButton.addEventListener("click", (e) => {
        const usuario = nombreUsuario.value;
        const password = contrasena.value;

        e.preventDefault(); // Evitar el envío del formulario por defecto
        
        if (!usuario || !password) {
            errorMessage.textContent = "Por favor, completa todos los campos.";
            errorMessage.style.display = "block";
            
            e.preventDefault(); // Evitar el envío del formulario
        } else if (!login_valido(localStorage.getItem("usuarios"), usuario)) {
            console.log(localStorage.getItem("usuarios"));
            errorMessage.textContent = "Usuario o contraseña incorrectos.";
            errorMessage.style.display = "block";
            e.preventDefault(); // Evitar el envío del formulario
        } else {
            e.preventDefault(); // Evitar el envío del formulario
            errorMessage.style.display = "none";
            console.log("correcto");
            // Aquí puedes agregar la lógica para enviar el formulario
            errorMessage.textContent = "Inicio de sesión exitoso. Redirigiendo...";
            errorMessage.style.display = "block";
            errorMessage.style.color = "green";
            const usuarios = JSON.parse(localStorage.getItem("usuarios"));
            for (const value of usuarios) {
                if (value.nombre === usuario) {
                    const userData = { nombreUsuario: value.nombre, rol: value.rol };
                    localStorage.setItem("usuarioLogeado", JSON.stringify(userData));
                    break;
                }
            }
            setTimeout(() => {
                window.location.href = `${BASE_URL}../root/index.html`;
            }, 3000);
            
        }
    });

    function login_valido(usuarios, nombreUsuario) {
        let usr = "";
        let contrasena = "";
        usuarios = JSON.parse(usuarios) || [];
        if (!usuarios || usuarios.length === 0) {
            return false; // No hay usuarios registrados
        }
        for (const value of usuarios) {
            console.log(value);
            if (value.nombre === nombreUsuario) {
                usr = value.nombre;
                contrasena = value.contrasena;            
                console.log(nombreUsuario + " " + value.contrasena + " " + contrasena + " " + (contrasena === value.contrasena && usr === nombreUsuario));

                return true; // Usuario encontrado
            }  
            return usr === nombreUsuario && contrasena === value.contrasena;

        }
    }

});