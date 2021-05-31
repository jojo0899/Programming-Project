package DB;
import java.sql.*;

public class DB {
	public static String username;
	public static String passwort;
	public static boolean bool;
	public static String email; 
	
	public static void DBconnection() {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void InsertDataIntoUser(String username, String vorname, String nachname, String geschlecht, String email, String passworthash) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			String query = "INSERT INTO user (username, vorname, nachname, geschlecht, email, passwort) VALUES ('" + username +"', '" + vorname + "' , '"+ nachname+ "' , '"+ geschlecht+ "' , '"+ email + "' , '"+passworthash + "' )";
			Statement s = connection.createStatement();
			s.execute(query);
			s.close();
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void InsertDataIntoEvent(int a, String b, String c,String d, String e, int g, float h, String i) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			String query = "INSERT INTO event (id, sportart, Datum, Uhrzeit, Stadt, Strasse, Anzahlplätze, kosten, veranstalter) VALUES ('" + a +"', '" + b + "' , '"+ c + "' , '"+ d + "' , '"+ e + "' , '"+ g + "' , '"+ h + "' , '"+ i + "' )";			
			Statement s = connection.createStatement();
			s.execute(query);
			s.close();
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void InsertDataIntoParticipate_on(String a, int b) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			String query = "INSERT INTO participate_on (username, eventid) VALUES ('" + a +"', '" + b + "')";
			Statement s = connection.createStatement();
			s.execute(query);
			s.close();
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static boolean LoginCheck(String UserName, String PassWort) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			String query = "SELECT username FROM user WHERE username = '" + UserName + "'";
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			 
			while(rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount();i++) {
					username = rs.getString(i);
				}	
			}
//			System.out.println(username);
			String query2 = "SELECT passwort FROM user WHERE username = '" + username +"'";
			Statement s2 = connection.createStatement(); 
			ResultSet rs2 = s2.executeQuery(query2);
			while(rs2.next()) {
				for (int i = 1; i <= rs2.getMetaData().getColumnCount();i++) {
					passwort = rs2.getString(i);
				}
			}
			
			String query3 = "SELECT email FROM user WHERE username = '" + username +"'";
			Statement s3 = connection.createStatement(); 
			ResultSet rs3 = s3.executeQuery(query3);
			while(rs3.next()) {
				for (int i = 1; i <= rs3.getMetaData().getColumnCount();i++) {
					email= rs3.getString(i);
				}
			}
			
			
			
			
//			System.out.println(passwort);
			if (UserName.equals(username) && PassWort.equals(passwort)) {
				System.out.println("Login");
				bool = true;
			}
			else {
				System.out.println("Keinen Treffer");
				bool = false;
			}
			
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(bool);
		return bool;
	}
}

