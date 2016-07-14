<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>User Form</title>
</head>
<body>
<h1>User Form</h1>

<form:form modelAttribute="userForm" action="userform" method="POST">

	<table>
		<tr>
			<td>Username:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><form:password path="password" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>