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
	<div style="min-width: 300px;" id='dropdown1' class='dropdown-content'>
		<div class="indigo darken-4 white-text" style="font-size: 14pt; padding: 2%"><b>Seus Produtos:</b></div>
		<table style="padding: 2%">
			<tr>
				<th>Nome</th>
				<th>Preço</th>
				<th>Ação</th>
			</tr>
		<c:forEach items="${sessionScope.produtosCarrinho}" var="produto">
			<tr>
				<td>${produto.nome}</td>
				<td>${produto.preco}</td>
				<td>
					<form method="post" action="removerCarrinho?id=${produto.id}">
						<button type="submit" class="btn-flat waves-effect"><i class="material-icons">delete</i></button>
					</form>

				</td>
			</tr>
		</c:forEach>
		</table>
		<form method="post" action="pedido">
			<button type="submit" class="btn waves-effect indigo darken-4">Finalizar</button>
		</form>
	</div>
	<br><br><br>
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
	<a href="index.jsp">Voltar</a>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>
</body>
</html>