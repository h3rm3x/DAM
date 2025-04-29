function arrayPares (array){
    let pares = [];
    for (let i = 0; i < array.length; i++) {
        if (array[i] % 2 === 0) {
            pares.push(array[i]);
        }
    }
    return pares;
}

const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(arrayPares(numeros)); // [2, 4, 6, 8, 10]