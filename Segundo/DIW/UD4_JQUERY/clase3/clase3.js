$(".postit").draggable();
$(".container").droppable({
    accept: function(draggable) {
        return $(this).data("color") === draggable.attr("class").split(" ")[1];
    },
    drop: function(event, ui) {
        //console.log(ui)
        let contador = parseInt($(this).data("counter"));
        console.log(contador);
        $(this).data("counter", contador+1);
        console.log($(this).data("counter"))
        console.log(contador)
    },
    out: function(event, ui) {
    }
})