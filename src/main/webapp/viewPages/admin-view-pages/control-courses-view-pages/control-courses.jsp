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
<%
    String projectPath1 = request.getContextPath();
%>

<%@ include file="../common-view-pages/message-show.jsp"%>

<header id="header">
    <%@ include file="../common-view-pages/navigation-bar.jsp" %>
</header>

<main id="main">
<section>

    <div class="admin_list">
        <span class="span">Add new course : </span>
        <a href="sub-course-add-new-form.jsp" class="btn-link btn">
            Add course
        </a>
    </div>

    <div class="admin_list">
        <span class="span">Update course : </span>
        <a href="<%=projectPath1 %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-form?id=update"
           class="btn-link btn">
           Update course
        </a>
    </div>

    <div class="admin_list">
        <span class="span">Update image in course : </span>
        <a href="<%=projectPath1 %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-form?id=addImage" class="btn-link btn">
           Update image
        </a>
    </div>

    <div class="admin_list">
        <span class="span">Upload lectures : </span>
        <a href="admin-course-context-update-form.jsp?id=upload_video"
           class="btn-link btn">
           Upload lecture
        </a>
    </div>

    <div class="admin_list">
        <span class="span">Delete course : </span>
         <a href="<%=projectPath1 %>/viewPages/admin-view-pages/control-courses-view-pages/sub-course-content-update-form?id=deleteCourse"
           class="btn-link btn_denger" >
           Delete course
        </a>
    </div>

</section>
</main>

<footer id="footer">
    <jsp:include page="../../user-view-pages/common-view-pages/footer.jsp" />
</footer>

<script src="<%=projectPath1%>/js/admin-view-pages-js/common-view-pages/admin-home-page.js"></script>

</body>
</html>