<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show dojo</title>
</head>
<body>
<h1><c:out value="${eldojo.name}"></c:out></h1>
<%-- usar .atributo o usar método get---%>
<table>
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
		<%-- aquí no itera con dojo ps no es un array
		<c:forEach items="${eldojo}" var ="eldojo">
		<td><c:out value="${eldojo.ninjas.lastName}"></c:out></td> --%>
			<c:forEach items="${eldojo.ninjas}" var ="dojoninjas">
				<tr>
					<td><c:out value="${dojoninjas.firstName}"></c:out></td>
					<td><c:out value="${dojoninjas.lastName}"></c:out></td>
					<td><c:out value="${dojoninjas.age}"></c:out></td>
				</tr>
			</c:forEach> 
	</tbody>
</table>

</body>
</html>