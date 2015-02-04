<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="demo.layered.*"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.getInteger(request.getParameter("id"));
				CountryBL bl = new CountryBL();
				bl.getCountryByID(id);

			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
	%>
	<table>
		<tr>
			<th>
			<td>
			</td>
			</th>
		</tr>

		<tr>
			<td></td>
		</tr>
	</table>
</body>
</html>