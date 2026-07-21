<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="menus/header.jsp" %>

<div class="Container">

<h2>User Login</h2>

<form action="/login" method="post">

Username

<input type="text"
       name="username">

<br><br>

Password

<input type="password"
       name="password">

<br><br>

<input type="submit"
       value="Login">

</form>

</div>

<%@ include file="menus/footer.jsp" %>