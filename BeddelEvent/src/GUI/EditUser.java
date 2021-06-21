package GUI;

import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DB;
import Functionalities.Password;
import Functionalities.SendMail;
import Functionalities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class EditUser extends JFrame {
	static char[] password;

	
	

	
	
	/**
	 * Prüfen ob die Email Syntax korrejt ist 
	 * @param email1 eingebene Emailadresse aus register feld 
	 * @return true wenn syntax korrekt
	 */
	public static boolean isValidEmailAddress(String email1) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email1);
        return m.matches();
 }
	/**
	 * Sind alle felder gefüllt und korrekt gefüllt? 
	 * @return true wenn alles passt
	 */
	public boolean FieldsOKtest()
    {
       	User.username = txtUserName.getText(); //information aus texteignabe in vairable storen
        User.firstName =  txtFirstName.getText();
        User.lastName =   txtLastName.getText();
        User.email =       txtEmail.getText();
        
        String mailconfirm =  txtemailconfirm.getText();
        String pwd =        String.valueOf(txtpw.getPassword());
        password = txtpw.getPassword();
        String pwdconfirm = String.valueOf(txtpwconfirm.getPassword());

  

        //leerzeichen nicht möglich und prüft ob felder leer sind
        if(User.firstName.trim().equals("") || User.lastName.trim().equals("") || User.email.trim().equals("") || mailconfirm.trim().equals("") 
                || pwd.trim().equals("") || pwdconfirm.trim().equals(""))   
        { //wenn feld leer ist fehlermeldung ausgeben
            JOptionPane.showMessageDialog(null, "Fülle bitte alle Felder aus!", "Eingabe Error",JOptionPane.WARNING_MESSAGE); //warning message wenn feld leer ist
            return false;
        }
             
        else if(!isValidEmailAddress(User.email)) { //check if its a valid email adress wenn nicht true error ausgeben
            JOptionPane.showMessageDialog(null, "Keine gültige Email-Adresse!", "Email Error",JOptionPane.WARNING_MESSAGE);
            return false;
        	
        }
        else if (!User.email.equals(mailconfirm)) // wenn die mails nicht übereinstimmen fehlermeldung
        {
            JOptionPane.showMessageDialog(null, "Email-Adressen stimmen nicht überein!", "Email Error",JOptionPane.WARNING_MESSAGE);
            return false;
            
        }
        else if (!pwd.equals(pwdconfirm)) //wenn passwörter nicht übereinstimmen fehlermeldung
        {
            JOptionPane.showMessageDialog(null, "Passwörter stimmen nicht überein!", "Password Error",JOptionPane.WARNING_MESSAGE);
            return false;
            
        }

        else 
        {
          
//            user.setPassword(pwd); //if passwort is equal set the value inside of the db 
//            user.setFristName(firstName);
//            user.setLastName(lastName);
//            user.setEmail(mail);
//                    
            
           
            return true; //gibt true zurück wenn alles passt
        }
        
    }
	
	
	//email double check muss hier noch rein
