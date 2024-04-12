<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.roomtypephoto.model.*"%>

<%
  // RoomTypePhotoVO roomTypePhotoVO = (RoomTypePhotoVOVO) request.getAttribute("roomTypePhotoVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�Ы��Ϥ��s�W - addRoomTypePhoto.jsp</title>

<style>
  table#table-1 {
    width: 450px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>�Ы��Ϥ��s�W - addRoomTypePhoto.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/image1.jpg" width="100" height="100" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">�Эץ��H�U���~:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<FORM METHOD="post" ACTION="roomtypephoto.do" name="form1">
<table>
	
	
	
	
	<tr>
		<td>�Ы��Ϥ��s��:</td>
		<td><input type="TEXT" name=roomTypePhotoId" value="${param.roomTypePhotoId}" size="45"/></td> <td>${errorMsgs.roomTypePhotoId}</td>
	</tr>
	<tr>
		<td>�Ы��s��:</td>
		<td><input type="TEXT" name="roomTypeId"   value="${param.roomTypeId}"   size="45"/></td> <td>${errorMsgs.roomTypeId}</td>
	</tr>
	<tr>
		<td>�Ы��Ϥ�:</td>
		<td><input  type="text" name="roomTypePhoto" ></td> <td>${errorMsgs.roomTypePhoto}</td>
	</tr>
	<tr>
		<td>�W�U�[���A:</td>
		<td><input type="TEXT" name="roomTypePhotoState"   value="${param.roomTypePhotoState}"   size="45"/></td> <td>${errorMsgs.roomTypePhotoState}</td>
	</tr>
	

	<jsp:useBean id="roomTypePhotoId" scope="page" class="com.roomtypephoto.model.RoomTypePhotoService" />
	<tr>
		<td>�Ы��s��:<font color=red><b>*</b></font></td>
		<td><select size="1" name="roomTypePhotoId">
			<c:forEach var="roomTypePhotoVO" items="${roomTypePhotoId.all}">
				<option value="${roomTypePhotoVO.roomTypePhotoId}" ${(param.roomTypePhotoId==roomTypePhotoVO.roomTypePhotoId)? 'selected':'' } >${roomTypePhotoVO.roomTypeId}
			</c:forEach>
		</select></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>

</body>



