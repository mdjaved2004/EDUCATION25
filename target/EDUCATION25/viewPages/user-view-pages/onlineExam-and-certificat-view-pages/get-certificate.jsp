<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.get-certificate</title>
<link href="../../../css/user-view-pages-css/common-view-pages-css/education-welcome.css" type="text/css" rel="stylesheet">
<link href="../../../css/user-view-pages-css/onlineExam-and-certificat-view-pages-css/get-certificate.css" type="text/css" rel="stylesheet">

<script	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>

</head>
<body>
<%@ include 	file="../comman-web-information/message-show.jsp"%>
<%@ include file="../comman-web-information/user-full-information.jsp" %>
	<header>
		<jsp:include page="../common-view-pages/navigation-bar.jsp" /> 
		<nav class="second_nav">
			<%if(user_email==null){%>
				<p id="login_message">you are not login,login first.</p>
			<%}%>
			<p id="first_heading">WELCOME TO EDUCATION25</p>
			<p id="second_heading">You can view all your records.</p>
		</nav>
	</header>
	<main>
		<section id="student_details">
			<!-- this div is record the test details. -->
			<div id="test_record">
				<div class="heading_name" id="Records">
					<p class="section_heading">My Records</p>
				</div>
				<%@ include file="test-record.jsp"%>
			</div>
			<div id="certificate-container">
				<div class="heading_name">
					<p class="section_heading">Certificate</p>
				</div>
				<div id="certificate_div">
					<div id="certificate">
						<h1>Certificate of Achievement</h1>
						<p class="certificate_p">This is to certify that</p>
						<p class="certificate_values">
							<b>Student Name : </b><%= user_name %>
						</p>
						<p class="certificate_values">
							<b>Student Email : </b><%= user_email %>
						</p>
						<p class="certificate_values" id="certificate_subject"></p>
						<p class="certificate_values" id="certificate_marks"></p>
						<p class="certificate_p">has successfully completed the paper
							with distinction in</p>
						<h2>Software Engineering</h2>
						<p class="certificate_p">and demonstrated outstanding skills
							in software development, problem-solving,and the ability to apply
							innovative solutions effectively</p>
					</div>
				</div>
				<div>
					<button id="download_certificate" onclick="downloadCertificate()">download certificate</button>
				</div>
				<div id="error_message">
					<p class="marks_less">Your marks less than 35%</p>
					<p class="message_try">Try again next time.</p>
				</div>
			</div>
		</section>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
	
	<script src="../../../js/user-view-pages-js/onlineExam-and-certificat-view-pages-js/get-certificate-download.js" type="text/javascript"></script>
</body>
</html>