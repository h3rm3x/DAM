// DESESTRUCURACIÓN: EXTRACCIÓN DE VALORES

// extraer valores de un array y de objetos

// Array
/*
const numeros = [1,2,3];
const [primero, segundo, tercero] = numeros;
console.log(primero); // 1
console.log(segundo); // 2
console.log(tercero); // 3
 
// Objeto
const persona = { 
    nombre: 'Alan',
    id: 24
};

const { nombre, id } = persona;
//console.log(nombre);

// atajo para asignar propiedades a un objeto

const nombre = 'Alan';
const id = 24;

const persona = { nombre, id };
console.log(persona); // { nombre: 'Alan', id: 24 }


// template strings (plantillas de cadenas)
const nombre = 'Alan';
const edad = 24;
const mensaje = `Hola mi nombre es ${nombre} y tengo ${edad} años`;
console.log(mensaje);

// operador string / operador de propagación 
// expandir array en multiples elementos
const numeros = [1,2,3];
const nuevosNumeros = [ 4,...numeros,5,6];
console.log(nuevosNumeros);


// parametros por defecto
function saludar(nombre = 'John Doe') {
    console.log(`Hola ${nombre}`);
}
saludar();

// Parametros REST
// capturar un numero indeterminado o variable de argumentos en una función
// pasaremos varios argumentos en uno
function sumar(...numeros) {
    let resultado = 0;
    for (let numero of numeros) {
        resultado += numero;
    }
    return resultado;
}
console.log(sumar(1,2,3,4,5)); // 15
console.log(sumar(10,20,30));


// arrow functions (funciones flecha)
const sumar = (a, b) => a + b;
console.log(sumar(2,3)); // 5
const sumar2 = (...numeros) => {
    let resultado = 0;
    for (let numero of numeros) {
        resultado += numero;
    }
    return resultado;  
};
console.log(sumar2(1,2,3,4,5)); // 15
*/

// Metodos de arrays

// forEach
const numeros = [1,2,3,4,5];
//numeros.forEach( numero => console.log(numero*2) );

// map()
//const dobles = numeros.map( numero => numero * 2 );
//console.log(dobles); // [2,4,6,8,10]

/*
// filter()
const numerosPares = numeros.filter( numero => numero % 2 === 0 );
console.log(numerosPares); // [2,4,6]
const numerosMayoresQueTres = numeros.filter( numero => numero >= 3 && numero < 7 );
console.log(numerosMayoresQueTres); // [4,5,6]
*/

// reduce()
const suma = numeros.reduce( (acumulador, numero) => acumulador + numero, 0);
console.log(suma); // 15
