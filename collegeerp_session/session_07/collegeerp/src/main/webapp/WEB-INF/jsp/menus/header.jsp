
<%@ page import="com.trymeyourself.collegeerp.entity.User" %>

<%
    User loggedUser = (User) session.getAttribute("loggedUser");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
	
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	
	<div class="header">
	    <h2>My Spring Boot Application</h2>
	</div>

	<div class="menu">
		
		<div class="left">
	    <a href="/">Home</a>
	    <a href="/employees">Employees</a>
	    <a href="/products">Products</a>
	    <a href="/contact">Contact</a>
		
	</div>
	<!--<div class="right">
		<a href="/register">Register</a>
		<a href="/login">Login</a>
	</div>-->
	
	
	<div class="right">

	<% if (loggedUser == null) { %>

	    <a href="/register">Register</a>
	    <a href="/login">Login</a>

	<% } else { %>

	    <span>Welcome, <b><%= loggedUser.getUsername() %></b></span>

	    <a href="/logout">Logout</a>

	<% } %>

	</div>
	</div>