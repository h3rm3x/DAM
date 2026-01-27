$(document).ready(function () {
  // Definir los contenedores y el popup de colores
  const contenedores = ["#contenedor1", "#contenedor2", "#contenedor3"];
  const popupColor = $(".pop-up-colores");

  $("#crearPostit").on("click", function () { // Abrir el popup de colores
    popupColor.addClass("active");
  });

  

  $( ".contenedor" ).droppable({ // Configurar los contenedores como droppables
    accept: ".postit", // Aceptar solo elementos con clase 'postit'
    drop: function (event, ui) { // Al soltar un postit en el contenedor
      if ($(ui.draggable).data("dropped") === "true") {
        //console.log("no se puede soltar el mismo postit 2 veces") DEBUG
        return;
      }
      // console.log(ui.draggable);
      const postit = ui.draggable;
      $(postit).data("estado", $(this).data("estado"));
      $(postit).css("background-color", colores($(this).data("estado"))); // Cambiar color según el contenedor
      $(postit).find("textarea").css("background-color", colores($(this).data("estado"))); // ajustar color del textarea
      //console.log($(this).data("estado")); DEBUG
      let contador = parseInt($(this).find("p strong").text());
      contador += 1;
      $(this).find("p strong").text(contador); // Actualizar contador al soltar el postit
      //console.log($(this).find("p strong")) DEBUG
      $(postit).data("dropped", "true");
      this.appendChild(postit);
    
    },
    out: function (event, ui) {
      let contador = parseInt($(this).find("p strong").text());
      contador -= 1;
      if (contador < 0) contador = 0;
      $(this).find("p strong").text(contador); // Actualizar contador al sacar el postit
      $(ui.draggable).data("dropped", "false");
    }
  });

  function crearPostit(color) { // Función para crear un nuevo postit
    let estado = estados(color);
    const postit = $(
      '<div class="postit" data-estado="' + estado + '" data-dropped="false"><h3 contenteditable="true">Nueva tarea</h3> <textarea contenteditable="true" class="descripcion" placeholder="Descripción de la tarea" maxlength="400"></textarea></div>'
    ); // Crear el elemento postit 
    $(postit).css("background-color", color);
    $(postit).find("textarea").css("background-color", color);
    // Posicionar aleatoriamente el postit
    const randomZona = Math.floor(Math.random() * 2);
    const zona = randomZona === 0 ? "top" : "bottom";
    $(postit).css(zona, Math.floor(Math.random() * 400) + "px");
    $(postit).css("left", Math.floor(Math.random() * 300) + "px");
    // Agregar botones de minimizar, cerrar y maximizar
    $(postit).append(
      '<button class="minimizar"><img src="./assets/minimizar.png" alt="Minimizar"></button>'
    );
    $(postit).append(
      '<button class="cerrar"><img src="./assets/cerrar.png" alt="Cerrar"></button>'
    );
    $(postit).append(
      '<button class="maximizar"><img src="./assets/maximizar.png" alt="Maximizar"></button>'
    );
    $("main").append(postit);
    $(postit).find(".descripcion").hide(); // Por defecto, ocultar la descripción
    popupColor.removeClass("active");
    // Configurar draggable con opción cancel para permitir edición
    $(postit).draggable({
      cancel: "[contenteditable='true'], button",
      handle: false
    });
  }

  function estados(color) { // Función para obtener el estado según el color
    switch (color) {
      case "rgb(209, 231, 221)":
        return "completada";
      case "rgb(248, 238, 215)":
        return "proceso";
      case "rgb(248, 215, 218)":
        return "pendiente";
    }
  }

  function colores(estado) { // Función para obtener el color según el estado
    switch (estado) {
      case "completada":
        return "rgb(209, 231, 221)";
      case "proceso":
        return "rgb(248, 238, 215)";
      case "pendiente":
        return "rgb(248, 215, 218)";
    }
  }

  $(".pop-up-colores .color").on("click", function () { // Al seleccionar un color en el popup de crear postit crear el postit
    const colorSeleccionado = $(this).css("background-color");
    crearPostit(colorSeleccionado);
  });

  $("main").on("click", ".minimizar", function () { // Al hacer click en minimizar ocultar la descripción y quitar clase maximizado
    $(this).closest(".postit").removeClass("maximizado");
    $(this).closest(".postit").find(".descripcion").hide();
  });

  $("main").on("click", ".maximizar", function () { // Al hacer click en maximizar mostrar la descripción y añadir clase maximizado
    $(this).closest(".postit").addClass("maximizado");
    $(this).closest(".postit").find(".descripcion").show();
  });

  $("main").on("click", ".cerrar", function () { // Al cerrar un postit, mostrar el diálogo de confirmación
    $(".dialogo-cerrar").show();
    $(this).addClass("dialogo-cerrar");
  });

  $("#confirmarCerrar").on("click", function () { // Al confirmar el cierre, eliminar el postit con animación
    const postit = $(".dialogo-cerrar").closest("body").find(".postit:has(.dialogo-cerrar)");
    postit.addClass("removing");
    postit.one('transitionend webkitTransitionEnd', function () {
      $(this).remove();
    });
    if (postit.data("dropped") === "true") { // Actualizar el contador del contenedor si el postit estaba en uno
      const contenedor = contenedores.find(c => $(c).data("estado") === postit.data("estado"));
      let contador = parseInt($(contenedor).find("p strong").text());
      contador -= 1;
      if (contador < 0) contador = 0;
      $(contenedor).find("p strong").text(contador);
    }
    $(".dialogo-cerrar").hide();
    $(".postit .cerrar").removeClass("dialogo-cerrar");
  });

  $("#cancelarCerrar").on("click", function () { // Al cancelar el cierre, ocultar el diálogo
    $(".dialogo-cerrar").hide();
    $(".postit .cerrar").removeClass("dialogo-cerrar");
  });


  $('#cerrarPopUp').click(function () {
    popupColor.removeClass("active");
  });
});
