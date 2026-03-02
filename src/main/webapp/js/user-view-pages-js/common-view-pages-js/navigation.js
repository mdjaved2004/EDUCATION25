        /*  username from JSP into JavaScript */
		
        const userEmail = document.getElementById('email').value;
        /* get user screen width */
        const screenWidth = window.innerWidth;
        const screenHeight = window.innerHeight;
       
        const menuIcon = document.getElementById('menu_list');
        if (userEmail != "null") {
            menuIcon.style.display = "inline-block";
        } else if(screenWidth < 981) {
            menuIcon.style.display = "inline-block";
        } else {
            menuIcon.style.display = "none";
        }

 	/* sidebar_right open and close. */
 	const menuButton = document.getElementById('menu_list');
 	const sidebar_left = document.getElementById('sidebar_left');

 	
 	menuButton.addEventListener('click', (event) => {
 		sidebar_left.classList.toggle('open');
 		event.stopPropagation(); 
 	});

 	
 	document.addEventListener('click', (event) => {
 		if (!sidebar_left.contains(event.target) && !menuButton.contains(event.target)) {
 			sidebar_left.classList.remove('open');
 		}
 	});