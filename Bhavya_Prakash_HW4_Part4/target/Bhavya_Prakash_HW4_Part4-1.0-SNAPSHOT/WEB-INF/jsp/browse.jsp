<%-- 
    Document   : browse
    Created on : 03-Mar-2023, 9:40:08 pm
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Searching Movies</title>
</head>
<body bgcolor="yellow">
<h1>Searching Movies</h1>
<div>
    <form action="movie_result.htm" method="post">
        <label>Keyword: </label> &nbsp;
        <input type="text" name="keyword" required/><br/> <br/>
        <input type="radio" name="search" value="title" required/>Search By Title<br/><br/>
        <input type="radio" name="search" value="actor" required/>Search By Actor<br/><br/>
        <input type="radio" name="search" value="actress" required/>Search By Actress<br/><br/><br/>
        <input type="submit" name="submit" value="Search Movies" />
        <input type="hidden" name="page" value="browse"/>
    </form>
</div>
</body>
</html>
