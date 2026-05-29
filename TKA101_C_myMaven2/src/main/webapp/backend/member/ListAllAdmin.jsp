<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>


<html>
<head>
<title>管理員資料</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class="list">
		<c:choose>
			<c:when test="${param.action == 'getAll'}">
                [ 全部管理員列表 ]
            </c:when>

			<c:when test="${param.action == 'getList_By_Status'}">
                [ 搜尋: 以帳號狀態分類: 
                <c:choose>
					<c:when test="${param.admStatus == 1}">啟用</c:when>
					<c:when test="${param.admStatus == 0}">停用</c:when>
					<c:otherwise>未知狀態</c:otherwise>
				</c:choose>
                ]
            </c:when>
            <c:when test="${param.action == 'update_admin'}">
           <span class="success">[ 提示: 管理員 "${adminVO.admName}" 資料已更新成功! ] </span>
          </c:when>
                <c:when test="${param.action == 'reset_AdmPw'}">
           <span class="success">[ 提示: 管理員 "${adminVO.admName}" 密碼更新成功! ] </span>
          </c:when>
                      <c:when test="${param.action == 'create_admin'}">
           <span class="success">[ 提示: 管理員 "${adminVO.admName}" 帳號新增成功! ] </span>
          </c:when>
		</c:choose>
	</div>
	<hr>


        <!--< @ include file="page1.file" %>   -->
	<table>
		<tr>
			<th>管理員編號</th>
			<th>管理員姓名</th>
			<th>管理員帳號</th>
			<th>雇用日期</th>
			<th>狀態</th>
			<th>操作</th>
		</tr>
		
	 
		<%-- 使用 c:forEach 迴圈把 Servlet 傳來的 adminList 跑一遍 --%>
		
			  <c:forEach var="admin" items="${adminList}">
			<tr>
				<%-- 使用 EL 表達式 ( ${} ) 把資料印出來 --%>
				<td>${admin.admId}</td>
				<td>${admin.admName}</td>
				<td>${admin.admAcc}</td>
				<td>${admin.hireDate}</td>
				 <td>${admin.admStatus == 1 ? '啟用' : '停用'}</td>
				<td>
                <!-- 修改按鈕表單 -->
                <form method="post" action="${pageContext.request.contextPath}/admin/admin.do" >
                    <input type="hidden" name="admId" value="${admin.admId}">
                    <input type="hidden" name="action" value="getOne_For_update">
                    <input type="submit" value="修改">
                     </form>
                      <form method="post" action="${pageContext.request.contextPath}/admin/admin.do" >
                    <input type="hidden" name="admId" value="${admin.admId}">
                    <input type="hidden" name="action" value="getOne_For_password">
                    <input type="submit" value="更改密碼">
                     </form>
			</tr>
		</c:forEach>
	</table>

    <div class="back-link"  >
     <h3>   <a href="${pageContext.request.contextPath}/backend/index.jsp">回首頁</a> </h3>
    </div>
</body>
</html>