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

	<h1>管理員帳號系統</h1>

	     <div class="card">
	<p>各種管理員相關功能</p>
	<div id="errorMsg" class="error" style="display:none; font-size: 14px; margin-bottom: 10px;"></div>


		<a
			href="${pageContext.request.contextPath}/admin/admin.do?action=getAll">所有管理員列表
		</a>
		<br>
		<a
			href="${pageContext.request.contextPath}/admin/adminPer.do?action=getAllPer">所有管理權限
		</a>
	<br>
		<a href="${pageContext.request.contextPath}/backend/member/create_Admin.jsp">新增管理員
		</a>

<form method="post" action="${pageContext.request.contextPath}/admin/admin.do" onsubmit="return validateForm()">
    <b>輸入管理員編號:</b>
    <input type="text" name="admId" id="admId"> 
    <input type="hidden" name="action" value="getOne_For_Display"> 
    <input type="submit" value="查詢">

</form>

<form method="post" action="${pageContext.request.contextPath}/admin/admin.do">
    <b>管理員帳號狀態:</b>
    <select name="admStatus">
        <option value="1">啟用</option>
        <option value="0">停用</option>
    </select>
    <input type="hidden" name="action" value="getList_By_Status">
    <input type="submit" value="查詢狀態名單">
</form>
</div>

   

	<script>
function validateForm() {
    var admId = document.getElementById("admId").value.trim(); // getadmId後 再去空白
    var errorMsg = document.getElementById("errorMsg");
    
    // 判斷是否從頭到尾都是數字 0-9
    var isNumber = /^[0-9]+$/.test(admId);
    
    // 如果是空白，或者不是純數字
    if (admId === "" || !isNumber) {
        errorMsg.innerHTML = "請輸入正確編號(數字)再送出"; // 顯示錯誤訊息
        errorMsg.style.display = "block";
        return false; // 回傳 false，表單就不會送出給 Servlet
    }
    
    // 如果驗證通過，清空錯誤訊息並放行
    errorMsg.innerHTML = ""; 
    errorMsg.style.display = "none";
    return true; 
}
</script>
</body>
</html>
