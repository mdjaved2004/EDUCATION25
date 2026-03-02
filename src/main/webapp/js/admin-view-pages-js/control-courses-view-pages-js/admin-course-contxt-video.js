function playVideo(element, lecture_id) { 
    // Create a form element
    const form = document.createElement("form");
    form.action = "admin_course_context_play_video";  
    form.method = "post";
    // Hidden Inputs for Form Submission
    form.innerHTML = `     
        <input type="hidden" name="lecture_id" value="${lecture_id}" />
    `;

    document.body.appendChild(form);
    form.submit();
      setTimeout(() => {
        form.remove();
    }, 1000);
}

function addListItem(lectureId) {
    let ul = document.getElementById("course_context_open_side_bar");

    let li = document.createElement("li");
    li.id = `side_bar_itom_${lectureId}`;
    li.className = 'side_bar_itom';

    li.innerHTML = `
        <a href="#Lecture_${lectureId}" onclick="highlight_sidebar_link(this);">Lecture ${lectureId}</a>
    `;

    ul.appendChild(li);
}

function buy_course_alert() {
	alert("bellow given option to buy the course");
}

function highlight_sidebar_link(clicked_link) { 
    const sidebar_links = document.querySelectorAll('.side_bar_itom a');
    sidebar_links.forEach(link => {
        link.classList.remove('active');
    });
    clicked_link.classList.add('active');
}