//		public static boolean DoubleEmail() throws SQLException{
//		Connection con=DriverManager.getConnection(  
//				"jdbc:mysql://localhost:3306/user","root","LuiJav");
//		String emailcheck = user.getEmail();
//		
//		Statement stmt=con.createStatement(); 
//		ResultSet rs=stmt.executeQuery("select email FROM users WHERE email ='"+emailcheck+"'"); //ergebnis statement vorbereiten mit sql string  
//
//		if(rs.next()) {
//		con.close();
//			return true;
//		}
//		else{
//			con.close();
//			return false;}
//		
//		
	//}
	

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtEmail;
	private JTextField txtemailconfirm;
	private JPasswordField txtpw;
	private JPasswordField txtpwconfirm;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
					EditUser frame = new EditUser();
					frame.setLocationRelativeTo(null); //fenster in mitte plazieren
					frame.setVisible(true);
					frame.txtUserName.setText(selectedUser);
					frame.txtEmail.setText(DB.getUserDataFromDB(selectedUser, "email"));
					frame.txtemailconfirm.setText(DB.getUserDataFromDB(selectedUser, "email"));
					frame.txtFirstName.setText(DB.getUserDataFromDB(selectedUser, "vorname"));
					frame.txtLastName.setText(DB.getUserDataFromDB(selectedUser, "nachname"));
					// geschlecht und passwort muss noch gefüllt werden
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditUser() {
		setTitle("User editieren");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblBearbeiten = new JLabel("User Daten bearbeiten");
		LblBearbeiten.setHorizontalAlignment(SwingConstants.CENTER);
		LblBearbeiten.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		LblBearbeiten.setBounds(165, 6, 283, 25);
		contentPane.add(LblBearbeiten);
		
		JLabel LblUserName = new JLabel("Benutzername:");
		LblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		LblUserName.setBounds(94, 40, 145, 16);
		contentPane.add(LblUserName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(94, 65, 145, 16);
		contentPane.add(lblEmail);
		
		JLabel lblEmailConfirmation = new JLabel("Email bestätigen:");
		lblEmailConfirmation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailConfirmation.setBounds(94, 93, 145, 16);
		contentPane.add(lblEmailConfirmation);
		
		JLabel lblPassword = new JLabel("Passwort:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(94, 124, 145, 16);
		contentPane.add(lblPassword);
		
		JLabel lblPasswordConfirmation = new JLabel("Passwort bestätigen:");
		lblPasswordConfirmation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordConfirmation.setBounds(94, 152, 145, 16);
		contentPane.add(lblPasswordConfirmation);
		
		txtUserName = new JTextField();
		txtUserName.setEditable(false);
		txtUserName.setEnabled(false);
		txtUserName.addKeyListener(new KeyAdapter() { //wenn etwas getippt wurde
			@Override
			public void keyTyped(KeyEvent e) {
				 if(Character.isWhitespace(e.getKeyChar())){ //lässt keine leerzeicghen zu
		            e.consume();
		        }
			}
		});
		txtUserName.setBounds(251, 35, 128, 26);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() { //wenn etwas getippt wurde
			@Override
			public void keyTyped(KeyEvent e) {
				 
		        if(Character.isWhitespace(e.getKeyChar())){ //lässt keine leerzeicghen zu
		            e.consume();
		        }
			}
		});
		txtEmail.setBounds(251, 60, 128, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtemailconfirm = new JTextField();
		txtemailconfirm.addKeyListener(new KeyAdapter() { //wenn etwas getippt wurde
			@Override
			public void keyTyped(KeyEvent e) {
				 if(Character.isWhitespace(e.getKeyChar())){// lässt keine leerzeichen zu
		            e.consume();
		        }
			}
		});
		txtemailconfirm.setBounds(251, 88, 128, 26);
		contentPane.add(txtemailconfirm);
		txtemailconfirm.setColumns(10);
		
		txtpw = new JPasswordField();
		txtpw.setBounds(251, 119, 128, 26);
		contentPane.add(txtpw);
		txtpw.setColumns(10);
		
		txtpwconfirm = new JPasswordField();
		txtpwconfirm.setBounds(251, 147, 128, 26);
		contentPane.add(txtpwconfirm);
		txtpwconfirm.setColumns(10);
		
		JLabel lblFirstName = new JLabel("Vorname: ");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(157, 180, 82, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Nachname:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(144, 208, 95, 16);
		contentPane.add(lblLastName);
		
		JLabel lblGender = new JLabel("Geschlecht:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(132, 236, 107, 16);
		contentPane.add(lblGender);
		
		JRadioButton ButtonMale = new JRadioButton("Männlich");
		buttonGroup.add(ButtonMale);
		ButtonMale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //Handcursor beim hoovern
		ButtonMale.addActionListener(new ActionListener() { //wenn button male gedrückt wurde
			public void actionPerformed(ActionEvent e) {
				User.gender = "M";
			}
		});
		ButtonMale.setSelected(true); //standardgemä´t male aktivieren
		ButtonMale.setBounds(251, 234, 107, 20);
		contentPane.add(ButtonMale);
		
		JRadioButton ButtonFemale = new JRadioButton("Weiblich");
		buttonGroup.add(ButtonFemale);
		ButtonFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //handcursor beim hoovern
		ButtonFemale.addActionListener(new ActionListener() { //wenn female button gedrückt wurde
			public void actionPerformed(ActionEvent e) {
				User.gender = "W";
			}
		});
		ButtonFemale.setBounds(342, 234, 106, 20);
		contentPane.add(ButtonFemale);
		
		JRadioButton ButtonDiverse = new JRadioButton("Divers");
		buttonGroup.add(ButtonDiverse);
		ButtonFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); //handucrsor beim hoovern
		ButtonDiverse.addActionListener(new ActionListener() { //wenn Divers gedrückt wurde
			public void actionPerformed(ActionEvent e) {
				User.gender = "X";
		
			}
		});
		ButtonDiverse.setBounds(424, 234, 116, 20);
		contentPane.add(ButtonDiverse);
		
		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() { //wenn etwas getippt wurde
			@Override
			public void keyTyped(KeyEvent e) {
				  if(!Character.isLetter(e.getKeyChar())){ //lässt nur Buchstaben zu
			            e.consume();
			}}
		});
		txtFirstName.setBounds(251, 175, 128, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() { //wenn etas getippt wurde
			@Override //only letters
			public void keyTyped(KeyEvent e) { //
				  if(!Character.isLetter(e.getKeyChar())){ //lässt nur buchstaben zu
			            e.consume();
			}}
		});
		txtLastName.setBounds(251, 203, 128, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JButton BackButton = new JButton("Zurück");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BackButton.setBounds(19, 296, 97, 26);
		contentPane.add(BackButton);
		
		JButton SpeichernButton = new JButton("Speichern");
		SpeichernButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        FieldsOKtest(); //Test Function
		        	        
		    	if(FieldsOKtest()) {
		    		
		    		try {
		    			User.passwort = Password.createhash(password, User.username);
					} catch (UnsupportedEncodingException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

	    			//DB.InsertDataIntoUser(User.username, User.firstName, User.lastName, User.gender, User.email, User.passwort);
		    		// Update Methode hier aufrufen!
		    		DB.UpdateUser(User.username, User.firstName, User.lastName, User.gender, User.email, User.passwort);
		    		
		    		
		    		//						if(!DoubleEmail()) {
//						CreateConnection();
		    		
		    		//DB.DB.InsertDataIntoUser(username, firstName,lastName, gender,email );
					JOptionPane.showMessageDialog(null, "Die Änderungen wurden erfolgreich übernommen!", "Speichern erfolgreich",JOptionPane.PLAIN_MESSAGE);
				    dispose();
				        
//						}else 
//					 JOptionPane.showMessageDialog(null, "Email already registered", "Registration failed",JOptionPane.WARNING_MESSAGE);
							
//						
						}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				
				
			}});
		
		SpeichernButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		SpeichernButton.setBounds(455, 296, 116, 26);
		contentPane.add(SpeichernButton);
	}
}

