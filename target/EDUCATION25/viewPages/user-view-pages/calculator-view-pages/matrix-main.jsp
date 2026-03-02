<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%   String projectPath= request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.calculator-matrix</title>
<link href="<%= projectPath %>/css/user-view-pages-css/calculator-view-pages-css/matrix-main.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include file="../comman-web-information/message-show.jsp"%>
	<%String	No_Of_matrix=null;
	    No_Of_matrix = request.getParameter("number_of_matrix");
	    String matrix_message_row_coloumn=null;
	    matrix_message_row_coloumn=(String)request.getAttribute("matrix_message_row_coloumn");
	    int num = 0,i=0;
	    if (No_Of_matrix != null) {
	        try {
	            num = Integer.parseInt(No_Of_matrix);
	        } catch (NumberFormatException e) {
	            num = 0; 
	        }
	    }
	%>
	<header>
		<jsp:include page="calculator-list-sidebar.jsp">
        		<jsp:param name="id" value="Matrix" />
    		</jsp:include>
	</header>
	
	<main>    
		<section class="section">
			<%if(matrix_message_row_coloumn==null){ %>			
				<!--Matrix start Enter number of matrix   -->
				<% if(No_Of_matrix==null){ %>
					<jsp:include page="matrix-main-form-enter-number-of-matrix.jsp" />
				<%}else{ %>
					<!-- after complete Enter number of matrix and submit, then start Enter row and colomn -->
					<jsp:include page="matrix-main-form-enter-row-and-colomn.jsp" />
				<%}%>
			<%}else{ %>
				<!-- after complete Enter Enter row and coloumn and submit, then start Enter row and colomn element -->
				<jsp:include page="matrix-main-form-enter-elements.jsp" />
			<%} %>
		</section>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
</body>
</html>