// a) Selecciona la secció amb id "container" sense usar querySelector
const containerById = document.getElementById("container");
console.log(containerById);

// b) Selecciona la secció amb id "container" amb querySelector
const containerByQuery = document.querySelector("#container");
console.log(containerByQuery);
// c) Selecciona tots els elements amb classe "second"
const seconds = document.querySelectorAll("li.second");
console.log(seconds);

// d) Selecciona l'element amb classe "third" dins de la llista ordenada
const thirdInOl = document.querySelector("ol li.third");
console.log(thirdInOl);

// e) Afegeix el text "Hola!" al final de la secció amb id "container"
containerById.innerHTML += "Hola!";
console.log(containerById.innerHTML);
console.log(containerById);

// f) Afegeix la classe "main" al div amb classe "footer"
const footer = document.querySelector("div.footer");
footer.classList.add("main");
console.log(footer.classList);  

// g) Treu la classe "main" del div amb classe "footer"
footer.classList.remove("main");
console.log(footer.classList);

// h) Crea un nou element li
const newLi = document.createElement("li");

// i) Dona-li el text "four"
newLi.textContent = "four";

// j) Afegeix l’element li a l'element ul
const ul = document.querySelector("ul");
ul.appendChild(newLi);

// k) Dona un color de fons verd a tots els elements de la llista ordenada
const olItems = document.querySelectorAll("ol li");
olItems.forEach(item => {
  item.style.backgroundColor = "green";
});

// l) Elimina el div amb classe "footer"
footer.remove();
