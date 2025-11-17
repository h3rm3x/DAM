// comentarios
// comentarios de una sola línea

/* 
    comentarios
    en bloque
*/

//VARIABLES
// var, let, const
// var nombre = "Juan";
// let numero = 10;
// const PI = 3.141692;
// let gano = true;
/* console.log(typeof nombre, typeof numero, typeof PI, typeof gano);
console.log(nombre, numero, PI, gano);
*/


// CADENAS 
/* let nombre = "Alan";
let apellido = 'Rabinerson';
let cuento = "Cuando despertó, vio que el sol ya había salido.";
let tabulacion = "Hola \tMundo";
console.log(tabulacion);
let salto = "Hola \nMundo";
console.log(salto);
let entreComillas = "Hola \"Mundo\"";
console.log(entreComillas); */


// NUMEROS
/* let edad = 23;
let precio = 99.99;
let ayudArbitralesAlMadrid = Infinity; 
let RojasparaValverde = -Infinity;
console.log(typeof ayudArbitralesAlMadrid, typeof RojasparaValverde); */
// null: algo definido pero vacio o con valor nulo
/* let variableNula = null;
console.log(variableNula, typeof variableNula); 
let prueba;
console.log(prueba, typeof prueba); // undefined: algo que no fue definido

// NaN - valor pretebndidamente numerico que no es un numero
let noEsUnNumero = "hola" / 2;
console.log(noEsUnNumero, typeof noEsUnNumero); */

// BOOLEANOS
/* let messi = true; 
let penaldo = false;
console.log(messi, typeof messi);
console.log(penaldo, typeof penaldo);

// valores falsy
// null, "", NaN, undefined 

 */

// OPERADORES
// operadores aritmeticos --> operaciones matematicas
// suma: a + b
// resta: a - b
// multiplicacion: a * b
// division: a / b
// modulo: a % b
/* let a = 10;
let b = 2;
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b);
console.log(a % b); */
// operadores unarios
// incremento: a++ o ++a
// decremento: a-- o --a
/* let a = 10;
console.log(a++, ++a);
console.log(a--, --a); */
// operadores de asignacion
// suma y asgna a+=b --> a = a + b
// resta y asigna a-=b --> a = a - b
// multiplicacion y asigna a*=b --> a = a * b
// division y asigna a/=b --> a = a / b
// modulo y asigna a%=b --> a = a % b

// CAMBIO DE TIPO
// - : a  = - b

/* let a = "10";
console.log(typeof a);
a = parseInt(a); 
console.log(typeof a);

let b = "10.55";
b = parseFloat(b);
console.log(typeof b); */

// OPERADORES DE COMPARACION
/*
 <, >, <=, >=, ==, ===, !=, !==
*/
/* 
let a = 5;
let b = '5';
console.log(a == b); // compara valores
console.log(a === b); // compara valores y tipos     */
// booleanos
// AND: a && b
// OR: a || b
// NOT: !a
/* let a = 5;
let b = 10;
let esMayor = a > b;
let esMenor = a < b;
console.log(esMayor, esMenor);
console.log(esMayor && esMenor);
console.log(esMayor || esMenor);
console.log(!esMayor);
console.log(!esMenor); */

// TRABAJANDO CON CADENAS
/* let nombre = "Alan";
let apellido = "Rabinerson";
let nombreCompleto = nombre + " " + apellido;
console.log(nombreCompleto);
// template strings o plantillas literales
let nombreCompleto2 = `${nombre} ${apellido}`;
console.log(nombreCompleto2);

let inicialNombre = nombre[0];  
console.log(inicialNombre);
let longitudNombre = nombre.length;
console.log(longitudNombre);
 */

// metodos de cadenas
/* let mensaje = "Hola Mundo";
console.log(mensaje.toUpperCase());
console.log(mensaje.toLowerCase()); */
// indexOf
/* let email = "aLan.rabinerson@example.com";
console.log(email.toLowerCase().indexOf("l"));
let ultimaL = email.lastIndexOf("l");
console.log(ultimaL);
// slice
let dominio = email.slice(0, email.indexOf("@") + 1);
console.log(dominio); */
// substring
// let direccion = email.substring(0, email.indexOf("@"));
// console.log(direccion);

// replace
// let nuevoEmail = email.replace("example.com", "gmail.com");
// console.log(nuevoEmail);

// ARRAYS
/* let numeros = [1, 2, 3, 4, 5];
console.log(numeros[2]);
let frutas = ["manzana", "banana", "pera", "naranja"];
console.log(frutas);
console.log(frutas.length); */
/* let numeros = new Array();
numeros[0] = 1;
numeros[1] = 2;
// numeros[2] = 3;
numeros[3] = 4;
numeros[4] = 5;
console.log(numeros);
console.log(numeros[2]); // undefined
*/

// let nombres = new Array("Alan", "Juan", "Pedro");
// console.log(nombres[0]);
/* let numeros = new Array(10); // crea un array con 10 posiciones vacias
console.log(numeros[5]);
numeros[5] = 6;
console.log(numeros[5]); */

// nuemros = Array(4).fill(0); // llena el array con 0
// console.log(nuemros);

