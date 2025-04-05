<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.tmys.springfirstapp.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
        return;
    }
%>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f4f6;
            text-align: center;
            padding-top: 50px;
        }

        .card {
            background: #fff;
            padding: 2rem;
            margin: auto;
            max-width: 400px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            margin-bottom: 1rem;
        }

        a.button {
            display: inline-block;
            margin-top: 1.5rem;
            padding: 10px 20px;
            background-color: #ef4444;
            color: white;
            text-decoration: none;
            border-radius: 8px;
        }

        a.button:hover {
            background-color: #dc2626;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Welcome, <%= user.getUsername() %>!</h2>
        <p>Your email: <%= user.getEmail() %></p>

        <a href="/logout" class="button">Logout</a>
    </div>
</body>
</html>
