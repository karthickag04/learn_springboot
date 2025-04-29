<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>My Web Application</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/style.css'/>">
<script src="<c:url value='/js/script.js'/>"></script>
</head>
<body>

	<h1>Welcome to My Web Application</h1>

	<!-- added logic -->
    <h2>Fruits List:</h2>
	<ul>
		<c:forEach var="fruit" items="${fruits}">
			<li>${fruit}</li>
		</c:forEach>
	</ul>

</body>
</html>