<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Categoria</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>

	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>

	<div id="nav">
			<ul>
			<li><a href="#">Livros</a>
				<ul>
					<li><a href="cadLivro.jsp">Cadastrar</a></li>
					<li><a href="editarLivro.jsp">Editar</a></li>
					<li><a href="excluirLivro.jsp">Excluir</a></li>
					<li><a href="buscarLivro.jsp">Buscar</a></li>
				</ul></li>
			<li><a href="#">Autores</a>
				<ul>
					<li><a href="cadAutor.jsp">Cadastrar</a></li>
					<li><a href="editarAutor.jsp">Editar</a></li>
					<li><a href="excluirAutor.jsp">Excluir</a></li>
					<li><a href="buscarAutor.jsp">Buscar</a></li>
				</ul></li>
			<li><a href="#">Categorias</a>
				<ul>
					<li><a href="cadCategoria.jsp">Cadastrar</a></li>
					<li><a href="editarCategoria.jsp">Editar</a></li>
					<li><a href="excluirCategoria.jsp">Excluir</a></li>
					<li><a href="buscarCategoria.jsp">Buscar</a></li>
				</ul></li>

			<li><a href="#">Editoras</a>
				<ul>
					<li><a href="cadEditora.jsp">Cadastrar</a></li>
					<li><a href="editarEditora.jsp">Editar</a></li>
					<li><a href="excluirEditora.jsp">Excluir</a></li>
					<li><a href="buscarEditora.jsp">Buscar</a></li>
				</ul></li>
				
			<li><a href="#">Usu�rios</a>
				<ul>
					<li><a href="cadUsuario.jsp">Cadastrar</a></li>
					<li><a href="editarUsuario.jsp">Editar</a></li>
					<li><a href="excluirUsuario.jsp">Excluir</a></li>
					<li><a href="buscarUsuario.jsp">Buscar</a></li>
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
	<a href="carrinho.jsp" id="h"><img src="/Nac_Livraria/imagens/carrinho.jpg"
		style="width: 42px; height: 42px; border: 0" title="Carrinho"></a>
	<a href="homeadm.jsp" id="h"><img src="/Nac_Livraria/imagens/home.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br>

	<br />
	<div id="section">
		<form action="exccategoria" method="post">
			<table>
				<tr>
					<td>Id:</td>
					<td colspan="2"><input type="text" name="txtId" size="10" /><input type="image" src="/Nac_Livraria/imagens/lupa2.jpg" title="Buscar" style="width: 44px; height:44px;"></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="txtNome" size="80" /></td>
				</tr>


			</table>
		</form>
	</div>

	<div id="footer">Copyright � Pedro, Danilo, Paulo</div>

</body>
</html>