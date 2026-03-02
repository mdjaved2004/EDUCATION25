<form action="matrix-main.jsp" method="post">
	<div class="form-group">
		<label for="matrix" class="lable">Enter number of matrix : </label> 
		<input type="number" id="matrix" name="number_of_matrix" min="1" max="4"
			autofocus required> <br>
		<button type="submit" class="submit-btn">Submit</button>
	</div>
	<input type="hidden" name="id" value="Matrix">
</form>