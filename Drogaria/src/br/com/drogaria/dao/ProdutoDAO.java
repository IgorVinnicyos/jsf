package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

public class ProdutoDAO {

	
	public ArrayList<Produto> listar(){
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM produto ");
		sql.append("ORDER BY nome ASC ");
		
		Connection con = ConexaoFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Produto p = new Produto();
				p.setCodigo(rs.getLong("codigo"));
				p.setDescricao(rs.getString("descricao"));
				p.setNome(rs.getString("nome"));
				produtos.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return produtos;
	}
	
	public void salvar(Produto p){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO testeproduto ");
		sql.append("(codigoprod) ");
		sql.append("VALUES (?)");
		
		Connection con = ConexaoFactory.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql.toString());
			ps.setLong(1, p.getCodigo());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
