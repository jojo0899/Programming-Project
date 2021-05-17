package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HistoryList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 709, 331);
		contentPane.add(scrollPane);
		
		table = new JTable();		//table ohne inhalt erstellen
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
		scrollPane.setViewportView(table);
		
		JButton btnSelect = new JButton("Ausw\u00E4hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {	//wenn button Ausw�hlen gedr�fckt wurde und eine Zeile ausgew�hlt
					dispose();			//schlie�e aktuelles fenester
					HistoryView.main(null);	//�ffne die �bersicht History
					} else {
						 JOptionPane.showMessageDialog(null, "Bitte w�hle ein Event aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);	//fehlermeldung wenn nciths ausgew�hlt wurde
					}							
			}
		});
		btnSelect.setBounds(612, 339, 97, 26);
		btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //hand cursor beim hovern
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //wenn zur�ck button geclicked
				dispose();				//fenster schlie�en
				MainWindow.main(null); 	//hauptfenster �ffnen
			}
		});
		btnBack.setBounds(6, 339, 97, 26);
		btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
		
	}
}
