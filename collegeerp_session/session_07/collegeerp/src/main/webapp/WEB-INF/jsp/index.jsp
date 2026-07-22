<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="menus/header.jsp" %>


<%
    String username = (String) request.getAttribute("uname");
%>


<div class="Container">
    <h1>Welcome!   <%= username %></h1>
    <p>Hello, welcome to my website.</p>
	</div>

<%@ include file="menus/footer.jsp" %>