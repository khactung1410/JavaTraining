<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<head>
	<title>Welcome to our website</title>
</head>
<body>
	<marquee><font size="3" color="#FF0033">
		Hello World <%= request.getParameter("j_username") %>!!<br>
		Hello World ${request.getParameter["j_username"]}!!
	</font></marquee>
	<font color="#0000FF"> Hostname: <%= request.getRemoteHost() %></font><br>
	<font color="#0000FF"> Session Id: <%=session.getId() %></font>
</body>

</html>