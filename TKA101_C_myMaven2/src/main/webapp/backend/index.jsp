<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員帳號管理中心</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

	<h1>管理員後台面</h1>

	     <div class="card">
	<p>各種後台功能</p>
	<div id="errorMsg" class="error" style="display:none; font-size: 14px; margin-bottom: 10px;"></div>


		<a
			href="${pageContext.request.contextPath}/admin/admin.do?action=getAll">所有管理員列表
		</a>
	

</div>

   
</body>
</html>
