<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Java Standard TagLib</title>
	</head>
	<body>
		<core:if test="${not empty empresa }"> 
			Nova empresa ${empresa} cadastrada com sucesso.
		</core:if>
		
		<core:if test="${empty empresa }"> 
			Não há empresa cadastrada!
		</core:if>
		
	</body>
</html>