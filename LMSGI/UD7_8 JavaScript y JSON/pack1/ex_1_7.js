let playlist=[]

function anadirCancion(titulo){
    playlist.push(titulo);
    console.log(`Cancion añadida: ${titulo}`)
    console.log(`Playlist actual: ${playlist}`)
}

function eliminarCancion(titulo){
    playlist.pop(titulo);
    console.log(`Cancion eliminada: ${titulo}`)
    console.log(`Playlist actual: ${playlist}`)
}

anadirCancion("Titulo 1")
anadirCancion("Titulo 2")
eliminarCancion("Titulo 1")