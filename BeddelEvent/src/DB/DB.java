package DB;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Functionalities.Event;
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
	
	public static void resultSetToTableModel(JTable table, String tableName, String whereCondition, int columnCount) throws SQLException{
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
	    	
			Statement st = connection.createStatement();
	    	ResultSet rs =  st.executeQuery("SELECT * FROM user;");
	        DefaultTableModel tableModel = new DefaultTableModel();
	        ResultSetMetaData metaData = rs.getMetaData();
	        
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
	            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }
	        
	        Object[] row = new Object[columnCount];
	
	        while (rs.next()){
	            for (int i = 0; i < columnCount; i++){
	                row[i] = rs.getObject(i+1);
	            }
	            tableModel.addRow(row);
	        }
	
	        table.setModel(tableModel);    
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}

        
    }
	
	public static Boolean checkIfUsernameExistsInDB(String username) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			Statement st = connection.createStatement();
            ResultSet result =  st.executeQuery("SELECT username FROM user WHERE username ='" + username + "'");
            return result.next();
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}
	
	public static void deleteUserFromDB(String username){
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		try (Connection connection = DriverManager.getConnection(url, user , password)) {
			Statement st = connection.createStatement();
			st.execute("DELETE FROM user WHERE username='" + username + "'");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static String getUserDataFromDB(String username, String column){
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			Statement st = connection.createStatement();
			String query = "SELECT " + column + " FROM user WHERE username='" + username + "'";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String columnResult = rs.getString(column);
				System.out.println(columnResult);
				return columnResult;
			}
		}
		catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return null;
	
}
	
	
	public static void DecrementAnzahlplaetze() {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			String query = "UPDATE event SET Anzahlplätze = Anzahlplätze - 1 WHERE id = '" + Event.id + "'";
			Statement st = connection.createStatement();
			st.executeLargeUpdate(query);
			System.out.println("Anzahlplätze in Event geändert(-)");
			st.close();
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static int getEventID(String Sport, String Date,String Time, String zip, String city, String street, String hnr, int Anz,  double Kosten, String username, double xval, double yval) {
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
			
			String query = "SELECT id FROM event WHERE sportart = '" + Sport + "' and Datum = '" + Date + "' and Uhrzeit = '" + Time + "' and Postleitzahl = '" + zip +"' and Straße = '" + street +"' and Hausnummer = '" + hnr + "' and Anzahlplätze = " + Anz +" and kosten = " + Kosten + " and veranstalter = '"  + username + "' and xCoordinate = " + xval + " and yCoordinate =" + yval+ "";
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(query);
			 
			while(rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount();i++) {
					Event.id = rs.getInt(i);
				}	
				System.out.println(Event.id);
				return Event.id;
			}
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return 0;
	}

}

