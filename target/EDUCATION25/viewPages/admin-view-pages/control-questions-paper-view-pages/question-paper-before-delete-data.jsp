<%@page import="com.education25.model.adminModel.paperControlModel.QuetionPaperQuetionInformationGetModel"%>
<%@page import="java.util.List"%>
<%@page import="com.education25.model.adminModel.paperControlModel.QuestionPaperInformationModel"%>
<%
	String id=null, projectPath1=null;
	
	QuestionPaperInformationModel paperInformation=null;
	List<QuetionPaperQuetionInformationGetModel> questionInfoList=null;
	
	projectPath1=request.getContextPath();
	id = (String) request.getAttribute("id");
	paperInformation= (QuestionPaperInformationModel) request.getAttribute("paperInformation");
	questionInfoList= (List<QuetionPaperQuetionInformationGetModel>) request.getAttribute("questionInfoList");	
%>

	<div id="form-container">
		<p id="first_heading">Questions</p>
		<p id="second_heading">After change question click update button 	<p>
		<div id="paper-info">
			<span class="paper-info_span">Paper Name : <%=paperInformation.getPaper_name() %></span>	
			<span class="paper-info_span">Total Question : <%=paperInformation.getTotal_ques() %></span>
		</div>
		<input type="hidden" name="paper_name"  value="<%=paperInformation.getPaper_name()%>">
		<input type="hidden" name="id"  value="<%=id%>">
		<%	for(QuetionPaperQuetionInformationGetModel questionInfo : questionInfoList) {
		
				int question_no = questionInfo.getQuestion_no();
				String question = questionInfo.getQuestion();
				String option_a = questionInfo.getOption_a();
				String option_b = questionInfo.getOption_b();
				String option_c = questionInfo.getOption_c();
				String option_d = questionInfo.getOption_d();
				String answer = questionInfo.getAnswer();
				String optionMarks = questionInfo.getOptionMarks();
				String notOptionMarks = questionInfo.getNotOptionMarks();
				%>
				<br><hr><br>
				<form id="form_<%= question_no %>">
					<input type="hidden" name="question_id" value="<%=question_no%>">
					<div class="large-container">
						<div class="question-header">
						    <label for="question<%= question_no %>">Question <%= question_no %></label>
							 <div class="question-header-right">
							    <% if ("0".equals(optionMarks)) { %>
							        <button type="button" class="marks_show"><%= notOptionMarks %></button>
							    <% } else { %>
							        <button type="button" class="marks_show"><%= optionMarks %></button>
							    <% }%>
						   </div>
						</div>
						<textarea id="question<%=question_no%>" name="question<%=question_no%>"
							class="question_text" rows="7" required><%=question%></textarea>
					</div>
					<div class="small-container">
						<div class="small">
							<label for="option_a<%= question_no%>">Option A</label>
							<textarea id="option_a<%= question_no%>" name="option_a<%= question_no%>"
								class="option" required><%= option_a%></textarea>
						</div>
						<div class="small">
							<label for="option_b<%=question_no%>">Option B</label>
							<textarea id="option_b<%= question_no%>" name="option_b<%= question_no%>"
								class="option" required><%= option_b%></textarea>
						</div>
					</div>
					<div class="small-container">
						<div class="small">
							<label for="option_c<%= question_no%>">Option C</label>
							<textarea id="option_c<%= question_no%>" name="option_c<%= question_no%>"
								class="option" required><%= option_c%></textarea>
						</div>
						<div class="small">
							<label for="option_d<%= question_no%>">Option D</label>
							<textarea id="option_d<%= question_no%>" name="option_d<%= question_no%>"
								class="option" required><%= option_a%></textarea>
						</div>
					</div>
					<div class="textarea-container">
						<div>
							<label for="select<%= question_no%>">Select answer</label> <select
								class="selected" id="select<%= question_no%>" name="answer<%= question_no%>" required>
								<option value="a" <%="a".equals(answer) ? "selected" : ""%>>Option A</option>
								<option value="b" <%="b".equals(answer) ? "selected" : ""%>>Option B</option>
								<option value="c" <%="c".equals(answer) ? "selected" : ""%>>Option C</option>
								<option value="d" <%="d".equals(answer) ? "selected" : ""%>>Option D</option>
							</select>
						</div>
					</div>
				</form>
				<%}%>
				<div class="buton_div">
					<button type="button" onclick="deletePaperName('<%= projectPath1 %>')" class="delete-btn btn-full-with">Delete</button>						
				</div>
		</div>
<script 	src="../../../js/admin-view-pages-js/control-questions-paper-view-pages-js/question-paper-before-delete-data.js"></script>