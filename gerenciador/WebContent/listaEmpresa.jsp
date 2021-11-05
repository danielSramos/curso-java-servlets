<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<core:url value="/delete" var="delete" />
<core:url value="/mostraEmpresa" var="mostraEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Empresas cadastradas</h3>
	<ul>

		<core:forEach items="${nomeEmpresas}" var="empresa">

			<li>${ empresa.nome } - <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="MM/dd/yyyy" /> 
					<a href="${mostraEmpresa}?id=${empresa.id}"> editar </a> | 
					<a href="${delete}?id=${empresa.id}"> remover </a>
			</li>
		</core:forEach>
	</ul>
	<a href="/gerenciador/formNovaEmpresa.jsp"> <button	>Cadastrar nova empresa</button> </a>
</html>
