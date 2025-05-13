const anadirTarea = document.getElementById("add-task");
const input = document.getElementById("task-input");
anadirTarea.addEventListener("click", () => {
  const userInput = input.value;
  if (userInput) {
    const nuevoElemento = document.createElement("li");
    nuevoElemento.textContent = userInput;
    const lista = document.getElementById("task-list");
    lista.appendChild(nuevoElemento);
    input.value = ""; // Limpiar el campo de entrada
  } else {
    alert("No se ha introducido texto.");
  }
});

const colorsSelect = document.getElementById("filter");

colorsSelect.addEventListener("change", cahangeColor);
function cahangeColor(e) {
  console.log(e.target.value);
}
