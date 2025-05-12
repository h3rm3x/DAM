// a) Selecciona la secció amb id "container" sense usar querySelector
const containerById = document.getElementById("container");

// b) Selecciona la secció amb id "container" amb querySelector
const containerByQuery = document.querySelector("#container");

// c) Selecciona tots els elements amb classe "second"
const seconds = document.querySelectorAll("li.second");

// d) Selecciona l'element amb classe "third" dins de la llista ordenada
const thirdInOl = document.querySelector("ol li.third");

// e) Afegeix el text "Hola!" al final de la secció amb id "container"
containerById.insertAdjacentText("beforeend", "Hola!");

// f) Afegeix la classe "main" al div amb classe "footer"
const footer = document.querySelector("div.footer");
footer.classList.add("main");

// g) Treu la classe "main" del div amb classe "footer"
footer.classList.remove("main");

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
