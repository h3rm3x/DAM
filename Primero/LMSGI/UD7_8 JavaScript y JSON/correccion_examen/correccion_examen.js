// ex 1
const persona = { nomEstudiant: "Anna", edat: 20}

const personas = [
    { nomEstudiant: "Joan", edat: 20 },
    { nomEstudiant: "Maria", edat: 22 }
]

personas.push(persona);
console.log(personas);

function buscarnombre (nombre) {
    for (let i = 0; i < personas.length; i++) {
        if (personas[i].nomEstudiant.toLocaleLowerCase === nombre.toLocaleLowerCase) {
            return personas[i];
        }

    };
}

// ex 2

document.getElementsByTagName("h1")[0].textContent = "Benvinguts al curs de JavaScript!";

const principal = document.getElementById("principal");
const h1 = document.querySelector("h1");
principal.appendChild(h1);

document.createElement("li");
const textNode = document.createTextNode("Nuevo elemento");
li.appendChild(textNode);
const lista = document.querySelector("#llista");
lista.appendChild(li);


const elemntosBorrar = document.getElementsByClassName("esborrar");
while (elemntosBorrar.length > 0) {
    elemntosBorrar[0].parentNode.removeChild(elemntosBorrar[0]);
}

const ultimoInput = document.querySelectorAll("input");
const ultimoInput2 = document.querySelector("input:last-of-type");

// ex 3
const formulario = document.createElement("form");
formulario.innerHTML = `
    <input type="text" id="nombre" placeholder="Nombre">
    <select id="curso">
        <option value="javascript">JavaScript</option>
        <option value="python">Python</option>
        <option value="java">Java</option>
    </select>
    <label><input type="checkbox" value= " "</input></label>
    <label><input type="radio" name="modalidad" value="Presencial">Presencial</label>
    <label><input type="radio" name="modalidad" value="Online">Online</label>
    <button type="submit">Enviar</button>
`;
document.body.appendChild(formulario);

const nombreInput = document.getElementById("nombre");
nombreInput.addEventListener("blur", function() {
    if (nombreInput.value.length < 4) {
        alert("El campo nombre no puede estar vacío");
    }
}
);c

formulario.addEventListener("submit", function(event) {
    event.preventDefault(); // Evita el envío del formulario
    const datos ={
        nombre: document.getElementById("nombre").value,
        curso: document.getElementById("curso").value,
        modalidad: document.querySelector('input[name="modalidad"]:checked').value
    }
    

    console.log(datos);
});

