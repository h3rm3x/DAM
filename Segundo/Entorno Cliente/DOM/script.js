const parrafo = document.querySelector("body > div:nth-child(3) > p:nth-child(2)");
//console.log(parrafo);

const titulo = document.querySelector("body > h1");
//console.log(titulo);

const parrafos = document.querySelectorAll("p");
//console.log(parrafos);

parrafos.forEach(parrafo => {
    //console.log(parrafo);
});

const todosErrores = document.querySelectorAll(".error");

todosErrores.forEach(error => {
    //console.log(error);
});

const tituloPagina = document.getElementById("titulo-pagina");
//console.log(tituloPagina);

const errores = document.getElementsByClassName("error");
console.log(errores);
/* errores.forEach(error => {
    console.log(error);
}); */ // No funciona porque no es un array

const parrafos2 = document.getElementsByTagName("p");
console.log(parrafos2);

for (let i = 0; i < parrafos2.length; i++) {
    const p = parrafos2[i];
    console.log(p);
}
