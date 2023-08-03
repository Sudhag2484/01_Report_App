<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
<body>

<div class="container">
<h3>Report Application</h3>

<form:form action="searchele" modelAttribute="search" method="POST">
<table>
<tr>
<td>Plan Name:</td>
<td>
<form:select path="planName">
<form:option value="">--Select--</form:option>
<form:options items="${name}"/>
</form:select>
</td>

<td>Plan Status:</td>
<td>
<form:select path="planStatus">
<form:option value="">--Select--</form:option>
<form:options items="${status}"/>

</form:select>
</td>
<td>Gender:</td>
<td>
<form:select path="gender">
<form:option value="">--Select--</form:option>
<form:option value="Male">Male</form:option>
<form:option value="Female">Female</form:option>
</form:select>
</td>
</tr>

<tr>
<td>Start Date:</td>
<td><form:input path="startDate" type="date"/></td>

<td>End Date:</td>
<td><form:input path="endDate" type="date"/></td>

</tr>
<tr>
<td>
<a href="/" class="btn btn-primary">Reset</a>
</td>
<td>
<input type="submit" value="Search" class="btn btn-primary"/>
</td>
</tr>
</table>
</form:form>
<hr/>
<table class="table table-striped table-hover table-info">
<thead class="table-dark">
<tr>
<td class="font-weight-bold">Id</td>
<td class="font-weight-bold">Holder Name</td>
<td class="font-weight-bold">Gender</td>
<td class="font-weight-bold">Plan Name</td>
<td class="font-weight-bold">Plan Status</td>
<td class="font-weight-bold">Start Date</td>
<td class="font-weight-bold">End Date</td>
<td class="font-weight-bold">Benifit Amount</td>
</tr>
</thead>

<tbody>
<c:forEach items="${plans}" var="p" varStatus="index">
<tr>
<td>${index.count}</td>
<td>${p.citizenName}</td>
<td>${p.gender}</td>
<td>${p.planName}</td>
<td>${p.planStatus}</td>
<td>${p.planStartDate}</td>
<td>${p.planEndDate}</td>
<td>${p.benifitAmt}</td>
</tr>
</c:forEach>
<tr>
<c:if test="${empty plans}">
<td colspan="8" style="text-align: center;">No record found</td>
</c:if>
</tr>
</tbody>
</table>
<hr/>

Export:<a href="pdf">Pdf</a> <a href="excel">Excel</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>