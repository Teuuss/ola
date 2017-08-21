package br.com.ioa.entidade.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.jasper.tagplugins.jstl.core.Param;

import br.com.ioa.entidade.Usuario;
import br.com.ioa.jdbc.UsuarioDAO;


@WebServlet("/user.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	public UsuarioController() {
        super();
  
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		if(acao!=null && acao.equals("exc")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuarioDAO.excluirc(usuario);
			response.sendRedirect("user.do?acao=lis");
						
		}
		
		if(acao!=null && acao.equals("alt")) {
			String id = request.getParameter("id");
			Usuario usuario = usuarioDAO.buscaPorIdc(Integer.parseInt(id));
			request.setAttribute("usuario", usuario);
			RequestDispatcher saida =  request.getRequestDispatcher("hu.jsp");
			try {
				saida.forward(request, response);
				}
				catch (Exception e){
				e.getMessage();
				}
		}
		
		
		
		if(acao!=null && acao.equals("lis")) {
	java.util.List<Usuario> lista = usuarioDAO.buscaTodos();

		request.setAttribute("lista", lista);
		
		RequestDispatcher saida =  request.getRequestDispatcher("oia.jsp");
		saida.forward(request, response);
		}
	
	
	
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Metodo POST");
		
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("cadc")) {
		String nome = request.getParameter("nome");
		String num = request.getParameter("num");
		String email = request.getParameter("email");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setNum(num);
		usuario.setEmail(email);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrarc(usuario);
		response.sendRedirect("user.do?acao=lis");
		}
		if(acao!=null && acao.equals("cad")) {
			String nome = request.getParameter("nome");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.cadastrar(usuario);
			response.sendRedirect("index.html");
			}
		
		
		if(acao!=null && acao.equals("altc")) {
			String nome = request.getParameter("nome");
			String num = request.getParameter("num");
			String email = request.getParameter("email");
			String id = request.getParameter("id");
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setNum(num);
			usuario.setEmail(email);
			usuario.setId(Integer.parseInt(id));
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.alterarc(usuario);
			response.sendRedirect("user.do?acao=lis");
			}
		
		
		if(acao!=null && acao.equals("mostrar")) {
			String nome = request.getParameter("login");
			String senha = request.getParameter("senha");
			System.out.println(nome);
			
			Usuario usuario = new Usuario();
			String oi = usuario.getNome();
			String oi2 = usuario.getSenha();
				
			if(nome.equals("usuarioDAO")&&senha.equals("usuarioDAO")) {
				System.out.println("Autenticado =]=]");
				response.sendRedirect("user.do?acao=lis");
			}else {
				System.out.println("Nao foi possivel autenticar =[");
			}
			
			
			
			//RequestDispatcher saida =  request.getRequestDispatcher("index.jsp");
			//saida.forward(request, response);
		
		}
	}
	
	
	

}
