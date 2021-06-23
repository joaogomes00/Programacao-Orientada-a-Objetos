package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Partidas;
import jdbc.ConnectionFactory;

public class PartidasDAO {

	public void create(Partidas partidas) {
		
		//insert sql no banco
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "INSERT INTO PARTIDAS (DATA,LOCAL,TIME1,TIME2) VALUES (?,?,?,?);";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, partidas.getData());
			stmt.setString(2, partidas.getLocal());
			stmt.setString(3, partidas.getTime1());
			stmt.setString(4, partidas.getTime2());

			
			stmt.executeUpdate();
			
			System.out.println("Partida incluída com sucesso!!!");
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar incluir partida");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		
	}
	
	public void delete(Partidas partidas) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "DELETE FROM PARTIDAS WHERE IDPARTIDA = (?)";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, partidas.getId());
			
			stmt.executeUpdate();
			
			System.out.println("Partida exluída com sucesso!!!");
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar excluir partida");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		
	}
	
	public void update(Partidas partidas) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "UPDATE PARTIDAS SET DATA = ?, TIME1=?, TIME2=? WHERE IDPARTIDA = ?;";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, partidas.getData());
			stmt.setString(2, partidas.getTime1());
			stmt.setString(3, partidas.getTime2());
			stmt.setString(4, partidas.getId());


			int cnt = stmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.print("atualizado");
			}
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar atualizar partida");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
	}

	
	
	public List<Partidas > read()
	{
		List<Partidas> listaPartidas = new ArrayList<Partidas>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT TIME1 AS 'MANDANTE',TIME2 AS 'VISITANTE',LOCAL,DATA "
				+ "	FROM PARTIDAS;";
		
		try
		{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Partidas partidas = new Partidas();
				
				partidas.setTime1(rs.getString("time1"));
				partidas.setTime2(rs.getString("time2"));
				partidas.setData(rs.getString("data"));
				partidas.setLocal(rs.getString("local"));

				listaPartidas.add(partidas);
				
			}
			
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Aluno...");
		}
		finally {
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		return listaPartidas;
	}

	

		
}

