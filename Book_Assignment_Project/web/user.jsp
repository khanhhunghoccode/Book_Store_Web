<%-- 
    Document   : user
    Created on : Dec 21, 2020, 5:04:29 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Welcome User ${sessionScope.LOGGING.fullName}</h1>
    <c:url var="logoutLink" value="MainController">
        <c:param name="btnAction" value="Logout"></c:param>
    </c:url>
    <a href="${logoutLink}">Go back to Home Page</a>
    <form action="MainController">
        Find book <input type="text" name="txtFind" value="${param.txtFind}"/>
        <input type="submit" name="btnAction" value="Find"/>
    </form>
    <br/>
    <c:if test="${requestScope.LIST_BOOK != null}">
        <c:if test="${not empty requestScope.LIST_BOOK}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Book ID</th>
                        <th>Book name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Add To Cart</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="list" varStatus="counter" items="${requestScope.LIST_BOOK}">
                    <tr>
                    <form action="MainController">
                        <td>${counter.count}</td>
                        <td><input type="text" name="txtBookID" value="${list.productID}" readonly="true"/></td>
                        <td><input type="text" name="txtBookName" value="${list.productName}" required="true"/></td>
                        <td><input type="text" name="txtPrice" value="${list.price}" required="true"/></td>
                        <td><input type="text" name="txtQuantity" value="${list.quantity}" required="true"/></td>
                        <td><input type="text" name="txtStatus" value="${list.status}" required="true"/></td>
                        <td><input type="submit" name="btnAction" value="Choose"/></td>
                    </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
    <%
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
    %>
    <%= message%>
</body>
</html>
