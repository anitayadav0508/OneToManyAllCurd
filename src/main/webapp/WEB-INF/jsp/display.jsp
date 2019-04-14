<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 12-04-2019
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${listOfEmployee}" var="list">
    ${list.empId}
    ${list.employeeName}
    ${list.designation}
    ${list.employeeDetail.id}
    ${list.employeeDetail.skills}
    ${list.employeeDetail.experience}
    ${list.employeeDetail.getEmployee().empId}
    ${list.employeeDetail.getEmployee().employeeName}
    ${list.employeeDetail.getEmployee().designation}
</c:forEach>
</body>
</html>
