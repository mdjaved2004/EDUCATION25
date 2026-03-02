let courseSelect = document.getElementById('course-name');
let subCourseDatalist = document.getElementById('sub_course_name_list');

courseSelect.addEventListener('change', function () {
    let selectedOption = this.options[this.selectedIndex];
    let courseId = selectedOption.getAttribute('course-id');

    // Fetch new options based on the selected courseId
    const options = document.querySelectorAll('#sub_course_name_list option');

    options.forEach(option => {
        const courseId_in_subsourse = option.getAttribute('course_id_inSubCorse');
        
        // If courseId does not match, remove the option
        if (courseId !== courseId_in_subsourse) {
        	option.disabled = true;
    } else {
        option.disabled = false; 
    }
    });
});