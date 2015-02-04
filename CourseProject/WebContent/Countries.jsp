<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="demo.layered.*"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getParameter("add") != null) {
			try {
				Country country = new Country(0,
						request.getParameter("name"),
						request.getParameter("capital"),
						Long.parseLong(request.getParameter("population")));
				CountryBL bl = new CountryBL();
				bl.addCountry(country);
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
	%>
	<h2>Country List</h2>
	<h6>Click on the Country Name to edit details</h6>
	<table border="1">
		<tr>
			<th>Country</th>
			<th>Capital</th>
			<th>Population</th>
		</tr>
		<%
			List<Country> countries = null;
			try {
				CountryBL bl = new CountryBL();
				countries = bl.getCountries();
				for (Country c : countries) {
					out.print("<tr>");
					out.print("<td><a href ='EditCountry.jsp?id=" + c.getId() + "' >" + c.getName() + "</a></td>");
					out.print("<td>" + c.getCapital() + "</td>");
					out.print("<td>" + c.getPopulation() + "</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				out.println(e.getMessage());
			}
		%>
	</table>
</body>
</html>