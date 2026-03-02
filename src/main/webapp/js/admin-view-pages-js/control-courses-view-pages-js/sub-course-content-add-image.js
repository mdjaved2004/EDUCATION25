let image_input = document.getElementById("image_input");
let profile_pic = document.getElementById("profile_pic");
let upload_text = document.getElementById("upload_text");

image_input.onchange = function () {
let file = image_input.files[0];  
    
    if (file) {
        if (file.size > 1* 1024* 1024) { 
            alert("File size must be less than 1MB");
            image_input.value = "";
            return;
        }
        profile_pic.src = URL.createObjectURL(file);
        profile_pic.style.display = "block";
        upload_text.style.display = "none";
    }
};

function addExtraInfoInForm(id, courseName, courseId, subCourseName, subCourseShortId, learningDays, price, image_link, projectPath) {
    const form = document.getElementById("form");

    // set form properties
    form.method = "post";
    form.action = projectPath + "/viewPages/admin-view-pages/control-courses-view-pages/sub-course-image-update";

	// create wrapper div
	   const hiddenDiv = document.createElement("div");
	   hiddenDiv.style.display = "none";

	   // use innerHTML safely INSIDE the div
	   hiddenDiv.innerHTML = `
	       <input type="hidden" name="id" value="${id}">
	       <input type="hidden" name="course_name" value="${courseName}">
	       <input type="hidden" name="course_id" value="${courseId}">
	       <input type="hidden" name="sub_course_name" value="${subCourseName}">
	       <input type="hidden" name="sub_course_short_id" value="${subCourseShortId}">
	       <input type="hidden" name="learning_days" value="${learningDays}">
	       <input type="hidden" name="price" value="${price}">
	       <input type="hidden" name="image_link" value="${image_link}">
	   `;
	   form.appendChild(hiddenDiv);
    // submit the form
    form.submit();
}