package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

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
					MainWindow frame = new MainWindow();
					frame.setLocationRelativeTo(null);

					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start your Beddel Journey ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(157, 6, 231, 30);
		contentPane.add(lblNewLabel);
		
		JLabel BtnActiveEvents = new JLabel("Create your own event");
		BtnActiveEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		BtnActiveEvents.setIcon(new ImageIcon("C:\\Users\\Fizzle\\Desktop\\Java Bilder\\1486564398-menu2_81519 (1).png"));
		BtnActiveEvents.setBounds(81, 184, 97, 96);
		BtnActiveEvents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(BtnActiveEvents);
		
		JButton btnLogOUt = new JButton("LogOut");
		btnLogOUt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.main(null);
			}
		});
		btnLogOUt.setBounds(447, 11, 97, 26);
		btnLogOUt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnLogOUt);
		
		JLabel BtnCreateEvent = new JLabel("New label");
		BtnCreateEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateEvent.main(null);
				dispose();
				
			}
		});
		BtnCreateEvent.setIcon(new ImageIcon("C:\\Users\\Fizzle\\Desktop\\Java Bilder\\1486564412-plus_81511.png"));
		BtnCreateEvent.setBounds(81, 48, 97, 96);
		BtnCreateEvent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(BtnCreateEvent);
		
		JLabel BtnHistory = new JLabel("New label");
		BtnHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		BtnHistory.setIcon(new ImageIcon("C:\\Users\\Fizzle\\Desktop\\Java Bilder\\1486564404-folder_81505 (1).png"));
		BtnHistory.setBounds(361, 184, 97, 96);
		BtnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(BtnHistory);
		
		JLabel BtnSearchEvent = new JLabel("New label");
		BtnSearchEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SearchEvent.main(null);
			}
		});
		BtnSearchEvent.setIcon(new ImageIcon("C:\\Users\\Fizzle\\Desktop\\Java Bilder\\PikPng.com_blue-circle-png_1191296 (1) (1).png"));
		BtnSearchEvent.setBounds(361, 46, 97, 101);
		BtnSearchEvent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(BtnSearchEvent);
		
		JLabel lblNewLabel_4 = new JLabel("Create new Event");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(69, 145, 109, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Search Event");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(361, 145, 97, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("See active Events");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(81, 285, 109, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("See past Events");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(371, 292, 87, 16);
		contentPane.add(lblNewLabel_7);
	}
}
