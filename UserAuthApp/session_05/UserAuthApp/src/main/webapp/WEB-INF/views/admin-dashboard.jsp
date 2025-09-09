
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.trymeyourself.userauthapp.model.User" %>


<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
        return;
    }
	
	if (!"Admin".equals(user.getRole())) {
        if ("USER".equals(user.getRole())) {
            response.sendRedirect("user-dashboard");
        } else {
            response.sendRedirect("login");
        }
    }
	
%>


<html>
<head>
</head>
<body>
    <div class="card">
        <h2>Welcome Admin</h2>
		<h2>Welcome, <%= user.getUsername() %>!</h2>
		<p>Your email: <%= user.getEmail() %></p>

        <a href="/logout" class="button">Logout</a>
		
		
		<a href="/create-user">➕ Create New User</a>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Role</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="u" items="${users}">
			                    <tr>
			                        <td><c:out value="${u.id}" /></td>
			                        <td><c:out value="${u.username}" /></td>
			                        <td><c:out value="${u.email}" /></td>
			                        <td><c:out value="${u.role}" /></td>
									<td>
										<a href="/edit/${u.id}">✏ Edit</a> |
					                     <a href="/delete/${u.id}" onclick="return confirm('Are you sure?')">❌ Delete</a>
										                
									</td>
					</tr>
				</c:forEach>
		</table>
		
		
    </div>
</body>
</html>