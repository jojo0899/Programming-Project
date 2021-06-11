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
					frame.setResizable(false); //größe nicht anpassbar
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
					"ID", "sportart", "Datum", "Uhrzeit", "Plz","Stadt", "Straße", "Hausnummer", "Anzahlplätze", "kosten" //Spaltenname
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
		String query = "SELECT e.id, e.sportart, e.Datum, e.Uhrzeit, e.Postleitzahl, e.Stadt, e.Straße, e.Hausnummer, e.Anzahlplätze, e.kosten FROM event e join participate_on p on(e.id = p.eventid) WHERE username = '" + User.username +"'";
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
			String kosten = String.valueOf(rs.getDouble("kosten"));
			
			String data[] = {ID, sportart, Datum, Uhrzeit,Plz, Stadt, Straße, Hausnummer, Anzahlplätze, kosten};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			System.out.println(Datum);
			
			if (!DateCompare.Datecheck(Datum)) {
				tblModel.addRow(data);
				}
			
		}
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		//////////////////////////////////
		
		btnNewButton = new JButton("Absagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {		//wenn der button absagen gedrüclt wurde und eine reihe ausgewählt wurde, führe sql delete statement aus 
					String url = "jdbc:mysql://freedb.tech:3306/freedbtech_progExDatabase?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
					String user = "freedbtech_sabbaprogex";
					String password = "sabba2021";
					
					try (Connection connection = DriverManager.getConnection(url, user , password)){
						System.out.println("Verbindung steht");
						

						int row = table.getSelectedRow();
						String cell = table.getModel().getValueAt(row, 0).toString();
						Event.id = Integer.parseInt(cell);
						
						String query = "DELETE from participate_on WHERE eventid = '" + Event.id + "'";
						Statement s1 = connection.createStatement();
						s1.executeLargeUpdate(query);
						System.out.println("wurde aus participate_on gelöscht");
						s1.close();
						
						String query2 = "UPDATE event SET Anzahlplätze = Anzahlplätze + 1 WHERE id = '" + Event.id + "'";
						Statement s2 = connection.createStatement();
						s2.executeLargeUpdate(query2);
						System.out.println("Anzahlplätze in Event geändert(+)");
						s2.close();
						
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						tblModel.removeRow(row);

						
					}
					catch(SQLException ex) {
						System.err.println(ex.getMessage());
					}
				} else {
					 JOptionPane.showMessageDialog(null, "Bitte wähle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE); //button gedrückt aber nichts ausgewählt
				}
							
			}
		});
		btnNewButton.setBounds(503, 339, 97, 26);
		btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JButton btnSelect = new JButton("Auswählen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {	//button auswählen gedrückt, schließe das aktuelle fenster und öffne die übersicht ActiveEventsView
				dispose();
				ActiveEventsView.main(null);
				} else {
					 JOptionPane.showMessageDialog(null, "Bitte wähle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE); //falls der button gedrückt wurde aber nichts ausgewählt wurde
				}
							
			}
		});
		btnSelect.setBounds(612, 339, 97, 26);
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Zurück");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//button zurück wurde gedrückt. Kehre zum Main window zurück und schließe das aktuelle fenster
				dispose();
				MainWindow.main(null);
			}
		});
		btnBack.setBounds(6, 339, 97, 26);
		btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
	}
}
