const anadirTarea = document.getElementById("add-task");
const input = document.getElementById("task-input");
const lista = document.getElementById("task-list");
const filter = document.getElementById("filter");

// Función para añadir una nueva tarea
anadirTarea.addEventListener("click", () => {
  addNewTask();
});

// Permitir añadir tarea al presionar Enter en el input
input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    addNewTask();
  }
});

// Función para crear y añadir una nueva tarea
function addNewTask() {
  const userInput = input.value.trim();
  if (userInput) {
    // Crear el elemento li
    const nuevoElemento = document.createElement("li");
    
    // Añadir el texto de la tarea
    const textoTarea = document.createTextNode(userInput);
    nuevoElemento.appendChild(textoTarea);
    
    // Crear el botón eliminar
    const btnEliminar = document.createElement("button");
    btnEliminar.textContent = "Eliminar";
    
    // Añadir el botón al elemento li
    nuevoElemento.appendChild(btnEliminar);
    
    // Establecer la clase inicial a "pending"
    nuevoElemento.classList.add("pending");
    lista.appendChild(nuevoElemento);
    
    // Limpiar el campo de entrada
    input.value = "";
    
    // Listener para cambiar el estado de la tarea (completada/pendiente)
    nuevoElemento.addEventListener("click", (e) => {
      // Solo cambiar la clase si no se ha hecho clic en el botón eliminar
      if (e.target !== btnEliminar) {
        if (nuevoElemento.classList.contains("pending")) {
          nuevoElemento.classList.remove("pending");
          nuevoElemento.classList.add("completed");
        } else {
          nuevoElemento.classList.remove("completed");
          nuevoElemento.classList.add("pending");
        }
        applyFilter(); // Aplicar el filtro actual
      }
    });
    
    // Listener para eliminar la tarea
    btnEliminar.addEventListener("click", () => {
      lista.removeChild(nuevoElemento);
    });
    
    // Aplicar el filtro actual
    applyFilter();
  } else {
    alert("No se ha introducido texto.");
  }
}

// Función para aplicar el filtro seleccionado
function applyFilter() {
  const selectedFilter = filter.value;
  const items = lista.getElementsByTagName("li");
  
  for (let i = 0; i < items.length; i++) {
    switch (selectedFilter) {
      case "all":
        items[i].style.display = "flex";
        break;
      case "completed":
        if (items[i].classList.contains("completed")) {
          items[i].style.display = "flex";
        } else {
          items[i].style.display = "none";
        }
        break;
      case "pending":
        if (items[i].classList.contains("pending")) {
          items[i].style.display = "flex";
        } else {
          items[i].style.display = "none";
        }
        break;
    }
  }
}

// Listener para el cambio de filtro
filter.addEventListener("change", applyFilter);