<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.roomtypephoto.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
   // ���oEmpServlet.java(Concroller)�A��31��s�Jsession��list����
   // List<EmpVO> list = (List<EmpVO>)session.getAttribute("list"); // list�ܼ�(����)�N����page1.file����11����o�d�ߨ쪺�`���ơA�A��page1.file�i��������ݭn
%>
   <%-- �H�U���P��9��--%>
   <jsp:useBean id="list" scope="session" type="java.util.List<RoomTypePhotoVO>" />

<html>
<head>
<meta charset="BIG5">

<title>�Ҧ��ж���� - listAllRoomTypePhoto2_getFromSession.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>�����m�߱ĥ� EL ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ��ж���� - listAllRoomTypePhoto2_getFromSession.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/image1.jpg" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�Ы��Ϥ��s��</th>
		<th>�Ы��s��</th>
		<th>�Ы��Ϥ�</th>
		<th>�W�U�[���A</th>
		
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="roomTypePhotoVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr>
		
		<td>${roomTypePhotoVO.roomTypePhotoId}</td>
			<td>${roomTypePhotoVO.roomTypeId}</td>
			<td>${roomTypePhotoVO.roomTypePhoto}</td>
			<td>${roomTypePhotoVO.roomTypePhotoState}</td>

		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>