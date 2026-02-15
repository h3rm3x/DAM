// Enunciat: 
// 1. Afegir elements de score: en fer clic a "Add score item", s'ha d'afegir dins #scores un nou element amb:
// - text: Score: 0
// - botó +
// - botó -
// Cada element ha de guardar el valor del seu score amb data-score.

// 2. Sumar i restar punts (delegació obligatòria). Els botons + i -:
// - modifiquen només el score del seu element
// - actualitzen el text visible
// - s'ha de fer amb delegació d'esdeveniments
// (no es poden assignar esdeveniments directes als botons en crear-los)

// 3. Calcular total (ús de .each()). Quan es clica "Calculate total":
// - recórrer tots els scores amb .each()
// - sumar tots els valors guardats amb .data()
// - mostrar el total dins #result 

//Function no necessari tal com hem inclòs script.
$(function () {

  // Afegir nou score
  $("#add").on("click", function () {

    const item = $(`
      <div class="scoreItem" data-score="0">
        <span class="value">Score: 0</span>
        <button class="plus">+</button>
        <button class="minus">−</button>
      </div>
    `);

    $("#scores").append(item);
  });


  // Delegació per sumar
  $("#scores").on("click", ".plus", function () {

    const container = $(this).closest(".scoreItem");
    let score = container.data("score");

    score++;
    container.data("score", score);
    container.find(".value").text("Score: " + score);
  });


  // Delegació per restar
  $("#scores").on("click", ".minus", function () {

    const container = $(this).closest(".scoreItem");
    let score = container.data("score");

    score--;
    container.data("score", score);
    container.find(".value").text("Score: " + score);
  });


  // Calcular total amb each
  $("#total").on("click", function () {

    let total = 0;

    $(".scoreItem").each(function () {
      total += $(this).data("score");
    });

    $("#result").text("Total score: " + total);
  });

});
