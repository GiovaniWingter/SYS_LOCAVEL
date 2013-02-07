package br.com.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.lab.exception.DaoException;


public class DbUtil {

	private static final String URL_DATABASE = "jdbc:sqlserver://localhost;databaseName=INF3AT;";
	private static final String DRIVER_JDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private static final String USUARIO_DB = "teste";
	private static final String SENHA_USUARIO_DB = "gigio1974";
	
	static {
		try {
			Class.forName(DRIVER_JDBC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws DaoException {
		try {
			Connection connection = DriverManager.getConnection(URL_DATABASE, USUARIO_DB, SENHA_USUARIO_DB);
			connection.setAutoCommit(true);
			return connection;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public static void close(Connection conn, Statement statement, ResultSet result) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
