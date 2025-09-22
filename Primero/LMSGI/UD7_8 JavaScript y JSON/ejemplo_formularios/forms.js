const form = document.getElementById("form");
const divformMessageError = document.getElementsByClassName("formMessageError");
const divformMessageSucces = document.querySelector(".formMessageSuccess");

// console.log(document.forms[0]);
// console.log(document.forms[0].nombre);
// console.log(form.nombre);
// console.log(form.nn);
// console.log(form.elements);



function checkRadio() {
    const radios = document.getElementsByName("colores");
    let color = "";
    for (let i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            color = radios[i].value;
        }
    }
    return color;
}

window.addEventListener("load", () => {
});

window.addEventListener("DOMContentLoaded", () => {
    document.addEventListener("keydown", (e) => {
        console.log(e.key);
        if (e.key === "Enter") {
            form.submit(e);
        }
    });
    form.addEventListener("submit", (e) => {
        e.preventDefault();
        console.log("enviado");

        const inputNombre = form.nombre.value;
        const inputColor = checkRadio();
        if(inputNombre && inputColor){
            divformMessageError[0].textContent = "";
            divformMessageSucces.textContent = `Formulario Enviado Correctamente. Nombre:`+inputNombre;
            form.reset();
        }else{
            e.preventDefault();
            divformMessageSucces.textContent = "";
            divformMessageError[0].textContent = `No puedes dejar campos vacios`;
            
        }

        form.reset();
    });
})