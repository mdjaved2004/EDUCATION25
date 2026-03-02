<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.sql.*"%>
<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.buy-courses</title>
<link href="../../../css/user-view-pages-css/courses-view-pages-css/buy-couse-details.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@ include file="../comman-web-information/user-not-login-redirect-login-page.jsp"%>
	<%@ include file="../comman-web-information/message-show.jsp"%>
	<%@ include file="buy-course-details-info-data.jsp"%>
	
	<header>
		<%@ include file="../common-view-pages/navigation-bar.jsp" %>
	</header>
	
	<main id="main">
		<section id="payment_section">
		 	<div class="course_box course_box_color<%=(course_id_int%3)%> ">
                <div class="add_image_container">
                       <% if (image_link != null) { %>
						<img src="<%=request.getContextPath()%>/media/assets/course-content/<%= course_name %>/images/<%= image_link %>" class="subcourse_image">
                       <% } else { %>
                           <p class="without_image_container subcourse_image without_image_container_color<%=(course_id_int%3)%>"><%= sub_course_name %></p>
                       <% } %>
                </div>
                <div class="subcourse_details">
                    <p class="sub_course_heading"><%= sub_course_name %></p>
                    <%-- <p>learning Days(<%= lear %> days)</p> --%>
                    <p>Price - &#8377;<%= price %>.00</p>
                </div>
			<button type="button" id="buy_coutrtse_button" <% if(user_user_name !=null){ %> onclick="startPayment('<%= price %>', '<%= sortId %>', '<%= projectPath %>')" <% }else{%> onclick="window.location.href='<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/login-page.jsp'" <%}%>>buy course</button>
            </div>
		</section> 
			
	</main>
	<script src="../../../js/user-view-pages-js/courses-view-pages-js/buying-course-start.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" 	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
</body>
</html>