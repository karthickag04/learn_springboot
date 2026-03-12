<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>User Login</title>
</head>

<body>

<!-- Header Section -->

<header>
    <h1>Welcome to My Website</h1>
    <nav>
        <div class="left">
            <a href="/">Home</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
        </div>

```
    <div class="right">
        <a href="/login">Login</a>
        <a href="/register">Register</a>
    </div>
</nav>
```

</header>

<h2>Login</h2>

<form action="login" method="post">


Email:<br>
<input type="email" name="email" required />
<br><br>

Password:<br>
<input type="password" name="password" required />
<br><br>

<input type="submit" value="Login" />


</form>

</body>
</html>
