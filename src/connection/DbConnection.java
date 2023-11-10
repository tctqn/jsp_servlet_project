package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	private static Connection connection;
	
	private DbConnection() {
	}

	public static Connection getConnection() {
		
		if(connection == null) {
			Properties props = DbProvider.getProperties();
			try {
				Class.forName(props.getProperty(DbConstant.DRIVER));
				connection = DriverManager.getConnection(
						props.getProperty(DbConstant.URL),
						props.getProperty(DbConstant.USER),
						props.getProperty(DbConstant.PASSWORD));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
