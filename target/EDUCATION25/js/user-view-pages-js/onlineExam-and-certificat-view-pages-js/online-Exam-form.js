
function startExam(paperName, paper_id) {
	const projectPath = document.querySelector("#projectPath").value;
	const userName = document.querySelector("#userName").value;

    if (userName === "null" || userName === "") {
        alert('Login first');
        window.location.href = projectPath+'/viewPages/user-view-pages/auth-view-pages/login-page.jsp';
        return false;
    } else {
		const form = document.createElement("form");
			form.method = "POST";
		    form.action = projectPath + "/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/exam-start";
			form.innerHTML= `
		           <input type="hidden" name="paperName" value="${paperName}">
				   <input type="hidden" name="paperId" value="${paper_id}">
		   `;
		   document.body.appendChild(form);
		   form.submit();
		   setTimeout(() => form.remove(), 1000);
    }
}