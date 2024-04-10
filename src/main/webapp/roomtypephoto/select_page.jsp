<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">

<title>Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for RoomTypePhoto: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllRoomTypePhoto1_byDAO.jsp'>List</a> all RoomTypePhoto    <h4>(byDAO).         </h4></li>
  <li><a href='roomtypephoto.do?action=getAll'> List</a> all RoomTypePhoto    <h4>(getFromSession).</h4> <br><br><br></li>
  
  <li>
    <FORM METHOD="post" ACTION="roomtypephoto.do" >
        <b>輸入房型圖片編號 (如1):</b>
        <input type="text" name="roomTypePhotoId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">                   <h4>(資料格式驗證  by Controller ).</h4> 
    </FORM>
  </li>
  
  <li>
    <FORM METHOD="post" ACTION="roomtypephoto.do" name="form1">
        <b>輸入房型編號 (如7001):</b>
        <input type="text" name="roomTypePhotoId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="button" value="送出" onclick="fun1()">  <h4>(資料格式驗證  by Java Script).</h4> 
    </FORM>
  </li>

  <%com.roomtypephoto.model.RoomTypePhotoJDBCDAO dao = new com.roomtypephoto.model.RoomTypePhotoJDBCDAO(); %> <%pageContext.setAttribute("dao",dao); %>
							<!--   pageContext: p.204, p.337 -->
  <li>
     <FORM METHOD="post" ACTION="roomtypephoto.do" >
       <b>選擇房型圖片編號:</b>
       <select size="1" name="roomTypePhotoId">
         <c:forEach var="roomTypePhotoVO" items="${pageScope.dao.all}" > 
          <option value="${roomTypePhotoVO.roomTypePhotoId}">${roomTypePhotoVO.roomTypePhotoId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="roomtypephoto.do" >
       <b>選擇房型編號:</b>
       <select size="1" name="roomTypePhotoId">
         <c:forEach var="roomTypePhotoVO" items="${dao.all}" > 
          <option value="${roomTypePhotoVO.roomTypePhotoId}">${roomTypePhotoVO.roomTypeId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>

<script>    
   function fun1(){
      with(document.form1){
         if (roomTypePhotoId.value=="") 
             alert("請輸入房型圖片編號!");
         else if (isNaN(roomTypePhotoId.value)) 
             alert("房型圖片編號格式不正確!");
         else if ((roomTypePhotoId.value < 7001) || (roomTypePhotoId.value > 7999)) 
             alert("請填寫介於1和10之間的數字!");
         else
             submit();
      }
   }
</script>

</body>
</html>