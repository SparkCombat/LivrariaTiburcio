<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>

	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>



	<div id="nav2">
		Título: <input type="text" name="txtTitulo" size="10" /><br>
		Autor: <input type="text" name="txtAutor" size="10" /><br>
		Editora: <input type="text" name="txtEditora" size="10" /><br> <br>
		<input type="submit" value="Buscar" />
	</div>

	<a href="#" id="h"><img src="/Nac_Livraria/imagens/logout.jpg"
		style="width: 42px; height: 42px; border: 0" title="Logout"></a>
	<a href="home.jsp" id="h"><img src="/Nac_Livraria/imagens/home.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br>

	<br />
	<div id="section">
		<form action="lislivro" method="post">
			<table>
				<tr>
					<dl>
						<img src="/Nac_Livraria/imagens/livro.png" style="float:left;margin:10px;width:60px;height:60px;">
						<input type="text" name="txtQtd" style="float:right;width:120px;height:30px;"><dt><a href="buscarLivro.jsp">Título</a></dt>
						<dd>- Autor</dd>  
						<dd>- Preço</dd>
						<dt><img src="/Nac_Livraria/imagens/linha.png" style="height:44px;"></dt>
					</dl>
				</tr>
				
				
				<tr>
					<dl>
						<img src="/Nac_Livraria/imagens/livro.png" style="float:left;margin:10px;width:60px;height:60px;">
						<input type="text" name="txtQtd" style="float:right;width:120px;height:30px;"><dt><a href="buscarLivro.jsp">Título</a></dt>
						<dd>- Autor</dd>  
						<dd>- Preço</dd>
						<dt><img src="/Nac_Livraria/imagens/linha.png" style="height:44px;"></dt>
					</dl>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input type="image" src="/Nac_Livraria/imagens/confirmar.jpg" title="Confirmar"></td>
				</tr>

			</table>
			<h1>R$</h1>
		</form>
	</div>

	<div id="footer">Copyright © Pedro, Danilo, Paulo</div>

</body>
</html>