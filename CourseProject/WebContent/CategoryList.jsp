<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
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
		// Load JDBC Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			out.println("Error loading JDBC driver: " + e);
		}
		// Connect to a database.
		Connection cn = null;
		try {
			cn = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/classfiles?user=root&password=root");
		} catch (SQLException e) {
			out.println("Error connecting to a database: " + e);
		}
		Statement st;
		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT product_category_name, product_category_code"
							+ " FROM product_category");
			while (rs.next()) {
				out.println(rs.getString(1) + "<br>");
			}
		} catch (SQLException e) {
			out.println("Error connecting to a database: " + e);
		}
	%>
</body>
</html>