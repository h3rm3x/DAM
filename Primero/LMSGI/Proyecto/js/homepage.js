const btnMenu = document.querySelector('#menu');
const navHeader = document.querySelector('#lista-paginas');
const btnClose = document.querySelector('#cerrar-menu');

btnMenu.addEventListener('click', () => { 
    navHeader.classList.add('div-visible');
});

btnClose.addEventListener('click', () => { 
    navHeader.classList.remove('div-visible');
});