<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo usu�rio</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>
	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>

	<div id="nav">
		T�tulo: <input type="text" name="txtTitulo" size="10" /><br>
		Autor: <input type="text" name="txtAutor" size="10" /><br>
		Editora: <input type="text" name="txtEditora" size="10" /><br> <br>
		<input type="submit" value="Buscar" />
	</div>

	<a href="home.jsp" id="h"><img src="/Nac_Livraria/imagens/home.png"
		style="width: 42px; height: 42px; border: 0"></a>

	<br />
	<br />
	<br />
	<div>
		<form action="novousu" method="post">
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
					<td>Senha:</td>
					<td><input type="password" name="txtSenha" size="23"/></td>
				</tr>
				<tr>
					<td>Confirme:</td>
					<td><input type="password" name="txtConfirme" size="23"/></td>
				</tr>
				<tr> </tr>
				<tr> </tr>
				<tr>
					<td colspan="2" style="text-align: right;"><input
						type="submit" value="Cadastrar" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="footer">Copyright � Pedro, Danilo, Paulo</div>

</body>
</html>