<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%   String projectPath= request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.calculator-factorial</title>
<link href="<%= projectPath %>/css/user-view-pages-css/calculator-view-pages-css/matrix-main.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%
		String factorial_value_resu=null;
	    int old_value=0;	
		Object check_message = session.getAttribute("result_value");
		if (check_message != null) {
			factorial_value_resu=(String)session.getAttribute("result_value");
			session.removeAttribute("result_value");
		}
		/* factorial_value_resu =(String)request.getAttribute("result_value"); */
		if(request.getAttribute("old_value")!=null){
		old_value =(int)request.getAttribute("old_value");
		}
	%>

	<header>
		<jsp:include page="calculator-list-sidebar.jsp">
        		<jsp:param name="id" value="Factorial" />
    		</jsp:include>
	</header>
	<main>
		<form action="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/factorial-solve" method="post">
			<div class="form-group">
				<label for="factorial" class="factorial_lable">Enter number to find factorial:</label>	
				<input type="number" id="factorial" name="factorial_value" <% if (old_value != 0) { %>
					value="<%= old_value %>" <% }else{ %> autofocus <%} %> min='0' max='20' required> <br>
				<button type="submit" class="submit-btn">Submit</button>
				<input type="hidden" name="id" value="Factorial">
			</div>
		</form>
		
		<!-- factorial result show -->
		<%if(factorial_value_resu != null){ %>
			<div class="form-group">
				<label class="factorial_lable">Result :</label>
			</div>
			<input type="text" class="r_maric_input"
				value="<%=factorial_value_resu %>" readonly>
		<%} %>
		
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
</body>
</html>