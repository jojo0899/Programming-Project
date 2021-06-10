package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Functionalities.DateCompare;
import Functionalities.Event;
import Functionalities.User;

import javax.swing.JScrollPane;

public class ActiveEventsResultList extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //look and feel setzten
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActiveEventsResultList frame = new ActiveEventsResultList();
					frame.setVisible(true);
					
					frame.setLocationRelativeTo(null); 		//fenster in der mitte plazieren
					frame.setResizable(false); //gr��e nicht anpassbar
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
	public ActiveEventsResultList() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 709, 331);
		contentPane.add(scrollPane);
		/*
		table = new JTable();
		table.setModel(new DefaultTableModel(					//tabelle ohne Inhalte
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"     //ComunName
			}
		) {
			boolean[] columnEditables = new boolean[] {					//Spalten d�rfen nicht editiert werden
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {		//Zellen d�rfen nicht editiert werden
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);*/
		String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
		String user = "freedbtech_sabbaprogex";
		String password = "sabba2021";
		
		try (Connection connection = DriverManager.getConnection(url, user , password)){
			System.out.println("Verbindung steht");
				table = new JTable(); //leere tabelle ohne werte erstellen
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				
				new String[] {
					"ID", "sportart", "Datum", "Uhrzeit", "Plz","Stadt", "Stra�e", "Hausnummer", "Anzahlpl�tze", "kosten" //Spaltenname
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
			
			
		
		
		Statement st = connection.createStatement();
		String query = "SELECT id, sportart, Datum, Uhrzeit, Postleitzahl, Stadt, Stra�e, Hausnummer, Anzahlpl�tze, kosten FROM event WHERE sportart = '" + Event.SearchSport+"' and Datum = '" + Event.SearchDate +"' and Stadt Like '%" + Event.Searchcity + "%' and kosten <= '" + Event.SearchKosten +"'";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String ID = String.valueOf(rs.getInt("id"));
			String sportart = rs.getString("sportart");
			String Datum = rs.getString("Datum");
			String Uhrzeit = rs.getString("Uhrzeit");
			String Plz= rs.getString("Postleitzahl");
			String Stadt = rs.getString("Stadt");
			String Stra�e = rs.getString("Stra�e");
			String Hausnummer = rs.getString("Hausnummer");
			String Anzahlpl�tze = String.valueOf(rs.getInt("Anzahlpl�tze"));
			String kosten = String.valueOf(rs.getDouble("kosten"));
			
			String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Stra�e, Hausnummer, Anzahlpl�tze, kosten};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			System.out.println(DateCompare.Datecheck(Datum));

			if (DateCompare.Datecheck(Datum)) {
				tblModel.addRow(data);
				System.out.println("zeile hinzugefuegt");
			}
			System.out.println("error");
		}
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		//////////////////////////////////
		
		btnNewButton = new JButton("Absagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {		//wenn der button absagen gedr�clt wurde und eine reihe ausgew�hlt wurde, f�hre sql delete statement aus 
				//SQL DELETE
				} else {
					 JOptionPane.showMessageDialog(null, "Bitte w�hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE); //button gedr�ckt aber nichts ausgew�hlt
				}
							
			}
		});
		btnNewButton.setBounds(503, 339, 97, 26);
		btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JButton btnSelect = new JButton("Ausw�hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {	//button ausw�hlen gedr�ckt, schlie�e das aktuelle fenster und �ffne die �bersicht ActiveEventsView
				dispose();
				ActiveEventsView.main(null);
				} else {
					 JOptionPane.showMessageDialog(null, "Bitte w�hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE); //falls der button gedr�ckt wurde aber nichts ausgew�hlt wurde
				}
							
			}
		});
		btnSelect.setBounds(612, 339, 97, 26);
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Zur�ck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//button zur�ck wurde gedr�ckt. Kehre zum Main window zur�ck und schlie�e das aktuelle fenster
				dispose();
				MainWindow.main(null);
			}
		});
		btnBack.setBounds(6, 339, 97, 26);
		btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
	}
}
