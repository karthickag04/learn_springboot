<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <form action="/edit/${user.id}" method="post">
        <label>Username:</label>
        <input type="text" name="username" value="${user.username}" required/><br><br>

        <label>Email:</label>
        <input type="email" name="email" value="${user.email}" required/><br><br>

        <label>Password:</label>
        <input type="password" name="password" value="${user.password}" required/><br><br>

        <label>Role:</label>
        <select name="role" required>
            <option value="USER" ${user.role == 'USER' ? 'selected' : ''}>USER</option>
            <option value="Admin" ${user.role == 'Admin' ? 'selected' : ''}>Admin</option>
        </select><br><br>

        <button type="submit">Update</button>
    </form>
    <br>
    <a href="/admin-dashboard">⬅ Back to Dashboard</a>
</body>
</html>
