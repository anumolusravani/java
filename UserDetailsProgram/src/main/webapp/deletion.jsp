<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body bgcolor = "pink">
<c:if test="${empty user}">
	   Deletion not found....
	   <jsp:include page="userdelete.html"/>
	</c:if>
	
	<c:if test="${not empty user}">
       Deteled file successfully....
		<jsp:include page="userdelete.html"/>
		
	</c:if>
	

</body>
</html>