package memberinfo.com.osf.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static final String DB_URL; 
	private static final String DB_USER;
	private static final String DB_PASSWORD;
	private static final String DB_DIRVER_NAME;
	private static Connection con = null;
	
	static {
		InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("config/db.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DB_URL = prop.getProperty("db.url");
		DB_USER = prop.getProperty("db.user");
		DB_PASSWORD = prop.getProperty("db.password");
		DB_DIRVER_NAME = prop.getProperty("db.drivername");
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(DB_DIRVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	public static void close() {
		if(con!=null) {
			try {
				if(!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}	
}
