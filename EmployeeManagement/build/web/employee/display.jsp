<%-- 
    Document   : display
    Created on : Dec 12, 2021, 9:31:39 AM
    Author     : Loki Kun
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee information</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Employee No</th>
                    <th>Name</th>
                    <th>Place Of Work</th>
                    <th>Phone No</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${EmployeeList}">
                <tr>
                    <td>${employee.employeeNo}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.placeOfWork}</td>
                    <td>${employee.phoneNo}</td>
                    <td><a href="actions?id=${employee.employeeNo}">${employee.employeeNo}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="actions">Add New</a>
    </body>
</html>
