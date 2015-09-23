<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>

	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>

	<div id="nav">
		Título: <input type="text" name="txtTitulo" size="10" /><br>
		Autor: <input type="text" name="txtAutor" size="10" /><br>
		Editora: <input type="text" name="txtEditora" size="10" /><br>
		<br> <input type="submit" value="Buscar" />
	</div>
	<a href="login.jsp" id="h"><img src="/Nac_Livraria/imagens/login.jpg" style="width: 42px; height: 42px; border: 0" title="Login"></a>  
		<a href="carrinho.jsp" id="h"><img src="/Nac_Livraria/imagens/carrinho.jpg"
		style="width: 42px; height: 42px; border: 0" title="Carrinho"></a>

	<br>
	<br>
	<table>
		<tr>
			<td>Buscar:</td>
			<td><input type="text" name="txtBuscar" size="100" /></td>
			<td colspan="2"><input type="image" src="/Nac_Livraria/imagens/lupa.jpg" title="Buscar" style="width: 62px; height42px;"></td>
		</tr>
	</table>
	<br />
	<div id="section">
		<img src="/Nac_Livraria/imagens/promocao.png" height="120" width="160">
		<br /> <br /> <br />
		<table>
		<tr><td>
			<img src="/Nac_Livraria/imagens/oferta2.png" height="250" width="300">
			</td>
			<td>
			<img src="/Nac_Livraria/imagens/oferta1.jpg" height="250" width="300">
			</td>
			
		</tr>
		</table>
	</div>

	<div id="footer">Copyright © Pedro, Danilo, Paulo</div>

</body>
</html>