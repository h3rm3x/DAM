$("#crearPostit").click(function() {
    const postit = $('<div class="postit" contenteditable="true">Nuevo Post-it</div>');
    const contenedores = ['#contenedor1', '#contenedor2'];
    const randomIndex = Math.floor(Math.random() * 2);
    const colores = ['#d1e7dd', '#f8d7da'];
    $(postit).css('background-color', colores[randomIndex]);
    $("main").append(postit);
});