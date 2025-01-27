document.addEventListener('DOMContentLoaded', () => {
    const menuButton = document.getElementById('mobile-menu-btn');
    const mobileMenu = document.getElementById('mobile-menu');
  
    menuButton.addEventListener('click', () => {
      mobileMenu.classList.toggle('hidden');
    });
  });