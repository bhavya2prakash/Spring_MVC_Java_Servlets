<%-- 
    Document   : movie
    Created on : 03-Mar-2023, 9:39:40 pm
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Store</title>
</head>
<body bgcolor="pink">
<h1>Welcome to our Movie Store</h1>
<p>Please make your selection below</p>
<form action="movie_operate.htm" method="post">
    <select name="operation">
        <option value="browse">Browse Movies</option>
        <option value="add">Add New Movie to Database</option>
    </select>
    <input type="submit" name="submit" value="Send"/>
    <input type="hidden" name="page" value="home"/>
</form>
</body>
</html>
