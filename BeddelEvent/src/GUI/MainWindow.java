//test
//Test2#
//test3
//
package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Functionalities.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //set look and feel
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setLocationRelativeTo(null);		//fenster in mitte plazieren
					frame.setResizable(false); //größe nicht anpassbar
					frame.setVisible(true);
					System.out.println(User.username);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/32.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 368);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Logout");
		menuBar.add(mnNewMenu);
		
		JButton LogOut = new JButton("Best\u00E4tigen");
		LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose(); //fenster schließen
				Login.main(null); //mainwindow öffnen
			}
		});
		mnNewMenu.add(LogOut);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Starte dein Beddel-Erlebnis");
		lblNewLabel.setBounds(157, 6, 262, 30);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		JLabel BtnActiveEvents = new JLabel("");
		BtnActiveEvents.setBounds(81, 184, 97, 96);
		BtnActiveEvents.addMouseListener(new MouseAdapter() { //wenn bild ggelicked wurde
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();	//fenster schließen
				ActiveEventsResultList.main(null); //activeEvents öffnen
			}
		});
		BtnActiveEvents.setIcon(new ImageIcon(MainWindow.class.getResource("/images/ActiveEvents.png")));
		BtnActiveEvents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //hoover c ursor hinzufgen
		contentPane.add(BtnActiveEvents);
		
		JLabel BtnCreateEvent = new JLabel("");
		BtnCreateEvent.setBounds(81, 48, 97, 96);
		BtnCreateEvent.addMouseListener(new MouseAdapter() { //wenn bild geclicked wurde
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateEvent.main(null); //create event öffnen 
				dispose(); //fenster schließen
				
			}
		});
		BtnCreateEvent.setIcon(new ImageIcon(MainWindow.class.getResource("/images/NeuesEvent.png")));
		BtnCreateEvent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //hand cursor beim hoovern
		contentPane.add(BtnCreateEvent);
		
		JLabel BtnHistory = new JLabel("");
		BtnHistory.setBounds(361, 184, 97, 96);
		BtnHistory.addMouseListener(new MouseAdapter() { //wenn bild geclicked
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); //fenster schließen 
				HistoryList.main(null); // History list öffnen
			}
		});
		BtnHistory.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Historie.png")));
		BtnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //hand cursor setten
		contentPane.add(BtnHistory);
		
		JLabel BtnSearchEvent = new JLabel("");
		BtnSearchEvent.setBounds(361, 46, 97, 101);
		BtnSearchEvent.addMouseListener(new MouseAdapter() { //wenn bild geclicked
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchEvent.main(null); //Search event öffnen
				dispose(); //aktuelles fenster schließen
			}
		});
		BtnSearchEvent.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Suchen.png")));
		BtnSearchEvent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //cursor für hoovern
		contentPane.add(BtnSearchEvent);
		
		JLabel lblNewLabel_4 = new JLabel("Neues Event");
		lblNewLabel_4.setBounds(69, 145, 121, 16);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Suchen");
		lblNewLabel_5.setBounds(361, 145, 97, 16);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Active Events");
		lblNewLabel_6.setBounds(81, 285, 109, 16);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Historie");
		lblNewLabel_7.setBounds(371, 292, 87, 16);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7);
	}
}
