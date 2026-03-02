<!-- after solve matrix show data on page -->
<%{
	String message_error=null,r_rows_string=null, r_columns_string=null, result_value=null;
	int r_rows=0,r_columns=0;
	double[][] result = null;
	
	message_error=(String)request.getAttribute("message_error");
	r_rows_string=(String)request.getAttribute("r_rows"); 
	r_columns_string=(String)request.getAttribute("r_columns");
	result_value=(String)request.getAttribute("result_value");
	result = (double[][]) request.getAttribute("result");
	
	if (r_rows_string != null && r_columns_string != null) {
		 r_rows=Integer.parseInt(r_rows_string);
		 r_columns=Integer.parseInt(r_columns_string);
	}

%>

	<% if(message_error!=null){ %>
		<p class="result_values_text"><%=message_error%></p>
	<%}
		if ((r_rows != 0 && r_columns != 0)||result_value!=null) { %>
			<div class="form-group">
				<label>Result R:</label>
			</div>
	 <% 	}
 		if (r_rows != 0 && r_columns != 0) {
			for (int i = 0; i < r_rows; i++) { %>
			<div class="matrix_input_group">
				<% for (int j = 0; j < r_columns; j++) { %>
				<label for="element<%= i %><%= j %>" class="result_lavel">r<sub><%=i + 1 %><%= j + 1 %></sub>:
				</label> <input type="number" class="r_maric_input"
					id="element<%= i %><%= j %>" value="<%=result[i][j] %>" readonly>
				<% } %>
			</div>
		<% } %>
	 <% } 
	if(result_value!=null){ %>
		<div id="result_value"><%=result_value%></div>
	<%} %>
<%}%>