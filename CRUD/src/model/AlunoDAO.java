package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Aluno;
import jdbc.ConnectionFactory;

public class AlunoDAO {

	public void create(Aluno aluno) {
		
		//insert sql no banco
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "insert into aluno(matricula, nome, cidade) values (?, ?, ?)";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getCidade());
			
			stmt.executeUpdate();
			
			System.out.println("Aluno inclu�do com sucesso!!!");
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar incluir aluno");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		
	}
	
	public void delete(Aluno aluno) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "delete from aluno where matricula = (?)";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, aluno.getMatricula());
			
			stmt.executeUpdate();
			
			System.out.println("Aluno exlu�do com sucesso!!!");
			
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar excluir aluno");	
		}
		finally {
			
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		
	}
	
	public void update(Aluno aluno) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		try
		{
			String sql = "update aluno set nome =?, cidade =? where matricula =?";
			
			stmt = banco.prepareStatement(sql);
			
			//popula a query com os parametros
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCidade());
			stmt.setString(3, aluno.getMatricula());
			
		
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

	
	
	public List<Aluno> read()
	{
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select matricula, nome, cidade from aluno";
		
		try
		{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Aluno aluno = new Aluno();
				
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome" ));
				aluno.setCidade(rs.getString("cidade"));
				
				listaAlunos.add(aluno);
				
			}
			
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Aluno...");
		}
		finally {
			ConnectionFactory.closeConnection(banco, stmt);
		}
		
		return listaAlunos;
	}

	

		
}

