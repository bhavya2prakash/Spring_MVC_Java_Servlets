<%-- 
    Document   : browseResult
    Created on : 03-Mar-2023, 9:39:58 pm
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Browse Result</title>
</head>
<body bgcolor="lightgreen">
<h2>You searched for "${keyword}"</h2>
<u>Here are the search results</u><br/><br/>
<table border="1">
    <tr/><th/>Movie Title<th/>Lead Actor<th/>Lead Actress<th/>Genre<th/>Year
    <c:forEach var="movie" items="${result}">
        <tr/><th/>${movie.title}<th/>${movie.actor}<th/>${movie.actress}<th/>${movie.genre}<th/>${movie.year}
    </c:forEach>
</table>
<br><br>
<c:if test="${requestScope.list.size()  == 0}">
    <h3><c:out value="No Data Found"></c:out></h3>
</c:if>
<form action="movie_home.htm" method="post">
    <input type="submit" name="submit" value="Go Back to Main Page"/>
    <input type="hidden" name="page" value="result"/>
</form>
</body>
</html>
