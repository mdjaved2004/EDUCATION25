const menu_button_calculator = document.getElementById('course_context_open_menu');
		const sidebar_calculator = document.getElementById('course_context_open_side_bar');
		menu_button_calculator.addEventListener('click', (event) => {
			sidebar_calculator.classList.toggle('open');
		    event.stopPropagation(); // Prevent the event from propagating to the document
		});
		
		document.addEventListener('click', (event) => {
		    if (!sidebar_calculator.contains(event.target) && !menu_button_calculator.contains(event.target)) {
		    	sidebar_calculator.classList.remove('open'); 
		    }
		});
		const sidebarItems = document.querySelectorAll('#course_context_open_side_bar li');
		sidebarItems.forEach(item => {
		    item.addEventListener('click', () => {
		        sidebar_calculator.classList.remove('open'); // Close sidebar on item click
		    });
});