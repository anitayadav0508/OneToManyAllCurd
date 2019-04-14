<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 12-04-2019
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${listOfEmployee1}" var="list">
    ${list.getEmployee().empId}
    ${list.getEmployee().employeeName}
    ${list.getEmployee().designation}
</c:forEach>
</body>
</html>
