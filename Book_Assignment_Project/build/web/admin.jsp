<%-- 
    Document   : admin
    Created on : Dec 21, 2020, 5:02:43 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
    </head>
    <body>
        <h1>Welcome Administrator ${sessionScope.LOGGING.fullName}</h1>
        <c:url var="logoutLink" value="MainController">
            <c:param name="btnAction" value="Logout"></c:param>
        </c:url>
        <a href="${logoutLink}">Go back to Home Page</a>
        <form action="MainController">
            Search by name <input type="text" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="btnAction" value="Search"/>
        </form>
        <br/>
        <c:if test="${requestScope.LIST_USER != null}">
            <c:if test="${not empty requestScope.LIST_USER}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone number</th>
                            <th>Role ID</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="list" varStatus="counter" items="${requestScope.LIST_USER}">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${list.userID}</td>
                                <td>${list.userPassword}</td>
                                <td><input type="text" name="txtFullName" value="${list.fullName}" required="true"/></td>
                                <td><input type="text" name="txtAddress" value="${list.address}" required="true"/></td>
                                <td><input type="text" name="txtEmail" value="${list.email}" required="true"/></td>
                                <td><input type="text" name="txtPhone" value="${list.phoneNumber}" required="true"/></td>
                                <td><input type="text" name="txtRoleID" value="${list.roleID}" required="true"/></td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="btnAction" value="Delete"></c:param>
                                        <c:param name="txtUserID" value="${list.userID}"></c:param>
                                        <c:param name="txtSearch" value="${param.search}"></c:param>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="txtUserID" value="${list.userID}"/>
                                    <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                    <input type="submit" name="btnAction" value="Update"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
</body>
</html>
