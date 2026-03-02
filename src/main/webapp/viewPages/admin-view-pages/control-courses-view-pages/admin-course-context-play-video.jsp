<%@page import="com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.sql.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com.education25.courses</title>
<style>
html{
 background-color: yellow;
}
</style>
</head>
<body>
	<main>
		<%String course_name=null,sub_course_name=null,sub_course_short_id=null,lecture_id=null;
		String user_name = (String)session.getAttribute("user_name");
		if(user_name!=null){
		  	course_name=(String)session.getAttribute("course_name");
			sub_course_name=(String)session.getAttribute("sub_course_name");
			sub_course_short_id=String.valueOf(session.getAttribute("sub_course_short_id"));
			course_name =new ReplaceSpaceTo_().replaceSpaceTo_(course_name);
		    lecture_id = (String)session.getAttribute("lecture_id");
		    course_name =new  ReplaceSpaceTo_().replaceSpaceTo_(course_name);
		    sub_course_name =new ReplaceSpaceTo_().replaceSpaceTo_(sub_course_name);
		     try {
		    Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/education25course_"+course_name+"", "root", "Mdjaved2004");
		    String video_info_query = "SELECT lecture_video FROM "+sub_course_name+"_lectures_"+sub_course_short_id+" WHERE lecture_id = ?";
		    PreparedStatement ps = com.prepareStatement(video_info_query);
		    ps.setInt(1, Integer.parseInt(lecture_id));
		   ResultSet rs = ps.executeQuery();
		    while(rs.next()){ 
		    	response.setContentType("video/mp4");
		        response.setHeader("Accept-Ranges", "bytes");
		        InputStream inputStream = rs.getBinaryStream("lecture_video");
		        OutputStream outStream = response.getOutputStream();
		
		         byte[] buffer = new byte[1024]; // 1 KB Buffer
		        int bytesRead;
		        while ((bytesRead = inputStream.read(buffer)) != -1) {
		            outStream.write(buffer, 0, bytesRead);
		        }
		
		        inputStream.close();
		        outStream.flush();
		        outStream.close(); 
		    } 
		    rs.close();
		    ps.close();  
		} catch (SQLException e) {
		    e.printStackTrace();
		} 
	}else{
		%><script>
		window.location.href = "<%= request.getContextPath()%>/viewPages/user-view-pages/auth-view-pages/login-page.jsp";
		</script>
		<%
	}%>
	</main>
	<%-- <%
    String course_name = request.getParameter("course_name");
    String sub_course_name = request.getParameter("sub_course_name");
    String sub_course_short_id = request.getParameter("sub_course_short_id");
    String lecture_id = request.getParameter("lecture_id");

    System.out.println("📌 Course Name: " + course_name);
    System.out.println("📌 Sub Course Name: " + sub_course_name);
    System.out.println("📌 Sub Course Short ID: " + sub_course_short_id);
    System.out.println("📌 Lecture ID: " + lecture_id);

    course_name = ReplaceSpaceTo_.replaceSpaceTo_(course_name);
    sub_course_name = ReplaceSpaceTo_.replaceSpaceTo_(sub_course_name);

        try {
            Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/education25course_" + course_name, "root", "Mdjaved2004");
            String video_info_query = "SELECT lecture_video FROM " + sub_course_name + "_lectures_" + sub_course_short_id + " WHERE lecture_id = ?";
            PreparedStatement ps = com.prepareStatement(video_info_query);
            ps.setString(1, lecture_id);
           /*  ResultSet rs = ps.executeQuery(); */
          /*  if (rs.next()) { */
      
                /* response.setContentType("video/mp4");
                InputStream inputStream = rs.getBinaryStream("lecture_video");
                OutputStream outStream = response.getOutputStream();

                byte[] buffer = new byte[8192]; // 8 KB Buffer
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outStream.flush();
                outStream.close(); */
          /*   }  */
           /*  rs.close();
            ps.close(); */ 
        } catch (SQLException e) {
            e.printStackTrace();
        } 
%> --%>

</body>
</html>
