<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.roomtypephoto.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	RoomTypePhotoJDBCDAO dao = new RoomTypePhotoJDBCDAO();
    List<RoomTypePhotoVO> list = dao.getAll();// 此行的list變數(物件)將提供page1.file的第11行取得查詢到的總筆數，再由page1.file進行分頁的需要
    pageContext.setAttribute("list",list); // 將上一行的list變數(物件)存入當前頁面pageContext，再由底下的第73行由JSTL的forEach列印出結果
%>


<html>
<head>


<title>所有房間資料 - listAllRoomTypePhoto1_byDAO.jsp</title>

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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有房間資料 - listAllRoomTypePhoto1_byDAO.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/image1.jpg" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>房型圖片編號</th>
		<th>房型編號</th>
		<th>房型圖片</th>
		<th>上下架狀態</th>

	</tr>  
	<%@ include file="page1.file" %> 
	<!-- 分頁用 -->
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
		<!-- 分頁用 -->

</body>
</html>