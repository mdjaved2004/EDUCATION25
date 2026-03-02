<%@page import="com.education25.model.userModel.onlineExamAndCertificateModel.GetCertificateModel"%>
<%@page import="java.util.List"%>
<link href="../../../css/user-view-pages-css/onlineExam-and-certificat-view-pages-css/test-record.css" type="text/css" rel="stylesheet">

<%
	List<GetCertificateModel> certificateRecords=null;
	int i=1;
	try {
		certificateRecords=(List<GetCertificateModel>)request.getAttribute("testRecords");
%>		
	<%
		if(certificateRecords!=null){
			for(GetCertificateModel result:certificateRecords){
				if(i==1){
					%>		
					<table id="table" class="table-box">
							<tr class="tr">
								<th class="number">No.</th>
								<th class="name">Paper Name</th>
								<th class="test_marks">Marks</th>
								<th class="certificate">Certificate</th>
							</tr>
						</table>
					<% }%>
					<table id="table<%=i%>" class="table-box">
						<tr class="tr">
							<td class="number">
								<input type="hidden" name="number" value="<%=i%>"><%=i%>
							</td>
							<td class="name">
								<input type="hidden" name="papername_<%=i%>" value="<%=result.getSubject()%>"><%=result.getSubject()%>
							</td>
							<td class="test_marks">
								<input type="hidden" name="marks_<%=i%>" value="<%=result.getMarks_persentage()%>"><%=result.getMarks_persentage()%>%</td>
							</td>
							<td class="certificate" id="cert_<%=i%>">
								<button type="button" id="button_<%=i%>" onclick="certificateShow(<%= i %>)"  class="certificate_submit-btn">Certificate</button>
							</td>
						</tr>
					</table>		
			<%i++;
			}
		}%>
	<%
	} catch (Exception e) {
		e.printStackTrace();
	}%>
	<script src="../../../js/user-view-pages-js/onlineExam-and-certificat-view-pages-js/get-certificate-show-certificate.js" type="text/javascript"></script>