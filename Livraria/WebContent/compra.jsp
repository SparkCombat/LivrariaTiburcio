<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compra</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>

	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>

	<div id="nav">
		<ul>
			<li><a href="#">Usu�rios</a>
				<ul>
					<li><a href="edUsuario.jsp">Editar</a></li>
					<li><a href="exUsuario.jsp">Excluir</a></li>
					<li><a href="buUsuario.jsp">Buscar</a></li>
				</ul></li>
				<li><a href="historico.jsp">Hist�rico</a></li>
		</ul>


	</div>

	<div id="nav2">
		T�tulo: <input type="text" name="txtTitulo" size="10" /><br>
		Autor: <input type="text" name="txtAutor" size="10" /><br>
		Editora: <input type="text" name="txtEditora" size="10" /><br> <br>
		<input type="submit" value="Buscar" />
	</div>

	<a href="#" id="h"><img src="/Nac_Livraria/imagens/logout.jpg"
		style="width: 42px; height: 42px; border: 0" title="Logout"></a>
	<a href="home.jsp" id="h"><img src="/Nac_Livraria/imagens/homeusu.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br>

	<br />
	<div>
		<form action="compra" method="post">
			<table>
		
			</table>
		</form>
	</div>

	<div id="footer">Copyright � Pedro, Danilo, Paulo</div>

</body>
</html>