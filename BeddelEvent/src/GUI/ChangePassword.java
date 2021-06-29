package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DB.DB;
import Functionalities.Password;
import Functionalities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String _selectedUser) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //set look and feel
		} catch (Throwable e) {
			e.printStackTrace();
		}
		String selectedUser = _selectedUser;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setLocationRelativeTo(null); //fenster in mitte plazieren
					frame.setVisible(true);
					frame.setVisible(true);
					frame.txtUsername.setText(selectedUser);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(73, 108, 145, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(230, 103, 128, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(230, 131, 128, 26);
		contentPane.add(passwordField_1);
		
		JLabel lblPasswordConfirmation = new JLabel("Passwort best\u00E4tigen:");
		lblPasswordConfirmation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordConfirmation.setBounds(73, 136, 145, 16);
		contentPane.add(lblPasswordConfirmation);
		
		JLabel LblUserName = new JLabel("Benutzername:");
		LblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		LblUserName.setBounds(73, 75, 145, 16);
		contentPane.add(LblUserName);
		
		txtUsername = new JTextField();
		txtUsername.setEnabled(false);
		txtUsername.setEditable(false);
		txtUsername.setColumns(10);
		txtUsername.setBounds(230, 70, 128, 26);
		contentPane.add(txtUsername);
		
		JLabel lblPasswortndern = new JLabel("Passwort \u00E4ndern");
		lblPasswortndern.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswortndern.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblPasswortndern.setBounds(99, 22, 251, 25);
		contentPane.add(lblPasswortndern);
		
		JButton btnNewButton = new JButton("Speichern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = String.valueOf(passwordField.getPassword());
		        String pwdconfirm = String.valueOf(passwordField_1.getPassword());
		        String passwort = "";
		        if (!pwd.equals(pwdconfirm)) {
		            JOptionPane.showMessageDialog(null, "Passwörter stimmen nicht überein!", "Password Error",JOptionPane.WARNING_MESSAGE);
		            return;
		           }
		        else if (pwd.trim().equals("") | pwdconfirm.trim().equals("")) {
		        	JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus!", "Password Error",JOptionPane.WARNING_MESSAGE);
		            return;
		        }
				else {		
					try {
		    			passwort = Password.createhash(passwordField.getPassword(), txtUsername.getText());
					} catch (UnsupportedEncodingException e2) {
						e2.printStackTrace();}
					DB.UpdateUserPassword(txtUsername.getText(), passwort);
					JOptionPane.showMessageDialog(null, "Die Änderungen wurden erfolgreich übernommen!", "Speichern erfolgreich",JOptionPane.PLAIN_MESSAGE);
				    dispose();
				    AdminView.main(null);
				}
				
			}
		});
		btnNewButton.setBounds(275, 222, 101, 27);
		contentPane.add(btnNewButton);
		
		JButton btnZurck = new JButton("Zur\u00FCck");
		btnZurck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminView.main(null);
			}
		});
		btnZurck.setBounds(73, 222, 101, 27);
		contentPane.add(btnZurck);
	}
}
