btnMenu = document.querySelector('#btn-menu');
console.log(btnMenu);
btnMenu.addEventListener('click', () => {
  const nav = document.querySelector('.nav');
  nav.classList.toggle('nav--visible');
});