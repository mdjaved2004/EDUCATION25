function buyCourseOpen(sub_course_sort_id, projectPath) {
	const form = document.createElement("form");
			form.innerHTML = `
			        <input type="hidden" name="sub_course_sort_id" value="${sub_course_sort_id}" />
			    `;
		form.method = "post";
		form.action = `${projectPath}/viewPages/user-view-pages/courses-view-pages/paid-course-open`;
		
		document.body.appendChild(form);
		form.submit();
		document.body.removeChild(form);
}