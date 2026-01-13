$("button").on("click", function() {
    $("p:hidden").show(); // Muestra los párrafos ocultos al hacer clic en el botón
});

$(".postit").on("click", function() {
    $("#SelectedPostit").val($(this).attr("id")); // Asigna el valor del atributo data-id al elemento con id SelectedPostit
});

$(":checked:disabled")
// :password, :selected, :enabled, :disabled, :text
// .contains()
{
    /* 
    <div id="container">-
    </div>
    */
    
}
// per comprocar si un element esta buit --> .children().length === 0

// :has()
console.log($("div:has(p)"))    // no s'empra

// es fa servir el metode .has()
$("div").has("p").addClass("amb-paragraf"); // Selecciona los divs que contienen párrafos y les aplica un borde rojo