     /* sidebar_right open and close. */
 	const menuButton = document.getElementById('menu_list');
 	const sidebar_left = document.getElementById('sidebar_left');

	menuButton.addEventListener('click', (event) => {
	    const isOpen = sidebar_left.classList.contains('open');
	    if (isOpen) {
	        sidebar_left.classList.remove('open'); 
	    } else {
	        sidebar_left.classList.add('open');
	    }

	    event.stopPropagation();
	});