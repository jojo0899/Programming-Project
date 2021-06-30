package GUI;
import java.sql.*;//////////////////////////////////////////////////

import Functionalities.DateCompare;
import Functionalities.Event;
import Functionalities.Map;
import Functionalities.User;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class SearchEventResultList extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEventResultList frame = new SearchEventResultList();
					frame.setVisible(true);
					frame.setResizable(false); //größe nicht anpassbar
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public SearchEventResultList() throws ParseException {
		setTitle("Events suchen");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 931, 331);
		contentPane.add(scrollPane);
		////////////////////////////////////////
		String url = "jdbc:mysql://remotemysql.com:3306/5Nc7hrEXoh";
		String user = "5Nc7hrEXoh";
		String password = "5LK7MO7stL";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			//System.out.println("Verbindung steht");
				table = new JTable(); //leere tabelle ohne werte erstellen
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				
				new String[] {
					"ID", "Sportart", "Datum", "Uhrzeit", "Plz","Stadt", "Straße", "Hausnummer", "Freie Plätze", "Kosten" //Spaltenname
				}
			) {
				boolean[] columnEditables = new boolean[] { //Zeilen nicht editieren
						false, false, false, false, false, false, false, false,false,false
				};
				
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(table);
			table.setAutoCreateRowSorter(true);
			
		//System.out.println(SearchEvent.SearchBefore);	
		if(SearchEvent.SearchBefore.equals("Ort")) {
			//System.out.println(SearchEvent.SearchBefore);
			Statement st = connection.createStatement();
			String query = "SELECT id, sportart, Datum, Uhrzeit, Postleitzahl, Stadt, Straße, Hausnummer, Anzahlplätze, kosten FROM event WHERE sportart = '" + Event.SearchSport+"' and Datum = '" + Event.SearchDate +"' and Stadt Like '%" + Event.Searchcity + "%'and Anzahlplätze > 0";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String ID = String.valueOf(rs.getInt("id"));
				String sportart = rs.getString("sportart");
				String Datum = rs.getString("Datum");
				String Uhrzeit = rs.getString("Uhrzeit");
				String Plz= rs.getString("Postleitzahl");
				String Stadt = rs.getString("Stadt");
				String Straße = rs.getString("Straße");
				String Hausnummer = rs.getString("Hausnummer");
				String Anzahlplätze = String.valueOf(rs.getInt("Anzahlplätze"));
				if(rs.getInt("Anzahlplätze")>300) {
					Anzahlplätze ="keine Beschränkung";
				}
				String kosten = String.valueOf(rs.getDouble("kosten"));
				
				String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Straße, Hausnummer, Anzahlplätze, kosten};
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				
				if (!DateCompare.Datecheck(Datum)) {
					tblModel.addRow(data);
					}	
			
			
			
		}}else if(SearchEvent.SearchBefore.equals("Datum")) {
			//System.out.println(SearchEvent.SearchBefore);
			Statement st = connection.createStatement();
			String query = "SELECT id, sportart, Datum, Uhrzeit, Postleitzahl, Stadt, Straße, Hausnummer, Anzahlplätze, kosten FROM event WHERE sportart = '" + Event.SearchSport+"' and Datum = '" + Event.SearchDate +"'and Anzahlplätze > 0";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String ID = String.valueOf(rs.getInt("id"));
				String sportart = rs.getString("sportart");
				String Datum = rs.getString("Datum");
				String Uhrzeit = rs.getString("Uhrzeit");
				String Plz= rs.getString("Postleitzahl");
				String Stadt = rs.getString("Stadt");
				String Straße = rs.getString("Straße");
				String Hausnummer = rs.getString("Hausnummer");
				String Anzahlplätze = String.valueOf(rs.getInt("Anzahlplätze"));
				if(rs.getInt("Anzahlplätze")>300) {
					Anzahlplätze ="keine Beschränkung";
				}
				String kosten = String.valueOf(rs.getDouble("kosten"));
				
				String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Straße, Hausnummer, Anzahlplätze, kosten};
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				tblModel.addRow(data);	
			
		}}else if(SearchEvent.SearchBefore.equals("Sport")) {
			//System.out.println(SearchEvent.SearchBefore);
			Statement st = connection.createStatement();
			String query = "SELECT id, sportart, Datum, Uhrzeit, Postleitzahl, Stadt, Straße, Hausnummer, Anzahlplätze, kosten FROM event WHERE sportart = '" + Event.SearchSport+"' and Anzahlplätze > 0";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String ID = String.valueOf(rs.getInt("id"));
				String sportart = rs.getString("sportart");
				String Datum = rs.getString("Datum");
				String Uhrzeit = rs.getString("Uhrzeit");
				String Plz= rs.getString("Postleitzahl");
				String Stadt = rs.getString("Stadt");
				String Straße = rs.getString("Straße");
				String Hausnummer = rs.getString("Hausnummer");
				String Anzahlplätze = String.valueOf(rs.getInt("Anzahlplätze"));
				if(rs.getInt("Anzahlplätze")>300) {
					Anzahlplätze ="keine Beschränkung";
				}
				String kosten = String.valueOf(rs.getDouble("kosten"));
				
				String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Straße, Hausnummer, Anzahlplätze, kosten};
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				if (!DateCompare.Datecheck(Datum)) {
					tblModel.addRow(data);
					}	
			
			
		}} 
		else {
		
		Statement st = connection.createStatement();
		String query = "SELECT id, sportart, Datum, Uhrzeit, Postleitzahl, Stadt, Straße, Hausnummer, Anzahlplätze, kosten FROM event WHERE sportart = '" + Event.SearchSport+"' and Datum = '" + Event.SearchDate +"' and Stadt Like '%" + Event.Searchcity + "%' and kosten <= '" + Event.SearchKosten +"' and Anzahlplätze > 0";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String ID = String.valueOf(rs.getInt("id"));
			String sportart = rs.getString("sportart");
			String Datum = rs.getString("Datum");
			String Uhrzeit = rs.getString("Uhrzeit");
			String Plz= rs.getString("Postleitzahl");
			String Stadt = rs.getString("Stadt");
			String Straße = rs.getString("Straße");
			String Hausnummer = rs.getString("Hausnummer");
			String Anzahlplätze = String.valueOf(rs.getInt("Anzahlplätze"));
			if(rs.getInt("Anzahlplätze")>300) {
				Anzahlplätze ="keine Beschränkung";
			}
			
			String kosten = String.valueOf(rs.getDouble("kosten"));
			
			String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Straße, Hausnummer, Anzahlplätze, kosten};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			if (!DateCompare.Datecheck(Datum)) {
				tblModel.addRow(data);
				}	
		

		}}
		
		
		
		
		
		
		
		
		
		
		
		
		
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
		

		JButton btnSelect = new JButton("Ausw\u00E4hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) { //wenn auswählen dgedrückt und eine zeile asugewählt wurde
					//hier 
					int row = table.getSelectedRow();
					String cell = table.getModel().getValueAt(row, 0).toString();
					Event.id = Integer.parseInt(cell);
					
					
					Event.SearchSport =(String) table.getValueAt(table.getSelectedRow(),1);
					Event.SearchDate=(String) table.getValueAt(table.getSelectedRow(),2);
					Event.SearchTime=(String) table.getValueAt(table.getSelectedRow(),3);
					Event.Searchzip=(String) table.getValueAt(table.getSelectedRow(),4);
					Event.Searchcity=(String) table.getValueAt(table.getSelectedRow(),5);
					Event.Searchstreet=(String) table.getValueAt(table.getSelectedRow(),6);
					Event.Searchhnr=(String) table.getValueAt(table.getSelectedRow(),7);
					
					Event.Kosten = Double.parseDouble( (String) table.getValueAt(table.getSelectedRow(),9));
					
				dispose(); //fnester schließen
				SearchEventConfirm.main(null); //Bestötigungsfenster öffnen
				}else { //wenn keine zeiele asugewählt wurde
					 JOptionPane.showMessageDialog(null, "Bitte wähle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnSelect.setBounds(834, 339, 97, 26);
		contentPane.add(btnSelect);
		
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//wenn click on zurück 
				dispose(); //fenster schließen 
				SearchEvent.main(null); //Search event main öffnen
			}
		});

		btnBack.setBounds(6, 339, 97, 26);
		contentPane.add(btnBack);
		
		JButton btnHauptmen = new JButton("Hauptmen\u00FC");
		btnHauptmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow.main(null);
			}
		});
		btnHauptmen.setBounds(435, 339, 115, 26);
		contentPane.add(btnHauptmen);
		
		
		
		}
	}

