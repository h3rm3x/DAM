/* ESDEVENIMENTS DE TEMPS:
- L'objecte window permet executar codi en intervals de temps.
- Hi ha tres mètodes: setTimeout, clearTimeout, setInterval */

/*setTimeout(<funcio>, <milisegons>): s'indiquen quants segons has de passar 
  abans que la funció indicada en el primer paràmetre s'executi.*/
function saludar(){
  //alert ("Hola!");
  console.log("Hola!");
}

/*clearTimeout(<variable timeout>): si assignem un setTimeout a una variable podem 
aturar la seva execució amb clearTimeout.*/

//setInterval(<funcio>, <milisegons>): repeteix una funció cada interval de temps.
let int = setInterval(rellotge, 1000);

function rellotge(){
  let data = new Date(); //Data actual
  document.getElementById("rellotge").innerHTML = data.getSeconds();
}

setTimeout(() => {
 console.log("Hola");
}, 3000)
