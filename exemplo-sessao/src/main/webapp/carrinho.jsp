<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
	<!-- CSS  -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<title>Lista de Produtos</title>
</head>
<body class="container">
<div class="row indigo darken-4">
	<center><h3 class="col s12 white-text">Carrinho</h3></center>
</div>
<table class="container">
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Preço</th>
		<th>Ação</th>
	</tr>
	<c:forEach items="${sessionScope.produtosCarrinho}" var="produto">
		<tr>
			<td>${produto.id}</td>
			<td>${produto.nome}</td>
			<td>${produto.preco}</td>
			<td>
				<form method="post" action="removerCarrinho?id=${produto.id}">
					<button type="submit" class="btn-floating indigo darken-4"><i class="material-icons">delete</i></button>
				</form>

			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<a href="produtos">Voltar</a>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/materialize.js"></script>
<script src="js/init.js"></script>
</body>
</html>