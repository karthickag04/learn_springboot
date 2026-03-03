<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
	
	
    <h2>Login</h2>
    <form action="/login" method="post">
        Username or Email: <input type="text" name="usernameOrEmail" required><br/>
        Password: <input type="password" name="password" required><br/>
        <button type="submit">Login</button>
    </form>
    <a href="/register">Don't have an account?</a>
	
	
</body>
</html>
