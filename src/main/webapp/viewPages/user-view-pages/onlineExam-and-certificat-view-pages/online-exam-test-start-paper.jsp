<%@page import="com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartPaperInformation"%>
<%@page import="com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartQuestionInformationModel"%>
<%@page import="java.util.List"%>
<%@page import="com.education25.model.userModel.onlineExamAndCertificateModel.ExamStartModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.exam-start</title>
<link href="../../../css/user-view-pages-css/onlineExam-and-certificat-view-pages-css/online-exam-test-start-paper.css" type="text/css" 	rel="stylesheet">

</head>
<body>
	<%  
		int paperId=0, totalQuestions = 0, optionQuestions = 0, notOptionQuestions = 0;
		String paperName=null;
		ExamStartModel examStartModel = null;
	
		int i = 1, j = 1;

		try{
			examStartModel=(ExamStartModel)request.getAttribute("examStartContent");
			if(examStartModel!=null){
				/* Get paper information  */
				ExamStartPaperInformation paperInfo=examStartModel.getPaperInfo();
				paperId = paperInfo.getPaper_id();
				paperName = paperInfo.getPaper_Name();
				totalQuestions = paperInfo.getTotal_ques();
				optionQuestions = paperInfo.getOption_ques();
				notOptionQuestions = paperInfo.getNotOption_ques();
				%>
				<div id="form-container">
					<p id="first_heading">Question Paper</p>
					<p id="second_heading">After complete exam click submit button</p>
					<p class="subject_time">Subject:	<%=paperName %></p>
					<p class="subject_time">Time: No limit</p>
					<p class="subject_time">	Note: <span id="paper_note">Do not refresh this page otherwise the exam will start again.</span></p>
					
					<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/onlineExam-and-certificat-view-pages/copyCheck" method="post">
						<input type="hidden" name="paperId" value="<%=paperId %>">
						<input type="hidden" name="paperName" value="<%=paperName %>">
						<input type="hidden" name="totalQuestions" value="<%=totalQuestions %>">
						<input type="hidden" name="optionQuestions" value="<%=optionQuestions %>">
						<input type="hidden" name="notOptionQuestions" value="<%=notOptionQuestions %>">
				<%
				/* Get quetions information in list*/
				List<ExamStartQuestionInformationModel> listOfQuestionInfo =examStartModel.getListOfQuestionInfo();
				if(listOfQuestionInfo!=null){
					for(ExamStartQuestionInformationModel questionInfo : listOfQuestionInfo ){
						int question_id = questionInfo.getQues_id();
						String question = questionInfo.getQuestion();
						String option_A = questionInfo.getOption_A();
						String option_B = questionInfo.getOption_B();
						String option_C = questionInfo.getOption_C();
						String option_D = questionInfo.getOption_D();
						String optionMarks = questionInfo.getOptionMarks();
						String notOptionMarks = questionInfo.getNotOptionMarks();
						%>
							<br>	<hr>
							<div class="ques_number">
								<b>Question <%= i %> </b>
								<span class="marks">
								 <%	if ("0".equals(optionMarks)) {
										out.print(notOptionMarks);
									} else {
										out.print(optionMarks);
									}
								  %>
								</span>
							</div>
							<p id="question_<%=i%>" class="question_text"><%=question %></p>
							<% if ("0".equals(notOptionMarks)) { %>
								<div class="small">
									<p class="option">A. <%= option_A %></p>
								</div>
								<div class="small">
									<p class="option">B. <%= option_B %> </p>
								</div>
								<div class="small">
									<p class="option">C. <%= option_C %></p>
								</div>
								<div class="small">
									<p class="option">D. <%= option_D %></p>
								</div>
					
					
								<div class="ans-container">
									<div>
										<select class="selected" id="select_<%=i%>" name="answer_<%=i%>">
											<option value="null" selected hidden>choose ans</option>
											<option value="a" class="selected_option">Option A</option>
											<option value="b" class="selected_option">Option B</option>
											<option value="c" class="selected_option">Option C</option>
											<option value="d" class="selected_option">Option D</option>
										</select>
									</div>
								</div>
								
							<%} else{%>
								<div class="ans-container1">
									<div>
										<select class="selected" id="select_<%=i%>" name="answer_<%=i%>">
											<option value="null" selected hidden>choose ans</option>
											<option value="a" class="selected_option">&#8594;<%= option_A %></option>
											<option value="b" class="selected_option">&#8594;<%= option_B %></option>
											<option value="c" class="selected_option">&#8594;<%= option_C %></option>
											<option value="d" class="selected_option">&#8594;<%= option_D %></option>
										</select>
									</div>
								</div>
							<% }
							i++; 
						}
					}%>
						<input type="submit" value="Submit paper" class="paper-submit">
					</form>
				</div>
		<%	} 
		}catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>