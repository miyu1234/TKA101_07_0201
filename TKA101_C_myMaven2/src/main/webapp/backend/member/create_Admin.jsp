<%-- 檔案位置：src/main/webapp/backend/member/create_Admin.jsp --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head><title>新增管理員</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <h3>新增管理員</h3>
     <div class="card">
    <form method="post" action="${pageContext.request.contextPath}/admin/admin.do">

  
        
        <b>帳號:</b>  
        <input type="text" name="admAcc" value="${adminVO.admAcc}" ><br>
        <div class="error">${errorMsg}</div><br>
        <b>密碼:</b> 
        <input type="password" name="admPw" value="${adminVO.admPw}" ><br>
        
        <b>姓名:</b> 
        <input type="text" name="admName" value="${adminVO.admName}"><br>
        
        <b>雇用日期:</b> 
        <input type="text" name="hireDate" value="${adminVO.hireDate}" > <br>
        
   
        <input type="hidden" name="admStatus" value="1" ${adminVO.admStatus == 1 ? 'checked' : ''}> <br>
        
        <input type="hidden" name="action" value="create_admin">
        <input type="submit" value="新增">

    </form>
       </div>
        <div class="back-link">
        <a href="${pageContext.request.contextPath}/backend/index.jsp">回首頁</a>
    </div>
</body>
</html>