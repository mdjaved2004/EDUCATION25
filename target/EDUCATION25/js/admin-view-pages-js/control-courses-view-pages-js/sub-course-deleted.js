function delete_subject(projectPath, sub_course_name, sub_course_short_id, course_name, course_id) {

    let msg = "Are you sure you want to remove subject: " + sub_course_name;
    const userConfirmed = confirm(msg);

    if (userConfirmed) {
        // Create form dynamically
        const form = document.createElement("form");
        form.action = projectPath+"/viewPages/admin-view-pages/control-courses-view-pages/sub-course-subject-deleted";
        form.method = "post";
		console.log("js ",course_id);
        form.innerHTML = `
            <input type="hidden" name="course_name" value="${course_name}">
            <input type="hidden" name="course_id" value="${course_id}">
            <input type="hidden" name="sub_course_name" value="${sub_course_name}">
            <input type="hidden" name="sub_course_short_id" value="${sub_course_short_id}">
        `;

        document.body.appendChild(form);
        form.submit();
    }
}