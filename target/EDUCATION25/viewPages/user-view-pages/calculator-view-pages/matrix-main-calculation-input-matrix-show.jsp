<!-- { } this is block in java (this block use solve duplicate variable)  -->

<% {
	String number_of_matrix_string=null;
	int number_of_matrix=0, i, j,k; 
	double doubleNum=0;
	char ch='A',ch1='a';
	
	number_of_matrix_string= (String) request.getAttribute("number_of_matrix");

	if(number_of_matrix_string!=null) {					
		number_of_matrix=Integer.parseInt(number_of_matrix_string);
	}
%>

<div id="matrix_inputs">					
	<div class="heading_name" id="matrix_record">
		<p class="section_heading">Shows Matrix</p>
	</div>
	
	<span id="matrix_include"> 
		<label>Total number of matrix: <%=number_of_matrix %></label> <%int[] matrix_row=new  int[number_of_matrix];
	    int[] matrix_colomn=new  int[number_of_matrix];
	    %>
	    
	    <div id="matrix_rows_and_columns" style="display:none;">
		    <%
		    for( i=0;i<number_of_matrix;i++) {
		    		String rows = "matrix_row" + (i + 1);
				String colomns = "matrix_colomn" + (i + 1);
				
				String input_row=(String) request.getAttribute(rows);
				String input_colomn=(String)request.getAttribute(colomns);
				
				if(input_row!=null)
					matrix_row[i] = Integer.parseInt(input_row);
				
				if(input_colomn!=null)
					matrix_colomn[i] = Integer.parseInt(input_colomn);
				
				%>
				<!-- Send  matrix rows and colomns number -->
				 <input type="hidden" name="<%=rows%>" value="<%= matrix_row[i]%>">
				 <input type="hidden" name="<%= colomns%>" value="<%= matrix_colomn[i]%>">
				
				<%
				
		    }%>
	    </div>
	    <%
	    for (i = 0; i < number_of_matrix; i++) { %>
		    <div class="form-group">
		        <label>Matrix <%= ch %>: </label>
		    </div>

		    <div id="matrix<%= i + 1 %>">
		        <% for (j = 0; j < matrix_row[i]; j++) { %>
		            <div class="matrix_input_group">
		                <% for (k = 0; k < matrix_colomn[i]; k++) { 
		                       String matrix_input = "m" + (i + 1) + "_r" + j + "_c" + k;
		                       doubleNum = Double.parseDouble(request.getParameter(matrix_input));
		                %>
	
		                    <!-- write input data send -->
		                    <label for="matrix<%= i + 1 %>_element<%= j %>_<%= k %>">
		                        <%= ch1 %><sub><%= j + 1 %><%= k + 1 %></sub>:
		                    </label>
	
		                    <input type="number"
		                           id="matrix<%= i + 1 %>_element<%= j %>_<%= k %>"
		                           class="input_number"
		                           name="m<%= i + 1 %>_r<%= j %>_c<%= k %>"
		                           value="<%= doubleNum %>"
		                           readonly>
	
		                		<% } %>
		            		</div>
		        <% } %>
		    </div>

		<%ch++; ch1++;
		} %>
	</span>
</div>
<%}%>