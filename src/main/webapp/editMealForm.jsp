<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meal</title>
    <style>
        dl {
            background: none repeat scroll;
            margin: 10px 0;
            padding: 0;
        }

        dt {
            display: inline-block;
            width: 200px;
        }

        dd {
            display: inline-block;
            margin-left: 10px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<h3>${param.action == 'create' ? 'Create meal' : 'Edit meal'}</h3>
<hr>
<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
<form method="post" action="meals">
    <input type="hidden" name="id" value="${meal.id}">
    <dl>
        <dt>DateTime:</dt>
        <dd><input type="datetime-local" value=${meal.dateTime} name="dateTime"></dd>
    </dl>
    <dl>
        <dt>Description:</dt>
        <dd><input type="text" value="${meal.description}" name="description"></dd>
    </dl>
    <dl>
        <dt>Calories:</dt>
        <dd><input type="number" value="${meal.calories}" name="calories"></dd>
    </dl>
    <button type="submit">Save</button>
    <button type="button" onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>
