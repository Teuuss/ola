<%@page import="java.util.List"%>
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
  text-align: center;
    padding: 1%;
    background: #f2af00;
    font-family: fantasy;
    font-size: 200%;
    color: white;
}
body{
  border: 0%;
  margin: 0%;
  background: #486b7b;
}
table{
  width: 100%;
  display:none;
  margin-top:5%;
  text-align: center;
  font-family: sans-serif;
  border: solid white 1px;
  color: white;
  box-shadow: 5px 10px 20px #2f2f2f;
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
font-family: monospace;
}
.botao:hover{
    box-shadow: 2px 2px 10px 0px #293d46;
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
box-shadow: 0px 1px 20px #2f2f2f;
}
input{
  text-align: center;
  border: none;
  background: none;
  color: black;
  width:100%;
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
</style>

<body>
<center>
<div>Agenda Telefonica</div>
<button onclick="a()" class="botao">Cadastrar Contato</button><button onclick="b()" class="botao">Listar Contato</button><br>
<script>
function a(){
	document.getElementById("b").style.display = "table";
	document.getElementById("a").style.display = "none";
}
function b(){
	document.getElementById("a").style.display = "table";
	document.getElementById("b").style.display = "none";
}
function c(){
	document.getElementById("a").style.display = "none";
	document.getElementById("b").style.display = "none";
}
</script>



<table id="a">

<tr><th></th><th></th><th></th><th></th><th></th><th><button onclick="c()" class="botaox">x</button></th></tr><tr><th>Id</th><th>Nome</th><th>Telefone</th><th>Email</th><th>Excluir</th><th>Alterar</th></tr>

<%
List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");

for(Usuario u: lista) {
%>
<tr>
<td><%= u.getId()%></td>
<td><%= u.getNome()%></td>
<td><%= u.getNum()%></td>
<td><%= u.getEmail()%></td>
<td><a href="user.do?acao=exc&id=<%= u.getId()%>">Excluir</a></td>
<td><a href="user.do?acao=alt&id=<%= u.getId()%>">Alterar</a></td>
</tr>
<%
	}
%>

</table>

<form id="b" action="user.do?acao=cadc" method="post">
	<a onclick="c()" class="botaoxa">x</a>
	<input type="text" placeholder="Nome" name="nome"/><hr><br>
	<input type="tell" placeholder="Telefone" name="num"/><hr><br>
	<input type="email" placeholder="Email" name="email"/><hr>
	
	<input type="submit" value="Cadastrar" class="bor"/>
	</form>
</div>	

</center>
</body>
</html>