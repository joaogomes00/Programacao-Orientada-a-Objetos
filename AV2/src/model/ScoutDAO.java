package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bo.Scout;
import jdbc.ConnectionFactory;

public class ScoutDAO {

	public List<Scout> read()
	{
		List<Scout> listaJogadores = new ArrayList<Scout>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT J.NOME_JOGADOR,J.QNT_CARTAO,J.GOLS, S.IDCAMP, S.ANO,J.TIME\r\n"
				+ "FROM JOGADORES AS J\r\n"
				+ "INNER JOIN SCOUTS AS S\r\n"
				+ "ON J.IDJOGADOR = S.ID_JOGADOR\r\n"
				+ "ORDER BY GOLS DESC;";
		
		try
		{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Scout jogador = new Scout();
				
				jogador.setNome(rs.getString("NOME_JOGADOR"));
				jogador.setCartao(rs.getString("QNT_CARTAO"));
				jogador.setGols(rs.getString("GOLS"));
				jogador.setAno(rs.getString("ANO"));
				jogador.setTime(rs.getString("TIME"));
				jogador.setIdcamp(rs.getString("IDCAMP"));
				
				
				listaJogadores.add(jogador);
				
				
			}
			
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Scouts...");
		}
		finally {
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		return listaJogadores;
	}

}

