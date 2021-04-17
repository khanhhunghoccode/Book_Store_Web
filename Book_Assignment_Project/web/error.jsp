<%-- 
    Document   : error
    Created on : Dec 17, 2020, 4:47:06 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1 style="color: red">Hello, You Have Some Trouble</h1>
        <h2 style="color: red">${applicationScope.ERROR}</h2>
        <a href="index.jsp">Click here to go back to Home Page</a>
    </body>
</html>
