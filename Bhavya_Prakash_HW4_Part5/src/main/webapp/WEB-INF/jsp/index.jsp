<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 5</title>
    </head>
    <body>
        <h2>How May Books You Want To Add?</h2>
        <form action="addnew.htm" method="post">
            
            <input type="number" name="count" min="1" max="10" required>
             <input type="hidden" name="page" value="index"/>
            <input type="submit" value="Proceed">
            
        </form>
    </body>

    </html>
