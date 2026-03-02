window.onload = function () {
    if (successMessage?.trim()) showAlert(successMessage, "success");
    else if (errorMessage?.trim()) showAlert(errorMessage, "error");
};

function showAlert(msg, type) {
    const alertBox = document.createElement("div");
    alertBox.className = "simple-alert " + type;
    alertBox.id = "message-alert";

    alertBox.innerHTML = `
        <div class="alert-msg">${msg}</div>
        <div class="button-conformation">
            <button class="alert-btn" onclick="hideAlert()">OK</button>
        </div>
    `;

    document.body.appendChild(alertBox);
}

function hideAlert() {
    const alertBox = document.getElementById("message-alert");
    if (alertBox) {
        alertBox.remove();   // OR alertBox.style.display = "none";
    }
}


