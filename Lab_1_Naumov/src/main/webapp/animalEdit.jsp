<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form action="AnimalEdit" method="post">
    <label for="firstName">Введите кличку:
        <input type="text" id="firstName" value="${animal.getName()}" name="name" required/>
    </label>  <br />
    <label for="sex">Выберите пол:
        <select  id="sex" name="sex">
            <option value="Не указано">Не указано</option>
            <option value="Кобель" ${animal.getSex().equals("Кобель") ? 'selected="selected"' : ''}>Кобель</option>
            <option value="Сука" ${animal.getSex().equals("Сука") ? 'selected="selected"' : ''}>Сука</option>

        </select>
    </label>  <br />
    <label for="color">Введите цвет:
        <input type="text" id="color" value="${animal.getColor()}" name="color" required/>
    </label>  <br />
    <label for="breed">Введите породу:
        <input type="text" id="breed" value="${animal.getBreed()}" name="breed" required/>
    </label>  <br />
    <label for="breed">Выберите хозяина:
    <select  id="owner" name="owner">
        <option value="null">В приюте</option>
        <c:forEach var="item" items="${owners}">
            <option value=${item.getOwnerId()} ${item.getOwnerId() == animal.getOwner().getOwnerId() ? 'selected="selected"' : ''}>${item.getFullName()}</option>
        </c:forEach>
    </select>
    </label>  <br />
    <input type="hidden" id="chipId" value="${animal.getChipId()}" name="chipId" />
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>