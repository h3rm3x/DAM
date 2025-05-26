let estudiantes=[];

function anadirEstudiante(nombre, edad, nota){
    estudiantes.push({nombre, edad, nota})
}

function eliminarEstudiante(nombre, edad, nota){
    estudiantes.push({nombre, edad, nota})
}

function encontrarMejorNota(estudiantes){
    for (let i=1; i<estudiantes.length;i++){
        let notamasalta
        if(estudiantes[i].nota> estudiantes[i-1].nota){
            notamasalta= estudiantes[i].nota
        }
    }
}