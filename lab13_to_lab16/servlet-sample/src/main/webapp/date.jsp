<!DOCTYPE html>
<%@ page import ="java.util.Date" %>
<html>
<head>
	<title>JSP Example</title>
</head>
<body>
	<% response.setHeader("Refresh", "6"); %>
	<li> Today's date is:<%= (new Date()).toLocaleString() %> </li>
	<li> Session Id: <%= session.getId() %></li>
	<li> The path of this JSP file is :<%request.getRequestURL() %> </li>
	<li>The Hostname is : <%=request.getRemoteHost() %></li>
</body>
</html>