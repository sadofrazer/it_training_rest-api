package formation.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class ConnectionProvider {
	
	private static DataSource datasource;
	
	public static Connection getConnection() {
		
		try {
			if (datasource == null) {
				Context context = new InitialContext();
				datasource = (DataSource) context.lookup("java:comp/env/jdbc/it_training_bdd");
			}
			return datasource.getConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
