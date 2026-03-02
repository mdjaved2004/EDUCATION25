<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EDUCATION25</title>

<link href="../../../css/admin-view-pages-css/admin-home-page.css" type="text/css" rel="stylesheet">
<link href="../../../css/admin-view-pages-css/control-courses-view-pages-css/admin.css" type="text/css" rel="stylesheet">
</head>

<body>

<%@ include file="../common-view-pages/message-show.jsp"%>

<header id="header">
    <%@ include file="../common-view-pages/navigation-bar.jsp" %>
</header>

<main id="main">
<section>

    <div class="admin_list">
        <span class="span">ServletContext Courses Infor update : </span>
        <button type="button" onclick="sevletContextUpdate('courses', '<%= projectPath %>')" class="btn-link btn button" >
            update </button>
    </div>

    <div class="admin_list">
        <span class="span">ServletContext OnlineExam Infor update : </span>
        <button type="button" onclick="sevletContextUpdate('onlineExam', '<%= projectPath %>')" class="btn-link btn button" >
            update </button>
    </div>

</section>
</main>

<footer id="footer">
    <jsp:include page="../../user-view-pages/common-view-pages/footer.jsp" />
</footer>

<script src="<%=projectPath%>/js/admin-view-pages-js/common-view-pages/admin-home-page.js"></script>
<script src="../../../js/admin-view-pages-js/update-servlet-context-js/servlet-context-update-form.js"></script>

</body>
</html>
