package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe respons�vel por controlar , criar e retornar a conex�o com o banco de dados
 * @author alex
 *
 */
public class SingletonConnetion {

	//Conex�o SQL Java
	private static Connection connection = null;
	
	// M�todo est�tico que faz sempre a chamada para conectar
	static {
		conectar();
	}

	public SingletonConnetion() {
		conectar();
	}

	/**
	 * Realiza a conex�o com o banco de dados
	 */
	private static void conectar() {
		try {
			
			if (connection == null) {
				/* Carrega o driver especificado para conex�o ao BD*/
				Class.forName("com.mysql.cj.jdbc.Driver");	
/*				Class.forName("org.postgresql.Driver"); // driver mysql
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_imagens?autoReconnect=true", "postgres", "admin");// url do banco de dados com user e senha
				connection.setAutoCommit(false);// n�o dar commit automatico
				connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // tipo da transa��o no banco de dados
*/

				//URL de conex�o ao BD
				String url = "jdbc:mysql://127.0.0.1:3306/projeto_imagens?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
				//Usu�rio usado para conectar ao BD
				String user = "root";
				//Senha do usu�rio a ser usado na conex�o
				String pass =  "Transcon2018";
				
				/* 
				*	getConnection ==> abre a conex�o
				*	A interface Connection ==>	Representa uma conex�o ao banco de dados
				*	M�todo close ==>	Geralmente � inserido dentro do bloco finally para realizar sempre a sua execu��o, pois esse m�todo serve para fechar e liberar imediatamente um objeto Connection.
				*	M�todo isClosed ==>	Serve para verificar se o objeto Connection est� fechado.
				*	M�todo createStatement ==>	� usado para criar um objeto Statement que executa instru��es SQL ao banco de dados.
				*/
				
				connection = DriverManager.getConnection(url,user,pass);
				
				connection.setAutoCommit(false);// n�o dar commit automatico
				//connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // tipo da transa��o no banco de dados
				
				}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com a base de dados."
					+ e);
		}

	}

	/**
	 * Retorna a conex�o com o banco de dados
	 * @return Connection
	 */
	public static Connection getConnection() {
		return connection;
	}

}
