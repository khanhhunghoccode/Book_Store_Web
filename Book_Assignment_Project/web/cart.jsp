<%-- 
    Document   : viewCart
    Created on : Dec 11, 2020, 9:06:48 AM
    Author     : PC
--%>

<%@page import="hungkd.dtos.BookDTO"%>
<%@page import="hungkd.dtos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Your shopping cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
                double total = 0;
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Book ID</th>
                    <th>Book Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Total</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (BookDTO book : cart.getCart().values()) {
                        total += book.getQuantity() * book.getPrice();
                %>
            <form ation="MainController">
                <tr>
                    <td><%= ++count%></td>
                    <td><input type="text" name="txtBookID" value="<%= book.getProductID() %> readonly="true"/></td>
                    <td><%= book.getProductName()%></td>
                    <td><input type="text" name="txtQuantity" value="<%= book.getQuantity() %>" required="true"</td>
                    <td><%= book.getPrice()%></td>
                    <td><%= book.getStatus() %></td>
                    <td><%= book.getQuantity() * book.getPrice()%></td>
                    <td><input type="submit" name="btnAction" value="Remove"/></td>
                    <td><input type="submit" name="btnAction" value="Edit"/></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <h3>Total: <%= total%></h3>
    <%
        }
    %>
    <a href="user.jsp">Continue shopping</a>
    <br/>
    <a href="index.jsp">Logout</a>
</body>
</html>
