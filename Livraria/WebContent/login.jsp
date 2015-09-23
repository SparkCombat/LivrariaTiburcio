<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="livraria.css">
</head>
<body>
	<div id="footer">
		<h1>Tiburciu's Library</h1>
	</div>

	<div id="nav">
		Título: <input type="text" name="txtTitulo" size="10" /><br>
		Autor: <input type="text" name="txtAutor" size="10" /><br>
		Editora: <input type="text" name="txtEditora" size="10" /><br> <br>
		<input type="submit" value="Buscar" />
	</div>

	<a href="home.jsp" id="h"><img src="/Nac_Livraria/imagens/home.png" style="width: 42px; height: 42px; border: 0"></a>

	<br />
	<br />
	<br />
	<div id="login1">
		<form action="login" method="post">
			<h4 style="color: red">${erro}</h4>

			<p>
				Usuário: <input type="text" name="txtUsuario" />
			</p>
			<p>
				Senha: <input type="password" name="txtSenha" />
			</p>
			<p>
				<input type="image" src="/Nac_Livraria/imagens/loginb.jpg" title="Login">
			</p>
			<a href="novoUsuario.jsp">Cadastrar novo usuário</a>
		</form>
	</div>

	<div id="footer">Copyright © Pedro, Danilo, Paulo</div>

</body>
</html>