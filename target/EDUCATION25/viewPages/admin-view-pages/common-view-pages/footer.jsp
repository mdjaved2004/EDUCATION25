<%String projectPath1= request.getContextPath();%>

<link href="../../../css/admin-view-pages-css/common-view-pages-css/footer.css" type="text/css" rel="stylesheet">	

<!-- Static page include  -->
<%@ include file="../admin-other-information/redirect-login-page-if-not-login-user-name.jsp" %>

	<footer id="footer">
		 <div class="information-container">
			 <div class="information-links">
	            <h4>Quick Links</h4>
            		<ul>
	              <li><a href="<%=projectPath1%>/viewPages/admin-view-pages/admin-view-pannel/admin-home-page.jsp">Home</a></li>
	              <li><a href="<%=projectPath1%>/viewPages/user-view-pages/courses-view-pages/available-courses.jsp">Courses</a></li>
	              <li><a href="<%=projectPath1%><%if(admin_userName!=null){ %>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/GetCertificate<%}else{%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp<%}%>">Get certificate</a></li>
	              <li><a href="#">About Us</a></li>
	              <li><a href="#">Contact</a></li>
	            </ul>
	          </div>
	          <div class="information-about">
	            <h3>EDUCATION25</h3>
	            <p>Your trusted platform for simple and quality online learning. Learn anytime, anywhere with expert-made courses.</p>
	          </div>
		      
		          
	          <div class="information-contact">
	            <h4>Contact Us</h4>
	            <p>Email: mdjavedmansoori22@gmail.com</p>
	            <p>Phone: +91 74159 48500</p>
	            <p>Location: Indore, India</p>
	          </div>
		      
	          <div class="information-social">
	            <h4>Follow Us</h4>
	             <a href="#">facebook</a>
	             <a href="#">Twitter</a>
	             <a href="#">LinkedIn</a>
	          </div>
        </div>
		<div class="information-bottom">
          <p>&copy; 2025 EDUCATION25. All rights reserved.</p>
        </div>  
	</footer>