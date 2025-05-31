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

    submitButton.addEventListener("click", () => {
        const usuario = nombreUsuario.value;
        const password = contrasena.value;
        
        if (!usuario || !password) {
            errorMessage.textContent = "Por favor, completa todos los campos.";
            errorMessage.style.display = "block";
        } else if (!login_valido(localStorage.getItem("usuarios"), usuario)) {
            errorMessage.textContent = "Usuario o contraseña incorrectos.";
            errorMessage.style.display = "block";
        } else {
            errorMessage.style.display = "none";
            // Aquí puedes agregar la lógica para enviar el formulario
            errorMessage.textContent = "Inicio de sesión exitoso. Redirigiendo...";
            errorMessage.style.display = "block";
            errorMessage.style.color = "green";
            setTimeout(() => {
                window.location.href = `${BASE_URL}HomePage.html`;
            }, 3000);
            
        }
    });

    function login_valido(usuarios, nombreUsuario) {
        const usr = "";
        const contrasena = "";
        
        for (value of usuarios) {
            const index = usuarios.indexOf(value);
            if (value.nombre === nombreUsuario) {
                usr = value.nombre;
                contrasena = value.contrasena;
                value.login = true;
                usuarios[index] = value; // Actualizar el usuario en el array
                localStorage.setItem("usuarios", JSON.stringify(usuarios));
                break;
            }
        }

        return usr === nombreUsuario && contrasena === value.contrasena;
    }

});