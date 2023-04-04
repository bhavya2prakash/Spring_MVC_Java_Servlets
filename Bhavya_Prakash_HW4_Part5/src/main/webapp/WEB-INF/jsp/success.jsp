<%-- 
    Document   : success
    Created on : 03-Mar-2023, 4:25:13 pm
    Author     : BHAVYA PRAKASH
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Added</title>
    </head>
    <body bgcolor="lightgreen">
        <h1>${requestScope.count}Books Have Been Added To DataBase</h1>
        <a href="index.htm">Home Page</a>
    </body>
</html>
