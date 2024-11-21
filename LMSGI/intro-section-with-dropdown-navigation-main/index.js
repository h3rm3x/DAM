btnMenu = document.querySelector('#btnMenu');
navHeader = document.querySelector('#nav-header');
btnClose = document.querySelector('#btn-close img');

btnMenu.addEventListener('click', () =>{ 
    navHeader.classList.add('nav-visible');
});
btnClose.addEventListener('click', () => { 
  navHeader.classList.remove('nav-visible');
});