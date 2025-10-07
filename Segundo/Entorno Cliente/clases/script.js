class persona {

    // constructor
    constructor(nombre) {
        this.nombre = nombre;
    }

    // metodo
    saludar() {
        console.log(`Hola, mi nombre es ${this.nombre}`);
    }
}

const ego = new persona('Alan');
//ego.saludar(); // Hola, mi nombre es Alan

// Herencia
class empleado extends persona {

    constructor(nombre, salario) {
        super(nombre); // llamar al constructor de la clase padre
        this.salario = salario;
    }

    trabajar() {
        console.log(` ${this.nombre} esta trabajando y gana ${this.salario}€`);
        document.getElementsByTagName('body')[0].innerHTML = `<h2>${this.nombre} esta trabajando y gana ${this.salario}€</h2>`;
    }
}

const empleado1 = new empleado('Alan', 3000);
empleado1.trabajar(); // Alan esta trabajando y gana 3000€
