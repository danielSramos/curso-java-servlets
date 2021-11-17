<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<core:url value="/entrada" var="novaEmpresa" />
<!DOCTYPE html>
<html>  
<head>
<meta charset="ISO-8859-1">
<title>Java Servlets</title>
</head>
<body>
	<form action="${novaEmpresa}" method="post">
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="senha" />
		<input type="hidden" name="acao" value="Login" />
		<input type="submit" />
	</form>
</body>
</html>