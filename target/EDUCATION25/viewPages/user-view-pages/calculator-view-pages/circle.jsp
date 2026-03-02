<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%   String projectPath= request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.calculator-circle</title>
<link href="../../../css/user-view-pages-css/calculator-view-pages-css/circle.css" type="text/css" rel="stylesheet">
</head>
<body>

	<%String r_operator=null,old_value_string=null;
	float old_value=0;
	r_operator=(String) request.getAttribute("operator");
	old_value_string=(String) request.getAttribute("old_value");
	
	if (old_value_string != null) {
		old_value=Float.parseFloat(old_value_string);
	}
	%>
	<header>
		<jsp:include page="calculator-list-sidebar.jsp">
        		<jsp:param name="id" value="Circle" />
    		</jsp:include>
	</header>
	<main>
		<form action="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/circle-solve" method="post">
			<div class="form-group">
				<label for="circle_redious_input" class="lable">Enter the
					redius of circle:</label> <input type="number" id="circle_redious_input"
					name="circle_redious_input" step="any" <%if (old_value != 0) {%>
					value="<%=old_value%>" <%} else {%> autofocus <%}%> max='1500'
					required>
				<div class="form-group">
					<label for="operator" class="lable">Choose a perform
						operator:</label> <select name="operator" id="operator" class="select"
						required>
						<option class="option" value="a" <%if ("a".equals(r_operator)) {%>
							selected <%}%>>Area</option>
						<option class="option" value="d" <%if ("d".equals(r_operator)) {%>
							selected <%}%>>Diameter</option>
						<option class="option" value="c" <%if ("c".equals(r_operator)) {%>
							selected <%}%>>Circumfarence</option>
						<option class="option" value="s" <%if ("s".equals(r_operator)) {%>
							selected <%}%>>Semicircle aria</option>
						<option class="option" value="all_r"
							<%if ("all_r".equals(r_operator)) {%> selected <%}%>>All
							upper operaters</option>
					</select>
				</div>
				<br>
				<button type="submit" class="submit-btn">Submit</button>
				<input type="hidden" name="id" value="Circle">
			</div>
		</form>
		
		<!--this page show circle result -->
		<%@ include 	file="circle-result-show.jsp"%>
	</main>

	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
</body>
</html>