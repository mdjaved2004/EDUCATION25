const menuButton1 = document.getElementById('menu_list');
const main = document.getElementById('main');

	menuButton1.addEventListener('click', (event) => {
    const isOpen = main.classList.contains('open');
    if (isOpen) {
        main.classList.remove('open'); 
    } else {
        main.classList.add('open');
    }

    event.stopPropagation();
});