<!-- after solve quadrilateral show data on page -->
<% 
	String result=null,result_text=null;

	result=(String) request.getAttribute("result_value");
	result_text=(String) request.getAttribute("result_text");
	if(result != null){ %>
		<div class="form-group">
			<label class="lable">Result : <% if(result_text!=null){ out.print(result_text);}%></label>
		</div>
		<%if(request.getAttribute("operator").equals("all_r")){  %>
		<p class="result_all_operation" class="result"><%=result %></p>
		<%}else{ %>
			<input type="text" class="r_maric_input" value="<%=result %>" readonly>
		<%}
	}
%>