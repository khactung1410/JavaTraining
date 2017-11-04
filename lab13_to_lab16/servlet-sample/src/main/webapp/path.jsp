<!DOCTYPE html>
<html>
<head>
	<title>JSP Example</title>
</head>
<body>
	<li> The path of this JSP file is :<%= request.getRequestURL() %> </li>
	<li>The Hostname is : <%=request.getRemoteHost() %></li>
</body>
</html>