// METODOS DE ARRAYS
const FRUTAS = ["manzana", "banana", "pera", "naranja"];
// FRUTAS.push(5); // agrega un elemento al final del array  
// console.log(FRUTAS);
// console.log(typeof(FRUTAS[0]), typeof(FRUTAS[4]), typeof(FRUTAS)); // string, number, object
// FRUTAS.pop(); // elimina el ultimo elemento del array
// console.log(FRUTAS);
// FRUTAS.shift(); // elimina el primer elemento del array
// let primeraFruta = FRUTAS.shift(); // elimina el primer elemento del array y lo guarda en una variable
// console.log(FRUTAS);
// console.log(primeraFruta);
// FRUTAS.unshift("kiwi", "mango"); // agrega un elemento al inicio del array
// console.log(FRUTAS);
// FRUTAS.slice(1, 2); // elimina elementos del array (inicio, fin) - no modifica el array original
// console.log(FRUTAS);  
// let frutas2 = ["kiwi", "mango"]; 
// let frutas_combinadas = [...FRUTAS, ...frutas2]; // une dos arrays
// console.log(frutas_combinadas);
// let frutas_combinadas = FRUTAS.concat(frutas2); // une dos arrays
// const frutas2 = ["kiwi", "mango"];
// FRUTAS.splice(1, 2, ...frutas2); // elimina elementos del array (inicio, cantidad a eliminar, elementos a agregar) - modifica el array original
// console.log(FRUTAS);
// let frutas_combinadas = FRUTAS.join(" - "); // une los elementos del array en una cadena
// console.log(frutas_combinadas);
// FRUTAS.sort(); // ordena los elementos del array por el valor Unicode
// console.log(FRUTAS);
/* let ciudades = ["Madrid", "Barcelona", "Valencia", "Àvila", "Zaragoza", "Sevilla"];
let numeros = [1, 9, 10, 26, 3, 5, 7, 8, 2, 4, 6];
console.log(ciudades.sort());
// console.log(numeros.sort());
// console.log(numeros.sort((a, b) => a - b)); // ordena los elementos del array de menor a mayor
// console.log(ciudades.sort((a, b) => a.toLowerCase() > b.toLowerCase() ? 1 : a.toLowerCase() < b.toLowerCase() ? -1 : 0)); // ordena los elementos del array alfabeticamente sin importar mayusculas o minusculas
console.log(ciudades.sort((a, b) => a.localeCompare(b))); // ordena los elementos del array alfabeticamente sin importar mayusculas, minusculas o acentos - recomendado */


// estructuras de control
// if, else if, else
/* let hora = 10;
if (hora < 12) {
    console.log("Buenos dias");
} else if (hora < 18) {
    console.log("Buenas tardes");
} else {
    console.log("Buenas noches");
} */

// switch
/* let nombre = "frodo";
let edad = -Infinity;
switch (nombre) {
    case "Gandalf":
        edad = 1230; 
        break;
    case "aragon":
        edad = 532; 
        break;
    case "frodo":
        edad = 34; 
        break;
    case "sam":
        edad = 34; 
        break;
    default:
        edad = -1; 
        break;
}
console.log("edad:", edad); */

// ternario ?:
// let hora = 20;
// let mensaje = hora <= 12 ? "Buenos días" : hora < 18 ? "Buenas tardes" : "Buenas noches";
// console.log(mensaje);


//  ITERACIONES
// while
/* let contador = 0;
while (contador < 5) {
    console.log("contador:", contador);
    contador++;
} */

// do while
/* let contador = 10;
do {
    console.log("contador:", contador);
    contador++;
} while (contador < 5); */

// for
/* for (let i = 0; i < 5; i++) {
    console.log("i:", i);
} */



// FUNCIONES
/* function saludar() {
    console.log("Hola Mundo");
}
//saludar();

function sumar(a, b) {
    return a + b;
}
console.log(sumar(5, 10)); */




// OBJETOS {} clave-valor
/* let cliente = {
    nombre: "Peter Jackson",
    "Dirección del cliente": "c/ desconocida, 123",
    pago: {
        tipo: "Visa",
        numero: "1234-5678-9012-3456",
        "fecha de caducidad": "12/29"
    }
};

cliente.nombre = "Alan Rabinerson"; // modifica el valor de una propiedad
cliente["Dirección del cliente"] = "c/ conocida, 456"; // modifica el valor de una propiedad con espacio en el nombre
console.log(cliente.nombre);
console.log(cliente["Dirección del cliente"]); // accede al valor de una propiedad con espacio en el nombre */

// JSON
// number, string, boolean, array, object, function


// METODOS COMO DATOS
/* let estudiante = {
    id: 1,
    nombre: "Alan",
    diHola: function() {
        console.log("Hola, soy " + this.nombre);
    }
};

estudiante.edad = 23; // agrega una nueva propiedad al objeto
estudiante.diAdios = function() { // agrega un nuevo metodo al objeto
    console.log("Adios, soy " + this.nombre);
}; */
// console.log(estudiante);

// CONSTRUCTORES

function Web(url, nombre) {
    this.url = url;
    this.nombre = nombre;
    this.muestraUrl = function() {
        console.log(this.url+ " :" + this.nombre);
    }
};
/*
let unaWeb = new Web("http://google.com", "Google");
console.log(unaWeb);
unaWeb.muestraUrl();
 let web1 = new Web();
console.log(web1);
web1.muestraUrl();
let web2 = new Web();
web2.url = "http://fcbarcelona.cat";
web2.nombre = "Mes que un club";
console.log(web2);
web2.muestraUrl(); */

Web.prototype.visitas = 12; // agrega una nueva propiedad a todas las instancias del objeto
Web.prototype.saludar = function() { // agrega un nuevo metodo a todas las instancias del objeto
    console.log("Hola, soy " + this.nombre);
};
let unaWeb = new Web("http://google.com", "Google");
unaWeb.saludar();
console.log(unaWeb.visitas);