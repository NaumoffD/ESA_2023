<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
<h3>Животные:</h3>(<a href="AnimalEdit">добавить</a>)
<ol>
    <c:forEach items="${animals}" var = "animal">
        <li>
                ${animal.toString()}
            <a href="AnimalEdit?chipId=${animal.getChipId()}">Редактировать</a> | <a href="AnimalRemove?chipId=${animal.getChipId()}">Удалить</a>
        </li>
    </c:forEach>
</ol>
<h3>Хозяева:</h3>(<a href="OwnerEdit">Добавить</a>)
<ol>
    <c:forEach items="${owners}" var = "owner">
        <li>
                ${owner.toString()}
                    <a href="OwnerEdit?ownerId=${owner.getOwnerId()}">Редактировать</a> | <a href="OwnerRemove?ownerId=${owner.getOwnerId()}">Удалить</a>

                    <ol>
                    <c:forEach items="${owner.getAnimals()}" var = "animal">
                        <li>
                            ${animal.getStringAnimal()}
                        </li>
                    </c:forEach>
                </ol>
        </li>
    </c:forEach>
</ol>
</body>
</html>