document.addEventListener("DOMContentLoaded", () => {
    // CODIGO
});

$(document).ready(function() {
    // Código jQuery aquí

});

$(function() {
    // Código jQuery aquí
});

$(() => {
    // Código jQuery aquí
});

// Seleccionar elementos del DOM
document.querySelector("#id")
document.querySelector(".clase")
document.querySelectorAll("div")

$("#id")
$(".clase")
$("div")

console.log( $("h1"))
console.log( $("p")) // misma funcion para seleccionar uno o varios elementos
console.log( $("p").length ) // numero de elementos seleccionados

// eliminar y mostrar elementos
$("p:first-of-type").hide();
$("p:first-of-type").show();

// Manipulacion del dom
//.text() .html() .val() .attr()

// READ
console.log( $("h1").text() );
// WRITE
$("h1").html( "<span>Hola</span>" );

// Eventos
$("input[type='button']").one("click", () => { // DEPRECATED: .click( ... )
    //$("p").css("color", "red");

    //$("p").addClass("blau");

    $("p").toggleClass("blau");
    console.log($("p").hasClass("blau"));

});

let boton = $("input[type='button']");
boton.on("mouseover", () => {
    $("this").css("color", "violet");
});

console.log(boton)