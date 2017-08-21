package br.com.ioa.teste;

import br.com.ioa.jdbc.UsuarioDAO;

import java.util.List;

import br.com.ioa.entidade.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		//TestAlterar();
		//TestCadastrar();
		//TesteExcluir();
		TesteBuscarTodos();
}

	private static void TestAlterar() {
		Usuario usu = new Usuario();
		usu.setNome("oia1");
		usu.setLogin("oia1");
		usu.setSenha("oia1");
		usu.setId(1);;
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
	}
	
	private static void TestCadastrar() { 
		Usuario usu = new Usuario();
		usu.setNome("oia");
		usu.setLogin("oia");
		usu.setSenha("oia");
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
	}
	
	private static void TesteExcluir() {
		Usuario usu = new Usuario();
		usu.setId(1);
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
	}
	
	private static void TesteBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> listaResultado = usuDAO.buscaTodos();
		
		for(Usuario u: listaResultado) {
			System.out.println(u.getNome()+" "+u.getLogin()+" "+u.getSenha()+" "+u.getId());
		}
	}

}
