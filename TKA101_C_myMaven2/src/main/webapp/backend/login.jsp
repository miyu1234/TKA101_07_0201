<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>管理員登入口</h1>

	<c:if test="${not empty errorMsg}">
		<div id="errorMsg" class="error" style="font-size: 14px; margin-bottom: 10px;">${errorMsg}</div>
	</c:if>

<div class ="card">
<form method="post" action="${pageContext.request.contextPath}/admin/admin.do" onsubmit="return validateForm()">
    <b>輸入管理員帳號:</b>
    <input type="text" name="admacc" id="admacc"><br>
         <b>輸入密碼:</b>
    <input type="password" name="admPw" id="admPw">
           <br>
    <input type="hidden" name="action" value="loginasadmin"> 
    <input type="submit" value="登入">

</form>
</div>

</body>
</html>