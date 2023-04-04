<%-- 
    Document   : part3
    Created on : 17-Feb-2023, 1:44:11 pm
    Author     : BHAVYA PRAKASH
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 3</title>
    </head>
    <body>
        <h1>Using JSTL tags</h1>
        <ul>
            <li>c:set, c:out,c:if,c:import, c:forEach </li>
            <li>fn:containsIgnoreCase(),fn:toLowerCase(),fn:length()</li>
            <li>fmt:formatDate,fmt:timeZone,fmt:parseDate </li>
            <li>x:parse,x:out,x:if </li>
            <li>sql:setDataSource,sql:query,sql:update</li>
        </ul>
        <c:set var="name" value="BHAVYA PRAKASH" scope="page"></c:set>
        Name : <c:out value="${name}"></c:out>
        <c:set var="i" value="1" scope="page"></c:set>
        <c:if test ="${i==1}">
            <h2> The if condition is true </h2>
        </c:if>
        <br>    
        Length of name is <c:out value="${fn:length(name)}"></c:out>
        <br> 
        <c:out value="${fn:toLowerCase(name)}"></c:out>
        <br> 
        <c:out value="${fn:containsIgnoreCase(name, bhavya)}"></c:out>
        <br>
        <c:set var="today" value="<%=new java.util.Date()%>"/>
        Date and Time now in USA 
        <fmt:formatDate value="${today}" type="both"/><br>
        Date and Time now in India
        <fmt:timeZone value="IST">
        <fmt:formatDate value="${today}" type="both"/><br>   
        </fmt:timeZone>
        <c:set var="date" value="12-08-2016" />  
  
        <fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />  
        <p><c:out value="${parsedDate}" /></p> 
        <h2>Vegetable Information:</h2>  
        <c:import url="vegetable.xml" var="vegetable"/> 
        <x:parse xml="${vegetable}" var="output"/>  
        <b>Name of the vegetable is</b>:  
        <x:out select="$output//vegetables/vegetable[1]/name" /><br>  
        <b>Price of the Potato is</b>:  
        <x:out select="$output//vegetables/vegetable[2]/price" /> 
        <x:if select="$output//vegetables/vegetable/price < 100"><br>
            Vegetables prices are very low.  
        </x:if>
        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
        url="jdbc:mysql://localhost/homework3"  
        user="root"  password="bhavya1234"/> 
        <sql:query dataSource="${db}" var="rs">  
        SELECT * from personal_details;  
        </sql:query>
        <sql:update dataSource="${db}" var="count">  
        INSERT INTO homework3.personal_details (Id, LastName, FirstName) VALUES (1004,"Fiza","Rose");
        </sql:update>
        <table border="2" width="100%">  
        <tr>  
        <th>ID</th>  
        <th>First Name</th>  
        <th>Last Name</th>   
        </tr>  
        <c:forEach var="table" items="${rs.rows}">  
        <tr>  
        <td><c:out value="${table.Id}"/></td>  
        <td><c:out value="${table.FirstName}"/></td>  
        <td><c:out value="${table.LastName}"/></td>   
        </tr>  
        </c:forEach>  
        </table>  
      
    </body>
</html>
