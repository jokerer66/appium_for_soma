<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/3/17
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestReport</title>
</head>
<body>
<table>
    <tr>
        <c:forEach var="v" begin="0" end="${drivercount}" step="1">
            <td><a href="http://localhost:8080/downreport${v}/html/index.html" >view report[driver${v}]</a> </td><br>
        </c:forEach>
        <%--<td><a href="http://localhost:8080/downreport/html/index.html" >view report[driver${drivercount}]</a> </td>--%>
    </tr>
</table>
</body>
</html>
