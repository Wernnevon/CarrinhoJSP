<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
	<title>Produtos</title>
	<!-- CSS  -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
	<div class="container row indigo darken-4">
		<center><h3 class="col s12 white-text">Conheça nossos produtos</h3></center>
	</div>
	<div style="padding-right: 15%">
		<a style="float: right" class='dropdown-trigger btn btn-floating btn-large indigo darken-4' href='#' data-target='dropdown1'>
			<i class="large material-icons">shopping_cart</i>
		</a>
	</div>
<!-- Dropdown Structure -->
	<ul id='dropdown1' class='dropdown-content'>
		<c:forEach items="${sessionScope.produtosCarrinho}" var="produto">
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
	</ul>
	<br>
	<div class="container">
		<table class="container">
			<tr>
				<th style="padding:1%">Nome</th>
				<th style="padding:1%">Preço</th>
				<th style="padding:1%">Ação</th>
			</tr>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td style="padding:1%">${produto.nome}</td>
					<td style="padding:1%">${produto.preco}</td>
					<td>
						<form method="post" action="adicionarCarrinho?id=${produto.id}">
							<button class="btn-floating indigo darken-4"><i class="material-icons">add</i></button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="adicionarCarrinho">Carrinho</a>
	<a href="index.jsp">Voltar</a>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>
</body>
</html>