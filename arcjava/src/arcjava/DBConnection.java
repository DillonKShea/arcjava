package arcjava;

import java.sql.*;
import com.ibm.as400.access.*;


public class DBConnection {
	
	private static String url;
	private static String user;
	private static String pass;
	private static String conString;
	private static Connection connection;
	private static ResultSet rSet;
	
	public DBConnection() {
		
		url = "jdbc:as400://S1051c6e.timeshare400.com/DKS6L1";
		user = "dks60320";
		pass = "husky123";
		connection = null;
		
	}
	
	public static void connect() {
		try {
			System.out.println("Attempting connection");
			url = "jdbc:as400://S1051c6e.timeshare400.com/DKS6L1";
			user = "dks60320";
			pass = "husky123";
			String asDriver = "com.ibm.as400.access.AS400JDBCDriver";
			Class.forName(asDriver);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successful");
			String query ="select * from dw21wrk";
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rSet = stmt.executeQuery(query);
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + " " + rSet.getString(2));
			}
			rSet.beforeFirst();
		} catch (SQLException e) {
			System.out.println("Connection failed: " + e);
		} catch (Exception e) {
			System.out.println("Error2: " + e);
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
			String sizeQuery = "select count(*) from dw21wrk";
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
	
	public static String getDesc (String name) {
		try {
			String descQuery = "select SPCDSC from dw21wrk where SPCNAM = \'" + name + "\'";
			Statement stmt = connection.createStatement();
			ResultSet descSet = stmt.executeQuery(descQuery);
			descSet.next();
			System.out.println(descSet.getString(1));
			return descSet.getString(1);
		}
		catch (SQLException e) {
			System.out.println("Description error: " + e);
			return null;
		}
	}
	
}
