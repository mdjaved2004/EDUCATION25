function openMainCourse(course_name, course_id, projectPath) { 
    // Create a form element
    const form1 = document.createElement("form");
	form1.action = `${projectPath}/viewPages/user-view-pages/courses-view-pages/education25-course-open-main`;
	form1.method = "post";
    form1.innerHTML = `
    	<input type="hidden" name="course_name" value="${course_name}" />
        <input type="hidden" name="course_id" value="${course_id}" />  
    `;

    // Append the form1 to the body
    document.body.appendChild(form1);
    form1.submit();
	document.body.removeChild(form1);
}