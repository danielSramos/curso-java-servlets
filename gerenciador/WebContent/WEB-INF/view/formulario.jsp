<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<core:url value="/entrada?acao=CriaEmpresa" var="novaEmpresa" />
<!DOCTYPE html>
<html>  
<head>
<meta charset="ISO-8859-1">
<title>Java Servlets</title>
</head>
<body>
	<form action="${novaEmpresa}" method="post">
		Nome: <input type="text" name="nome"  />
		Data Abertura: <input type="text" name="data"  />
		<input type="submit" />
	</form>
</body>
</html>