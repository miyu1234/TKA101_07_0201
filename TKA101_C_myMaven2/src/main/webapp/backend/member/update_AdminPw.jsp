<%-- 檔案位置：src/main/webapp/backend/member/update_AdminPw.jsp --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head><title>管理員資料修改</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <h3>管理員更改密碼</h3>
     <div class="card">
    <form method="post" action="${pageContext.request.contextPath}/admin/admin.do">

        <input type="hidden" name="admId" value="${adminVO.admId}" readonly><br>
       
        <b>帳號:</b>  ${adminVO.admAcc}
        <input type="hidden" name="admAcc" value="${adminVO.admAcc}" readonly><br>
        
        <b>密碼:</b>       
        <input type="password" name="admPw" value="" required><br>
        

        <input type="hidden" name="admName" value="${adminVO.admName}"><br>
                <input type="hidden" name="hireDate" value="${adminVO.hireDate}" readonly> <br>
        
        <input type="hidden" name="admStatus" value="1" ${adminVO.admStatus == 1 ? 'checked' : ''}> 
        <input type="hidden" name="admStatus" value="0" ${adminVO.admStatus == 0 ? 'checked' : ''}> <br>
        
        <input type="hidden" name="action" value="reset_AdmPw">
        <input type="submit" value="送出修改">

    </form>
       </div>
        <div class="back-link">
        <a href="${pageContext.request.contextPath}/backend/index.jsp">回首頁</a>
    </div>
</body>
</html>