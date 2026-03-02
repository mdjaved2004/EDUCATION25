<%
String number_of_matrix_temp =request.getParameter("number_of_matrix");
int number_of_matrix=0,i=0;
char ch='A',ch1='a';
%>
<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/calculator-view-pages/matrix-solve" method="post">
	 <!-- Send data number of total matrix  -->
	 <input type="hidden" name="number_of_matrix" value="<%=number_of_matrix_temp%>">
	 
	<%i=0;
	if (number_of_matrix_temp != null) {
	        try {
	       	 	number_of_matrix = Integer.parseInt(number_of_matrix_temp);
	        } catch (Exception e) {
	            number_of_matrix = 0; 
	        }
	  }				 
	  /* create two array  */				
	   int[] matrix_row=new  int[number_of_matrix];
	   int[] matrix_colomn=new  int[number_of_matrix];
	   for( i=0;i<number_of_matrix;i++) {
		   
		   String rows="matrix_row"+(i+1);
		   String colomns="matrix_colomn"+(i+1);
			
			//get  matrix rows and colomns
			matrix_row[i]= (Integer) request.getAttribute(rows);
			matrix_colomn[i]=(Integer) request.getAttribute(colomns); 
			%>
			<!-- Send  matrix rows and colomns number -->
			 <input type="hidden" name="<%= rows%>" value="<%= matrix_row[i]%>">
			 <input type="hidden" name="<%= colomns%>" value="<%= matrix_colomn[i]%>">
			
			<%
	   }					 
	
	   for (i = 0; i < number_of_matrix; i++) {%>
			<div class="form-group">
				<label for="matrix<%=i+1 %>" class="lable">Matrix <%= ch %>:	</label>
				<input type="number" id="matrix<%=i+1 %>" name="Matrix<%=i+1 %>"	value="<%=i+1 %>" hidden>
			</div>

			<% for (int j = 0; j < matrix_row[i]; j++) { %>
			<div class="form-group">
				<% for (int k = 0; k < matrix_colomn[i]; k++) { %>
					<label for="matrix<%=i + 1 %>_element<%=j %>_<%=k %>" class="lable">
						<% out.print(ch1); %><sub> <% out.print(j + 1); %><%=k + 1 %></sub>:
					</label>
					<input type="number" id="matrix<%=i + 1 %>_element<%=j %>_<%=k %>" name="m<%=i + 1 %>_r<%=j %>_c<%=k %>" step="any"
						<%if(matrix_row[i]==3&&matrix_colomn[i]==3){%> max="1400" <%}else if(matrix_row[i]==4&&matrix_colomn[i]==4){%> max="1000"
						<%}else{%> max="1500" <%}%> <% if(i==0 && j==0 && k==0){ %> 	autofocus <% } %> required>
					<% } %>
			</div>
		    <% } %>
		<% 
		ch++; ch1++; 
		}%>
		<button type="submit" id="submit-btn">Submit</button>
		<input type="hidden" name="id" value="Matrix">
	</form>