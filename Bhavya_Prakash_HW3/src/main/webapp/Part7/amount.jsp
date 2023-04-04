<%-- 
    Document   : amount
    Created on : 18-Feb-2023, 12:59:04 am
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Amount</title>
    </head>
    <body>
        <h1>How many books do you want to add?</h1>
         <form action="../AddBooks" method="get">
            
            <input type="number" name="count" min="1" max="10" required>
            <input type="submit" value="Proceed">
            
        </form>
       
    </body>
</html>
