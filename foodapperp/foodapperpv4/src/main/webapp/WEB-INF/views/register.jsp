<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>User Registration</title>
</head>

<body>
	
	<!-- Header Section -->
	<header>
	    <h1>Welcome to My Website</h1>
	    <nav>
			<div class'left'>
	        <a href="/">Home</a>
	        <a href="#">About</a>
	        <a href="#">Contact</a>
			</div>
			<div class='right'>

			<a href="/login">Login</a>

			<a href="/register">Register</a>
			</div>
			
	    </nav>
	</header>

<h2>User Registration</h2>

<form action="register" method="post">

Name:<br>
<input type="text" id="name" name="name"/>
<br><br>

Email:<br>
<input type="email" name="email"/>
<br><br>

Password:<br>
<input type="password" name="password"/>
<br><br>

<input type="submit" value="Register"/>

</form>

</body>
</html>