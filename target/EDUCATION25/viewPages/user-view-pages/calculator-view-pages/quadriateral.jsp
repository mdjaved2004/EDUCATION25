<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String projectPath= request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.calculator-quadriateral</title>
<link href="<%= projectPath %>/css/user-view-pages-css/calculator-view-pages-css/circle.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%
	String r_operator=null, old_value_width_String=null, old_value_height_String=null;
	float old_value_width=0,old_value_height=0;
	
	r_operator=(String) request.getAttribute("operator");
	
	old_value_width_String=(String) request.getAttribute("width");
	old_value_height_String=(String) request.getAttribute("length");
		
	if (old_value_width_String != null) {
		old_value_width=Float.parseFloat(old_value_width_String);
	}
	if (old_value_height_String != null) {
		old_value_height=Float.parseFloat(old_value_height_String);
	}

	%>
	<header>
		<jsp:include page="calculator-list-sidebar.jsp">
        		<jsp:param name="id" value="Quadriateral" />
    		</jsp:include>
	</header>
	<main>
		<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/calculator-view-pages/quadrilateral-solve" method="post">
			<div class="form-group">
				<label for="quadriated_width_input" class="lable">Enter the width of quadrilateral :</label>
				<input type="number" 	id="quadriated_width_input" name="quadriated_width_input"
					step="any" <% if (old_value_width != 0) { %>	value="<%= old_value_width %>" <% }else{ %> autofocus <%} %>
					max='1500' required>
				<div class="form-group">
					<label for="operator" class="lable">Choose a perform
						operator:</label> <select name="operator" id="operator"
						class="select select1" required>
						<option class="option" value="a" <%if("a".equals(r_operator)){%>
							selected <%} %>>Area</option>
						<option class="option" value="p" <%if("p".equals(r_operator)){%>
							selected <%} %>>Perimeter</option>
						<option class="option" value="d" <%if("d".equals(r_operator)){%>
							selected <%} %>>Diagonal</option>
						<option class="option" value="all_r"
							<%if("all_r".equals(r_operator)){%> selected <%} %>>All
							operaters</option>
					</select>
				</div>
				<label for="quadriated_height_input" class="lable">Enter the height of quadrilateral :</label> 
				<input type="number" step="any"	id="quadriated_height_input" name="quadriated_height_input"
					<% if (old_value_height != 0) { %> value="<%= old_value_height %>"<% }else{ %> autofocus <%} %> max='1500' required>
					<br>
				<button type="submit">Submit</button>
				<input type="hidden" name="id" value="Quadriateral">
			</div>
		</form>
		
		<!--this page show quadrilateral result -->
		<%@ include 	file="quadriateral-result-show.jsp"%>
		
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
</body>
</html>