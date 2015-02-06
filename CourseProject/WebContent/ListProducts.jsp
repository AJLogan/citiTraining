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
	<h3>Product List for category: <%= request.getParameter("category") %></h3>
	<a href="CategoryQuery.jsp">Select Category</a>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Product</th>
				<th>Price ($)</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (request.getParameter("category") != null) {
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
						String option = request.getParameter("category");
						String query = "select product_id, description, price from product where product_category_code = '"
								+ option + "';";
						st = cn.createStatement();
						ResultSet rs = st.executeQuery(query);
						while (rs.next()) {
							out.print("<tr><td><a href ='ProductOrders.jsp?product="
									/* out.print("<tr><td><a href ='BootstrapDemo.jsp?product="  */
									+ rs.getString("product_id") + "'>" + rs.getString("description")+ "</a></td>");
							out.print("<td>" + rs.getString("price") + "</td></tr>");

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