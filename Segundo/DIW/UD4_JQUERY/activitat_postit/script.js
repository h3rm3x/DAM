$(document).ready(function () {
  const contenedores = ["#contenedor1", "#contenedor2", "#contenedor3"];
  const popupColor = $(".pop-up-colores");

  $("#crearPostit").click(function () {
    popupColor.addClass("active");
  });

  

  $( ".contenedor" ).droppable({
    accept: function (draggable) {
      return ($(this).data("aceptar") == draggable.data("estado"));
    },
    drop: function (event, ui) {
      if ($(ui.draggable).data("dropped") === "true") {
        console.log("no se puede soltar el mismo postit 2 veces")
        return;
      }
      console.log(ui.draggable);
      const postit = ui.draggable;
      let contador = parseInt($(this).find("p strong").text());
      console.log(contador);
      contador += 1;
      $(this).find("p strong").text(contador);
      console.log($(this).find("p strong"))
      $(ui.draggable).data("dropped", "true");
      console.log($(this).attr(""))
    },
    out: function (event, ui) {
      const postit = this;
      let contador = parseInt($(this).find("p strong").text());
      contador -= 1;
      $(this).find("p strong").text(contador);
      $(ui.draggable).data("dropped", "false");
    }
  });

  function crearPostit(color) {
    let estado = estados(color);
    const postit = $(
      '<div class="postit" data-estado="' + estado + '" data-dropped="false"><h3 contenteditable="true">Nueva tarea</h3> <p contenteditable="true" class="descripcion">Descripción de la tarea</p></div>'
    );
    $(postit).css("background-color", color);
    const randomZona = Math.floor(Math.random() * 2);
    const zona = randomZona === 0 ? "top" : "bottom";
    $(postit).css(zona, Math.floor(Math.random() * 400) + "px");
    $(postit).css("left", Math.floor(Math.random() * 300) + "px");
    $(postit).append(
      '<button class="minimizar"><img src="./assets/minimizar.png" alt="Minimizar"></button>'
    );
    $(postit).append(
      '<button class="maximizar"><img src="./assets/maximizar.png" alt="Maximizar"></button>'
    );
    $("main").append(postit);
    $(postit).find(".descripcion").hide();
    popupColor.removeClass("active");
    // Configurar draggable con opcción cancel para permitir edición
    $(postit).draggable({
      cancel: "[contenteditable='true'], button",
      handle: false
    });
  }

  function estados(color) {
    switch (color) {
      case "rgb(209, 231, 221)":
        return "completada";
      case "rgb(248, 238, 215)":
        return "proceso";
      case "rgb(248, 215, 218)":
        return "pendiente";
    }
  }

  $(".pop-up-colores .color").click(function () {
    const colorSeleccionado = $(this).css("background-color");
    crearPostit(colorSeleccionado);
  });

  $("main").on("click", ".minimizar", function () {
    $(this).closest(".postit").removeClass("maximizado");
    $(this).closest(".postit").find(".descripcion").hide();
  });

  $("main").on("click", ".maximizar", function () {
    $(this).closest(".postit").addClass("maximizado");
    $(this).closest(".postit").find(".descripcion").show();
  });

  $('#cerrarPopUp').click(function () {
    popupColor.removeClass("active");
  });
});
