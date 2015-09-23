<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edição de livro</title>
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
				
			<li><a href="#">Usuários</a>
				<ul>
					<li><a href="cadUsuario.jsp">Cadastrar</a></li>
					<li><a href="editarUsuario.jsp">Editar</a></li>
					<li><a href="excluirUsuario.jsp">Excluir</a></li>
					<li><a href="buscarUsuario.jsp">Buscar</a></li>
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

	<a href="#" id="h"><img
		src="/Nac_Livraria/imagens/logout.jpg"
		style="width: 42px; height: 42px; border: 0" title="Logout"></a>
	<a href="carrinho.jsp" id="h"><img src="/Nac_Livraria/imagens/carrinho.jpg"
		style="width: 42px; height: 42px; border: 0" title="Carrinho"></a>
	<a href="homeadm.jsp" id="h"><img src="/Nac_Livraria/imagens/home.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br>

	<br />
	<div id="section">
		<form action="edtlivro" method="post">

			<table>
				<tr>
					<td>Id:</td>
					<td colspan="2"><input type="text" name="txtId" size="10" /><input type="image" src="/Nac_Livraria/imagens/lupa2.jpg" title="Buscar" style="width: 44px; height:44px;"></td>
				</tr>
			</table>

			<table>
				<tr>
					<td>Título:</td>
					<td><input type="text" name="txtTitulo" size="80" /></td>
				</tr>
				<tr>
					<td>Sinopse:</td>
					<td><textarea name="sinopse" rows="10" cols="61"></textarea></td>
				</tr>
				<tr>
					<td>Idioma:</td>
					<td><input type="text" name="txtIdioma" size="23" /></td>
				</tr>
				<tr>
					<td>Origem:</td>
					<td><input type="text" name="txtOrigem" size="23" /></td>
				</tr>
				<tr>
					<td>Isbn:</td>
					<td><input type="text" name="txtIsbn" size="23" /></td>
				</tr>
			<tr>
					<td>Autor:</td>
					<td><select>
							<option value="x">Selecione uma opção</option>
							<option value="y">ykajnsdknsd</option>
							<option value="z">zkjansdkjsnd dj</option>
							<option value="k">kjsdn jasnd</option>
					</select> <a href="cadAutor.jsp"><input type="image" src="/Nac_Livraria/imagens/+.png" title="Cadastrar Autor" style="width:15px; height:15px"></a></td>
				</tr>
				<tr>
					<td>Editora:</td>
					<td><select>
							<option value="x">Selecione uma opção</option>
							<option value="y">yosandsdnk</option>
							<option value="z">zdn oasjdojnd</option>
							<option value="k">kkajnsd jansdojnds</option>
					</select> <a href="cadEditora.jsp"><input type="image" src="/Nac_Livraria/imagens/+.png" title="Cadastrar Editora" style="width:15px; height:15px"></a></td>

				</tr>
				<tr>
					<td>Categoria:</td>
					<td><select>
							<option value="x">Selecione uma opção</option>
							<option value="y">yosandsdnk</option>
							<option value="z">zdn oasjdojnd</option>
							<option value="k">kkajnsd jansdojnds</option>
					</select> <a href="cadCategoria.jsp"> <input type="image" src="/Nac_Livraria/imagens/+.png" title="Cadastrar Categoria" style="width:15px; height:15px"></a></td>

				</tr>
				<tr>
					<td>Preço:</td>
					<td><input type="text" name="txtPreco" size="23" /></td>
				</tr>
				<tr>
					<td>Altura:</td>
					<td><input type="text" name="txtAltura" size="23" /></td>
				</tr>
				<tr>
					<td>Largura:</td>
					<td><input type="text" name="txtLargura" size="23" /></td>
				</tr>
				<tr>
					<td>Comprimento:</td>
					<td><input type="text" name="txtComprimento" size="23" /></td>
				</tr>
				<tr>
					<td>Preço desconto:</td>
					<td><input type="text" name="txtPrecoDesconto" size="23" /></td>
				</tr>
				<tr>
					<td>Ano:</td>
					<td><input type="text" name="txtAno" size="23" /></td>
				</tr>
				<tr>
					<td>Páginas:</td>
					<td><input type="text" name="txtPaginas" size="23" /></td>
				</tr>
				<tr>
					<td>Estoque:</td>
					<td><input type="text" name="txtEstoque" size="23" /></td>
				</tr>
				<tr>
					<td>Porcentagem desconto:</td>
					<td><input type="text" name="txtPorcDesc" size="23" /></td>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input type="image" src="/Nac_Livraria/imagens/editar.jpg" title="Editar Livro"></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="footer">Copyright © Pedro, Danilo, Paulo</div>

</body>
</html>