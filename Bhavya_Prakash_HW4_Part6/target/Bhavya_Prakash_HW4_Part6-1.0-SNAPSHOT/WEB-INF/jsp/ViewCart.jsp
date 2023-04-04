<%-- 
    Document   : ViewCart
    Created on : 20-Feb-2023, 6:29:34 pm
    Author     : BHAVYA PRAKASH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <c:set var="cart" value="${sessionScope.cart}"/>
        <h2 align="center">View Your Cart</h2>
        
            <table border=1 align="center">
                <tr/><th/>Object<th/>Amount<th/>Remove
                <c:if test="${cart != null}">
                    <c:forEach var="item" items="${cart.cart}">                        
                        <tr/><td/>${item.name}
                        <td/>${item.count}<td/><form action="remove.htm" method="post"><input type = "hidden" name = "remove" value="${item.name}"> <input type="submit" name="Submit" value="Remove"></form>
                    </c:forEach>
                </c:if>
            </table>
    
    </body>
</html>
