<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="by.bsuir.Yuzhik.model.entity.Dish" %>
<%@ page import="by.bsuir.Yuzhik.model.entity.Order" %>
<%@ page import="by.bsuir.Yuzhik.model.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: masha
  Date: 11.12.2019
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <caption>Dishes</caption>
        <tr>
            <th align="left" width="100">Title</th>
            <th align="center" width="100">Table number</th>
        </tr>
        <%	ArrayList<Dish> d = (ArrayList) request.getAttribute("dishes");
            for (Dish row : d) { %>
        <tr>
            <td><%= row.getTitle() %></td>
            <td align="center"><%= row.getTableNumber() %></td>
        </tr>
        <%	} %>
    </table>
    <br />
    <table>
        <caption>Orders</caption>
        <tr>
            <th align="left" width="100">Title</th>
            <th align="center" width="100">Table number</th>
            <th align="center" width="100">Price</th>
            <th align="center" width="100">Time</th>
        </tr>
        <%	ArrayList<Order> o = (ArrayList) request.getAttribute("orders");
            for (Order row : o) { %>
        <tr>
            <td><%= row.getTitle() %></td>
            <td align="center" ><%= row.getTableNumber() %></td>
            <td align="center" ><%= row.getPrice() %></td>
            <td align="center" ><%= row.getTime() %></td>
        </tr>
        <%	} %>
    </table>
    <br />
    <table>
        <caption>Employees</caption>
        <tr>
            <th align="left" width="120">Name</th>
            <th align="center"  width="120">Surname</th>
            <th align="center" width="120">Age</th>
            <th align="center" width="120">Category</th>
            <th align="center" width="120">Birthday</th>
        </tr>
        <%	ArrayList<Employee> e = (ArrayList) request.getAttribute("employees");
            for (Employee row : e) { %>
        <tr>
            <td><%= row.getName() %></td>
            <td align="center"><%= row.getSurname() %></td>
            <td align="center"><%= row.getAge() %></td>
            <td align="center"><%= row.getCategory() %></td>
            <td align="center"><%= row.getDob() %></td>
        </tr>
        <%	} %>
    </table>
</body>
</html>
