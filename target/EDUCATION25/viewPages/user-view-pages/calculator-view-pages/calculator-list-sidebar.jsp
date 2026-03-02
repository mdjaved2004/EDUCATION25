<%  String projectPath= request.getContextPath();%>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="<%= projectPath %>/css/user-view-pages-css/calculator-view-pages-css/calculator-list-sidebar.css" type="text/css"
	rel="stylesheet">

<!--get id for identify which current page (example Simple_Calculator page etc,) -->
	<% String id=null;
		id=request.getParameter("id");
	 %> 
	 
	 <!-- include navigation bar -->
	<jsp:include page="/viewPages/user-view-pages/common-view-pages/navigation-bar.jsp" /> 
	
	<!-- write code for calculator navigation bar -->
	<nav id="calculator_nav">
		<a id="choose_calculate_option"> <span
			class="material-symbols-outlined" id="calculator_menu">menu</span>
		</a>
		
		<!-- write code for calculator sidebar bar -->
		<ul id="calculator_sidebar">
			<li>
				<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/simple-calculator.jsp?id=Simple_Calculator"
					<% if("Simple_Calculator".equals(id)){%>	class="calculator_sidebar_item" <%} %>>Simple Calculator</a>
			</li>
			
			<li>
				<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/matrix-main.jsp?id=Matrix"
					<%if("Matrix".equals(id)){%> class="calculator_sidebar_item" <%} %>>Matrix</a>
			</li>
			
			<li>
				<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/factorial.jsp?id=Factorial"
					<% if("Factorial".equals(id)){%> class="calculator_sidebar_item" 	<%} %>>Factorial</a>
			</li>
			
			<li>
				<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/circle.jsp?id=Circle"
				<% if("Circle".equals(id)){%> class="calculator_sidebar_item" <%} %>>Circle</a>	
			</li>
			
			<li>
				<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/quadriateral.jsp?id=Quadriateral"
					<% if("Quadriateral".equals(id)){%> class="calculator_sidebar_item" <%} %>>Quadriateral</a>
			</li>
			
			<li>
				<a href="<%= projectPath %>/viewPages/user-view-pages/calculator-view-pages/polynomials.jsp?id=Polynomials"
					<% if("Polynomials".equals(id)){%> class="calculator_sidebar_item" <%} %>>Polynomials</a>
			</li>
		</ul>
	</nav>

	
	<script src="../../../js/user-view-pages-js/calculator-view-pages-js/calculator-list-sidebar.js"></script>