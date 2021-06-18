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
import javax.swing.JTextArea;

public class CreateEventConfirm extends JFrame {

	private JPanel contentPane;
	String  TeilnAsString;
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
		lblDatum.setBounds(24, 131, 52, 16);
		contentPane.add(lblDatum);
		
		JLabel lblKOstne = new JLabel("Kosten");
		lblKOstne.setBounds(24, 187, 78, 16);
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
				DB.DB.InsertDataIntoEvent(Event.Sport, Event.Date, Event.Time, Event.zip,Event.city,Event.street,Event.hnr, Event.Anz, Event.Kosten, User.username,Event.xval,Event.yval);
				DB.DB.getEventID(Event.Sport, Event.Date, Event.Time, Event.zip,Event.city,Event.street,Event.hnr, Event.Anz, Event.Kosten, User.username,Event.xval,Event.yval);
				DB.DB.InsertDataIntoParticipate_on(User.username, Event.id);
				dispose(); //fenster schließen 
				MainWindow.main(null); //main fenster öffnen
				try {
					SendMail.createEventMail(User.email, User.username, Event.Date,Event.Time, Event.Sport, Event.zip,Event.city, Event.street,Event.hnr, Event.Kosten, Event.Anz);
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
		
		JLabel lblDatum2 = new JLabel(Event.Date);
		lblDatum2.setBounds(114, 131, 232, 16);
		contentPane.add(lblDatum2);
		
		String KstAsString;
		if(Event.Kosten==0.00) {
			KstAsString = "kostenlos";
		}else {
			KstAsString = Double.toString(Event.Kosten);
			}
		JLabel lblKosten2 = new JLabel(KstAsString);
		lblKosten2.setBounds(114, 187, 232, 16);
		contentPane.add(lblKosten2);
		
		JLabel lblAnzteil = new JLabel("Teilnehmer: ");
		lblAnzteil.setBounds(268, 187, 78, 16);
		contentPane.add(lblAnzteil);
		
		String TeilnAsString;
		if(Event.Anz==0) {
			TeilnAsString = "keine Beschärnkung";
		}else {
			TeilnAsString = Integer.toString(Event.Anz);
		}
		JLabel lblAnzteil2 = new JLabel(TeilnAsString);
		lblAnzteil2.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnzteil2.setBounds(342, 187, 86, 16);
		contentPane.add(lblAnzteil2);
		
		JLabel lblUhrzeit = new JLabel("Uhrzeit");
		lblUhrzeit.setBounds(24, 159, 52, 16);
		contentPane.add(lblUhrzeit);
		
		JLabel lblUhrzeit2 = new JLabel(Event.Time);
		lblUhrzeit2.setBounds(114, 159, 232, 16);
		contentPane.add(lblUhrzeit2);
		
		JTextArea textArea = new JTextArea(Event.zip+" "+Event.city+"\n"+Event.street+" "+Event.hnr);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(114, 74, 314, 45);
		contentPane.add(textArea);
	}
}
