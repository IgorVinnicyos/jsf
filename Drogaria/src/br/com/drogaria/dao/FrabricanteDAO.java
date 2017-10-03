package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FrabricanteDAO {

	public void salvar(Fabricante f){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(nome,descricao) ");
		sql.append("VALUES (?,?)");
		
		Connection con = ConexaoFactory.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ps.setString(1, f.getNome());
			ps.setString(2, f.getDescricao());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void excluir(Fabricante f){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ?");
		
		Connection con = ConexaoFactory.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setLong(1, f.getCodigo());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void  editar(Fabricante f){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET nome = ?,descricao = ? ");
		sql.append("WHERE codigo = ?");
		
		Connection con = ConexaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ps.setString(1, f.getNome());
			ps.setString(2, f.getDescricao());
			ps.setLong(3, f.getCodigo());
			
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Fabricante pesquisar(Long c){
		Fabricante fabricante = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM  fabricante ");
		sql.append("WHERE codigo = ?");
		
		Connection con = ConexaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ps.setLong(1, c);
			
			ResultSet rs  = ps.executeQuery();
			if(rs.next()){
				fabricante = new Fabricante();
				fabricante.setCodigo(rs.getLong("codigo"));
				fabricante.setDescricao(rs.getString("descricao"));
				fabricante.setNome(rs.getString("nome"));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fabricante;
	}
	
	public ArrayList<Fabricante> listar(){
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM fabricante ");
		sql.append("ORDER BY nome ASC ");
		
		Connection con = ConexaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Fabricante f = new Fabricante();
				f.setCodigo(rs.getLong("codigo"));
				f.setDescricao(rs.getString("descricao"));
				f.setNome(rs.getString("nome"));
				fabricantes.add(f);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return fabricantes;
	}
	public ArrayList<Fabricante> listarPorNome(String nome){
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM fabricante ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY nome ASC ");
		
		Connection con = ConexaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Fabricante f = new Fabricante();
				f.setCodigo(rs.getLong("codigo"));
				f.setDescricao(rs.getString("descricao"));
				f.setNome(rs.getString("nome"));
				fabricantes.add(f);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return fabricantes;
	}
	
}
