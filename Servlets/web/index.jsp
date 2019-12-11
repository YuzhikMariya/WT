<%--
  Created by IntelliJ IDEA.
  User: masha
  Date: 10.12.2019
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>MyJSP</title>
</head>
<body>
<form action="RestaurantServlet" method="get">
  <input type="hidden" name="command" value="forward" />
  Enter path to xml-file:<br/>
  <label>
    <input type="text" name="path" value="" />
  </label><br/>
  <p><b>Check parser:</b></p>
  <p><input name="parser" type="radio" value="sax" checked> SAX</p>
  <p><input name="parser" type="radio" value="stax"> StAX</p>
  <p><input name="parser" type="radio" value="dom"> DOM</p>
  <input type="submit" value="Отправить" /><br/>
</form>
</body>
</html>