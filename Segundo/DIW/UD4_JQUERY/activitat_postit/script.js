$("#crearPostit").click(function() {
    const postit = $('<div class="postit" contenteditable="true">Nuevo Post-it</div>');
    const contenedores = ['#contenedor1', '#contenedor2'];
    const randomIndex = Math.floor(Math.random() * 2);
    const colores = ['#d1e7dd', '#f8d7da'];
    $(postit).css('background-color', colores[randomIndex]);
    const zona = randomIndex === 0 ? 'top' : 'bottom';
    $(postit).css(zona, Math.floor(Math.random() * 400) + 'px');
    const lado = randomIndex === 1 ? 'left' : 'right';
    $(postit).css(lado, Math.floor(Math.random() * 600) + 'px');
    $("main").append(postit);

});