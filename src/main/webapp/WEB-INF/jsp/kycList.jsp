<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 14-04-2019
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${listOfkycdocument}" var="list">
    ${list.getEmployee().empId}
    ${list.getEmployee().employeeName}
    ${list.getEmployee().designation}
</c:forEach>
</body>
</html>
