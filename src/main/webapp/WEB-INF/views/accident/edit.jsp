<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Id:</td>
            <td><input type='text' readonly name='id' value="<c:out value="${accident.getId()}"/>"></td>
        </tr>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name' value="<c:out value="${accident.getName()}"/>"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='text' value="<c:out value="${accident.getText()}"/>"></td>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><input type='text' name='address' value="<c:out value="${accident.getAddress()}"/>"></td>
        </tr>
        <tr>
            <td>Тип:</td>
            <td>
                <select name="type.id">
                    <c:forEach var="type" items="${types}" >
                        <c:if test = "${type.id == accident.getType().getId()}">
                        <option value="${type.id}" selected>${type.name}</option>
                        </c:if>>
                        <c:if test = "${type.id != accident.getType().getId()}">
                            <option value="${type.id}">${type.name}</option>
                        </c:if>>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td>Статьи:</td>
            <td>
                <select name="rIds" multiple>
                    <c:forEach var="rule" items="${rules}" >
                        <c:if test = "${accident.getRules().contains(rule)}">
                            <option value="${rule.id}" selected>${rule.name}</option>
                        </c:if>>
                        <c:if test = "${!accident.getRules().contains(rule)}">
                            <option value="${rule.id}">${rule.name}</option>
                        </c:if>>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>
