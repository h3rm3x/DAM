function inicialnombreApellido (nombre, apellido) {
    return `${nombre.charAt(0).toUpperCase()}${ apellido.toLowerCase()}`;
}

console.log(inicialnombreApellido("Alan", "Rabinerson")); // JP