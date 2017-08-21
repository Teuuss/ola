<%@page import="br.com.ioa.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div{
  background: silver;
  text-align: center;
  padding: 1%;
  background: #f2af00;
  font-family: sans-serif;
  color: white;
}
body{
  border: 0%;
  margin: 0%;
  background: #486b7b;
}
form{
margin-top:5%;
  border: solid white 1px;
  width: 250px;
  padding: 1%;
  border: solid #00577F 2px;
  background: white;
  border-radius: 5%;
}
hr{
  margin-top: 0%;
}
a{
text-decoration: none;
}
.botao{
background: #00577F;
border:none;
padding: 1%;
color: white;
}
.botaox{
	background: #f2af00;
	border:none;
	width:60%;
	cursor: pointer;
}
.botaoxa{
	background: #f2af00;
	border:none;
	float: right;
	color:black;
	text-decoration: none;
	padding: 1%;
	width:10%;
	cursor: pointer;
}

a{
text-decoration: none;
color: white;
}
input:focus{outline:none;}

#b{
display:none;
box-shadow: 0px 1px 20px #888888;
}
input{
	text-decoration:underline;
  border: none;
  background: none;
  color: black;
}
hr{
  margin-top: 0%;
}
.bor{
	border: solid silver 2px;
	width: 50%;
	border-radius: 5%;
	padding-top:2px;
	padding-button:2px;
}
label{
text-align: center;}
</style>
<body>
<div>Agenda Telefonica</div>
<%
Usuario usuario = (Usuario) request.getAttribute("usuario");
String oia = usuario.getNome();
%>
<center>
	<form action="user.do?acao=altc" method="post">
	<a href="user.do?acao=lis" class="botaoxa">x</a><br><br>
	<labe>Nome: </labe>
	<input type="text" value="<%= usuario.getNome()%>" name="nome"/><br>
	<labe>Telefone: </labe>
	<input type="text" value="<%= usuario.getNum()%>" name="num"/><br>
	<labe>Email: </labe>
	<input type="text" value="<%= usuario.getEmail()%>" name="email"/><br>
	<labe>Id: </labe>
	<input type="text" value="<%= usuario.getId()%>" name="id"/><br>
	<input type="submit" value="Salvar" class="bor"/>
	</form>
	</center>
</body>
</html>