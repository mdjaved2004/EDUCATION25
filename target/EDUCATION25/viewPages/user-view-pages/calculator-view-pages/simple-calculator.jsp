<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.calculator</title>
<link href="../../../css/user-view-pages-css/calculator-view-pages-css/simple-calculator.css" type="text/css" rel="stylesheet">
<link href="../../../css/user-view-pages-css/calculator-view-pages-css/simple-calulator-history.css" type="text/css" rel="stylesheet">
</head>
<body>
	<header>
		<jsp:include page="calculator-list-sidebar.jsp">
		    <jsp:param name="id" value="Simple_Calculator" />
		</jsp:include>
	</header>
	<main>
		<section class="section">
			<div id="container">
				<div id="simple_calculator">
					<div class="display">
						<input type="text" placeholder="0" id="input_box" readonly><input
							type="text" id="input_box2" readonly>
					</div>
					<div id="icon_show">
						<p class="cal_icon" id="history" style="text-align: center;">History	</p>
						<div id="historyBox">
							<div id="history_box_inner_button_div">
								<button id="closeHistory" class="history_box_inner_button" ><- Cancel</button>
								<button id="deleteAll" class="history_box_inner_button">Delete All</button>
							</div>
							<ul id="historyList" class="history-main-ul">
    							 </ul>
						</div>
						<p class="cal_icon">
							<span style="font-size: 15px; display: none;"
								class="material-symbols-outlined">calculate</span>
						</p>
						<button class="cal_icon button-icon">ce</button>
						<button class="cal_icon button-icon" style="font-size: 15p;">%</button>
					</div>
					<div class="row_container">
						<button style="color: blue;" class="button">C</button>
						<button class="button">(</button>
						<button class="button">)</button>
						<button class="button">/</button>
					</div>
					<div class="row_container">
						<button class="button">7</button>
						<button class="button">8</button>
						<button class="button">9</button>
						<button class="button">*</button>
					</div>
					<div class="row_container">
						<button class="button">4</button>
						<button class="button">5</button>
						<button class="button">6</button>
						<button class="button">-</button>
					</div>
					<div class="row_container">
						<button class="button">1</button>
						<button class="button">2</button>
						<button class="button">3</button>
						<button class="button">+</button>
					</div>
					<div class="row_container">
						<button class="button">0</button>
						<button class="button">00</button>
						<button class="button">.</button>
						<button class="button" id="button-equal">=</button>
					</div>
				</div>
			</div>
		</section>
	</main>
	<footer id="footer">
		<jsp:include page="../common-view-pages/footer.jsp" />
	</footer>
	<script src="../../../js/user-view-pages-js/calculator-view-pages-js/simple-calculator.js"></script>
	<script src="../../../js/user-view-pages-js/calculator-view-pages-js/simple-calculator-history.js"></script>
</body>
</html>