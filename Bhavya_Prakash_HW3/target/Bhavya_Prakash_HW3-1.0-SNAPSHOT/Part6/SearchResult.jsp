<%-- 
    Document   : SearchResult
    Created on : 18-Feb-2023, 12:19:11 am
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body bgcolor="lightgreen">
        <p>You searched for "${requestScope.keyword}"</p>
        <u>Here are the search results</u><br/><br/>
        <table border=1>
            <tr/><th/>Movie Title<th/>Lead Actor<th/>Lead Actress<th/>Genre<th/>Year
            <c:forEach var="movie" items="${requestScope.result}">
                <tr/><td/>${movie.title}<td/>${movie.actor}<td/>${movie.actress}<td/>${movie.genre}<td/>${movie.year}
            </c:forEach>
        </table>
        <a href="Part6/movie.html">Click here to go back to the main page</a>
    </body>
</html>
