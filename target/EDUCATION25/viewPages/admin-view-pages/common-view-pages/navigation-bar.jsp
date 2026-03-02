<%@ include file="../admin-other-information/redirect-login-page-if-not-login-email.jsp"%>

<%
//Application context path (given project corrent path)
String projectPath = request.getContextPath();
%>

<!-- this link use to access google multiple fonts, icons . which provide google -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+
	Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<link href="../../../css/admin-view-pages-css/common-view-pages-css/navigation-bar1.css" 	type="text/css" rel="stylesheet">

<nav id="nav_bar">

	<ul>
		<li>
			<a id="menu_list"> 
				<span	class="material-symbols-outlined" id="menu">menu</span>
			</a>
			<ul id="sidebar_left">		
				
			
			</ul>
			
			 <a id="webName" href="<%=projectPath%>/viewPages/admin-view-pages/admin-view-pannel/admin-home-page.jsp">
			 	<span id="edu">EDU</span><span id="cation25">CATION25</span>
			 </a> 			 	
		</li> 
				
	</ul>
	<ul id="nav_ul">	  
		<li>
			<div id="profile_box">
				<a href="<%=projectPath%>/viewPages/user-view-pages/user-information-view-pages/profile.jsp">
					<span class="material-symbols-outlined nav_default_pic">person</span>
				</a>
			</div>
		</li>
	</ul>
</nav>

<script 	src="<%=projectPath%>/js/admin-view-pages-js/common-view-pages/navigation.js"></script>


