package GUI;

import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DB.DB;

public class AdminView extends JFrame {

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
					AdminView frame = new AdminView();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1333, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Account Management");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(6, 6, 424, 42);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 60, 1291, 382);
		contentPane.add(scrollPane);

		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		refreshTable(table);
		
		JButton viewUsersButton = new JButton("Refresh");
		viewUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(table);
			}
		});
		viewUsersButton.setBounds(34, 454, 169, 23);
		contentPane.add(viewUsersButton);
		
		
		
		JButton editUserButton = new JButton("Edit this User\r\n");
		/**
		 * action to edit selected user
		 */
		/*editUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userTable.checkIfUsernameExistsInDB(userSelectionTextField.getText())) {
					EditUserWindow edtu = new EditUserWindow();
					edtu.createEditUserWindow(userSelectionTextField.getText());
				}
				else {
					showMessageDialog(null, "User not found", "Message",WARNING_MESSAGE);
					userSelectionTextField.setText("");
				}
				
			}
		});
		editUserButton.setBounds(954, 501, 173, 23);
		contentPane.add(editUserButton);*/
		
		JButton deleteButton = new JButton("Delete this User");
		deleteButton.setForeground(Color.RED);
		/**
		 * action to delete selected user
		 */
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String userToDelete = userSelectionTextField.getText();
				
				if(userTable.checkIfUsernameExistsInDB(userToDelete)) {
					int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this User?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					if (confirm == 0) {
							userTable.deleteUserFromDB(userToDelete);
							String message = "User " + userToDelete + " succesfully deleted";
							showMessageDialog(null, message, "Message",WARNING_MESSAGE);
							userSelectionTextField.setText("");
					}
					else return;
				}
				else {
					showMessageDialog(null, "User not found", "Message",WARNING_MESSAGE);
					userSelectionTextField.setText("");
				}*/
			}
		});
		deleteButton.setBounds(1138, 501, 169, 23);
		contentPane.add(deleteButton);
		
		JLabel lblNewLabel = new JLabel("Please enter the username of the user you like to edit or delete:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(149, 488, 564, 42);
		contentPane.add(lblNewLabel);
		/*
		userSelectionTextField = new JTextField();
		userSelectionTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userSelectionTextField.setBounds(723, 498, 221, 26);
		contentPane.add(userSelectionTextField);
		userSelectionTextField.setColumns(10);
		*/
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 477, 1307, 12);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Leave Admin View");
		/**
		 * action to leave admin view and go back to the login dialog
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave Admin view?\nAny unsaved Changes won't be saved!", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				if (confirm == 0) {
					dispose();
					Login.main(null);
				}
				else return;
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		btnNewButton.setBounds(1109, 6, 198, 29);
		contentPane.add(btnNewButton);
	}
	
	public void refreshTable(JTable table) {
		try {
			DB.resultSetToTableModel(table, "user", "", 5);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
