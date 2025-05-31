const form = document.getElementsByTagName("form")[0];
const nombreUsuario = document.getElementById("username");
const contrasena = document.getElementById("password");
const confirmarContrasena = document.getElementById("confirm-password");
const submitButton = document.getElementById("submit");
const errorMessage = document.getElementById("error-message");
const birthdate = document.getElementById("birthdate");
const email = document.getElementById("email");
const confirmarCorreo = document.getElementById("confirm-email").value;

const rol = document.getElementById("rol").value;
const usuarios = JSON.parse(localStorage.getItem("usuario")) || [];
document.addEventListener("DOMContentLoaded", function() {
    if (!localStorage.getItem("usuarios")) {
        localStorage.setItem("usuarios", []);
    }
    
});

submitButton.addEventListener("click", (e) => {
    const usuarionombre = nombreUsuario.value;
    const password = contrasena.value;
    const confirmarPassword = confirmarContrasena.value;
    const fechaNacimiento = new Date(birthdate.value);
    const edad = (new Date().getFullYear() - fechaNacimiento.getFullYear());
    const correoElectronico = email.value;
    const rol = document.getElementById("rol").value;
    const usuario = {
        
        "nombre": usuarionombre,
        "contrasena": password,
        "fechaNacimiento": fechaNacimiento,
        "correoElectronico": correoElectronico,
        "rol": rol,
        "login": false
        
    }
    e.preventDefault();
    if (!usuarionombre || !password || !confirmarPassword || !fechaNacimiento || !correoElectronico) {
        errorMessage.textContent = "Por favor, completa todos los campos.";
        errorMessage.style.display = "block";
    } else if (password !== confirmarPassword) {
        errorMessage.textContent = "Las contraseñas no coinciden.";
        errorMessage.style.display = "block";
    } else if (edad < 14) {
        errorMessage.style.display = "block";
        errorMessage.textContent = "Debes tener al menos 14 años para registrarte.";
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(correoElectronico)) {
        errorMessage.style.display = "block";
        errorMessage.textContent = "Por favor, introduce un correo electrónico válido.";
    } else if ( !/^[a-z0-9]{8,}+$/.test(password)) {
        errorMessage.style.display = "block";
        errorMessage.textContent = "La contraseña debe tener al menos 8 caracteres y tener al menos una mayuscula y un número.";
    } else if (usuario.length < 4 && !/^[a-z0-9]+$/.test(usuarionombre)) {
        errorMessage.style.display = "block";
        errorMessage.textContent = "El nombre de usuario debe tener al menos 4 caracteres y tener al menos una letra y un número.";
    } else if (containsEmail(usuarios, correoElectronico)) {
        errorMessage.textContent = "El correo electrónico ya está registrado.";
        errorMessage.style.display = "block";
    }  else if (containsNombreUsuario(usuarios, usuarionombre)) {
        errorMessage.textContent = "El nombre de usuario ya está registrado.";
        errorMessage.style.display = "block";
    }  
    else {
        errorMessage.style.display = "none";
        // Aquí puedes agregar la lógica para enviar el formulario
        usuarios.push(usuario)
        localStorage.setItem("usuarios", JSON.stringify(usuarios));
        errorMessage.textContent = "El usuario ha sido registrado correctamente."
        errorMessage.style.display = "block";
        errorMessage.style.color = "green";
        
    }
    
});

confirmarContrasena.addEventListener("blur", (e) => {
    const password = contrasena.value;
    const confirmarPassword = e.target.value;

    if (password !== confirmarPassword) {
        errorMessage.textContent = "Las contraseñas no coinciden.";
        errorMessage.style.display = "block";
    } else if( password === confirmarPassword) {
        errorMessage.style.display = "none";
    }
});

confirmarCorreo.addEventListener("blur", (e) => {
    const correoElectronico = email.value;
    const confirmarCorreoElectronico = e.target.value;

    if (correoElectronico !== confirmarCorreoElectronico) {
        errorMessage.textContent = "Los correos electrónicos no coinciden.";
        errorMessage.style.display = "block";
    } else if (correoElectronico === confirmarCorreoElectronico) {
        errorMessage.style.display = "none";
    }
});

function containsEmail(array, value) {
    for (value of array) {
        if (value.correoElectronico === email.value) {
            return true;
        }
    }
}

function containsNombreUsuario(array, value) {
    for (value of array) {
        if (value.nombre === nombreUsuario.value) {
            return true;
        }
    }
    return false;
}
