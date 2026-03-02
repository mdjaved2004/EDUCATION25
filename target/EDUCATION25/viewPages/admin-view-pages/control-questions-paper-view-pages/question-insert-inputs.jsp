<%@ include 	file="question-insert-basic-info-data.jsp"%>

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
		
		<% for(int i=1; i<= select_que_int; i++) { %>
			<div class="large-container">
				<label for="question<%= i %>">Question <%= i %></label>
				<textarea id="question<%= i %>" name="question<%= i %>" rows=4
					class="question_text" maxlength="500"
					placeholder="Question (limit 500 characters)" required></textarea>
			</div>
			<div class="small-container">
				<div class="small">
					<label for="option_a<%= i %>">Option A</label>
					<textarea id="option_a<%= i %>" name="option_a<%= i %>"
						class="option" maxlength="180"
						placeholder="option A (limit 180 characters)" required></textarea>
				</div>
				<div class="small">
					<label for="option_b<%= i %>">Option B</label>
					<textarea id="option_b<%= i %>" name="option_b<%= i %>"
						class="option" maxlength="180"
						placeholder="option B (limit 180 characters)" required></textarea>
				</div>
			</div>
			<div class="small-container">
				<div class="small">
					<label for="option_c<%= i %>">Option C</label>
					<textarea id="option_c<%= i %>" name="option_c<%= i %>"
						class="option" maxlength="180"
						placeholder="option C (limit 180 characters)" required></textarea>
				</div>
				<div class="small">
					<label for="option_d<%= i %>">Option D</label>
					<textarea id="option_d<%= i %>" name="option_d<%= i %>"
						class="option" maxlength="180"
						placeholder="option D (limit 180 characters)" required></textarea>
				</div>
			</div>
			<div class="textarea-container">
				<label for="select1<%= i %>">Select answer</label> <select
					id="select1<%= i %>" name="answer<%= i %>" class="select" required>
					<option value="" selected hidden>choose ans</option>
					<option value="a">Option A</option>
					<option value="b">Option B</option>
					<option value="c">Option C</option>
					<option value="d">Option D</option>
				</select>
			</div>
			<hr>
		<% } %>
		<br><br><br><br>
		<hr>
		<% for(int i=select_que_int+1; i<=total_ques_int; i++) { %>
			<div class="large-container">
				<label for="question<%= i %>">Question <%= i %></label>
				<textarea id="question<%= i %>" name="question<%= i %>" rows=4
					class="question_text" maxlength="500"
					placeholder="Question (limit 500 characters)" required></textarea>
			</div>
			<div class="small-container">
				<div class="small">
					<label for="option_a<%= i %>">Option A</label>
					<textarea id="option_a<%= i %>" name="option_a<%= i %>"
						class="option" maxlength="180"
						placeholder="option A (limit 180 characters)" required></textarea>
				</div>
				<div class="small">
					<label for="option_b<%= i %>">Option B</label>
					<textarea id="option_b<%= i %>" name="option_b<%= i %>"
						class="option" maxlength="180"
						placeholder="option B (limit 180 characters)" required></textarea>
				</div>
			</div>
			<div class="small-container">
				<div class="small">
					<label for="option_c<%= i %>">Option C</label>
					<textarea id="option_c<%= i %>" name="option_c<%= i %>"
						class="option" maxlength="180"
						placeholder="option C (limit 180 characters)" required></textarea>
				</div>
				<div class="small">
					<label for="option_d<%= i %>">Option D</label>
					<textarea id="option_d<%= i %>" name="option_d<%= i %>"
						class="option" maxlength="180"
						placeholder="option D (limit 180 characters)" required></textarea>
				</div>
			</div>
			<div class="textarea-container">
				<label for="select1<%= i %>">Select answer</label> <select
					id="select1<%= i %>" name="answer<%= i %>" class="select" required>
					<option value="" selected hidden>choose ans</option>
					<option value="a">Option A</option>
					<option value="b">Option B</option>
					<option value="c">Option C</option>
					<option value="d">Option D</option>
				</select>
			</div>
			<hr>
		<% } %>
		<button type="submit" class="submit-btn">Submit</button>
	</form>
</div>