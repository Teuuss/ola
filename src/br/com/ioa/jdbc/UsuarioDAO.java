package br.com.ioa.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.ws.Response;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.com.ioa.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = Conexao.getConnection();

	public void cadastrar(Usuario usuario){
		String sql = "INSERT INTO USUARIO (nome, login, senha) values(?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.execute();
			preparador.close();
			System.out.print("Cadastrado com sucesso!! =]=]");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void cadastrarc(Usuario usuario){
		String sql = "INSERT INTO CONTATO (nome, num, email) values(?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getNum());
			preparador.setString(3, usuario.getEmail());
			preparador.execute();
			preparador.close();
			System.out.print("Cadastrado com sucesso!! =]=]");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void alterar(Usuario usuario){
		String sql = "UPDATE USUARIO SET nome=?, login=?, senha=? WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.print("Alterado com sucesso!! =]=]");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void salvar (Usuario usuario) {
		if (usuario.getId()!=null && usuario.getId()!=0) {
			alterar(usuario);
		}else {
			cadastrar(usuario);
		}
	}
	
	
	public void alterarc(Usuario usuario){
		String sql = "UPDATE CONTATO SET nome=?, num=?, email=? WHERE id=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getNum());
			preparador.setString(3, usuario.getEmail());
			preparador.setInt(4, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.print("Alterado com sucesso!! =]=]");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
		
	public void excluir(Usuario usuario){
		String sql = "DELETE FROM USUARIO WHERE id=?;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.print("Apagado com sucesso!! =]=]");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void excluirc(Usuario usuario){
		String sql = "DELETE FROM CONTATO WHERE id=?;";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.print("Apagado com sucesso!! =]=]");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public java.util.List<Usuario> buscaTodos(){
		
		String sql = "SELECT * FROM CONTATO ORDER BY id ASC";

		java.util.List<Usuario> lista = new ArrayList<Usuario>(); 
		
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			
			while(resultado.next()) {
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setNum(resultado.getString("num"));
				usu.setEmail(resultado.getString("email"));
				
				lista.add(usu);

			}
			
			
			preparador.executeQuery();
			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario buscaPorId(Integer id) {
		String sql = "SELECT * FROM Usuario WHERE ID=?";
		Usuario usuario=null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			}
			
			
			
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return usuario;
	
	}

	public Usuario buscaPorIdc(Integer id) {
		String sql = "SELECT * FROM CONTATO WHERE ID=?";
		Usuario usuario=null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setNum(resultado.getString("num"));
				usuario.setEmail(resultado.getString("email"));
			}
			
			
			
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return usuario;
	
	}
	
	public Usuario login(Usuario usuario) {
		String sql = "SELECT * FROM CONTATO WHERE LOGIN=? and SENHA=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setLogin(1, login);
			preparador.setSenha(2, senha);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setNum(resultado.getString("num"));
				usuario.setEmail(resultado.getString("email"));
			}
			
			
			
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return usuario;
	
	}
	
}

