<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new Ninja</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<form:label path="dojo">Dojo </form:label>
<form:select path="dojo">
		<form:option value="">Select a dojo</form:option>
       <c:forEach var="dojos" items="${dojos}">
       		 <form:option value="${dojos.id}"> <c:out value="${dojos.name} "/></form:option>
       	</c:forEach>
</form:select>
<p>
	<form:label path="firstName">First Name:</form:label>
	<form:input path="firstName"/>
</p>
<p>
	<form:label path="lastName">Last Name:</form:label>
	<form:input path="lastName"/>
</p>
<p>
	<form:label path="age">Age:</form:label>
	<form:input type="number" min="5" max="120" path="age"/>
</p>
<input type="submit" value="Create">
</form:form>
</body>
</html>