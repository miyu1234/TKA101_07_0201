<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顯示所有權限列表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class = "list"> 	</div>
	<table>
		<tr>
		<th>權限</th>
		<th>管理員姓名</th>
		</tr>
		<c:forEach var="admPer" items="${admPerList}">
		<tr>
			<td>${admPer.admfuncVO.funcName} </td>
			<td>${admPer.adminVO.admName} </td>
		</tr>
				</c:forEach>
	</table>
	

	
	    <div class="back-link"  >
     <h3>   <a href="${pageContext.request.contextPath}/backend/member/admin_index.jsp">回首頁</a> </h3>
    </div>
</body>
</html>