<%@ page language="java" contentType="text/html"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="aqua">
<c:if test = "${saveResult == 1}">
       Data Inserted successfully...${saveResult}
   </c:if>
   <c:if test = "${saveResult == 0}">
       Data Inserted fail...${saveResult} 
       <%@include file = "users.html"%>
    </c:if>   

</body>
</html>