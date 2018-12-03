package conexao;

import java.sql.DriverManager;

import org.primefaces.model.diagram.Connection;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

/**
 * Classe responsável por controlar , criar e retornar a conexão com o banco de dados
 * @author alex
 *
 */
public class SingletonConnetion {

	//Conexão SQL Java
	private static Connection connection = null;
	
	// Método estático que faz sempre a chamada para conectar
	static {
		conectar();
	}

	public SingletonConnetion() {
		conectar();
	}

	/**
	 * Realiza a conexão com o banco de dados
	 */
	private static void conectar() {
		try {
			
			if (connection == null) {
				/* Carrega o driver especificado para conexão ao BD*/
				Class.forName("com.mysql.cj.jdbc.Driver");	
/*				Class.forName("org.postgresql.Driver"); // driver mysql
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_imagens?autoReconnect=true", "postgres", "admin");// url do banco de dados com user e senha
				connection.setAutoCommit(false);// não dar commit automatico
				connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // tipo da transação no banco de dados
*/

				//URL de conexão ao BD
				String url = "jdbc:mysql://127.0.0.1:3306/projeto_imagens?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
				//Usuário usado para conectar ao BD
				String user = "root";
				//Senha do usuário a ser usado na conexão
				String pass =  "Transcon2018";
				
				/* 
				*	getConnection ==> abre a conexão
				*	A interface Connection ==>	Representa uma conexão ao banco de dados
				*	Método close ==>	Geralmente é inserido dentro do bloco finally para realizar sempre a sua execução, pois esse método serve para fechar e liberar imediatamente um objeto Connection.
				*	Método isClosed ==>	Serve para verificar se o objeto Connection está fechado.
				*	Método createStatement ==>	É usado para criar um objeto Statement que executa instruções SQL ao banco de dados.
				*/
				
				connection = DriverManager.getConnection(url,user,pass);
				
				connection.setAutoCommit(false);// não dar commit automatico
				//connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); // tipo da transação no banco de dados
				
				}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com a base de dados."
					+ e);
		}

	}

	/**
	 * Retorna a conexão com o banco de dados
	 * @return Connection
	 */
	public static Connection getConnection() {
		return connection;
	}

}
