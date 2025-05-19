const nombreUsuario = document.getElementById("username");
const contrasena = document.getElementById("password");
const form = document.getElementsByTagName("form")[0];
const submitButton = document.getElementById("submit");
const errorMessage = document.getElementById("error-message");

submitButton.addEventListener("click", () => {
    const usuario = nombreUsuario.value;
    const password = contrasena.value;
    
    if (!usuario || !password) {
        errorMessage.textContent = "Por favor, completa todos los campos.";
        errorMessage.style.display = "block";
    } else {
        errorMessage.style.display = "none";
        // Aquí puedes agregar la lógica para enviar el formulario
        form.submit();
    }
    // Aquí puedes agregar la lógica para enviar el formulario
});