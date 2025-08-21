<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
	<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
    
	
	<h2>Register Admin</h2>

	<form action="/register-admin" method="post">
	    Username: <input type="text" name="username" required><br/>
	    Email: <input type="email" name="email" required><br/>
	    Password: <input type="password" name="password" required><br/>
	    <button type="submit">Register as Admin</button>
	</form>
	
	
    <a href="/login">Already have an account?</a>

	
	
</body>
</html>
