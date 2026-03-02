// Function to highlight active link in the nav bar
function highlightSubjectBarItem(clickedLink) { 
    const navLinks = document.querySelectorAll('.subject_bar_item');
    navLinks.forEach(link => {
        link.classList.remove('active');
    });
    clickedLink.classList.add('active');
}

// Function to highlight active link in the sidebar
function highlight_sidebar_link(clicked_link) { 
    const sidebar_links = document.querySelectorAll('.Sub_heading_side_bar a');
    sidebar_links.forEach(link => {
        link.classList.remove('active');
    });
    clicked_link.classList.add('active');
}

function copyText(element) {
    let icon = element.querySelector('.material-symbols-outlined');
    let textToCopy = element.closest('.sub_heading_example_div').querySelector('.sub_heading_example').innerText;
    let textSpan=element;

    navigator.clipboard.writeText(textToCopy).then(() => {
        icon.innerText = "check";
        icon.style.fontSize = "1.5rem";
        setTimeout(() => icon.innerText = "content_copy", 2000);
        icon.style.fontSize = "1rem";
    }).catch(err => {
    });
}