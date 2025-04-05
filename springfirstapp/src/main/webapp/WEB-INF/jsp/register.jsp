<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Website</title>
    <link rel="stylesheet" href="/css/styles.css"> <!-- Link to your CSS file -->
</head>
<body >

    <!-- Navigation Menu -->
    <nav>
        <ul class="nav-menu">
            <li><a href="/">Home</a></li>
            <li><a href="/about">About</a></li>
            <li><a href="/services">Services</a></li>
            
            <li><a href="/login">Login</a></li>
            
            <li><a href="/register">Register</a></li>
        </ul>
    </nav>
<div class="form-container-parent">
   <div class="form-container">
    <h2>Register</h2>
    <form action="/register" method="POST">
      <label for="username">Username</label>
      <input type="text" id="username" name="username" required />

      <label for="email">Email</label>
      <input type="email" id="email" name="email" required />

      <label for="password">Password</label>
      <input type="password" id="password" name="password" required />

      <button type="submit">Register</button>
    </form>
  </div>
</div>
</body>
</html>
