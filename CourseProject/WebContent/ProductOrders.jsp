<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title>
</head>
<body>
<a href="Index.html">Home</a>
	<h3>Orders for: <%=request.getParameter("product")%></h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Product</th>
				<th>Invoice Number</th>
				<th>Number Ordered</th>
			</tr>
		</thead>
		<%
			if (request.getParameter("product") != null) {
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
					String option = request.getParameter("product");
					String query = "select invoice_number, p.product_id, description, quantity from order_item o "
							+ "join product p ON o.product_id = p.product_id WHERE p.product_id = '"
							+ option + "';";
					st = cn.createStatement();
					ResultSet rs = st.executeQuery(query);
					while (rs.next()) {
						out.print("<tr><td>" + rs.getString("description") + "</td>");
						out.print("<td>" + rs.getString("invoice_number") + "</td>");
						out.print("<td>" + rs.getString("quantity") + "</td></tr>");

					}
				} catch (SQLException e) {
					out.println("Error connecting to a database: " + e);
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>