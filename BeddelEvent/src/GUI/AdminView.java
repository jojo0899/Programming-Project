package GUI;

import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
		setTitle("Admin View");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1333, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Account Verwaltung");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(6, 6, 424, 42);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 60, 1291, 382);
		contentPane.add(scrollPane);

		JTable table = new JTable();
		table.setRowSelectionAllowed(true);
		table.setShowHorizontalLines(true);
		
		
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
		
		JButton editUserButton = new JButton("User bearbeiten");
		/**
		 * action to edit selected user
		 */
		editUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					String selectedUser = (String) table.getValueAt(table.getSelectedRow(), 0);
					dispose();
					EditUser.main(selectedUser);
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte wähle einen Benutzer aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		editUserButton.setBounds(956, 454, 173, 23);
		contentPane.add(editUserButton);
		
		JButton deleteButton = new JButton("User l\u00F6schen");
		deleteButton.setForeground(Color.RED);
		/**
		 * action to delete selected user
		 */
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int confirm = JOptionPane.showConfirmDialog(null, "Sind Sie sicher, dass Sie diesen User löschen möchten?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
					if (confirm == 0) {
						String selectedUser = (String) table.getValueAt(table.getSelectedRow(), 0);
						DB.deleteUserFromDB(selectedUser);
						refreshTable(table);
						String message = "Der User wurde erfolgreich gelöscht!";
						showMessageDialog(null, message, "Message",WARNING_MESSAGE);
					}
					else return;
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte wähle einen Benutzer aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		deleteButton.setBounds(1138, 454, 169, 23);
		contentPane.add(deleteButton);
		
		JButton btnNewButton = new JButton("Admin View verlassen");
		/**
		 * action to leave admin view and go back to the login dialog
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Sind Sie Sicher, dass Sie die Admin Ansicht verlassen wollen?\nAlle ungespeicherten Änderungen gehen verloren!", "Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
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
		
		JButton psswdUserButton_1 = new JButton("User Passwort \u00E4ndern");
		psswdUserButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					String selectedUser = (String) table.getValueAt(table.getSelectedRow(), 0);
					dispose();
					ChangePassword.main(selectedUser);
				}
				else {
					JOptionPane.showMessageDialog(null, "Bitte wähle einen Benutzer aus!", "Keine Auswahl",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		psswdUserButton_1.setBounds(771, 454, 173, 23);
		contentPane.add(psswdUserButton_1);
	}
	
	public void refreshTable(JTable table) {
		try {
			DB.resultSetToTableModel(table, "user", "", 5);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
