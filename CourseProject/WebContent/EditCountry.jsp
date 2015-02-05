<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="demo.layered.*"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Country</title>
</head>
<body>
	<h2>Edit Country</h2>
	<%
		Country c = null;
		if (request.getParameter("id") != null) {
			try {
				CountryBL bl = new CountryBL();
				c = bl.getCountryByID(Integer.parseInt(request
						.getParameter("id")));
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	%>
	<form action="Countries.jsp" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name"
					value="<%=c.getName()%>" /></td>
			</tr>
			<tr>
				<td>Capital</td>
				<td><input type="text" name="capital" id="cap"
					value="<%=c.getCapital()%>" /></td>
			</tr>
			<tr>
				<td>Population</td>
				<td><input type="text" name="population" id="pop"
					value="<%=c.getPopulation()%>" /> <input type="hidden" name="id"
					id="id" value="<%=c.getId()%>" /></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-sm btn-success" name="edit"
			id="edit">Edit</button>
		<button type="submit" class="btn btn-sm btn-danger" name="delete"
			id="delete">Delete</button>
	</form>
</body>
</html>