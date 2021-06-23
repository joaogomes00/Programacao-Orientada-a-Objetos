package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Jogadores;
import jdbc.ConnectionFactory;

public class JogadoresDAO {

	public void create(Jogadores jogador) {
		
		//insert sql no banco
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "INSERT INTO JOGADORES (NOME_JOGADOR,TIME,NUM_CAMISA,QNT_CARTAO,GOLS,JOGOS_DISPUTADOS) VALUES (?,?,?,?,?,?);";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, jogador.getNome());
			stmt.setString(2, jogador.getTime());
			stmt.setString(3, jogador.getNumCamisa());
			stmt.setString(4, jogador.getCartao());
			stmt.setString(5, jogador.getGols());
			stmt.setString(6, jogador.getJogosD());
			
			stmt.executeUpdate();
			
			System.out.println("Jogador incluído com sucesso!!!");
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar incluir Partida");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		
	}
	
	public void delete(Jogadores jogador) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "DELETE FROM SCOUTS WHERE ID_JOGADOR = ?;";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, jogador.getId());
			
			stmt.executeUpdate();
			
			String sql1 ="DELETE FROM JOGADORES WHERE IDJOGADOR = ?;";
			
			stmt = banco.prepareStatement(sql1);
			
			//popula a query com os parametros
			stmt.setString(1, jogador.getId());
			
			stmt.executeUpdate();
			
			
			System.out.println("Jogador exluído com sucesso!!!");
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar excluir jogador");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		
	}
	
	public void update(Jogadores jogador) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "UPDATE JOGADORES SET NOME_JOGADOR =?, TIME=?, JOGOS_DISPUTADOS=?, QNT_CARTAO=?,NUM_CAMISA=?,GOLS=?"
					+ "  where IDJOGADOR =?;";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, jogador.getNome());
			stmt.setString(2, jogador.getTime());
			stmt.setString(3, jogador.getJogosD());
			stmt.setString(4, jogador.getCartao());
			stmt.setString(5, jogador.getNumCamisa());
			stmt.setString(6, jogador.getGols());
			stmt.setString(7, jogador.getId());

			int cnt = stmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.print("atualizado");
			}
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar atualizar aluno");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
	}

	
	
	public List<Jogadores> read()
	{
		List<Jogadores> listaJogadores = new ArrayList<Jogadores>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT NOME_JOGADOR AS NOME,TIME,JOGOS_DISPUTADOS AS JOGOS,QNT_CARTAO AS CARTÕES,GOLS"
				+ "FROM JOGADORES"
				+ "ORDER BY GOLS DESC;";
		
		try
		{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Jogadores jogador = new Jogadores();
				
				jogador.setNome(rs.getString("nome"));
				jogador.setTime(rs.getString("time"));
				jogador.setJogosD(rs.getString("jogosD"));
				jogador.setCartao(rs.getString("cartao"));
				jogador.setGols(rs.getString("gols"));
				
				listaJogadores.add(jogador);
				
			}
			
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler jogadores...");
		}
		finally {
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		return listaJogadores;
	}

	

		
}

