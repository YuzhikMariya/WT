<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
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
        <c:forEach var="d" items="${dishes}" >
            <tr>
                <td><c:out value="${d.getTitle()}"/></td>
                <td align="center"><c:out value="${d.getTableNumber()}"/></td>
            </tr>
        </c:forEach>
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
        <c:forEach var="o" items="${orders}" >
            <tr>
                <td><c:out value="${o.getTitle()}"/></td>
                <td align="center"><c:out value="${o.getTableNumber()}"/></td>
                <td align="center"><c:out value="${o.getPrice()}"/></td>
                <td align="center"><c:out value="${o.getTime()}"/></td>
            </tr>
        </c:forEach>
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
        <c:forEach var="e" items="${employees}" >
            <tr>
                <td><c:out value="${e.getName()}"/></td>
                <td align="center"><c:out value="${e.getSurname()}"/></td>
                <td align="center"><c:out value="${e.getAge()}"/></td>
                <td align="center"><c:out value="${e.getCategory()}"/></td>
                <td align="center"><c:out value="${e.getDob()}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
