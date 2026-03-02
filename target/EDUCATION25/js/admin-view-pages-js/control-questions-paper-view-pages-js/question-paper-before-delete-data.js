function deletePaperName(contextPath){
	const paperName = document.querySelector('input[name="paper_name"]').value;
	const id = document.querySelector('input[name="id"]').value;
	 
	const confirmation = confirm(`Are you sure you want to delete Paper Name = ${paperName} And after delete no backup available ?`);
	
	if (confirmation){
		const form = document.createElement("form");
		form.method = "post";
		form.action = contextPath + "/viewPages/admin-view-pages/control-courses-view-pages/delete-paper";

		form.innerHTML = `
		        <input type="hidden" name="paper_name" value="${paperName}">
				<input type="hidden" name="id" value="${id}">
		    `;
			
		document.body.appendChild(form);
	    form.submit();
	}else{
		return;
	}	
}