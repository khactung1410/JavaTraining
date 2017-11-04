<!DOCTYPE html>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix ="fn"%>
<html>
<head>
	<title>EL Example</title>
</head>
<body>
	<h1>EL Example</h1>
	<c:forEach var="reqHeader" items="${header}">
		${reqHeader.key} = reqHeader.value <br/>
		reqHeader.value - length = $fn:length(reqHeader.value) }<br/>
	</c:forEach>
</body>

</html>