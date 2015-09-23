<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir usu�rio</title>
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
	<a href="carrinho.jsp" id="h"><img src="/Nac_Livraria/imagens/carrinho.jpg"
		style="width: 42px; height: 42px; border: 0" title="Carrinho"></a>
	<a href="home.jsp" id="h"><img src="/Nac_Livraria/imagens/homeadm.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br>

	<br />
	<div>
		<form action="exusu" method="post">
			<table>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="txtNome" size="80"/></td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input type="text" name="txtCpf" size="23"/></td>
				</tr>
				<tr>
					<td>Data de Nascimento: </td>
					<td><input type="text" name="txtNasc" size="23"/></td>
				</tr>
				<tr>
					<td>Sexo: </td>
					<td><input type="radio" name="sex" value="fem" checked>Feminino
					<input type="radio" name="sex" value="masc">Masculino</td>
				</tr>
				<tr>
					<td>Telefone: </td>
					<td><input type="text" name="txtTel" size="23"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><input type="text" name="txtEmail" size="80"/></td>
				</tr>
				<tr>
					<td>Tipo usu�rio:</td>
					<td><select>
							<option value="x">Selecione uma op��o</option>
							<option value="y">Administrador</option>
							<option value="z">Usu�rio</option>
					</select> </td>

				</tr>
				<tr> </tr>
				<tr> </tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input type="image" src="/Nac_Livraria/imagens/excluir.jpg" title="excluir"></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="footer">Copyright � Pedro, Danilo, Paulo</div>

</body>
</html>