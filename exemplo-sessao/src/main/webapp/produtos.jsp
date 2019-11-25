<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
<h1>Lista de produtos</h1>
<table>
	<tr>
		<th style="padding:1%">ID</th>
		<th style="padding:1%">Nome</th>
		<th style="padding:1%">Preço</th>
		<th style="padding:1%">Ação</th>
	</tr>
	<c:forEach items="${produtos}" var="produto">
		<tr>
			<td style="padding:1%">${produto.id}</td>
			<td style="padding:1%">${produto.nome}</td>
			<td style="padding:1%">${produto.preco}</td>
			<td>
				<form method="post" action="adicionarCarrinho?id=${produto.id}">
					<button>Adicionar</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<form method="get" action="adicionarCarrinho"><a href="adicionarCarrinho">Carrinho</a></form>
</body>
</html>