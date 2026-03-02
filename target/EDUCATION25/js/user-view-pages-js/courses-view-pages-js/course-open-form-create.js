function courseInformation(course_name, course_id, sub_course_name, sub_course_sort_id, price){
	const form = document.createElement("form");
	form.innerHTML = `
	    	<input type="hidden" name="course_name" value="${course_name}" />
	        <input type="hidden" name="course_id" value="${course_id}" />
	        <input type="hidden" name="sub_course_name" value="${sub_course_name}" />
	        <input type="hidden" name="sub_course_sort_id" value="${sub_course_sort_id}" />
	        <input type="hidden" name="price" value="${price}" />    
	    `;
	return form;
}

function freeCourseOpen(course_name, course_id, sub_course_name, sub_course_sort_id, price, projectPath) {
	const form = courseInformation(course_name, course_id, sub_course_name, sub_course_sort_id, price);
	form.method = "post";
	form.action = `${projectPath}/viewPages/user-view-pages/courses-view-pages/education25-course-open`;
	
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
} 
   

function freeCourseAdd(course_name, course_id, sub_course_name, sub_course_sort_id, price, projectPath) {
	const form = courseInformation(course_name, course_id, sub_course_name, sub_course_sort_id, price);
	form.method = "post";
	form.action = `${projectPath}/viewPages/user-view-pages/courses-view-pages/free-course-add`;
	
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
}

function freeCourseDelete(sub_course_sort_id, projectPath) {
	const form = document.createElement("form");
		form.innerHTML = `
		        <input type="hidden" name="sub_course_sort_id" value="${sub_course_sort_id}" />
		    `;
	form.method = "post";
	form.action = `${projectPath}/viewPages/user-view-pages/courses-view-pages/free-course-delete`;
	
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
}

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


function BuyCourseDetails(sub_course_sort_id, projectPath) {

    const form = document.createElement("form");

    form.innerHTML = `
        <input type="hidden" name="sub_cour_sort_id" value="${sub_course_sort_id}" />
    `;

    form.method = "post";
    form.action = projectPath + "/viewPages/user-view-pages/courses-view-pages/buy-course-details";

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}