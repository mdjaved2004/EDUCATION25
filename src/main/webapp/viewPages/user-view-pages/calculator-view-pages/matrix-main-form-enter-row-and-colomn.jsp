<%
String No_Of_matrix =null;
int num = 0,i=0;
No_Of_matrix =request.getParameter("number_of_matrix");
if(No_Of_matrix!=null){
	num = Integer.parseInt(No_Of_matrix);	
}

char ch = 'A';
%>

<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/calculator-view-pages/matrix-templet" method="post">
	<div class="form-group">
		<label class="lable">Total number of matrix : <%= num %></label>
		<input type="hidden" id="matrix" name="number_of_matrix" min="1" max="4"	value="<%= num %>" readonly>
	</div>
	<%for (i = 1; i <= num; i++) { %>
		<div class="form-group">
			<label for="matrix_row<%= i%>" class="lable">Matrix <%= ch%> size (rows, cols) : </label>
			<div class="input_group">
				<input type="number" class="matrix<%= i%>" id="matrix_row<%= i%>" 
					name="matrix_row<%= i%>" min="1" max="4" <% if(i==1){ %>	autofocus <% } %> required>
				<input type="number" class="matrix<%= i%>" id="matrix_colomn<%= i%>"
					name="matrix_colomn<%= i%>" min="1" max="4" required>
			</div>
		</div>
	<% ch++;
	} %>
	<button type="submit" class="submit-btn">Submit</button>
	<input type="hidden" name="id" value="Matrix">
</form>