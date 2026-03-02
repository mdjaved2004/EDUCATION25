function createHeading(button, projectPath, headingId, course_name, course_id, sub_course_name,sub_course_short_id) {
    const heading_div = document.createElement('div');
    heading_div.className = 'heading-container';
    heading_div.innerHTML = `
        <form action="${projectPath}/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update" method="post">
            <label for="new_heading" class="heading_level">New Heading ${headingId}</label>
            <textarea id="new_heading" name="new_heading_text" class="heading_text" maxlength="100"  rows="2" required></textarea>
			
			<input type="hidden" name="form_id" value="add-one-heading" />
            <input type="hidden" name="heading_id" value="${headingId}" />
            <input type="hidden" name="course_name" value="${course_name}" />
            <input type="hidden" name="course_id" value="${course_id}" />
            <input type="hidden" name="sub_course_name" value="${sub_course_name}" />
            <input type="hidden" name="sub_course_short_id" value="${sub_course_short_id}" />
            <button type="submit" class="add_heading">Submit</button>
        </form>
    `;
    const remove_button = document.createElement('button');
    remove_button.className = 'remove-btn';
    remove_button.textContent = 'Remove';
    remove_button.type = 'button'; 

    remove_button.addEventListener('click', () => {
        heading_div.remove(); 
        button.style.display = ''; 
    });

    const form = heading_div.querySelector('form');
    form.appendChild(remove_button);

    const parent_container = button.closest('.heading-container').parentNode;
    const current_heading_div = button.closest('.heading-container');
    parent_container.insertBefore(heading_div, current_heading_div);

    button.style.display = 'none';
}

function create_sub_heading(button, projectPath, headingId, subHeadingId, tem_id, course_name, course_id, sub_course_name,sub_course_short_id) {
    const sub_heading_div = document.createElement('div');
    sub_heading_div.className = 'sub-heading';
    sub_heading_div.innerHTML = `
        <form action="${projectPath}/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update" method="post">
            <label for="new_sub_heading" class="heading_level">New Sub-heading ${tem_id}</label>
            <textarea id="new_sub_heading" name="new_sub_heading_text" class="sub-heading-text" maxlength="100"  rows="2" required></textarea>
            
			<input type="hidden" name="form_id" value="add-one-sub-heading" />
			<input type="hidden" name="heading_id" value="${headingId}" />
            <input type="hidden" name="sub_heading_id" value="${subHeadingId}" />
            <input type="hidden" name="course_name" value="${course_name}" />
            <input type="hidden" name="course_id" value="${course_id}" />
            <input type="hidden" name="sub_course_name" value="${sub_course_name}" />
            <input type="hidden" name="sub_course_short_id" value="${sub_course_short_id}" />
            <button type="submit" class="add_subheading">Submit</button>
        </form>
    `;
    const sub_heading_definition_div = document.createElement('div');
    sub_heading_definition_div.className = 'sub-heading-defination new-sub-heading-defination';
    sub_heading_definition_div.innerHTML = `
        <label for="new_sub_heading_definition">Definition ${tem_id}</label>
        <textarea id="new_sub_heading_definition" name="new_sub_heading_defination_text" class="sub-heading-defination-text" maxlength="4000" required></textarea>
    `;
    
    const sub_heading_example_div = document.createElement('div');
    sub_heading_example_div.className = 'sub-heading-example new-sub-heading-example';
    sub_heading_example_div.innerHTML = `
        <label for="new_sub_heading_example" class="example">Example ${tem_id}</label>
        <textarea id="new_sub_heading_example" name="new_sub_heading_example_text" class="sub-heading-example-text" maxlength="4000"></textarea>
    `;

    const remove_button = document.createElement('button');
    remove_button.className = 'remove-btn';
    remove_button.textContent = 'Remove';
    remove_button.type = 'button'; 

    remove_button.addEventListener('click', () => {
        sub_heading_div.remove();
        button.style.display = '';
    });

    const form = sub_heading_div.querySelector('form');
    form.appendChild(remove_button);
    form.appendChild(sub_heading_definition_div);
    form.appendChild(sub_heading_example_div);
    

    const parent_container = button.closest('.sub-heading').parentNode;
    const current_sub_heading_div = button.closest('.sub-heading');
    parent_container.insertBefore(sub_heading_div, current_sub_heading_div);

    button.style.display = 'none';
}

