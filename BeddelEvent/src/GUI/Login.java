// test
package GUI;

import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DB;
import Functionalities.Password;

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
import java.io.UnsupportedEncodingException;

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
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //look and feel ändern
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
//		// generate test hash
//		String test = "test";
//		char test1[] = test.toCharArray();
//		try {
//			System.out.print(Functionalities.Password.createhash(test1, "test"));
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null); //Fenster in mitte plazieren
					frame.setVisible(true);
					frame.setResizable(false); //größe nicht anpassbar
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
		setTitle("Login");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
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
			public void keyTyped(KeyEvent e) { //wenn user name eingebeen wurde wert abfragen
			}
		});
		txtUserName.setBounds(77, 102, 126, 24);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {		//wenn registrieren gedrückt wurde
			public void actionPerformed(ActionEvent e) {
				dispose(); //login fenster schließen
				Register.main(null); //main window öffnen
				
			}
		});
		btnNewButton.setBounds(277, 166, 95, 37);
		btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				  if(e.getKeyCode() == KeyEvent.VK_ENTER){ //login mit enter key
					login();  
				  }
				  }
							
			}
		);
		txtPassword.setBounds(77, 129, 126, 26);
		contentPane.add(txtPassword);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					login();
					// wenn login geclicekd wurde SQL abfrage ob daten passen --> augelagert in login methode (JJ)
			}
		});
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnLogin.setBounds(83, 166, 95, 37);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnLogin);
		
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
		lblHeadline.setBounds(163, 6, 126, 37);
		contentPane.add(lblHeadline);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("./pic/48.png"));
		//lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("C:\\Users\\Fizzle\\Desktop\\Java Bilder\\72.png")));
		lblNewLabel_2.setBounds(109, -11, 55, 74);
		contentPane.add(lblNewLabel_2);
	}
	
	private void login() {
		String user;
		user = txtUserName.getText();
	
		char[] password = txtPassword.getPassword();
	    String encryptedPassword = "";
	    try {
			encryptedPassword = Password.createhash(password, user);
		} catch (UnsupportedEncodingException e1) {
		
		}
	    
	    if(DB.LoginCheck(user, encryptedPassword) == true) {
	    	dispose();
	    	MainWindow.main(null);
	    }
	    else {
			showMessageDialog(null, "Wrong Username or Password!\nPlease try again!", "Warning", WARNING_MESSAGE);
			txtUserName.setText("");
			txtPassword.setText("");
	    }
	}
}
