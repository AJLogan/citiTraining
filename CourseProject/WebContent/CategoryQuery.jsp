<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
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
	<h3>Choose a category</h3>
	<form action="ListProducts.jsp" method=post>
		<div class="form-group">
			<label for="category">Select a category:</label> <select
				class="form-control" name="category" id="category">
				<option selected value="-1">Choose a category</option>
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
						ResultSet rs = st
								.executeQuery("SELECT product_category_name, product_category_code"
										+ " FROM product_category");
						while (rs.next()) {
							out.println("<option value='" + rs.getString(2) + "'>"
									+ rs.getString(1) + "</ option>");
						}
					} catch (SQLException e) {
						out.println("Error connecting to a database: " + e);
					}
				%>
			</select>
		</div>
		<div>
			<button type="submit" class="btn btn-sm btn-success"
				name="listProducts" id="listProducts">List Products</button>
		</div>
	</form>
</body>
</html>