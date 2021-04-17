<%-- 
    Document   : index
    Created on : Dec 17, 2020, 8:35:39 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Welcome To Hung's Book Store</h1><br/>
        <h2>Login</h2>
        <form action="MainController" method="POST">
            Username <input type="text" name="txtUserID""/><br/>
            Password <input type="password" name="txtPassword"/><br/>
            <input type="submit" name="btnAction" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <br/>
        <c:url var="registerLink" value="MainController">
            <c:param name="btnAction" value="RegisterPage"></c:param>
        </c:url>
        <a href="${registerLink}">Don't have account? Register</a>
    </body>
</html>
