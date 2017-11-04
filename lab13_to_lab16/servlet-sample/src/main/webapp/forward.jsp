<!DOCTYPE html>
<html>
<head>
	<title>JSP Example</title>
</head>
<body>
	<%
		String agent = request.getHeader("User-Agent");
	%>
	<% if(agent.indexOf("Firefox")!=0){ %>
		<jsp:forward page= "path.jsp"/>
	<%} else{ %>
		<jsp:forward page= "include.jsp"/>
	<%} %>
	
</body>
</html>