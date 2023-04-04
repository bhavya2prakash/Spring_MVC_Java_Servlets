<%-- 
    Document   : AddResult
    Created on : 18-Feb-2023, 12:19:51 am
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Result</title>
    </head>
    <body bgcolor="turquoise">
        <fmt:parseNumber var="flag" integerOnly="true" type="number" value="${requestScope.result}" />
        <c:choose>
            <c:when test="${flag > 0}">
                <h1>1 Movie Added Successfully</h1>
            </c:when>
            <c:otherwise>
                <h1>Movie Added Failed</h1>
            </c:otherwise>
        </c:choose>
        <a href="Part6/movie.html">Click here to go back to the main page</a>
    </body>
</html>
