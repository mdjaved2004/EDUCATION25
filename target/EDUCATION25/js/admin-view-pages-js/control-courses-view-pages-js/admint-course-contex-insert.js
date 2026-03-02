let heading_container, addHeadingButton;
let heading_no = 0;

 window.onload = function() {	
	let submit_button = document.getElementById("submit_botton");
	submit_button.disabled =true; 
    heading_container = document.getElementById("heading");
    addHeadingButton = document.getElementById("addHeadingButton");
    addHeadingButton.onclick = addHeading;
  };
  
 //add the div which inner create level and textarea. 
function addHeading() {
    heading_no++;
	let submit_button = document.getElementById("submit_botton");
    if (heading_no === 1) {
        submit_button.disabled = false; // Show button
    } 
  if (heading_no >= 21) {
	    alert("Maximum 20 Heading ");
	    return;
	}
	const newHeadingDiv = document.createElement("div");
	newHeadingDiv.id = "heading-container-" + heading_no;
	newHeadingDiv.className = "heading-container";
	
	const label = document.createElement("label");
	label.setAttribute("for", "heading" + heading_no);
	label.textContent = "Heading " + heading_no;
	label.className = "heading_level";
	
	const textarea = document.createElement("textarea");
	textarea.id = "heading" + heading_no;
	textarea.name = "heading" + heading_no;
	textarea.rows = 2;
	textarea.className = "heading_text";
	textarea.maxLength = 100;
	textarea.placeholder = "Enter heading name";
	if (heading_no === 1) {
		textarea.required = true; 
	}

	
	
		 /*  const removeButton = document.createElement("button");
	removeButton.className = 'remove-btn';
	removeButton.id = "heading-remove" + heading_no;
	removeButton.textContent = 'Remove Heading';
	removeButton.onclick = function() {
	    newHeadingDiv.remove(); // Remove heading container
	    updateHeadingIndices(); // Update heading and sub-heading numbers after removal
	};
	*/
	// create button for adding sub-headings
	const addSubHeadingButton = document.createElement("button");
	addSubHeadingButton.textContent = "Add sub-heading";
	addSubHeadingButton.className = "add-sub-heading-button";
	addSubHeadingButton.type = "button";
	addSubHeadingButton.id = heading_no;
	addSubHeadingButton.onclick = function() {
	    addSubHeading(newHeadingDiv, addSubHeadingButton.id);
	};
	
	newHeadingDiv.appendChild(label);
	newHeadingDiv.appendChild(textarea);
	newHeadingDiv.appendChild(addSubHeadingButton);
	
	heading_container.appendChild(newHeadingDiv);
	
	updateHeadingIndices();
}

//add the sub-heading div which inner create level and textarea. 
function addSubHeading(headingDiv, headingNumber) {
	const subHeadingCount = headingDiv.getElementsByClassName("sub-heading").length;
	if (subHeadingCount >= 26) {
	    alert("Maximum 26 sub-headings reached for Heading " + headingNumber + ".");
	    return;
	}
	
	const subHeadingDiv = document.createElement("div");
	subHeadingDiv.className = "sub-heading";
	
	const subLabel = document.createElement("label");
	const subLetter = String.fromCharCode(97 + subHeadingCount); // a, b, c
	subLabel.setAttribute("for", "sub-heading" + headingNumber + subLetter);
	subLabel.textContent = "Sub-Heading " + headingNumber + subLetter;
	subLabel.className = "heading_level";
	
	const subTextarea = document.createElement("textarea");
	subTextarea.id = "sub-heading" + headingNumber + subLetter;
	subTextarea.name = "sub-heading" + headingNumber + subLetter;
	subTextarea.rows = 2;
	subTextarea.className = "sub-heading-text";
	subTextarea.maxLength = 100;
	subTextarea.placeholder = "Enter sub-heading name";
	subTextarea.required = true;
	

	const removeSubHeadingButton = document.createElement("button");
	removeSubHeadingButton.textContent = "Remove Sub-Heading";
	removeSubHeadingButton.id ="sub-heading-remove"+ headingNumber + subLetter;
	removeSubHeadingButton.type = "button";
	removeSubHeadingButton.className = "remove-btn";
	
	removeSubHeadingButton.onclick = function() {
		
		subHeadingDiv.remove();
		
		// correctly calculate the heading number and subLetter.
		const subLetter = subHeadingDiv.querySelector("label").textContent.slice(-1); // Get last character from label
		const headingNumber = headingDiv.id.split('-').pop(); // Assuming headingDiv id is like 'heading-container-1'
		
		// find and remove the related definition and example textareas
		const definitionTextarea = headingDiv.querySelector("#definition" + headingNumber + subLetter);
		const exampleTextarea = headingDiv.querySelector("#example" + headingNumber + subLetter);
		
		// remove definition and textarea, if found.
		if (definitionTextarea && definitionTextarea.parentElement) {
		    definitionTextarea.parentElement.remove(); // Definition container remove
		    
		} 		
		// remove example textarea, if found.
		if (exampleTextarea && exampleTextarea.parentElement) {
		    exampleTextarea.parentElement.remove(); 
		  }
		
		
		updateSubHeadingIndices(headingDiv, headingNumber);
	};
	
    subHeadingDiv.appendChild(subLabel);
    subHeadingDiv.appendChild(subTextarea);
    subHeadingDiv.appendChild(removeSubHeadingButton);
    headingDiv.appendChild(subHeadingDiv);

   
    addDefinationBox(headingDiv, headingNumber, subLetter);
    addExampleBox(headingDiv, headingNumber, subLetter);
    updateSubHeadingIndices(headingDiv, headingNumber);
}


