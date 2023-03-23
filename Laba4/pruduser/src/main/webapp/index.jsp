<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="POST" action="hello-servlet">
    <p> Write first grade <label>
        <input name="first" type="text"/>
    </label></p>
    <p> Write second grade <label>
        <input name="second" type="text"/>
    </label></p>
    <p> Write third grade <label>
        <input name="third" type="text"/>
    </label></p>
    <input name="delete" type="submit"/>
</form>
</body>
</html>