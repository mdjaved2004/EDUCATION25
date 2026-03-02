const menu_button_calculator = document.getElementById('calculator_menu');
const sidebar_calculator = document.getElementById('calculator_sidebar');
const choose_calculate_option = document.getElementById('choose_calculate_option');

menu_button_calculator.addEventListener('click', (event) => {
	sidebar_calculator.classList.toggle('open');
	choose_calculate_option.style.textAlign = 'right';
    event.stopPropagation(); // Prevent the event from propagating to the document
});

document.addEventListener('click', (event) => {
    if (!sidebar_calculator.contains(event.target) && !menu_button_calculator.contains(event.target)) {
    	choose_calculate_option.style.removeProperty('text-align');
    	sidebar_calculator.classList.remove('open'); 
    }
});