function addQuestionForm(btn, contextPath, question_no, mask) {
    const div = createQuestionForm(contextPath, question_no, mask);

    //insert AFTER clicked button
    btn.closest(".buton_div").after(div);
	btn.style.display = "none";
}
function addQuestionFormStarting(btn, contextPath, question_no, mask) {
    // Create the form using the provided data
    const div = createQuestionForm(contextPath, question_no, mask);
    
    // Get the closest form element to the button
    const form = btn.closest("form");

    // Insert the new form after the current form
    form.before(div);
	btn.style.display = "none";
}

// Helper function to generate the form HTML with the same design and classes
function createQuestionForm(contextPath, question_no, mask) {
	const paperName = document.querySelector('input[name="paper_name"]').value;
	const id = document.querySelector('input[name="id"]').value;

    const form = document.createElement("form");
    form.id = `new_form_${question_no}`;
	form.action =contextPath+"/viewPages/admin-view-pages/control-courses-view-pages/add-one-question";
	form.method ="post";

    form.innerHTML = `
		<br><hr><br>
        <input type="hidden" name="questionNo" value="${question_no}">
		<input type="hidden" name="paper_name" value="${paperName}">
		<input type="hidden" name="id" value="${id}">        
        <div class="large-container">
            <div class="question-header">
                <label for="question${question_no}">Question ${question_no}</label>
                <div class="question-header-right">
                    <button type="button" class="marks_show">${mask}</button>
                </div>
            </div>
            <textarea id="question${question_no}" name="new_question${question_no}"
                class="question_text" rows="7" required></textarea>
        </div>

        <div class="small-container">
            <div class="small">
                <label for="option_a${question_no}">Option A</label>
                <textarea id="option_a${question_no}" name="new_option_a${question_no}"
                    class="option" required></textarea>
            </div>
            <div class="small">
                <label for="option_b${question_no}">Option B</label>
                <textarea id="option_b${question_no}" name="new_option_b${question_no}"
                    class="option" required></textarea>
            </div>
        </div>

        <div class="small-container">
            <div class="small">
                <label for="option_c${question_no}">Option C</label>
                <textarea id="option_c${question_no}" name="new_option_c${question_no}"
                    class="option" required></textarea>
            </div>
            <div class="small">
                <label for="option_d${question_no}">Option D</label>
                <textarea id="option_d${question_no}" name="new_option_d${question_no}"
                    class="option" required></textarea>
            </div>
        </div>

        <div class="textarea-container">
            <div>
                <label for="select${question_no}">Select answer</label>
                <select class="selected" id="select${question_no}" name="new_answer${question_no}" required>
					<option value="" hidden>choose ans</option>    
					<option value="a">Option A</option>
					<option value="b">Option B</option>
					<option value="c">Option C</option>
					<option value="d">Option D</option>
                </select>
            </div>
        </div>
		<div class="buton_div">
			<button type="submit" class="submit-btn">Submit</button>
			<button type="button" onclick="removeForm(this, ${question_no})" class="delete-btn">Remove</button>	
		</div>
    `;

    return form;
}

// Function to remove the form and show the "Add" button again
function removeForm(btn, question_no) {
    // Find the form that needs to be removed (using a unique identifier)
    const form = document.querySelector(`#new_form_${question_no}`);
	const addButton = document.querySelector(`#new_add_${question_no}`);
	console.log(addButton);
	       
   if (addButton) {
       // Make the "Add" button visible again
       addButton.style.display = "inline-block"; // or use "" to reset it to default
   }
    if (form) {
        // Remove the form from the DOM
        form.remove();

        // Find the corresponding "Add" button and make it visible again
   
    }
}

function submitForm(contextPath, questionNo) {
    // Get the form element by ID
    const form = document.getElementById("form_" + questionNo);

    // Retrieve the values of the hidden fields from the form
    const paperName = document.querySelector('input[name="paper_name"]').value;
    const id = document.querySelector('input[name="id"]').value;

    // Create hidden inputs and append them to the form
    const hiddenPaperNameInput = document.createElement('input');
    hiddenPaperNameInput.type = 'hidden';
    hiddenPaperNameInput.name = 'paper_name';
    hiddenPaperNameInput.value = paperName;
    
    const hiddenIdInput = document.createElement('input');
    hiddenIdInput.type = 'hidden';
    hiddenIdInput.name = 'id';
    hiddenIdInput.value = id;

    const hiddenQuestionNoInput = document.createElement('input');
    hiddenQuestionNoInput.type = 'hidden';
    hiddenQuestionNoInput.name = 'questionNo';
    hiddenQuestionNoInput.value = questionNo;

    // Append the hidden inputs to the form
    form.appendChild(hiddenPaperNameInput);
    form.appendChild(hiddenIdInput);
    form.appendChild(hiddenQuestionNoInput);

    // Set the form's action and method
    form.action = contextPath + "/viewPages/admin-view-pages/control-questions-paper-view-pages/question-paper-question-update";
    form.method = "post";

    // Submit the form
    form.submit();
}

function deleteOneQuestion(btn, contextPath, question_no) {

    if (!confirm("Are you sure you want to delete this question?")) {
        return; 
    }

    const paperName = document.querySelector('input[name="paper_name"]').value;
    const id = document.querySelector('input[name="id"]').value;

    // Create the form element
    const form = document.createElement("form");
    form.action = contextPath + "/viewPages/admin-view-pages/control-courses-view-pages/delete-one-question";
    form.method = "post";
    form.style.display = "none";

    console.log(paperName);
    console.log(id);
    console.log(question_no);

    // Add hidden inputs for the form data
    form.innerHTML = `
        <input type="hidden" name="questionNo" value="${question_no}">
        <input type="hidden" name="paper_name" value="${paperName}">
        <input type="hidden" name="id" value="${id}">
    `;

    document.body.appendChild(form);
    form.submit();
}
