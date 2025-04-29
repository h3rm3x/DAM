function preciofinal (precio, descuento){
    let precioFinal = precio - (precio * descuento / 100);
    return "El precio final con descuento es " + precioFinal + " euros";
}

console.log(preciofinal(100, 20)); // El precio final con descuento es 80 euros