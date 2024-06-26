<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.roomtypephoto.model.*"%>
<%@ page import="com.roomtypephoto.controller.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	RoomTypePhotoVO roomTypePhotoVO = (RoomTypePhotoVO)request.getAttribute("roomTypePhotoVO"); //RoomTypePhotoServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<meta charset="BIG5">
<title>所有房間資料 - listOneRoomTypePhoto.jsp</title>

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
	width: 600px;
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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>房間資料 - listOneRoomTypePhoto.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>房型圖片編號</th>
		<th>房型編號</th>
		<th>房型圖片</th>
		<th>上下架狀態</th>
	</tr>
	<tr>
			<td>${roomTypePhotoVO.roomTypePhotoId}</td>
			<td>${roomTypePhotoVO.roomTypeId}</td>
			<td>${roomTypePhotoVO.roomTypePhoto}</td>
			<td>${roomTypePhotoVO.roomTypePhotoState}</td>


	</tr>
</table>

</body>
</html>