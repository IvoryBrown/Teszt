<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Customer</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Customer</h1>
		<form:form action="saveCustomer" method="post" modelAttribute="Customer">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Nev:</td>
				<td><form:input path="nev" /></td>
			</tr>
			<tr>
				<td>Pont:</td>
				<td><form:input path="pont" /></td>
			</tr>
			<tr>
				<td>Osszeg:</td>
				<td><form:input path="osszeg" /></td>
			</tr>
			<tr>
				<td>Adatok:</td>
				<td><form:input path="adatok" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>