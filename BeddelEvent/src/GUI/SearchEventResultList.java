package GUI;
import java.sql.*;//////////////////////////////////////////////////

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
					frame.setResizable(false); //gr��e nicht anpassbar
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEventResultList() {
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
		////////////////////////////////////////
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
					"sportart", "Datum", "Uhrzeit", "Stadt", "Stra�e", "Hausnummer", "Anzahlpl�tze", "kosten" //Spaltenname
				}
			) {
				boolean[] columnEditables = new boolean[] { //Zeilen nicht editieren
					false, false, false, false, false, false, false, false
				};
				
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(table);
			
			
		
		
		Statement st = connection.createStatement();
		String query = "SELECT sportart, Datum, Uhrzeit, Stadt, Stra�e, Hausnummer, Anzahlpl�tze, kosten FROM event";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String sportart = rs.getString("sportart");
			String Datum = rs.getString("Datum");
			String Uhrzeit = rs.getString("Uhrzeit");
			String Stadt = rs.getString("Stadt");
			String Stra�e = rs.getString("Stra�e");
			String Hausnummer = rs.getString("Hausnummer");
			String Anzahlpl�tze = String.valueOf(rs.getInt("Anzahlpl�tze"));
			String kosten = String.valueOf(rs.getDouble("kosten"));
			
			String data[] = {sportart, Datum, Uhrzeit, Stadt, Stra�e, Hausnummer, Anzahlpl�tze, kosten};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			tblModel.addRow(data);

			
		}
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
		
	/////////////////////////////////////////////////////////////
		
	/*	table = new JTable(); //leere tabelle ohne werte erstellen
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
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column" //Spaltenname
			}
		) {
			boolean[] columnEditables = new boolean[] { //Zeilen nicht editieren
				false, false, false, false, false, false, false, false
			};
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});*/
		scrollPane.setViewportView(table);
		//////////////////////////////////////////////////////////
		/*}catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}*/
		
		////////////////////////////////////////////////////////////////
		JButton btnSelect = new JButton("Ausw\u00E4hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) { //wenn ausw�hlen dgedr�ckt und eine zeile asugew�hlt wurde
				dispose(); //fnester schlie�en
				SearchEventConfirm.main(null); //Best�tigungsfenster �ffnen
				}else { //wenn keine zeiele asugew�hlt wurde
					 JOptionPane.showMessageDialog(null, "Bitte w�hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnSelect.setBounds(612, 339, 97, 26);
		contentPane.add(btnSelect);
		
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//wenn click on zur�ck 
				dispose(); //fenster schlie�en 
				SearchEvent.main(null); //Search event main �ffnen
			}
		});

		btnBack.setBounds(6, 339, 97, 26);
		contentPane.add(btnBack);
		
		
		
		}
	
	
	
	}

