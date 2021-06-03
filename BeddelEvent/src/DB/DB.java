package DB;
import java.sql.*;

import Functionalities.Map;
import Functionalities.User;

public class DB {
	public static boolean bool;
	
//	
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
	public static int counter=0;
	public static void getMakers() throws SQLException {

		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
		
		
		String query = "SELECT sportart,xCoordinate,yCoordinate FROM event";
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(query);
		 
		while(rs.next()) {
			for (int i = 1; i <= rs.getMetaData().getColumnCount();i++) {
				Map.nMark.add(rs.getString(i));

				
				}	
		}	
		
		
		
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
	//hallo
	
	public static void InsertDataIntoEvent(String sportart, String datum,String uhrzeit, String zip,String stadt,String straße, String hausnummer, int anz, double kosten, String veranstalter, double xval, double yval) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			String query = "INSERT INTO event (sportart, Datum, Uhrzeit, Postleitzahl,Stadt,Straße,Hausnummer, Anzahlplätze, kosten, veranstalter,xCoordinate,yCoordinate) VALUES ('" + sportart + "' , '"+ datum + "' , '"+ uhrzeit + "' , '"+ zip + "' , '"+ stadt + "' , '"+ straße + "' , '"+ hausnummer + "' , '"+ anz + "' , '"+ kosten + "' , '"+ veranstalter + "' , '"+xval+"' , '"+yval+"' )";			
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
					User.username = rs.getString(i);
				}	
			}
//			System.out.println(username);
			String query2 = "SELECT passwort FROM user WHERE username = '" + User.username +"'";
			Statement s2 = connection.createStatement(); 
			ResultSet rs2 = s2.executeQuery(query2);
			while(rs2.next()) {
				for (int i = 1; i <= rs2.getMetaData().getColumnCount();i++) {
					User.passwort = rs2.getString(i);
				}
			}
			
			String query3 = "SELECT email FROM user WHERE username = '" + User.username +"'";
			Statement s3 = connection.createStatement(); 
			ResultSet rs3 = s3.executeQuery(query3);
			while(rs3.next()) {
				for (int i = 1; i <= rs3.getMetaData().getColumnCount();i++) {
					User.email= rs3.getString(i);
				}
			}
			
			
			
			
//			System.out.println(passwort);
			if (UserName.equals(User.username) && PassWort.equals(User.passwort)) {
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

