$(document).ready(function () {
  const contenedores = ["#contenedor1", "#contenedor2", "#contenedor3"];
  const popupColor = $(".pop-up-colores");

  $("#crearPostit").click(function () {
    popupColor.addClass("active");
  });

  function crearPostit(color) {
    const postit = $(
      '<div class="postit" draggable="true"><h3 contenteditable="true">Nueva tarea</h3> <p contenteditable="true" class="descripcion">Descripción de la tarea</p></div>'
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
