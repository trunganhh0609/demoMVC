<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert</title>
</head>
<body>
    <h2>Insert new Product</h2>
    <form:form method= "POST" action="../test/insert" modelAttribute="employee">
        <form:input type="text"   placeholder="type name" path="name"></form:input>
        <form:errors path="name" cssClass="error"/> <br>
        <form:input type="text"  placeholder="type address" path="address" ></form:input>
        <form:errors path="address" cssClass="error"/> <br>
        <input type="submit" value="Add">
    </form:form>
    <style>
        .error{
            color: red;
        }
    </style>
</body>
</html>