function create_sub_heading_using_heading(button, projectPath, headingId, head_id_tepm, course_name, course_id, sub_course_name,sub_course_short_id) {
    const sub_heading_div = document.createElement('div');
    sub_heading_div.className = 'sub-heading';
    sub_heading_div.innerHTML = `
        <form action="${projectPath}/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update" method="post">
            <label for="new_sub_heading" class="heading_level">New Sub-heading 1</label>
            <textarea id="new_sub_heading" name="new_sub_heading_text" class="sub-heading-text" maxlength="100" rows="2" required></textarea>
            
			<input type="hidden" name="form_id" value="add-one-sub-heading" />
			<input type="hidden" name="heading_id" value="${headingId}" />
            <input type="hidden" name="sub_heading_id" value="${head_id_tepm}" />
            <input type="hidden" name="course_name" value="${course_name}" />
            <input type="hidden" name="course_id" value="${course_id}" />
            <input type="hidden" name="sub_course_name" value="${sub_course_name}" />
            <input type="hidden" name="sub_course_short_id" value="${sub_course_short_id}" />
            <button type="submit" class="add_subheading">Submit</button>
        </form>
    `;
    
    const sub_heading_definition_div = document.createElement('div');
    sub_heading_definition_div.className = 'sub-heading-defination new-sub-heading-defination';
    sub_heading_definition_div.innerHTML = `
        <label for="new_sub_heading_definition">Definition 1</label>
        <textarea id="new_sub_heading_definition" name="new_sub_heading_defination_text" class="sub-heading-defination-text" maxlength="4000" required></textarea>
    `;
    
    const sub_heading_example_div = document.createElement('div');
    sub_heading_example_div.className = 'sub-heading-example new-sub-heading-example';
    sub_heading_example_div.innerHTML = `
        <label for="new_sub_heading_example" class="example">Example 1</label>
        <textarea id="new_sub_heading_example" name="new_sub_heading_example_text" class="sub-heading-example-text" maxlength="4000" ></textarea>
    `;

    const remove_button = document.createElement('button');
    remove_button.className = 'remove-btn';
    remove_button.textContent = 'Remove';
    remove_button.type = 'button';
    remove_button.addEventListener('click', () => {
        sub_heading_div.remove(); 
        button.style.display = ''; 
    });

    const form = sub_heading_div.querySelector('form');
    form.appendChild(remove_button);
    form.appendChild(sub_heading_definition_div);
    form.appendChild(sub_heading_example_div);
     

    const current_sub_heading_div = button.closest('.heading-container');
    current_sub_heading_div.after(sub_heading_div);

    button.style.display = 'none';
}
function remove_sub_heading(heading_id, projectPath, sub_heading_id, course_name, course_id, sub_course_name,sub_course_short_id) {
        const userConfirmed = confirm("Are you sure you want to remove this sub heading? ");
        if (userConfirmed) {
            const form = document.createElement("form");
            form.action = projectPath+"/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update";
            form.method = "post";

            // Add form fields
            form.innerHTML = `
				<input type="hidden" name="form_id" value="remove-one-sub-heading" />
                <input type="hidden" name="heading_id" value="${heading_id}" />
                <input type="hidden" name="sub_heading_id" value="${sub_heading_id}" />
                <input type="hidden" name="course_name" value="${course_name}" />
                <input type="hidden" name="course_id" value="${course_id}" />
                <input type="hidden" name="sub_course_name" value="${sub_course_name}" />
                <input type="hidden" name="sub_course_short_id" value="${sub_course_short_id}" />
            `;

            document.body.appendChild(form);
            form.submit();
        } 
    }

/* remove heading form to send information on saervlet*/
function removeHeading(heading_id, projectPath, course_name, course_id, sub_course_name,sub_course_short_id) {
        const userConfirmed = confirm("Are you sure you want to remove this heading?\n" +
           "If this heading is removed, all sub headings will also be removed."
		);

        if (userConfirmed) {
            // Create a hidden form dynamically
            const form = document.createElement("form");
            form.action = projectPath+"/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update";
            form.method = "post";

            // Add form fields
            form.innerHTML = `
				<input type="hidden" name="form_id" value="remove-one-heading" />
                <input type="hidden" name="heading_id" value="${heading_id}" />
                <input type="hidden" name="course_name" value="${course_name}" />
                <input type="hidden" name="course_id" value="${course_id}" />
                <input type="hidden" name="sub_course_name" value="${sub_course_name}" />
                <input type="hidden" name="sub_course_short_id" value="${sub_course_short_id}" />
            `;

            document.body.appendChild(form);
            form.submit();
        } 
    }