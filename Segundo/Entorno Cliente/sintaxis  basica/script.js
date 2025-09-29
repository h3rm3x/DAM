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

let a = "10";
console.log(typeof a);
a = parseInt(a); 
console.log(typeof a);

let b = "10.55";
b = parseFloat(b);
console.log(typeof b);