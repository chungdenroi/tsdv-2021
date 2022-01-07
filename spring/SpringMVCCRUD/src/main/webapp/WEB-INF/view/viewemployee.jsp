<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 22/11/2021
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <div class="container mt-4 col-md-6">
        <h1 class="text text-primary text-center mb-3">Employee List</h1>
        <table class="table table-bordered ">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Menu</th>
            </tr>
            <c:forEach var="employee" items="${list}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.salary} $ </td>
                    <td>
                        <a class="btn btn-warning" href="editemployee/${employee.id}">Edit</a>
                        <a class="btn btn-danger" href="deleteemployee/${employee.id}"
                           onclick="return confirm('Do you want to delete this employee ?')";
                        >Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
