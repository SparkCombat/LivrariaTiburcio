<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historico</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>

	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>

	<div id="nav">
		<ul>
			<li><a href="#">Usuários</a>
				<ul>
					<li><a href="edUsuario.jsp">Editar</a></li>
					<li><a href="exUsuario.jsp">Excluir</a></li>
					<li><a href="buUsuario.jsp">Buscar</a></li>
				</ul></li>
			<li><a href="historico.jsp">Histórico</a></li>
		</ul>


	</div>

	<div id="nav2">
		Título: <input type="text" name="txtTitulo" size="10" /><br>
		Autor: <input type="text" name="txtAutor" size="10" /><br>
		Editora: <input type="text" name="txtEditora" size="10" /><br> <br>
		<input type="submit" value="Buscar" />
	</div>

	<a href="#" id="h"><img src="/Nac_Livraria/imagens/logout.jpg"
		style="width: 42px; height: 42px; border: 0" title="Logout"></a>
	<a href="carrinho.jsp" id="h"><img src="/Nac_Livraria/imagens/carrinho.jpg"
		style="width: 42px; height: 42px; border: 0" title="Carrinho"></a>
	<a href="home.jsp" id="h"><img src="/Nac_Livraria/imagens/homeusu.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br>

	<br />
	<div id="section">
		<form action="historico" method="post">

			<table>
				<tr>
					<td>Data</td>
					<td>....</td>
				</tr>
				<tr>
					<td>Item1</td>
					<td>....</td>
				</tr>
				<tr>
					<td>Item2</td>
					<td>....</td>

				</tr>
				<tr>
					<td>R$</td>
					<td>....</td>
				</tr>
				</table>
				<table>
				<tr>
				<td>
				<img src="/Nac_Livraria/imagens/linha.png" style="height: 44px;">
				</td>
				</tr>
				</table>
				<table>

				<tr>
					<td>Data</td>
					<td>....</td>
				</tr>
				<tr>
					<td>Item1</td>
					<td>....</td>
				</tr>
				<tr>
					<td>Item2</td>
					<td>....</td>

				</tr>
				<tr>
					<td>R$</td>
					<td>....</td>
				</tr>

			</table>
		</form>
	</div>

	<div id="footer">Copyright © Pedro, Danilo, Paulo</div>

</body>
</html>