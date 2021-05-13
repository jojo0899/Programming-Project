package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchEventResultList extends JFrame {

	private JPanel contentPane;
	private JTable ResultTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEventResultList frame = new SearchEventResultList();
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
	public SearchEventResultList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ResultTable = new JTable();
		ResultTable.setToolTipText("");
		ResultTable.setBounds(6, 319, 706, -312);
		contentPane.add(ResultTable);
		
		JButton btnSelect = new JButton("Ausw\u00E4hlen");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEventConfirm.main(null);
				
			}
		});
		btnSelect.setBounds(612, 339, 97, 26);
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SearchEvent.main(null);
			}
		});
		btnBack.setBounds(6, 339, 97, 26);
		contentPane.add(btnBack);
	}
}
