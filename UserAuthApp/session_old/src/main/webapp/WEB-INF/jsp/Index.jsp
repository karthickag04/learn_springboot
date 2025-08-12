<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to My Web App</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            text-align: center;
            padding-top: 50px;
        }
        .container {
            background-color: white;
            display: inline-block;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }
        h1 {
            color: #333;
        }
        a.button {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a.button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Welcome to My JSP Web Application</h1>
        <p>This is the home page.</p>

        <a class="button" href="/login">Login</a>
        <a class="button" href="/register">Register</a>
        <a class="button" href="/about">About</a>
    </div>

</body>
</html>
