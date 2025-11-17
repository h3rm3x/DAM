const nombres = ["Luke", "Obi-Wan", "Yoda", "Leia"];
const edades = [19, 57, 900, 18];
function Personaje(nombre, edad) { // constructor del objeto Personaje
    this.nombre = nombre;
    this.edad = edad;
}
let edad_total = 0;

for (let i = 0; i < nombres.length; i++) {  
    let personaje = new Personaje(nombres[i], edades[i]); // por cada index crea un nuevo objeto Personaje
    console.log(personaje); // muestra el objeto creado
    edad_total += personaje.edad; 
}
console.log("Edad total:", edad_total); // muestra la suma de todas las edades