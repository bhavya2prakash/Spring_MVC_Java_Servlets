<%-- 
    Document   : success
    Created on : 20-Feb-2023, 4:13:22 pm
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <body bgcolor="turquoise">
        <fmt:parseNumber var="flag" integerOnly="true" type="number" value="${sessionScope.count}" />
        <h1>${flag} Books Have Been Added To DataBase</h1>
        <a href="Part7/amount.jsp">Click here to go back to the main page</a>
    </body>
    </body>
</html>
