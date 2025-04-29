// variables
/*
let x = 9;
const PI = 3.1416;
var y = "texto";

const persona ={nombre: "Juan", edad: 30};
console.log(persona);
persona.nombre = "Pedro";
console.log(persona);
persona.edad = 31;
console.log(persona);
// const persona = {nombre: "Maria", edad: 25}; // Error: Assignment to constant variable.
console.log(typeof persona); // object
console.log(typeof x); // number
console.log(typeof PI); // number
console.log(typeof y); // string

console.log(x==y);// false
console.log(x/y); // NaN

y = "9";
console.log(x==y); // true
console.log(x===y); // false
console.log(x!=y); // false
console.log(x!==y); // true

console.log(typeof +y); // number
*/
//arrays
/*
var numeros = [1, 2, 3, 4, 5, " numero", true, null, undefined, {nombre: "Juan", edad: 30}];
console.log(numeros[0]); // 1
console.log(numeros[7]); // 2

var arraynumeros = new Array();
arraynumeros[0] = 1;
arraynumeros[1] = 2;
arraynumeros[2] = 3;

console.log(arraynumeros);

var arraynombres = new Array('Juan', 'Pedro', 'Maria');
console.log(arraynombres[0]); // Juan
console.log(arraynombres[1]); // Pedro
console.log(arraynombres[2]); // Maria
console.log(arraynombres); // undefined

let nums = new Array(10); // Crea un array de 5 elementos vacíos
console.log(nums); // [ <10 empty items> ]

nums.fill(0); // Rellena el array con ceros
console.log(nums); // [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]

nums.push(1); // Agrega un elemento al final del array
console.log(nums); // [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ]

nums.pop(); // Elimina el último elemento del array
console.log(nums); // [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]

nums[0] = 1; // Asigna un valor a la posición 0 del array
console.log(nums); // [ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]

let eliminado = nums.shift(); // Elimina el primer elemento del array
console.log(eliminado); // 1
console.log(nums); // [ 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
*/
/*
//iterar
// for (let i = 0; i < 10; i++) {
//     console.log(i);
// }

const numeros = [1, 2, 3, 4, 5];
numeros.forEach((num) => {
    console.log(num);
});

for (let num in numeros) {
    console.log(num); // 0 1 2 3 4
}

function g() {
    console.log('Esto es una función');
    
}
g(); // Esto es una función

const a = () => {
    console.log('Esto es una función de flecha');
}
a(); // Esto es una función de flecha
*/
// sets y maps
/*
const lista = new Set();
lista.add(1);
lista.add(2);
lista.add(3);
lista.add(4);
lista.add(3);
lista.add(5);

console.log(lista);

console.log(lista.size); // 5
console.log(lista.has(3)); // true

const provincias = new Map();
provincias.set(1, 'Madrid').set(2, 'Cataluña');
provincias.set(3, 'Andalucía').set(4, 'Valencia').set(5, 'Galicia');

console.log(provincias.get(1)); // Madrid
console.log(provincias.get(2)); // Cataluña
console.log(provincias.get(3)); // Andalucía

const persona = new Map();
persona.set('nombre', 'Pedro').set('edad', 31).set('ciudad', 'Barcelona');
console.log(persona.get('nombre')); // Pedro
console.log(persona.get('edad')); // 31
console.log(persona.has('ciudad')); // Barcelona

const claves = persona.keys();
const valores = persona.values();
console.log(claves); // [ 'nombre', 'edad', 'ciudad' ]
console.log(valores); // [ 'Pedro', 31, 'Barcelona' ]
console.log(persona.entries()); // [ [ 'nombre', 'Pedro' ], [ 'edad', 31 ], [ 'ciudad', 'Barcelona' ] ]
*/

const numeros = [1, 2, 3, 4, 5];
const [a, b, c] = numeros; // Desestructuración de arrays
console.log(a); // 1
console.log(b); // 2
console.log(c); // 3

const nombre = 'Alan';
const persona = {nombre, edad: 23, ciudad: 'Mahon'}

console.log(persona);

console.log("La persona"+ persona.nombre + " tiene " + persona.edad + " años y vive en " + persona.ciudad); // La persona Alan tiene 23 años y vive en Mahon
console.log(`La persona ${persona.nombre} tiene ${persona.edad} años y vive en ${persona.ciudad}`); // La persona Alan tiene 23 años y vive en Mahon

// operador spread

const numeros1 = [1, 2, 3];
const masNumeros = [4, 5, 6,...numeros];
console.log(masNumeros); // [ 4, 5, 6, 1, 2, 3 ]    

function resta(c=0, d=0){
    return c - d;
}

console.log(resta())

function mult(...nums){
    let total = 1;
    for (let num of nums) {
        total *= num;
    }
    return  total;
}

console.log(mult(1, 2, 3, 4, 5)); // 120
