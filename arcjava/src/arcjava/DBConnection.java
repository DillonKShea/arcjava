package arcjava;

import java.sql.*;
import com.mysql.*;


public class DBConnection {
	
	private static String url;
	private static String user;
	private static String pass;
	private static String conString;
	private static Connection connection;
	private static ResultSet rSet;
	
	public DBConnection() {
		
		url = "jdbc:mysql://127.0.0.1:3306/arc_db";
		user = "root";
		pass = "";
		connection = null;
		
	}
	
	public static void connect() {
		try {
			System.out.println("Attempting connection");
			url = "jdbc:mysql://127.0.0.1:3306/arc_db";
			user = "root";
			pass = "";
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successful");
			String query ="SELECT * FROM arctable;";
			Statement stmt = connection.createStatement();
			rSet = stmt.executeQuery(query);
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + " " + rSet.getString(2));
			}
			rSet.beforeFirst();
		} catch (SQLException e) {
			System.out.println("Connection failed: " + e);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public void disconnect(Connection connection) {
		System.out.println("Connection closed");
		if (connection != null) try {
			connection.close();
		} catch (SQLException e) {
			
		}
	}
	
	public static ResultSet getResultSet() {
		return rSet;
	}
	
	public static int getRSSize() {
		try {
			String sizeQuery = "SELECT count(*) from arctable";
			Statement stmt = connection.createStatement();
			ResultSet sizeSet = stmt.executeQuery(sizeQuery);
			sizeSet.next();
			System.out.println(sizeSet.getInt(1));
			return sizeSet.getInt(1);
		}
		catch (SQLException e) {
			System.out.println("RSSize failed: " + e);
			return 0;
		}
		
	}
	
}
