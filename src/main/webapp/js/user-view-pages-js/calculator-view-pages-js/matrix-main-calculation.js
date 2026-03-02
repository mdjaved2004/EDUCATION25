const operatorSelect = document.querySelector("#operator0");
operatorSelect.addEventListener("change", () => {
    const selectedValue = operatorSelect.value;
    const matrixInputGroup2 = document.querySelector("#matrix_input_group2");

    if (matrixInputGroup2) {
        if (selectedValue === "d" || selectedValue === "t" || selectedValue === "c" || selectedValue === "a" || selectedValue === "i") {
            matrixInputGroup2.style.display = "none";
        } else {
            matrixInputGroup2.style.display = "block";
        }
    }
});