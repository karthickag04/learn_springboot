<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<c:set var="title" value="Students Page" />
<c:set var="content" value="students.jsp" />

<h2>Students List</h2>
<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.course}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>