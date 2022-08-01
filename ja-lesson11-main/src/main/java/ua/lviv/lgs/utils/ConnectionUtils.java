package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

public class ConnectionUtils {

	
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "root";
	private  static String URL = "jdbc:mysql://localhost/i_shop";	
		
	public static Connection  openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DOMConfigurator.configure("LoggerConfig.xml");
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return (DriverManager.getConnection(URL,USER_NAME,USER_PASSWORD));
	}
}
