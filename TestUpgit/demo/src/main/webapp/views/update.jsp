<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>update</title>
</head>
<body>
    <form:form method="POST" action="/test/update/${employee.getId()}" modelAttribute="employee">
        <form:input type="text"  placeholder="Name" path="name" value="${employee.getName()}"/>
        <form:errors path="name" cssClass="error"/> <br>
        <form:input type="text"  placeholder="Address" path="address" value="${employee.getAddress()}"/>
        <form:errors path="address" cssClass="error"/> <br>
        <input type="submit" value="submit">
    </form:form>
    <style>
        .error{
            color: red;
        }
    </style>
</body>
</html>