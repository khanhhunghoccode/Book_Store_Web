<%-- 
    Document   : register
    Created on : Dec 21, 2020, 9:17:15 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Sign Up</h1>
        <form action="MainController" method="POST">
            Username <input type="text" name="txtUserID" value="${param.txtUserID}" required="true"/>
            <font color="red">${requestScope.ERROR.userIdError}</font></br>
            Password <input type="password" name="txtPassword" required="true"/></br>            
            Confirm <input type="password" name="txtConfirm" required="true"/>
            <font color="red">${requestScope.ERROR.confirmError}</font></br>
            Full Name <input type="text" name="txtFullName" value="${param.txtFullName}" required="true"/></br>
            Address <input type="text" name="txtAddress" value="${param.txtAddress}" required="true"/></br>
            Email <input type="text" name="txtEmail" value="${param.txtEmail}" required="true"/>
            <font color="red">${requestScope.ERROR.emailError}</font></br>
            Phone Number <input type="text" name="txtPhone" value="${param.txtPhone}" required="true"/>
            <font color="red">${requestScope.ERROR.phoneNumberError}</font></br>
            Role ID <input type="text" name="txtRoleID" value="${param.txtRoleID}" required="true"/>
            <font color="red">${requestScope.ERROR.roleIdError}</font></br>
            <input type="submit" name="btnAction" value="Register"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
