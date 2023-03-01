<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form action="OwnerEdit" method="post">
    <label for="firstName">Введите фамилию:
        <input type="text" id="firstName" value="${owner.getFirstName()}" name="firstName" required/>
    </label>  <br />
    <label for="surname">Введите имя:
        <input type="text" id="surname" value="${owner.getSurname()}" name="surname" required/>
    </label>  <br />
    <label for="patronymic">Введите отчество:
        <input type="text" id="patronymic" value="${owner.getPatronymic()}" name="patronymic" required/>
    </label>  <br />
    <label for="phoneNumber">Введите телефон:
        <input type="tel" id="phoneNumber" pattern="[8]{1}-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}" value="${owner.getPhoneNumber()}" name="phoneNumber" />
    </label> <small>Format: 8-111-111-11-11</small> <br />
    <label for="address">Введите адрес:
        <input type="text" id="address" value="${owner.getAddress()}" name="address" required/>
    </label>  <br />
    <input type="hidden" id="ownerId" value="${owner.getOwnerId()}" name="ownerId"/>
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>
