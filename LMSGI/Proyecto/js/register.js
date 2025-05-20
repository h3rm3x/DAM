const form = document.getElementsByTagName("form")[0];
const nombreUsuario = document.getElementById("username");
const contrasena = document.getElementById("password");
const confirmarContrasena = document.getElementById("confirm-password");
const submitButton = document.getElementById("submit");
const errorMessage = document.getElementById("error-message");
const birthdate = document.getElementById("birthdate");
const email = document.getElementById("email");

submitButton.addEventListener("click", (e) => {
    const usuario = nombreUsuario.value;
    const password = contrasena.value;
    const confirmarPassword = confirmarContrasena.value;
    const fechaNacimiento = new Date(birthdate.value);
    const edad = (new Date().getFullYear() - fechaNacimiento.getFullYear());
    const correoElectronico = email.value;
    e.preventDefault();
    if (!usuario || !password || !confirmarPassword || !fechaNacimiento || !correoElectronico) {
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
    } else if (usuario.length < 4 && !/^[a-z0-9]+$/.test(usuario)) {
        errorMessage.style.display = "block";
        errorMessage.textContent = "El nombre de usuario debe tener al menos 4 caracteres y tener al menos una letra y un número.";
    } else {
        errorMessage.style.display = "none";
        // Aquí puedes agregar la lógica para enviar el formulario
        form.submit();
    }
    
});

confirmarContrasena.addEventListener("blur", (e) => {
    const password = contrasena.value;
    const confirmarPassword = e.target.value;

    if (password !== confirmarPassword) {
        errorMessage.textContent = "Las contraseñas no coinciden.";
        errorMessage.style.display = "block";
    } else {
        errorMessage.style.display = "none";
    }
});