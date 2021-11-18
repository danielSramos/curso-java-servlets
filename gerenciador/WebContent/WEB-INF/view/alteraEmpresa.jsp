<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<core:url value="/entrada?acao=AlteraEmpresa" var="alteraEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Servlets</title>
</head>
<body>
	<core:import url="logout-parcial.jsp" />
	<form action="${alteraEmpresa}" method="post">
	
		Nome: <input type="text" name="nome" value="${empresa.nome}" />
		Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="MM/dd/yyyy" />" />
		<input type="hidden" name="id" value="${empresa.id}"/>
		<input type="submit" />	
	</form>

</body>
</html>