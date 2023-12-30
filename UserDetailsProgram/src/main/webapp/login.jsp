<%@ page language="java" contentType="text/html"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body bgcolor="pink">
    <c:if test="${empty user}">
        Search Result not found....
        <jsp:include page="user_register.html" />
    </c:if>
    <c:if test="${not empty user}">
        <c:redirect url="https://sathyatech.com/" />
    </c:if>
</body>
</html>