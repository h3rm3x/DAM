const contenedor = document.getElementById("contenedor");
console.log(contenedor);

const items = document.getElementsByClassName("elemento");
console.log(items);
console.log(items[0]);

const contenedor2 = document.querySelector("#contenedor");
console.log(contenedor2);

const items2 = document.querySelectorAll(".elemento");
console.log(items2);

const item = document.querySelector(".elemento");
console.log(item);

const ul = document.querySelector("ul");
console.log(ul.querySelectorAll(".elemento"));


console.log(document.getElementsByName("Ejemplo"));
console.log(document.getElementsByTagName("li"));

//Crear un elemento nuevo
var texto = "Elemnto 5";
var etiqueta = document.createElement("li");
var textoNodo = document.createTextNode(texto);
var nuevoElemento = etiqueta.appendChild(textoNodo);

console.log(etiqueta);