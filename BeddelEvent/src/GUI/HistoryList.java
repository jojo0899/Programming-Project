package GUI;

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

public class HistoryList extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //look and feel setten
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryList frame = new HistoryList();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);	//fenster in mitte plazieren
					frame.setResizable(false); //gr??e nicht anpassbar
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
	public HistoryList() throws ParseException {
		setTitle("Event Hitsorie");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HistoryList.class.getResource("/images/32.png")));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 931, 331);
		contentPane.add(scrollPane);
		
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
					"ID", "Sportart", "Datum", "Uhrzeit", "Plz","Stadt", "Stra?e", "Hausnummer", "Anzahlpl?tze", "Kosten" //Spaltenname
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
		String query = "SELECT e.id, e.sportart, e.Datum, e.Uhrzeit, e.Postleitzahl, e.Stadt, e.Stra?e, e.Hausnummer, e.Anzahlpl?tze, e.kosten FROM event e join participate_on p on(e.id = p.eventid) WHERE username = '" + User.username +"'";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String ID = String.valueOf(rs.getInt("id"));
			String sportart = rs.getString("sportart");
			String Datum = rs.getString("Datum");
			String Uhrzeit = rs.getString("Uhrzeit");
			String Plz= rs.getString("Postleitzahl");
			String Stadt = rs.getString("Stadt");
			String Stra?e = rs.getString("Stra?e");
			String Hausnummer = rs.getString("Hausnummer");
			String Anzahlpl?tze = String.valueOf(rs.getInt("Anzahlpl?tze"));
			if(Anzahlpl?tze.equals("999")) {
				Anzahlpl?tze ="keine Beschr?nkung";
			}
			String kosten = String.valueOf(rs.getDouble("kosten"));
			
			String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Stra?e, Hausnummer, Anzahlpl?tze, kosten};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			//System.out.println(Datum);
			
			if (DateCompare.Datecheck(Datum)) {
				tblModel.addRow(data);
				}
			
		}
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		/*table = new JTable();		//table ohne inhalt erstellen
		table.setModel(new DefaultTableModel(
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
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column" //column namen des tabel
			}
		) {
			boolean[] columnEditables = new boolean[] {				//zeilen nicht editierbar
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {		//zellen nicht editierbar
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);*/
		
		JButton btnSelect = new JButton("Ausw\u00E4hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {	//wenn button Ausw?hlen gedr?fckt wurde und eine Zeile ausgew?hlt
					Event.HistorySport =(String) table.getValueAt(table.getSelectedRow(),1);
					Event.HistoryDate=(String) table.getValueAt(table.getSelectedRow(),2);
					Event.HistoryTime=(String) table.getValueAt(table.getSelectedRow(),3);
					Event.HistoryZip=(String) table.getValueAt(table.getSelectedRow(),4);
					Event.HistoryCity=(String) table.getValueAt(table.getSelectedRow(),5);
					Event.HistoryStreet=(String) table.getValueAt(table.getSelectedRow(),6);
					Event.HistoryHnr=(String) table.getValueAt(table.getSelectedRow(),7);
					
					Event.HistoryKosten = Double.parseDouble( (String) table.getValueAt(table.getSelectedRow(),9));
					
					
					
					
					dispose();			//schlie?e aktuelles fenester
					HistoryView.main(null);	//?ffne die ?bersicht History
					
					
					
					
					
					} else {
						 JOptionPane.showMessageDialog(null, "Bitte w?hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);	//fehlermeldung wenn nciths ausgew?hlt wurde
					}							
			}
		});
		btnSelect.setBounds(834, 343, 97, 26);
		btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //hand cursor beim hovern
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //wenn zur?ck button geclicked
				dispose();				//fenster schlie?en
				MainWindow.main(null); 	//hauptfenster ?ffnen
			}
		});
		btnBack.setBounds(6, 339, 97, 26);
		btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
		
	}
}
