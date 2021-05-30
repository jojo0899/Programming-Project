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
import java.awt.Toolkit;

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
					frame.setResizable(false); //größe nicht anpassbar
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
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
		
		JLabel lblSports = new JLabel("Sportart:");
		lblSports.setBounds(24, 48, 78, 16);
		contentPane.add(lblSports);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(24, 76, 52, 16);
		contentPane.add(lblOrt);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(24, 104, 52, 16);
		contentPane.add(lblDatum);
		
		JLabel lblKOstne = new JLabel("Kosten:");
		lblKOstne.setBounds(24, 132, 78, 16);
		contentPane.add(lblKOstne);
		
		JButton btnZurueck= new JButton("Zurück");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on zurück
				dispose(); //fenster schließen
				SearchEventResultList.main(null); //Vorheriges fenster öffnen
			}
		});
		btnZurueck.setBounds(6, 215, 97, 26);
		contentPane.add(btnZurueck);
		
		JButton btnBestÃ¤tigen = new JButton("Bestätigen");
		btnBestÃ¤tigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on bestätigen
				dispose(); //fenster schließen 
				MainWindow.main(null); //main fenster öffnen
				
			}
		});
		btnBestÃ¤tigen.setBounds(331, 215, 97, 26);
		contentPane.add(btnBestÃ¤tigen);
		
		JLabel lblSports2 = new JLabel("");
		lblSports2.setBounds(114, 48, 52, 16);
		contentPane.add(lblSports2);
		
		JLabel lblOrt2 = new JLabel("");
		lblOrt2.setBounds(114, 76, 52, 16);
		contentPane.add(lblOrt2);
		
		JLabel lblDatum2 = new JLabel("");
		lblDatum2.setBounds(114, 104, 52, 16);
		contentPane.add(lblDatum2);
		
		JLabel lblKosten2 = new JLabel("");
		lblKosten2.setBounds(114, 132, 52, 16);
		contentPane.add(lblKosten2);
	}
}
