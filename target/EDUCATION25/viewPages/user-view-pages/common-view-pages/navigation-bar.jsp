<%
//Application context path (given project corrent path)
String projectPath = request.getContextPath();
%>

<!-- this link use to access google multiple fonts, icons . which provide google -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+
	Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<link href="<%= projectPath %>/css/user-view-pages-css/common-view-pages-css/navigation-bar.css"
	type="text/css" rel="stylesheet">

<!-- Static user-full-information.jsp page include ,not run time including this page  -->
<%@ include file="../comman-web-information/user-user-name-get.jsp" %>

<nav id="nav_bar">

	<!--UL 1 start inner nav -->
	<ul>
		<li>
			<a id="menu_list"> 
				<span	class="material-symbols-outlined" id="menu">menu</span>
			</a>
			
			<!--UL inner UL start -->
			<ul id="sidebar_left">		
				<!-- if user login or register then show profile option -->
				<% if (user_user_name != null) {	%>
				<li>
					<a href="<%=projectPath%>/viewPages/user-view-pages/user-information-view-pages/profile.jsp">Profile</a>
				</li>
				<%}	%>
				
				<!-- if user are login or register then after click link redirect my-courses.jsp page otherwise redirect login-page.jsp  -->
				<li class="sidebar_main_links">
					<a	href="<%=projectPath%><%if (user_user_name != null){%>/viewPages/user-view-pages/courses-view-pages/my-courses
						<%}else {%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>">My	courses</a>
				</li>
				
				<!-- if user are login or register then after click link redirect get-certificate.jsp page otherwise redirect login-page.jsp  -->
				<li class="sidebar_main_links">
					<a	href="<%=projectPath%><%if (user_user_name != null) {%>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/GetCertificate
						<%} else {%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>">Get Certificates</a>
				</li>
				
				<li class="sidebar_main_links">
					<a	href="<%=projectPath%>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam.jsp">All exams</a>
				</li>

				<!-- if user login or register then show logout option -->
				<%if (user_user_name != null) {	%>
				<li>
					<a href="<%=projectPath%>/logOut">LogOut</a>
				</li>
				<%}%>
				
			<!--UL inner UL end -->
			</ul>
			
			 <a id="webName" href="<%=projectPath%>/homePage">
			 	<span id="edu">EDU</span><span id="cation25">CATION25</span>
			 </a> 
			 
			 <a id="my_courses"	href="<%=projectPath%><%if (user_user_name != null) {%>/viewPages/user-view-pages/courses-view-pages/my-courses
			 	<%} else {%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>"
				class="nav_li_a">My courses</a> 
				
			<a id="get_certificate" 	href="<%=projectPath%><%if (user_user_name != null) {%>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/GetCertificate
				<%} else {%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>"
				class="nav_li_a">Get	Certificates</a>
				
			<a id="all_exams" href="<%=projectPath%>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/online-exam.jsp"
			 	class="nav_li_a">All exams</a>
			 	
		</li> 
				
	<!-- UL 1 complete inner nav -->
	</ul>

	<!--UL 2 start inner nav . this Inner UL mention login, register and profile page -->
	<ul id="nav_ul">
		
	  <!-- this if-else statement, if user are not login and Register then show login and register options(buttons) 
	  		otherwise show profile option(button) -->
	  <% if (user_user_name == null) {	%>
		<li class="nav_li">
			<a href="<%=projectPath%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp"
				class="login_register" id="login">Login</a>
			
			<a href="<%=projectPath%>/viewPages/user-view-pages/auth-view-pages/resister-page.jsp"
				class="login_register" id="register">Register</a>
		</li>
	  <% } else {%>
		<li>
			<div id="profile_box">
				<a href="<%=projectPath%>/viewPages/user-view-pages/user-information-view-pages/profile.jsp">
					<span class="material-symbols-outlined nav_default_pic">person</span>
				</a>
			</div>
		</li>
	  <%}%>
	<!--UL 2 end inner nav -->
	</ul>
	
</nav>

<!-- this input  define only use for user information in javascript page   -->
<input type="hidden" name="userName" id="email" value="<%=user_user_name%>">


<script 	src="<%=projectPath%>/js/user-view-pages-js/common-view-pages-js/navigation.js"></script>
