const historyBtn = document.getElementById("history");
const historyBox = document.getElementById("historyBox");

// Get input boxes
let input_field = document.querySelector('#input_box');
let input_field2 = document.querySelector('#input_box2');

// Get button equal(=)
let button_equal = document.querySelector('#button-equal'); 

// Get button for close historyBox
const closeHistory = document.getElementById("closeHistory");

// Get button for delete history inner historyBox
const deleteAllBtn = document.getElementById("deleteAll");

const operators_all = ['*', '/', '+', '-', '%'];

let historyElementNo=1; 
// Show box when clicking History
historyBtn.addEventListener("click", function () {
    historyBox.style.display = "block";
});

closeHistory.addEventListener("click", function() {
    historyBox.style.display = "none";
});



button_equal.addEventListener("click", function () {
    let firstValue = input_field.value.trim();
    let secondValue = input_field2.value.trim();

    // Check both fields are not empty
    if (firstValue !== "" && secondValue !== "") {
        // Check which input has operator
        const firstHasOperator = checkStringCharacterOneByOne(firstValue,operators_all);
        const secondHasOperator = checkStringCharacterOneByOne(secondValue,operators_all);

        // Only one input should have operator
        if (firstHasOperator && !secondHasOperator) {
            // first input has operator
            var innerList = [firstValue, secondValue];
        } else if (!firstHasOperator && secondHasOperator) {
            // second input has operator
            var innerList = [secondValue, firstValue];
        }else{
			return;
		}

		// Create inner UL and append
        const innerUl = document.createElement("ul");
        innerUl.className = "history-inner-ul";
		let id="history-inner-ul"+historyElementNo;
		innerUl.id =id;
		historyElementNo++;
		innerUl.setAttribute("onclick", `historyULClick('${id}')`);
		
		let innerULId=1;
        innerList.forEach(val => {
            const li = document.createElement("li");
            li.textContent = val;
			li.id =id+innerULId;
			innerULId++;
            innerUl.appendChild(li);
        });

        historyList.appendChild(innerUl);
    }
});

function checkStringCharacterOneByOne(str, operators_all) {
    for (let i = 1; i < str.length; i++) { 
        if (operators_all.includes(str[i])) {
            return true;  
        }
    }
    return false;
}

deleteAllBtn.addEventListener("click", function () {
	const confirmDelete = confirm("Are you sure you want to delete all history?");
	if (confirmDelete) {
		historyList.innerHTML = "";
		historyElementNo = 1;
	}
});
