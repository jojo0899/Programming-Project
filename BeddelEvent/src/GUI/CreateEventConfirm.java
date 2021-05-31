package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.GeneralSecurityException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Functionalities.Event;
import Functionalities.SendMail;
import Functionalities.User;

public class CreateEventConfirm extends JFrame {

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
					CreateEventConfirm frame = new CreateEventConfirm();
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
	public CreateEventConfirm() {
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
		lblKOstne.setBounds(24, 159, 78, 16);
		contentPane.add(lblKOstne);
		
		JButton btnZurueck= new JButton("Zurück");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on zurück
				dispose(); //fenster schließen
				CreateEvent.main(null); //Vorheriges fenster öffnen
			}
		});
		btnZurueck.setBounds(6, 215, 97, 26);
		contentPane.add(btnZurueck);
		
		JButton btnBestÃ¤tigen = new JButton("Bestätigen");
		btnBestÃ¤tigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on bestätigen
				dispose(); //fenster schließen 
				MainWindow.main(null); //main fenster öffnen
				try {
					SendMail.createEventMail(User.email, User.username, Event.Date,Event.Time, Event.Sport, Event.Ort, Event.Kosten, Event.Anz);
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBestÃ¤tigen.setBounds(331, 215, 97, 26);
		contentPane.add(btnBestÃ¤tigen);
		
		JLabel lblSports2 = new JLabel(Event.Sport);
		lblSports2.setBounds(114, 48, 232, 16);
		contentPane.add(lblSports2);
		
		JLabel lblOrt2 = new JLabel(Event.Ort);
		lblOrt2.setBounds(114, 76, 232, 16);
		contentPane.add(lblOrt2);
		
		JLabel lblDatum2 = new JLabel(Event.Date);
		lblDatum2.setBounds(114, 104, 232, 16);
		contentPane.add(lblDatum2);
		
		JLabel lblKosten2 = new JLabel(Event.Kosten);
		lblKosten2.setBounds(114, 159, 232, 16);
		contentPane.add(lblKosten2);
		
		JLabel lblAnzteil = new JLabel("Teilnehmer: ");
		lblAnzteil.setBounds(24, 187, 78, 16);
		contentPane.add(lblAnzteil);
		
		JLabel lblAnzteil2 = new JLabel(Event.Anz);
		lblAnzteil2.setBounds(114, 187, 232, 16);
		contentPane.add(lblAnzteil2);
		
		JLabel lblUhrzeit = new JLabel("Uhrzeit");
		lblUhrzeit.setBounds(24, 131, 52, 16);
		contentPane.add(lblUhrzeit);
		
		JLabel lblUhrzeit2 = new JLabel(Event.Time);
		lblUhrzeit2.setBounds(114, 132, 232, 16);
		contentPane.add(lblUhrzeit2);
	}
}
