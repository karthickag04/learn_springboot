<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
    <h2>Create New User</h2>
    <form action="/create-user" method="post">
        <label>Username:</label>
        <input type="text" name="username" required/><br><br>

        <label>Email:</label>
        <input type="email" name="email" required/><br><br>

        <label>Password:</label>
        <input type="password" name="password" required/><br><br>

        <label>Role:</label>
        <select name="role" required>
            <option value="USER">USER</option>
            <option value="Admin">Admin</option>
        </select><br><br>

        <button type="submit">Create</button>
    </form>
    <br>
    <a href="/admin-dashboard">⬅ Back to Dashboard</a>
</body>
</html>
