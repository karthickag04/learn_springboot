<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.trymeyourself.collegeerp.entity.User" %>



<%@ include file="menus/header.jsp" %>

<div class="Container">

<h2>User Update</h2>



<% User user =
(User)request.getAttribute("user_data"); %>

<form action="/edit" method="post">
	
	
	<input type="hidden"
	       name="id"
	       value="<%= user.getId()%>">

    Username

    <input type="text"
           name="username" id="username" value="<%= user.getUsername()%>">

    <br><br>

    Password

    <input type="password"
           name="password" id="password" value="<%= user.getPassword()%>">

    <br><br>

    Email

    <input type="email"
           name="email" id="email" value="<%= user.getEmail()%>">

   <br><br>
   
  

   <label for="address">Address</label>

   <textarea id="address"
             name="address"
             rows="5"
             cols="40"
             placeholder="Enter your full address"><%= user.getAddress()%></textarea>
		      <br><br>

    <input type="submit"
           value="Update">

</form>


</div>
<%@ include file="menus/footer.jsp" %>