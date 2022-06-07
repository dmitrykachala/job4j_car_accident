<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>
</head>
<body>
<!--Hello : ${accidents}-->

<a href="<c:url value='/create'/>">Добавить инцидент</a>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Имя</th>
        <th scope="col">Описание</th>
        <th scope="col">Адрес</th>
        <th scope="col">Тип события</th>
        <th scope="col">Статьи</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${accidents}" var="accident">
    <tr>
        <th scope="row"><c:out value="${accident.getId()}"/></th>
        <td><c:out value="${accident.getName()}"/></td>
        <td><c:out value="${accident.getText()}"/></td>
        <td><c:out value="${accident.getAddress()}"/></td>
        <td><c:out value="${accident.getType().getName()}"/></td>
        <td>
                <%--<c:out value="${accident.getRules().getName()}"/>--%>
        <td>
            <td>
                <c:forEach var="rule" items="${accident.getRules()}" >
                    <option value="${rule.id}">${rule.name}</option>
                </c:forEach>
            </td>
        </td>
        </td>
        <td/><a href="<c:url value='/edit?id=${accident.id}'/>">Редактировать инцидент</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>