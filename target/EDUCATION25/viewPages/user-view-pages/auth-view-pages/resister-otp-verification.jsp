<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<title>com.education25.email-verification</title>
<link href="<%= request.getContextPath() %>/css/user-view-pages-css/auth-view-pages-css/otp-page.css" type="text/css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="otp-message">
			<span class="material-symbols-outlined">check_circle</span>
			<p>We have sent an OTP to your email.</p>
		</div>
		<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/resister_after_otp_verification" method="post">
			<div class="code-input">
				<input type="text" name="inp1" pattern="[0-9]" title="Only numbers (0-9) allowed." maxlength="1"
					oninput="moveNext(this, 0)" required autofocus>
				<input type="text" name="inp2" pattern="[0-9]" title="Only numbers (0-9) allowed." maxlength="1"
					oninput="moveNext(this, 1)" required> 
				<input type="text" name="inp3" pattern="[0-9]" title="Only numbers (0-9) allowed."
					maxlength="1" oninput="moveNext(this, 2)" required>
				<input type="text" name="inp4" pattern="[0-9]" title="Only numbers (0-9) allowed." maxlength="1"
					oninput="moveNext(this, 3)" required>
				<input type="text" name="inp5" pattern="[0-9]" title="Only numbers (0-9) allowed."
					maxlength="1" oninput="moveNext(this, 4)" required>
				<input type="text" name="inp6" pattern="[0-9]" title="Only numbers (0-9) allowed." maxlength="1"
					oninput="moveNext(this, 5)" required>
			</div>

			<button type="submit" class="btn">Verify</button>
		</form>
		<form action="<%= request.getContextPath() %>/viewPages/user-view-pages/auth-view-pages/resister_recend_otp" method="post">
			<button type="submit" class="resend">Resend Code</button>
		</form>
	</div>

	<script>
        function moveNext(input, index) {
            let inputs = document.querySelectorAll(".code-input input");
            
            if (input.value && index < inputs.length - 1) {
                inputs[index + 1].focus();
            }
        }
    </script>

</body>
</html>