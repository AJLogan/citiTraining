<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="demo.layered.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>State Demo</title>
</head>
<body>
	<%
		if (session.getAttribute("country") != null) {
			out.print("The Selected Country is: "
					+ session.getAttribute("country").toString());

		} else {
			out.print("No session state has been set for any country.");
		}
		if (session.getAttribute("allCountries") != null) {
			List<Country> countries = (List<Country>)session.getAttribute("allCountries");
			out.print("<ul>");
			for (Country c : countries) {
				out.print("<li>" + c.getName() + "</li>");
			}
			out.print("</ul>");
		}
	%>
	<a href="Countries.jsp">Country List</a>
</body>
</html>