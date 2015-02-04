<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="demo.layered.*"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			Country country = new Country(0, request.getParameter("name"),
					request.getParameter("capital"),
					Integer.parseInt(request.getParameter("population")));
			CountryBL bl = new CountryBL();
			bl.addCountry(country);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	%>
	<h1>Success!</h1>
	<form action="ListCountries.jsp" method="get">
		<input type="submit" value="List Countries">
	</form>
</body>
</html>