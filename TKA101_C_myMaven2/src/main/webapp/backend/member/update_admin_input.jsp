<%-- 檔案位置：src/main/webapp/backend/member/update_admin_input.jsp --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head><title>管理員資料修改</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <h3>管理員資料修改</h3>
     <div class="card">
    <form method="post" action="${pageContext.request.contextPath}/admin/admin.do">

        <b>管理員編號:</b> ${adminVO.admId}
        <input type="hidden" name="admId" value="${adminVO.admId}"><br>
        
        <b>帳號:</b>  ${adminVO.admAcc}
        <input type="hidden" name="admAcc" value="${adminVO.admAcc}" readonly><br>
        
        <b>密碼:</b> 
        <b>如要修改 請按修改密碼</b>
        <input type="hidden" name="admPw" value="${adminVO.admPw}" readonly><br>
        
        <b>姓名:</b> 
        <input type="text" name="admName" value="${adminVO.admName}"required><br>
        
        <b>雇用日期:</b> 
        <input type="text" name="hireDate" value="${adminVO.hireDate}" readonly> (唯讀)<br>
        
        <b>狀態:</b>
        <input type="radio" name="admStatus" value="1" ${adminVO.admStatus == 1 ? 'checked' : ''}> 啟用
        <input type="radio" name="admStatus" value="0" ${adminVO.admStatus == 0 ? 'checked' : ''}> 停用<br>
        
        <input type="hidden" name="action" value="update_admin">
        <input type="submit" value="送出修改">

    </form>
       </div>
        <div class="back-link">
        <a href="${pageContext.request.contextPath}/backend/member/admin_index.jsp">回首頁</a>
    </div>
</body>
</html>