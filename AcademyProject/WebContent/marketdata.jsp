<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Market Data</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Stocks</a>

		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview <span
							class="sr-only">(current)</span></a></li>
					<li>
						<div class="table-responsive">
							<form>
								<div class="form-group">
								<br>
									<select class="form-control" name="ticker" id="ticker">
										<option selected value="">Choose a ticker</option>
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
											Statement st = null;
											try {
												st = cn.createStatement();
												ResultSet rs = st
														.executeQuery("select distinct ticker from market_data;");
												while (rs.next()) {
													out.println("<option value='" + rs.getString(1) + "'>"
															+ rs.getString(1) + "</ option>");
												}
											} catch (SQLException e) {
												out.println("Error connecting to a database: " + e);
											} finally {
												cn.close();
												st.close();
											}
										%>
									</select>
								</div>
								<div>
									<button type="submit" class="btn btn-sm btn-success"
										name="viewmarketdata" id="viewmarketdata">View Data</button>
								</div>
							</form>
						</div>
					</li>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<br>
				<h1 class="page-header">
					<%
						if (request.getParameter("ticker") != null) {
							// Load JDBC Driver
					%>
					Market Data for:
					<%=request.getParameter("ticker")%></h1>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Date</th>
								<th>Opening Price</th>
								<th>High Price</th>
								<th>Low Price</th>
								<th>Close Price</th>
								<th>Volume</th>
							</tr>
						</thead>
						<%
							try {
									Class.forName("com.mysql.jdbc.Driver");
								} catch (ClassNotFoundException e) {
									out.println("Error loading JDBC driver: " + e);
								}
								// Connect to a database.
								Connection conn = null;
								try {
									cn = DriverManager
											.getConnection("jdbc:mysql://localhost:8889/classfiles?user=root&password=root");
								} catch (SQLException e) {
									out.println("Error connecting to a database: " + e);
								}
								st = null;
								try {
									String option = request.getParameter("ticker");
									String query = "select ticker, tdate, openpr, highpr, lowpr, closepr, volume from market_data where ticker = '"
											+ option + "';";
									st = cn.createStatement();
									ResultSet rs = st.executeQuery(query);
									while (rs.next()) {
										out.print("<tr><td>" + rs.getString("tdate") + "</td>");
										out.print("<td>" + rs.getString("openpr") + "</td>");
										out.print("<td>" + rs.getString("highpr") + "</td>");
										out.print("<td>" + rs.getString("lowpr") + "</td>");
										out.print("<td>" + rs.getString("closepr") + "</td>");
										out.print("<td>" + rs.getString("volume")
												+ "</td></tr>");
									}
								} catch (SQLException e) {
									out.println("Error connecting to a database: " + e);
								}
							}
						%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>