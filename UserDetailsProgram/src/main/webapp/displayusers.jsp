<%@ page import = "com.sathya.form.UserDao"  %>
<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Insert title here</title>
</head>
<body bgcolor = "pink">
    <table border = "3">
    <thead>
       <tr> 
          <th>userId</th>
          <th>userName</th>
          <th>userEmail</th>
          <th>userMobile</th>
          <th>userLocation</th>
       </tr>
    </thead>
    <tbody>
       <c:forEach items = "<%=new UserDao().findAll() %>" var ="user">
       <tr> 
       <td> ${user.userId }</td>
       <td> ${user.userName }</td>
       <td> ${user.userEmail }</td>
       <td> ${user.userMobile }</td>
       <td> ${user.userLocation }</td>
       </tr>
       </c:forEach>
    </tbody>
</table>

</body>
</html>