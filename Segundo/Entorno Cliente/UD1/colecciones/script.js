// Simbolos - Valores únicos e inmutables -> Identificadores de objetos
/*
const id = Symbol('id');
const persona = {
    nombre: 'Alan',
    [id]: 123 // usar el símbolo como clave de propiedad
};
console.log(persona.id); // undefined
console.log(persona[id]); // 123
*/


// Iteradores - Objectos que implementas un protocolo de iteración en JavaScript
/*
const numeros = [1, 2, 3,];
const iterador = numeros[Symbol.iterator]();
console.log(iterador.next()); // { value: 1, done: false }
console.log(iterador.next()); // { value: 2, done: false }
console.log(iterador.next()); // { value: 3, done: false }
console.log(iterador.next()); // { value: undefined, done: true }
*/

// Colecciones

//Set() - permite almacenar valores unicos de cualquier tipo
// no permite duplicados
/*
const set = new Set();
set.add(1);
set.add(2);
set.add(3);
set.add(4);
console.log(set);
set.clear()
console.log(set.size);
*/

//Map() - permite almacenar pares clave-valor
const mapa = new Map();
mapa.set('nombre', 'Alan');
mapa.set('edad', 24);
console.log(mapa);
console.log(mapa.get('nombre'));
console.log(mapa.has('edad'));