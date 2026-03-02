<%@page import="com.education25.model.adminModel.paperControlModel.QuestionPaperQuestionDataModel"%>
<%@page import="java.util.List"%>
<%@ include 	file="question-insert-basic-info-data.jsp"%>

<%
 List<QuestionPaperQuestionDataModel> questionDataStrore=null;
	questionDataStrore=(List<QuestionPaperQuestionDataModel>) request.getAttribute("QuetionPapeQuestionInfo"); 
	boolean doublLineBreak =true;
%>

<div id="form-container">
	<h1>Create a papers</h1>
	<div id="paper-info">
		<span class="paper-info_span">Paper Name : <%=paper_name %></span>
		<span class="paper-info_span">Total Marks : <%=total_marks_int %></span>		
		<span class="paper-info_span">Total Question : <%=total_ques %></span>
	</div>
	<form action="<%= request.getContextPath() %>/viewPages/admin-view-pages/control-questions-paper-view-pages/question-insert" method="post">
		<input type="hidden" name="paper_name"  value="<%=paper_name%>">
		<input type="hidden" name="total_ques"  value="<%=total_ques%>">
		<input type="hidden" name="select_op_ques"  value="<%=select_ques%>">
		<input type="hidden" name="select_op_ques_marks"  value="<%=select_marks%>">
		<input type="hidden" name="not_select_op_ques"  value="<%= notSelect_ques%>">
		<input type="hidden" name="not_select_op_ques_marks"  value="<%=notSelect_marks%>">
		<input type="hidden" name="total_marks"  value="<%=total_marks%>">
		
		<% for(QuestionPaperQuestionDataModel quetionInfo: questionDataStrore) { 
		
			int question_no = quetionInfo.getQuestion_no();
		 	String question = quetionInfo.getQuestion();
	        String option_a = quetionInfo.getOption_a();
	        String option_b = quetionInfo.getOption_b();
	        String option_c = quetionInfo.getOption_c();
	        String option_d = quetionInfo.getOption_d();
	        String answer = quetionInfo.getAnswer();
	        
	        if(question_no<=select_que_int){
		%>
				<div class="large-container">
					<label for="question<%= question_no %>">Question <%= question_no %></label>
					<textarea id="question<%= question_no %>" name="question<%= question_no %>" rows=4
						class="question_text" maxlength="500" 
						placeholder="Question (limit 500 characters)" required><%= question != null ? question : "" %></textarea>
				</div>
				<div class="small-container">
					<div class="small">
						<label for="option_a<%= question_no %>">Option A</label>
						<textarea id="option_a<%= question_no %>" name="option_a<%= question_no %>"
							class="option" maxlength="180" 
							placeholder="option A (limit 180 characters)" required><%= option_a != null ? option_a : "" %></textarea>
					</div>
					<div class="small">
						<label for="option_b<%= question_no %>">Option B</label>
						<textarea id="option_b<%= question_no %>" name="option_b<%= question_no %>"
							class="option" maxlength="180" 
							placeholder="option B (limit 180 characters)" required><%= option_b != null ? option_b : "" %></textarea>
					</div>
				</div>
				<div class="small-container">
					<div class="small">
						<label for="option_c<%= question_no %>">Option C</label>
						<textarea id="option_c<%= question_no %>" name="option_c<%= question_no %>"
							class="option" maxlength="180"
							placeholder="option C (limit 180 characters)" required><%= option_c != null ? option_c : "" %></textarea>
					</div>
					<div class="small">
						<label for="option_d<%= question_no %>">Option D</label>
						<textarea id="option_d<%= question_no %>" name="option_d<%= question_no %>"
							class="option" maxlength="180" 
							placeholder="option D (limit 180 characters)" required><%= option_d != null ? option_d : "" %></textarea>
					</div>
				</div>
				<div class="textarea-container">
					<label for="select1<%= question_no %>">Select answer</label>
					 <select id="select1<%= question_no %>" name="answer<%= question_no %>" class="select" required>
						<option value="" <%= (answer == null || answer.isEmpty()) ? "selected" : "" %> hidden>choose ans</option>
						<option value="a" <%= "a".equals(answer) ? "selected" : "" %>>Option A</option>
					    <option value="b" <%= "b".equals(answer) ? "selected" : "" %>>Option B</option>
					    <option value="c" <%= "c".equals(answer) ? "selected" : "" %>>Option C</option>
					    <option value="d" <%= "d".equals(answer) ? "selected" : "" %>>Option D</option>
					   </select>
				</div>
				<hr>
			<% } else{
					if(doublLineBreak){
						doublLineBreak=false; %>
						<br><br><br><br>	<hr>
					<%}%>
					<div class="large-container">
						<textarea id="question<%= question_no %>" name="question<%= question_no %>" rows=4
							class="question_text" maxlength="500"
							placeholder="Question (limit 500 characters)" required><%= question != null ? question : "" %></textarea>
					</div>
					<div class="small-container">
						<div class="small">
							<label for="option_a<%= question_no %>">Option A</label>
							<textarea id="option_a<%= question_no %>" name="option_a<%= question_no %>"
								class="option" maxlength="180"
								placeholder="option A (limit 180 characters)" required><%= option_a != null ? option_a : "" %></textarea>
						</div>
						<div class="small">
							<label for="option_b<%= question_no %>">Option B</label>
							<textarea id="option_b<%= question_no %>" name="option_b<%= question_no %>"
								class="option" maxlength="180" 
								placeholder="option B (limit 180 characters)" required><%= option_b != null ? option_b : "" %></textarea>
						</div>
					</div>
					<div class="small-container">
						<div class="small">
							<label for="option_c<%= question_no %>">Option C</label>
							<textarea id="option_c<%= question_no %>" name="option_c<%= question_no %>"
								class="option" maxlength="180"
								placeholder="option C (limit 180 characters)" required><%= option_c != null ? option_c : "" %></textarea>
						</div>
						<div class="small">
							<label for="option_d<%= question_no %>">Option D</label>
							<textarea id="option_d<%= question_no %>" name="option_d<%= question_no %>"
								class="option" maxlength="180"
								placeholder="option D (limit 180 characters)" required><%= option_d != null ? option_d : "" %></textarea>
						</div>
					</div>
					<div class="textarea-container">
						<label for="select1<%= question_no %>">Select answer</label>
						 <select id="select1<%= question_no %>" name="answer<%= question_no %>" class="select" required>
							<option value="" <%= (answer == null || answer.isEmpty()) ? "selected" : "" %> hidden>choose ans</option>
							<option value="a" <%= "a".equals(answer) ? "selected" : "" %>>Option A</option>
						    <option value="b" <%= "b".equals(answer) ? "selected" : "" %>>Option B</option>
						    <option value="c" <%= "c".equals(answer) ? "selected" : "" %>>Option C</option>
						    <option value="d" <%= "d".equals(answer) ? "selected" : "" %>>Option D</option>
						</select>
					</div>
					<hr>
			<% } 
			}%>
		<button type="submit" class="submit-btn">Submit</button>
	</form>
</div>