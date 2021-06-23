package jdbc;
import java.sql.*;


public class TesteBanco {

	public static void main(String[] args) {
		
		try {
			
			Connection banco = ConnectionFactory.getConnection();
			System.out.println("Conexão OK!!!!");
			
			createNewTable(banco);
			// readTableTest(banco);
		}
		catch(Exception e)
		{
			System.out.println("Erro na Conexão<<>>");
			System.out.println(e);
		}

	}
	
	public static void createNewTable(Connection banco) {
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS JOGADORES("
        		+ "IDJOGADOR INT PRIMARY KEY AUTO_INCREMENT,\r\n"
        		+ "	NOME_JOGADOR VARCHAR (30) NOT NULL,\r\n"
        		+ "	TIME VARCHAR(30) NOT NULL,\r\n"
        		+ "	JOGOS_DISPUTADOS INT(2) DEFAULT 0,\r\n"
        		+ "	QNT_CARTAO INT(2) DEFAULT 0,\r\n"
        		+ "	NUM_CAMISA INT (2) NOT NULL,\r\n"
        		+ "	GOLS INT (2) DEFAULT 0)";
        
        try {
			
        	Statement stmt = banco.createStatement();
            
        	// create a new table
            stmt.execute(sql);
                
			System.out.println("Tabela criada!!!");
		}
		catch(Exception e)
		{
			System.out.println("Erro criando tabela...");
			System.out.println(e);
		}
        
        String sql1 = "CREATE TABLE IF NOT EXISTS PARTIDAS(\r\n"
        		+ "	IDPARTIDA INT PRIMARY KEY AUTO_INCREMENT,\r\n"
        		+ "	DATA VARCHAR(5) NOT NULL,"
        		+ "	LOCAL VARCHAR(30) NOT NULL,"
        		+ "	TIME1 VARCHAR(30) NOT NULL,	"
        		+ "	TIME2 VARCHAR(30) NOT NULL);";
        
        try {
			
        	Statement stmt = banco.createStatement();
            
        	// create a new table
            stmt.execute(sql1);
                
			System.out.println("Tabela criada!!!");
		}
		catch(Exception e)
		{
			System.out.println("Erro criando tabela...");
			System.out.println(e);
		}
        
        String sql2 = "CREATE TABLE IF NOT EXISTS SCOUTS(\r\n"
        		+ "	IDCAMP INT NOT NULL,\r\n"
        		+ "	ANO VARCHAR(4) NOT NULL,\r\n"
        		+ "	ID_JOGADOR INT,\r\n"
        		+ "	FOREIGN KEY (ID_JOGADOR)\r\n"
        		+ "	REFERENCES JOGADORES (IDJOGADOR));";
        
        try {
			
        	Statement stmt = banco.createStatement();
            
        	// create a new table
            stmt.execute(sql2);
                
			System.out.println("Tabela criada!!!");
		}
		catch(Exception e)
		{
			System.out.println("Erro criando tabela...");
			System.out.println(e);
		}
        
        
    }//FIM 


	public static void readTableTest(Connection banco) {
        
        // SQL statement for creating a new table
        String sql = "select * from aluno;";
        
        PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//String sql = "SELECT * FROM db_aula_prog_java.aluno";
		
		try{
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if (rs.next())
				System.out.println("Com registro");
			else
				System.out.println("Sem registro");
			
			
			
		}catch(SQLException e)
		{
			System.out.println("<DAO> Erro lendo banco");
		}
		finally {
			ConnectionFactory.closeConnection(banco, stmt);
		}
        
    }
}

	