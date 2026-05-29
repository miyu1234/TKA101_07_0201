<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員詳細資料</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h2>管理員詳細資料</h2>
    

    <div class="card">
        <c:if test="${not empty adminVO}">
            <p><strong>管理員編號:</strong> ${adminVO.admId}</p>
            <p><strong>管理員姓名:</strong> ${adminVO.admName}</p>
            <p><strong>管理員帳號:</strong> ${adminVO.admAcc}</p>
            <p><strong>雇用日期:</strong> ${adminVO.hireDate}</p>
            <p><strong>狀態:</strong> 
                <c:choose>
                    <c:when test="${adminVO.admStatus == 1}">啟用</c:when>
                    <c:otherwise>停用</c:otherwise>
                </c:choose>
            </p>
        </c:if>
        <c:if test="${empty adminVO}">
            <div class="error">找不到該管理員資料！</div>
        </c:if>
    </div>

    <div class="back-link">
        <a href="${pageContext.request.contextPath}/backend/index.jsp">回首頁</a>
    </div>
</body>
</html>
