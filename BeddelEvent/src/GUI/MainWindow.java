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
		lblNewLabel.setBounds(104, 6, 231, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnCreateEvent = new JButton("Create Event");
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEvent.main(null);
				dispose();
			}
		});
		btnCreateEvent.setBounds(32, 93, 119, 26);
		contentPane.add(btnCreateEvent);
		
		JButton btnSeachEvent = new JButton("Search Event");
		btnSeachEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SearchEvent.main(null);
			}
		});
		btnSeachEvent.setBounds(32, 148, 119, 26);
		contentPane.add(btnSeachEvent);
		
		JButton btnAssignedEvents = new JButton("Assigned Events");
		btnAssignedEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAssignedEvents.setBounds(32, 199, 119, 26);
		contentPane.add(btnAssignedEvents);
		
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHistory.setBounds(32, 251, 119, 26);
		contentPane.add(btnHistory);
		
		JLabel lblHistory = new JLabel("View all past events");
		lblHistory.setBounds(206, 256, 200, 16);
		contentPane.add(lblHistory);
		
		JLabel lblAssignedEvents = new JLabel("View all current and upcoming events");
		lblAssignedEvents.setBounds(206, 204, 222, 16);
		contentPane.add(lblAssignedEvents);
		
		JLabel lblSeachEvenet = new JLabel("Seach for an event");
		lblSeachEvenet.setBounds(206, 153, 222, 16);
		contentPane.add(lblSeachEvenet);
		
		JLabel lblCreateEvent = new JLabel("Create your own event");
		lblCreateEvent.setBounds(206, 98, 222, 16);
		contentPane.add(lblCreateEvent);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.main(null);
			}
		});
		btnNewButton.setBounds(447, 297, 97, 26);
		contentPane.add(btnNewButton);
	}
}
