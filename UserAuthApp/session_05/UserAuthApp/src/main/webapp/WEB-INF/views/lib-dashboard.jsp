
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="com.trymeyourself.userauthapp.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
        return;
    }
%>


<html>
<head>
</head>
<body>
    <div class="card">
        <h2>Welcome Lib</h2>
		<h2>Welcome, <%= user.getUsername() %>!</h2>
		<p>Your email: <%= user.getEmail() %></p>

        <a href="/logout" class="button">Logout</a>
    </div>
</body>
</html>