package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchEventConfirm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //set look anbd feel
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEventConfirm frame = new SearchEventConfirm();
					frame.setVisible(true);
					frame.setResizable(false); //gr��e nicht anpassbar
					frame.setLocationRelativeTo(null); //Fenster in mitte plazieren
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEventConfirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Zusammenfassung");
		lblHeadline.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setBounds(114, 6, 168, 25);
		contentPane.add(lblHeadline);
		
		JLabel lblSports = new JLabel("Sportart");
		lblSports.setBounds(24, 48, 78, 16);
		contentPane.add(lblSports);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setBounds(24, 76, 52, 16);
		contentPane.add(lblOrt);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(24, 104, 52, 16);
		contentPane.add(lblDatum);
		
		JLabel lblKOstne = new JLabel("Kosten");
		lblKOstne.setBounds(24, 132, 78, 16);
		contentPane.add(lblKOstne);
		
		JLabel lblGeschlechter = new JLabel("Geschlechter");
		lblGeschlechter.setBounds(24, 160, 78, 16);
		contentPane.add(lblGeschlechter);
		
		JButton btnZur�ck = new JButton("Zur\u00FCck");
		btnZur�ck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on zur�ck
				dispose(); //fenster schlie�en
				SearchEventResultList.main(null); //Vorheriges fenster �ffnen
			}
		});
		btnZur�ck.setBounds(6, 215, 97, 26);
		contentPane.add(btnZur�ck);
		
		JButton btnBest�tigen = new JButton("Best\u00E4tigen");
		btnBest�tigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on best�tigen
				dispose(); //fenster schlie�en 
				MainWindow.main(null); //main fenster �ffnen
				
			}
		});
		btnBest�tigen.setBounds(331, 215, 97, 26);
		contentPane.add(btnBest�tigen);
	}
}
