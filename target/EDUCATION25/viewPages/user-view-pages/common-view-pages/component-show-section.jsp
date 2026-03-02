<!-- Mini-components section start --> 
<%   String projectPath= request.getContextPath();%>
<link href="<%= projectPath %>/css/user-view-pages-css/common-view-pages-css/component-show-section.css" type="text/css" rel="stylesheet">

<!-- Static page include  -->
<%@ include file="../comman-web-information/user-user-name-get.jsp" %>

<div class="section">
	<div class="links_box">
		<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/simple-calculator.jsp?id=Simple_Calculator">calculator</a>
	</div>
	<div class="links_box">
		<a href="<%= projectPath %><%if(user_user_name!=null){ %>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/GetCertificate
		<%}else{%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>">Get certificate</a>
	</div>
	<div class="links_box">
		<a href="<%= projectPath %><%if(user_user_name!=null){ %>/viewPages/user-view-pages/courses-view-pages/my-courses
			<%}else{%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>">My courses</a>
	</div>
	<!-- <div class="links_box">
       	<a href="#home.jsp?id=notes">notes</a>
       </div> -->
	<div class="links_box">
		<a href="<%= projectPath %>/viewPages/user-view-pages/courses-view-pages/available-courses.jsp">available courses</a>
	</div>
</div> 