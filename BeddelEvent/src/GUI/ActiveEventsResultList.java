package GUI;


import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
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
	public ActiveEventsResultList() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ActiveEventsResultList.class.getResource("/images/32.png")));
		setTitle("Aktive Events");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
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
					"ID", "Sportart", "Datum", "Uhrzeit", "Plz","Stadt", "Stra?e", "Hausnummer", "Freie Pl?tze", "Kosten" //Spaltenname
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
		String query = "SELECT e.id, e.sportart, e.Datum, e.Uhrzeit, e.Postleitzahl, e.Stadt, e.Stra?e, e.Hausnummer, e.Anzahlpl?tze, e.kosten FROM event e join participate_on p on(e.id = p.eventid) WHERE username = '" + User.username +"' ";
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
			
			System.out.println("call DateCompare");
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
				if(!table.getSelectionModel().isSelectionEmpty()) {		//wenn der button absagen gedr?clt wurde und eine reihe ausgew?hlt wurde, f?hre sql delete statement aus
					int confirm = JOptionPane.showConfirmDialog(null, "Sind Sie sicher, dass Sie dieses Event Absagen m?chten?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					if(confirm==0) {
						String url = "jdbc:mysql://remotemysql.com:3306/5Nc7hrEXoh";
						String user = "5Nc7hrEXoh";
						String password = "5LK7MO7stL";
					
					try (Connection connection = DriverManager.getConnection(url, user , password)){
						//System.out.println("Verbindung steht");
						

						int row = table.getSelectedRow();
						String cell = table.getModel().getValueAt(row, 0).toString();
						Event.id = Integer.parseInt(cell);
						
						String query = "DELETE from participate_on WHERE eventid = '" + Event.id + "'";
						Statement s1 = connection.createStatement();
						s1.executeLargeUpdate(query);
						//System.out.println("wurde aus participate_on gel?scht");
						s1.close();
						
						String query2 = "UPDATE event SET Anzahlpl?tze = Anzahlpl?tze + 1 WHERE id = '" + Event.id + "'";
						Statement s2 = connection.createStatement();
						s2.executeLargeUpdate(query2);
						//System.out.println("Anzahlpl?tze in Event ge?ndert(+)");
						s2.close();
						
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						tblModel.removeRow(row);

						
					}
					catch(SQLException ex) {
						System.err.println(ex.getMessage());
					}}
				} else {
					 JOptionPane.showMessageDialog(null, "Bitte w?hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE); //button gedr?ckt aber nichts ausgew?hlt
				}
							
			}
		});
		btnNewButton.setBounds(421, 339, 97, 26);
		btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JButton btnSelect = new JButton("Ausw?hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {	//button ausw?hlen gedr?ckt, schlie?e das aktuelle fenster und ?ffne die ?bersicht ActiveEventsView
					Event.ActiveSport =(String) table.getValueAt(table.getSelectedRow(),1);
					Event.ActiveDate=(String) table.getValueAt(table.getSelectedRow(),2);
					Event.ActiveTime=(String) table.getValueAt(table.getSelectedRow(),3);
					Event.ActiveZip=(String) table.getValueAt(table.getSelectedRow(),4);
					Event.ActiveCity=(String) table.getValueAt(table.getSelectedRow(),5);
					Event.ActiveStreet=(String) table.getValueAt(table.getSelectedRow(),6);
					Event.ActiveHnr=(String) table.getValueAt(table.getSelectedRow(),7);
					
					Event.ActiveKosten = Double.parseDouble( (String) table.getValueAt(table.getSelectedRow(),9));
					
					
					
					
					dispose();
				ActiveEventsView.main(null);
				
				} else {
					 JOptionPane.showMessageDialog(null, "Bitte w?hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE); //falls der button gedr?ckt wurde aber nichts ausgew?hlt wurde
				}
							
			}
		});
		btnSelect.setBounds(834, 339, 97, 26);
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Zur?ck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		//button zur?ck wurde gedr?ckt. Kehre zum Main window zur?ck und schlie?e das aktuelle fenster
				dispose();
				MainWindow.main(null);
			}
		});
		btnBack.setBounds(6, 339, 97, 26);
		btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
	}
}
