function certificateShow(number) {
    // Get values from hidden inputs
    const paperNameValue = document.querySelector(`input[name="papername_${number}"]`).value;
    const marksInputValue = document.querySelector(`input[name="marks_${number}"]`).value;

    const marks = parseFloat(marksInputValue);

    // Get certificate and error divs
    const certificateDiv = document.querySelector("#certificate_div");
    const certificateBox = document.querySelector("#certificate");
    const errorDiv = document.querySelector("#error_message");

    // Set subject and marks in certificate
    const subjectElement = certificateDiv.querySelector("#certificate_subject");
    subjectElement.innerHTML = `<b>Subject : </b> ${paperNameValue}`;

    const marksElement = certificateDiv.querySelector("#certificate_marks");
    marksElement.innerHTML = `<b>Marks : </b> ${marksInputValue}%`;

    // Show certificate or error based on marks
    if (marks >= 35) {
		const imagePath ='https://res.cloudinary.com/doiv9mzx7/image/upload/v1771835032/certificate_m2zaat.png';
		certificateBox.style.background = `url(${imagePath})`;
		certificateBox.style.backgroundRepeat = "no-repeat";
		certificateBox.style.backgroundPosition = "center center";
		certificateBox.style.backgroundSize = "cover";	
        certificateDiv.style.display = "flex";
		certificateDiv.style.justifyContent = "center";
		
		document.querySelector("#download_certificate").style.display = "block";
		
        errorDiv.style.display = "none";
    } else {
        certificateDiv.style.display = "none";
		document.querySelector("#download_certificate").style.display = "none";
        errorDiv.style.display = "block";
    }
}
