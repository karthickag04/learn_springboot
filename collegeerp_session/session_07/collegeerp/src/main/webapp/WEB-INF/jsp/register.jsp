<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="menus/header.jsp" %>

<div class="Container">

<h2>User Registration</h2>

<form action="/register" method="post">

    Username

    <input type="text"
           name="username" id="username">

    <br><br>

    Password

    <input type="password"
           name="password" id="password">

    <br><br>

    Email

    <input type="email"
           name="email" id="email">

   <br><br>

   <label for="address">Address</label>

   <textarea id="address"
             name="address"
             rows="5"
             cols="35"
             placeholder="Enter your full address"></textarea>
		      <br><br>
			  
			  <label for="address">Role</label>
			  <select id="role" name="role">

			      <option value="USER">User</option>

			      <option value="ADMIN">Admin</option>

			  </select>		  <br><br>

			  
			  
			  
    <input type="submit"
           value="Register">

</form>


</div>
<%@ include file="menus/footer.jsp" %>