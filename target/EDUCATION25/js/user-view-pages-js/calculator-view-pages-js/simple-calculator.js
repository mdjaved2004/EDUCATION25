let string = "";
let string2 = "";
let input_box = document.querySelector('#input_box');
let input_box2 = document.querySelector('#input_box2');
let buttons = document.querySelectorAll('button');
let lastLetter = 'null';

const operators = ['*', '/','+','-','%'];
const operators1 = ['*', '/','%'];


document.addEventListener('click', (e) => {
    const buttonValue = e.target.innerHTML;
	// Check if clicked element is .button OR .button-icon
	  if (!(e.target.classList.contains("button") || 
	        e.target.classList.contains("button-icon"))) {
	      return;
	  }
    if (buttonValue === '=') {
		if((string!=='') && !operators.includes(lastLetter)){			
        	string2 = string;
        	try {
                string = String(eval(string));
                input_box.value = string;  
                input_box2.value = string2;
            } catch (error) {
                input_box.value = "Error";
                string = ""; 
            }
      }
    }else if (buttonValue === 'C') {  
		//data clean.        
        string = "";
        string2 = "";
        input_box.value = string;  
        input_box2.value = string;  

    } else if (buttonValue === 'ce') {
             // remove the last character.
        string = string.slice(0, -1);
        input_box.value = string;            
        try {
            string2 = string;
            input_box2.value = string2.length > 0 ? eval(string2) : ""; 
        } catch (error) {
            input_box2.value = "";
        }
     }
     else if (string === "" && operators1.includes(buttonValue)){
		   
	  }
	  else if ((string ==='-'|| string ==='+')&&operators.includes(buttonValue)){
              if(buttonValue === '+' || buttonValue === '-') {
                          string = buttonValue;
                          input_box.value = string;
       }
       else{
		
	   }
    } else if (operators.includes(buttonValue) && operators.includes(lastLetter)) {
           //remove last character of string and add present buttonValue.
           string = string.slice(0, -1) + buttonValue;
           input_box.value = string;
           
      } else {		
        string += buttonValue;   
        input_box.value = string;        
        lastLetter = string[string.length - 1];            
        try {
            string2 = string;
            input_box2.value = string2.length > 0 ? eval(string2) : "";
        } catch (error) {
            input_box2.value = ""; 
        }
    }
});

function historyULClick(historyId){
	let li1 = document.getElementById(historyId + "1");
	   let li2 = document.getElementById(historyId + "2");

	   if (!li1 || !li2) return;

	   input_box.value = li1.textContent.trim();
	   input_box2.value = li2.textContent.trim();
	   
	   string = li1.textContent.trim();
	   string2 = li2.textContent.trim();
}