//add the defination div which inner create level and textarea. 
function addDefinationBox(headingDiv, headingNumber, subLetter) {
	const defination_div_create = document.createElement("div");
	defination_div_create.className = "sub-heading-defination";
	
	const defination_level = document.createElement("label");
	defination_level.setAttribute("for", "definition" + headingNumber + subLetter); // Corrected here
	defination_level.textContent = "Definition: " + headingNumber + subLetter;
	
	const defination_textarea = document.createElement("textarea");
	defination_textarea.id = "definition" + headingNumber + subLetter; // Corrected here
	defination_textarea.name = "sub-heading-defination" + headingNumber + subLetter;
	defination_textarea.className = "sub-heading-defination-text";
	defination_textarea.maxLength = 3500;
	defination_textarea.placeholder = "Enter definition (max length 3500 characters)";
	defination_textarea.value = "";
	defination_textarea.required = true;
	
	defination_div_create.appendChild(defination_level);
	defination_div_create.appendChild(defination_textarea);
	headingDiv.appendChild(defination_div_create);
}

     
//add the example div which inner create level and textarea.   
function addExampleBox(headingDiv, headingNumber, subLetter) {
    const example_div_create = document.createElement("div");
    example_div_create.className = "sub-heading-example";

    const example_level = document.createElement("label");
    example_level.setAttribute("for", "example" + headingNumber + subLetter);
    example_level.textContent = "Example: " + headingNumber + subLetter;
    example_level.className = "example";
    const example_textarea = document.createElement("textarea");
    example_textarea.id = "example" + headingNumber + subLetter;
    example_textarea.name = "sub-heading-example" + headingNumber + subLetter;
    example_textarea.className = "sub-heading-example-text";
 	example_textarea.maxLength = 3500;
    example_textarea.placeholder = "Enter example (max length 3500 characters)";
    example_textarea.value = "";

    example_div_create.appendChild(example_level);
    example_div_create.appendChild(example_textarea);
    headingDiv.appendChild(example_div_create);
}


function updateHeadingIndices() {
	const headings = document.getElementsByClassName("heading-container");
	
	for (let i = 0; i < headings.length; i++) {
	    const label = headings[i].querySelector("label");
	    const textarea = headings[i].querySelector("textarea");
	
	    // update heading label and textarea.
	    label.textContent = "Heading " + (i + 1);
	    textarea.id = "heading" + (i + 1);
	    textarea.name = "heading" + (i + 1);
	
	    // update sub-heading button id.
	    const addSubHeadingButton = headings[i].querySelector("button");
	    addSubHeadingButton.id = (i + 1);
	    
	    
	    
	    const headingDiv = headings[i];
	    const headingNumber = (i + 1);
	    updateSubHeadingIndices(headingDiv, headingNumber);
	}
}

function updateSubHeadingIndices(headingDiv, headingNumber) {
    const subHeadings = headingDiv.getElementsByClassName("sub-heading");

    for (let i = 0; i < subHeadings.length; i++) {
        const subLabel = subHeadings[i].querySelector("label");
        const subTextarea = subHeadings[i].querySelector("textarea");
        const newLetter = String.fromCharCode(97 + i);
        const removeSubHeadingButton = subHeadings[i].querySelector("button");
        removeSubHeadingButton.id="sub-heading-remove"+ headingNumber + newLetter; // a, b, c, etc.
        // update sub-heading label and textarea.
        subLabel.textContent = "Sub-Heading " + headingNumber + newLetter;
        subLabel.setAttribute("for", "sub-heading" + headingNumber + newLetter);
        subTextarea.id = "sub-heading" + headingNumber + newLetter;
        subTextarea.name = "sub-heading" + headingNumber + newLetter;

        //update the Definition and Example fields with the same index.
        const definationDiv = subHeadings[i].nextElementSibling;  
        const exampleDiv = definationDiv.nextElementSibling;     

        if (definationDiv) {
            const defTextarea = definationDiv.querySelector("textarea");
            const defLabel = definationDiv.querySelector("label");

            // update Definition label and textarea.
            defLabel.textContent = "Definition: " + headingNumber + newLetter;
            defLabel.setAttribute("for", "definition" + headingNumber + newLetter);
            defTextarea.id = "definition" + headingNumber + newLetter;
            defTextarea.name = "definition" + headingNumber + newLetter;
        }

        if (exampleDiv) {
            const exampleTextarea = exampleDiv.querySelector("textarea");
            const exampleLabel = exampleDiv.querySelector("label");

            // update Example label and textarea.
            exampleLabel.textContent = "Example: " + headingNumber + newLetter;
            exampleLabel.setAttribute("for", "example" + headingNumber + newLetter);
            exampleTextarea.id = "example" + headingNumber + newLetter;
            exampleTextarea.name = "example" + headingNumber + newLetter;
        } 
    }
}