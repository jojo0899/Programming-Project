package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Register extends JFrame {
	
	public static boolean isValidEmailAddress(String email1) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email1);
        return m.matches();
 }
	public boolean FieldsOKtest()
    {
       	String username = txtUserName.getText();
        String firstName =  txtFirstName.getText();
        String lastName =   txtLastName.getText();
        String mail =       txtEmail.getText();
        String mailconfirm =  txtemailconfirm.getText();
        String pwd =        txtpw.getText();
        String pwdconfirm =       txtpwconfirm.getText();      

  

        //Trim Whitespace and compare if empty
        if( firstName.trim().equals("") || lastName.trim().equals("") || mail.trim().equals("") || mailconfirm.trim().equals("") 
                || pwd.trim().equals("") || pwdconfirm.trim().equals(""))   
        {
            JOptionPane.showMessageDialog(null, "Please fill all fields!", "Empty Fields",JOptionPane.WARNING_MESSAGE);
            return false;
        }
             
        else if(!isValidEmailAddress(mail)) { //check if its a valid email adress
            JOptionPane.showMessageDialog(null, "Not a correct Email Syntax!", "Email Error",JOptionPane.WARNING_MESSAGE);
            return false;
        	
        }
        else if (!mail.equals(mailconfirm)) //if equal == 1 true
        {
            JOptionPane.showMessageDialog(null, "Email-Addresses don't match!", "Email Error",JOptionPane.WARNING_MESSAGE);
           // int status = 0;
         //   System.exit(status);
            return false;
            
        }
        else if (!pwd.equals(pwdconfirm)) //if equal == 1 true
        {
            JOptionPane.showMessageDialog(null, "Passwords don't match!", "Password Error",JOptionPane.WARNING_MESSAGE);
            return false;
            
        }

        else 
        {
          
//            user.setPassword(pwd); //if passwort is equal set the value inside of the db 
//            user.setFristName(firstName);
//            user.setLastName(lastName);
//            user.setEmail(mail);
//                    
            
           
            return true;
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
	private JTextField txtpw;
	private JTextField txtpwconfirm;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
					Register frame = new Register();
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
	public Register() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblRegistration = new JLabel("Registration");
		LblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		LblRegistration.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		LblRegistration.setBounds(230, 6, 145, 25);
		contentPane.add(LblRegistration);
		
		JLabel LblUserName = new JLabel("UserName:");
		LblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		LblUserName.setBounds(94, 40, 145, 16);
		contentPane.add(LblUserName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(94, 65, 145, 16);
		contentPane.add(lblEmail);
		
		JLabel lblEmailConfirmation = new JLabel("Email Confirmation:");
		lblEmailConfirmation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailConfirmation.setBounds(94, 93, 145, 16);
		contentPane.add(lblEmailConfirmation);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(94, 124, 145, 16);
		contentPane.add(lblPassword);
		
		JLabel lblPasswordConfirmation = new JLabel("Password Confirmation:");
		lblPasswordConfirmation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordConfirmation.setBounds(94, 152, 145, 16);
		contentPane.add(lblPasswordConfirmation);
		
		txtUserName = new JTextField();
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 // No Whitespace in UserName
		        if(Character.isWhitespace(e.getKeyChar())){
		            e.consume();
		        }
			}
		});
		txtUserName.setBounds(251, 35, 128, 26);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 // No Whitespace in Password
		        if(Character.isWhitespace(e.getKeyChar())){
		            e.consume();
		        }
			}
		});
		txtEmail.setBounds(251, 60, 128, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtemailconfirm = new JTextField();
		txtemailconfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 // No Whitespace in emailconfirm
		        if(Character.isWhitespace(e.getKeyChar())){
		            e.consume();
		        }
			}
		});
		txtemailconfirm.setBounds(251, 88, 128, 26);
		contentPane.add(txtemailconfirm);
		txtemailconfirm.setColumns(10);
		
		txtpw = new JTextField();
		txtpw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 // No Whitespace in Password
		        if(Character.isWhitespace(e.getKeyChar())){
		            e.consume();
		        }
			}
		});
		txtpw.setBounds(251, 119, 128, 26);
		contentPane.add(txtpw);
		txtpw.setColumns(10);
		
		txtpwconfirm = new JTextField();
		txtpwconfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 // No Whitespace in PasswordConfirm
		        if(Character.isWhitespace(e.getKeyChar())){
		            e.consume();
		        }
			}
		});
		txtpwconfirm.setBounds(251, 147, 128, 26);
		contentPane.add(txtpwconfirm);
		txtpwconfirm.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(157, 180, 82, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(144, 208, 95, 16);
		contentPane.add(lblLastName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(187, 236, 52, 16);
		contentPane.add(lblGender);
		
		JRadioButton ButtonMale = new JRadioButton("Male");
		buttonGroup.add(ButtonMale);
		ButtonMale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ButtonMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonMale.setSelected(true);
		ButtonMale.setBounds(251, 234, 70, 20);
		contentPane.add(ButtonMale);
		
		JRadioButton ButtonFemale = new JRadioButton("Female");
		buttonGroup.add(ButtonFemale);
		ButtonFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ButtonFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonFemale.setBounds(323, 234, 70, 20);
		contentPane.add(ButtonFemale);
		
		JRadioButton ButtonDiverse = new JRadioButton("Diverse");
		buttonGroup.add(ButtonDiverse);
		ButtonFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ButtonDiverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonDiverse.setBounds(405, 234, 116, 20);
		contentPane.add(ButtonDiverse);
		
		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//only letters
				  if(!Character.isLetter(e.getKeyChar())){
			            e.consume();
			}}
		});
		txtFirstName.setBounds(251, 175, 128, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override //only letters
			public void keyTyped(KeyEvent e) {
				  if(!Character.isLetter(e.getKeyChar())){
			            e.consume();
			}}
		});
		txtLastName.setBounds(251, 203, 128, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//when back is pressed return to main window and close the current one
				Login.main(null);
				dispose();
			}
		});
		BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		BackButton.setBounds(19, 296, 97, 26);
		contentPane.add(BackButton);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        FieldsOKtest(); //Test Function
//		        try {
//					if(FieldsOKtest()) {
//						if(!DoubleEmail()) {
//						CreateConnection();
//						 JOptionPane.showMessageDialog(null, "Thank you for your registration!", "Registration Successful",JOptionPane.PLAIN_MESSAGE);
//				            dispose();
//				            LoginGUI.main(null);
//						}else 
//					 JOptionPane.showMessageDialog(null, "Email already registered", "Registration failed",JOptionPane.WARNING_MESSAGE);
							
//						
//						}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				
				
			}
		});
		RegisterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		RegisterButton.setBounds(474, 296, 97, 26);
		contentPane.add(RegisterButton);
	}
}
