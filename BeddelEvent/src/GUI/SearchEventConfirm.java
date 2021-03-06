package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Functionalities.Event;
import Functionalities.SendMail;
import Functionalities.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.GeneralSecurityException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
					frame.setResizable(false); //gr??e nicht anpassbar
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
		setTitle("Auswahl best?tigen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchEventConfirm.class.getResource("/images/32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Zusammenfassung");
		lblHeadline.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setBounds(125, 6, 200, 25);
		contentPane.add(lblHeadline);
		
		JLabel lblSports = new JLabel("Sportart:");
		lblSports.setBounds(24, 48, 78, 16);
		contentPane.add(lblSports);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(24, 76, 52, 16);
		contentPane.add(lblOrt);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(24, 126, 52, 16);
		contentPane.add(lblDatum);
		
		JLabel lblKOstne = new JLabel("Kosten:");
		lblKOstne.setBounds(24, 187, 52, 16);
		contentPane.add(lblKOstne);
		
		JButton btnZurueck= new JButton("Zur?ck");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on zur?ck
				dispose(); //fenster schlie?en
				SearchEventResultList.main(null); //Vorheriges fenster ?ffnen
			}
		});
		btnZurueck.setBounds(6, 215, 97, 26);
		contentPane.add(btnZurueck);
		
		JButton btnBestätigen = new JButton("Best?tigen");
		btnBestätigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on best?tigen
				DB.DB.InsertDataIntoParticipate_on(User.username, Event.id);
				DB.DB.DecrementAnzahlplaetze();
				try {
					SendMail.participateEventMail(User.email, User.username, Event.Date, Event.Time, Event.Sport, Event.zip,Event.city,Event.street,Event.hnr,Event.Kosten,Event.Anz);
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose(); //fenster schlie?en 
				MainWindow.main(null); //main fenster ?ffnen
				
			}
		});
		btnBestätigen.setBounds(331, 215, 97, 26);
		contentPane.add(btnBestätigen);
		
		JLabel lblSports2 = new JLabel(Event.SearchSport);
		lblSports2.setBounds(114, 48, 314, 16);
		contentPane.add(lblSports2);
		

		JLabel lblDatum2 = new JLabel(Event.SearchDate);
		lblDatum2.setBounds(114, 126, 314, 16);
		contentPane.add(lblDatum2);
		
		JLabel lblKosten2 = new JLabel(Double.toString(Event.SearchKosten));
		lblKosten2.setBounds(114, 187, 52, 16);
		contentPane.add(lblKosten2);
		
		JTextArea textArea = new JTextArea(Event.Searchzip+" "+Event.Searchcity+"\n"+Event.Searchstreet+ " "+Event.Searchhnr);
		textArea.setBounds(114, 74, 314, 40);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(77, 187, 18, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Uhrzeit:");
		lblNewLabel_1.setBounds(24, 154, 52, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Event.SearchTime);
		lblNewLabel_2.setBounds(114, 154, 52, 16);
		contentPane.add(lblNewLabel_2);
	}
}
