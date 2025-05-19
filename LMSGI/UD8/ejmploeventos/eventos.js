const div = document.querySelector("div");
const p = document.querySelector("p");
const button = document.querySelector("button");

div.addEventListener("click", () => console.log("click div"));
p.addEventListener("click", () => console.log("click p"));

const a = document.querySelector("a");
console.log(a[0]);
a.addEventListener("click", (e) => {
  if (!confirm("¿Quieres salir?")) {
    e.preventDefault();
  }
});

const img = document.getElementsByTagName("img")[0];
img.addEventListener("contextmenu", (e) => {
  e.preventDefault();
});