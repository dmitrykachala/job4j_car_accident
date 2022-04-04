<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>
</head>
<body>
Hello : ${jedis}

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${jedis}" var="jedi">
    <tr>
        <th scope="row">${jedis.indexOf(jedi)+1}</th>
        <td><c:out value="${jedi}"/></td>
        <td><c:out value="${jedi.length()}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>