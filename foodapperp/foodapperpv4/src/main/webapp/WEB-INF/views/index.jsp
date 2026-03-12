<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My First Website</title>

    <!-- CSS -->
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

    <!-- Header Section -->
    <header>
        <h1>Welcome to My Website</h1>
        <nav>
			<div class'left'>
            <a href="#">Home</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
			</div>
			<div class='right'>

			<a href="/login">Login</a>

			<a href="/register">Register</a>
			</div>
			
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <h2>Home Page</h2>
        <p>This is the main page of the website.</p>
    </main>
	
	
	<table border="1">

	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Password</th>
	<th>Actions</th>
	</tr>

	<c:forEach var="user" items="${users}">

	<tr>

	<td>${user.id}</td>
	<td>${user.name}</td>
	<td>${user.email}</td>
	<td>${user.password}</td>

	<td>

	<a href="/edit/${user.id}">Edit</a>

	|

	<a href="/delete/${user.id}">Delete</a>

	</td>

	</tr>

	</c:forEach>

	</table>

    <!-- Footer -->
    <footer>
        <p>© 2026 My Website</p>
    </footer>

    <!-- JavaScript -->
    <!--<script src="/js/script.js"></script>
-->
</body>
</html>