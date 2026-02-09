// // 1. afegir eleements score amb text i botns de + i - 
// // 2. sumar i restar emprant deegació
// // 3. Calcular total emprant .each()

// let arr = ["A", "B", "C"];

// $.each(arr, function(index, value) {
//     console.log(index, value);
// });

$("#add").on("click", () => {
    let counter = 0;
    let scoreItem = $(`<div class="score-item">
        <button class="decrease">-</button>
        <span class="score">0</span>
        <button class="increase">+</button>
    </div>`);
    $("#scores").append(scoreItem);
});

$("#scores").on("click", ".increase", function() {
    let scoreElement = $(this).siblings(".score");
    let currentScore = parseInt(scoreElement.text());
    scoreElement.text(currentScore + 1);
});

$("#scores").on("click", ".decrease", function() {
    let scoreElement = $(this).siblings(".score");
    let currentScore = parseInt(scoreElement.text());
    scoreElement.text(currentScore - 1);
});

$("#total").on("click", () => {
    let totalScore = 0;
    $(".score").each(function() {
        totalScore += parseInt($(this).text());
    });
    $("#totalScore").text(`Total Score: ${totalScore}`);
});