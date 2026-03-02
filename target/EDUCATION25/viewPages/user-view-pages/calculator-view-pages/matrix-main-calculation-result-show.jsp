<!-- after solve matrix  data find  start -->
<%{
	String number_of_matrix_string=null;
	int number_of_matrix=0; 
	char ch='A',ch1='a'; 
	
	String projectPath= request.getContextPath();
	
	number_of_matrix_string= (String) request.getAttribute("number_of_matrix");
	if(number_of_matrix_string!=null) {					
		number_of_matrix=Integer.parseInt(number_of_matrix_string);
	}
	
	
	String first_matrix_number=null,r_operator=null,second_matrix_number=null;
	first_matrix_number=(String)request.getAttribute("first_matrix_number");
	r_operator=(String)request.getAttribute("r_operator");
	second_matrix_number=(String)request.getAttribute("second_matrix_number");	
%>

<div id="result_box">
	<div class="heading_name" id="result">
		<p class="section_heading">Results matrix</p>
	</div>
	
	<form id="matrix-solve-form"  action="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/matrix-solution"
      method="post">
		<input type="hidden" name="number_of_matrix" value="<%= number_of_matrix_string %>">
		<!-- i < number_of_matrix; -->
		<% for(int i = 0; i < 2; i++) { %>
		<div class="result_lavel_select" <%if(i==1){ %>
			id="matrix_input_group2" <%} %>>
			<label for="matrixSelect<%=i%>">Choose a matrix :</label> 
			<select	name="matrix<%=i%>" id="matrixSelect<%=i%>"
				class="select_matrix_box" required>
				<%ch = 'A';
                 for(int j = 0; j < number_of_matrix; j++) {%>
				<option class="option" value="<%= (j + 1) %>"
					<%if(i==0){
                		   if(String.valueOf((j+1)).equals(first_matrix_number)){%>
					selected
					<%} } else if(i==1){
                		   if(String.valueOf((j+1)).equals(second_matrix_number)){%>
					selected <%} }%>>Matrix
					<%= ch %>
				</option>
				<%ch++;}%>
			</select>
		</div>
		<!-- (number_of_matrix-1) -->
		<%if(i<(2-1)){ %>
		<div class="form-group">
			<label for="operator<%=i%>">Choose a operator :</label> 
			<select	name="operator<%=i%>" id="operator<%=i%>" required>
				<option class="option" value="+" <%if("+".equals(r_operator)){%>
					selected <%} %>>+</option>
				<option class="option" value="-" <%if("-".equals(r_operator)){%>
					selected <%} %>>-</option>
				<option class="option" value="*" <%if("*".equals(r_operator)){%>
					selected <%} %>>*</option>
				<option class="option advance_option" value="d"
					<%if("d".equals(r_operator)){%> selected <%} %>>determinant</option>
				<option class="option advance_option" value="t"
					<%if("t".equals(r_operator)){%> selected <%} %>>transpose</option>
				<option class="option advance_option" value="c"
					<%if("c".equals(r_operator)){%> selected <%} %>>Co-factor</option>
				<option class="option advance_option" value="a"
					<%if("a".equals(r_operator)){%> selected <%} %>>adjA</option>
				<option class="option advance_option" value="i"
					<%if("i".equals(r_operator)){%> selected <%} %>>invers</option>
			</select>
		</div>
		<%} %>
		<% } %>
		<div id="hiddenMatrixContainer" style="display:none;"></div>
		<div id="result_button">
			<button type="button" onclick="solveMatrix()">Solve</button>
		</div>
		<input type="hidden" name="id" value="Matrix"> 
	</form>	
	
	<!--this page show result value -->
	<%@ include 	file="matrix-main-calculation-result-show-values.jsp"%>	
	
</div>
<%if("d".equals(r_operator)|| "t".equals(r_operator)||"c".equals(r_operator)||"a".equals(r_operator)||"i".equals(r_operator)) {%>	
		<script src="../../../js/user-view-pages-js/calculator-view-pages-js/matrix-main-calculation-second-matrix-input.js"></script>
	<%}%>
	
	<script src="../../../js/user-view-pages-js/calculator-view-pages-js/matrix-main-calculation.js"></script>
<%}%>
