// const contenedor = document.getElementById("contenedor");
// console.log(contenedor);

// const items = document.getElementsByClassName("elemento");
// console.log(items);
// console.log(items[0]);

// const contenedor2 = document.querySelector("#contenedor");
// console.log(contenedor2);

// const items2 = document.querySelectorAll(".elemento");
// console.log(items2);

// const item = document.querySelector(".elemento");
// console.log(item);

//const ul = document.querySelector("ul");
//console.log(ul.querySelectorAll(".elemento"));


console.log(document.getElementsByName("Ejemplo"));
console.log(document.getElementsByTagName("li"));

//Crear un elemento nuevo
var texto = "Quinto Elemento";
var li = document.createElement("li");
var textNode = document.createTextNode(texto);
li.appendChild(textNode);
li.className="elemento";


console.log(li);

const ul = document.querySelector("ul");
ul.appendChild(li);

//insertar un elemento antes de otro
const header = document.createElement("header");
var textHeader = document.createTextNode("Hola");
header.appendChild(textHeader);

const h1 = document.querySelector("h1");
const padre = h1.parentNode;
console.log(padre);
padre.insertBefore(header, h1);
// remover un elemento
//padre.replaceChild(header, h1);


//eliminar un elemento (removeChild)
//header.removeChild(header.firstChild);
//header.removeChild(textHeader);
console.log(header.firstChild);


// crear un nuevo titulo en el header 
const h1_nuevo = document.createElement("h1");
h1_nuevo.innerHTML = "Nuevo Titulo";
//h1_nuevo.textContent = "Nuevo Titulo";
header.appendChild(h1_nuevo);

// eliminar el h1 original
h1.remove();

const a = document.querySelector("a");
a.href = "https://www.google.com";
a.target = "_blank";
// a.innerHTML = "Google";
a.textContent = "Google";

console.log(a.hasAttribute("class"));

li.style.color = "red";
li.style.backgroundColor = "blue";
li.style.fontSize = "24px";
li.style["font-family"] = "Arial";

const btn = document.getElementById("btn");
btn.addEventListener("click", () => {
    console.log("click");
});