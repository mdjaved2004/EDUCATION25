function solveMatrix() {
    const form = document.getElementById("matrix-solve-form");

    const number_of_matrix = parseInt(
		form.querySelector("input[name='number_of_matrix']").value
    );

    const hiddenDiv = document.getElementById("hiddenMatrixContainer");
    hiddenDiv.innerHTML = ""; // clear previous data
	
	hiddenDiv.append(document.getElementById("matrix_rows_and_columns").cloneNode(true));
	
    for (let i = 0; i < number_of_matrix; i++) {

        let matrixDiv = document.getElementById("matrix" + (i + 1));

        if (matrixDiv) {
            hiddenDiv.append(matrixDiv.cloneNode(true));
        }
    }
	form.submit();
}
