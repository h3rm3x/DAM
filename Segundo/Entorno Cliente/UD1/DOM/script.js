let enlaces = document.getElementsByTagName("a");
let enlace5 = enlaces[4];
let miDiv = document.getElementById("miDiv");
let parrafos = document.getElementsByTagName("p");
let divP = document.getElementById("divP");
let creaP = document.getElementById("creaP");
let polar = divP.getElementsByTagName("p")[divP.getElementsByTagName("p").length - 1].getElementsByTagName("img")[0];
divP.insertBefore(parrafos[2], parrafos[1]);
let miP = document.getElementById("miP");

creaP.addEventListener("click", () => {
    if (polar.alt) {
        let texto = document.createTextNode(polar.alt);
        let elemento = document.createElement("div");
        let miEnlace = document.createElement("a");
        elemento.appendChild(miEnlace);
        polar.parentElement.appendChild(elemento);
        polar.parentElement.replaceChild(texto, polar);
        miP.style.color = "blue";
    }
    
});