<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trymeyourself.collegeerp.entity.User" %>


<%@ include file="menus/header.jsp" %>

<div class="Container">
<h2>Welcome page</h2>

<%
List<User> users =
(List<User>) request.getAttribute("user_info");
%>



<table border="1">

<tr>

<th>ID</th>
<th>Username</th>
<th>Password</th>
<th>Email</th>
<th>Address</th>

</tr>

<%

for(User user : users){

%>

<tr>

<td><%= user.getId() %></td>

<td><%= user.getUsername() %></td>

<td><%= user.getPassword() %></td>

<td><%= user.getEmail() %></td>

<td><%= user.getAddress() %></td>
<td><a href="/edit">Edit</a></td>

<td><a href="/delete?id=<%= user.getId() %>">Delete</a></td>
</tr>

<%

}

%>

</table>



</div>

<%@ include file="menus/footer.jsp" %>