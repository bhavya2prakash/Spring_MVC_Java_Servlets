<%-- 
    Document   : add
    Created on : 03-Mar-2023, 9:40:31 pm
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Movie to Database</title>
</head>
<body bgcolor="turquoise">
<h1>Please enter the details below:</h1>
<div>
    <form action="movie_result.htm" method="post">
        <label>Movie Title: </label> &nbsp;
        <input type="text" name="Movie Title" required/><br/><br/>
        <label>Lead Actor: </label> &nbsp;
        <input type="text" name="Lead Actor" required/><br/><br/>
        <label>Lead Actress: </label> &nbsp;
        <input type="text" name="Lead Actress" required/><br/><br/>
        <label>Genre: </label>&nbsp;
        <input type="text" name="Genre" required/><br/><br/>
        <label>Year: </label>&nbsp;
        <input type="number" name="Year" min="1900" max="2023" required/><br/><br/>
        <input type="submit" name="submit" value="Add Movie"/>
        <input type="hidden" name="page" value="add"/>
    </form>
</div>
</body>
</html>
