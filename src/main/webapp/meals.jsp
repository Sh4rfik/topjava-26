<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style>
        .normal {
            color: green
        }

        .exceed {
            color: red
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<a href="meals?action=create">Add meal</a>
<hr>
<form method="get" action="meals">
    <table>
        <thead>
        <input type="hidden" name="action" value="filter">
        <tr>
            <th>От даты(включая):</th>
            <th>До даты (включая):</th>
            <th></th>
            <th>От времени (включая):</th>
            <th>До времени (исключая):</th>
        </tr>
        </thead>
        <tr>
            <th><input type="date" name="startDate" value="${param.startDate}"></th>
            <th><input type="date" name="endDate" value="${param.endDate}"></th>
            <th></th>
            <th><input type="time" name="startTime" value="${param.startTime}"></th>
            <th><input type="time" name="endTime" value="${param.endTime}"></th>
        </tr>
    </table>
    <br><br>
    <button type="submit">Filter</button>
    <br><br>
</form>
<table border="1" cellpadding="10" cellspacing="5">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.to.MealTo"/>
        <tr class="${meal.excess ? 'exceed' : 'normal'}">
            <td>${fn:formatDateTime(meal.dateTime)}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
            <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>