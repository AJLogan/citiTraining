<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Counter</title>
</head>
<body>
	<%
		int counter;
		if (session.getAttribute("counter") == null) {
			counter = 0;
		} else {
			counter = (Integer)session.getAttribute("counter");
			counter++;
		}
		session.setAttribute("counter", counter);
		out.println("counter = " + counter);
	%>
	<form action="Counter.jsp" method="get">
		<input type="submit" value="Go" />
	</form>

</body>
</html>