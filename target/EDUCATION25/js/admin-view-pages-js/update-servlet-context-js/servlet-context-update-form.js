function sevletContextUpdate(value, projectPath) {
    // First confirmation
    if (!confirm("Are you sure you want to update this course?")) {
        return;
    }
	
	if (!confirm("Conform, Are you sure you want to update this course?")) {
	        return;			
	 }
	 
	 switch (value) {
         case "courses":
             updateCorsesInformationInServletContext(projectPath);
			 break;

         case "onlineExam":
             updateOnlineExamInformationInServletContext(projectPath);
			 break;
			 
         default:
             alert("Invalid option selected");
	     }

}

function updateCorsesInformationInServletContext(projectPath) {
	const form = document.createElement("form");
	form.method = "post";
	form.action = `${projectPath}/viewPages/admin-view-pages/update-servlet-context/update-course-context`;
	
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
}
function updateOnlineExamInformationInServletContext(projectPath) {
	const form = document.createElement("form");
	form.method = "post";
	form.action = `${projectPath}/viewPages/admin-view-pages/update-servlet-context/update-onlineExam-context`;
	
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
}