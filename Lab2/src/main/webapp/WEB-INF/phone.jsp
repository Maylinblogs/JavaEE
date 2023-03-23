<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Title</title>
</head>
<body>
<div class="container">
    <div class="main-container">
        <h2>Welcome User</h2>
        <form method="get" action="phone">
            <table class="table">
                <caption>Список Телефонов</caption>
                <tr>
                    <th>id</th>
                    <th>catalog</th>
                    <th>model</th>
                    <th>price</th>
                    <th>yes</th>
                </tr>
                <jsp:useBean id="phones" scope="request" type="java.util.ArrayList"/>
                <c:forEach items="${phones}" var="phone">
                    <tr>
                        <td>${phone.id}</td>
                        <td>${phone.category}</td>
                        <td>${phone.model}</td>
                        <td>${phone.price}</td>
                        <td>${phone.yes}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <form method="POST" action="phoneSearch">
            <jsp:useBean id="search" scope="request" type="com.example.lab2.model.Phone"/>
            <p> Search Phone</p>
            <p> id ${search.id}</p>
            <p> catalog ${search.price}</p>
            <p> model ${search.model}</p>
            <p> price ${search.category}</p>
            <p> yes ${search.yes}</p>
            <p> Write model <label>
                <input name="nmodel" type="text"/>
            </label></p>
            <p> Write yes <label>
                <input name="nyes" type="radio" value="true"/>
            </label></p>
            <input name="search" type="submit"/>
        </form>
        <form method="POST" action="phone">
            <p> Write model <label>
                <input name="nmodel" type="text"/>
            </label></p>
            <p> Write category <label>
                <input name="ncategory" type="text"/>
            </label></p>
            <input name="delete" type="submit"/>
        </form>
    </div>
    <footer class="footer">
    </footer>
</div>
</body>
</html>
