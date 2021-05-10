package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

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
					Login frame = new Login();
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
	public Login() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(5, 106, 77, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(5, 134, 77, 16);
		contentPane.add(lblNewLabel_1);
		
		txtUserName = new JTextField();
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtUserName.setBounds(77, 102, 126, 24);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register.main(null);
				
			}
		});
		btnNewButton.setBounds(277, 166, 95, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1.setBounds(83, 166, 95, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNew = new JLabel("New?");
		lblNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblNew.setBounds(277, 106, 95, 16);
		contentPane.add(lblNew);
		
		JLabel lblRegisterYourself = new JLabel("Register yourself");
		lblRegisterYourself.setBounds(277, 134, 95, 16);
		contentPane.add(lblRegisterYourself);
		
		JLabel lblHeadline = new JLabel("BeddelEvent");
		lblHeadline.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setBounds(159, 6, 126, 37);
		contentPane.add(lblHeadline);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtPassword.setBounds(77, 129, 126, 26);
		contentPane.add(txtPassword);
	}
}
