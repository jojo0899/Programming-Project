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

import Functionalities.SendMail;

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
		lblKOstne.setBounds(24, 132, 78, 16);
		contentPane.add(lblKOstne);
		
		JLabel lblGeschlechter = new JLabel("Geschlechter");
		lblGeschlechter.setBounds(24, 187, 78, 16);
		contentPane.add(lblGeschlechter);
		
		JButton btnZurueck= new JButton("Zur�ck");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on zur�ck
				dispose(); //fenster schlie�en
				CreateEvent.main(null); //Vorheriges fenster �ffnen
			}
		});
		btnZurueck.setBounds(6, 215, 97, 26);
		contentPane.add(btnZurueck);
		
		JButton btnBestätigen = new JButton("Best�tigen");
		btnBestätigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //click on best�tigen
				dispose(); //fenster schlie�en 
				MainWindow.main(null); //main fenster �ffnen
				try {
					SendMail.createEventMail(DB.DB.email, DB.DB.username, CreateEvent.date, CreateEvent.sports, CreateEvent.place, CreateEvent.costs , CreateEvent.participantsnum);
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBestätigen.setBounds(331, 215, 97, 26);
		contentPane.add(btnBestätigen);
		
		JLabel lblSports2 = new JLabel(CreateEvent.sports);
		lblSports2.setBounds(114, 48, 232, 16);
		contentPane.add(lblSports2);
		
		JLabel lblOrt2 = new JLabel(CreateEvent.place);
		lblOrt2.setBounds(114, 76, 232, 16);
		contentPane.add(lblOrt2);
		
		JLabel lblDatum2 = new JLabel(CreateEvent.date);
		lblDatum2.setBounds(114, 104, 232, 16);
		contentPane.add(lblDatum2);
		
		JLabel lblKosten2 = new JLabel(CreateEvent.costs);
		lblKosten2.setBounds(114, 132, 232, 16);
		contentPane.add(lblKosten2);
		
		JLabel lblGeschlechter2 = new JLabel("New label");
		lblGeschlechter2.setBounds(114, 187, 232, 16);
		contentPane.add(lblGeschlechter2);
		
		JLabel lblAnzteil = new JLabel("Teilnehmer: ");
		lblAnzteil.setBounds(24, 160, 78, 16);
		contentPane.add(lblAnzteil);
		
		JLabel lblAnzteil2 = new JLabel(CreateEvent.participantsnum);
		lblAnzteil2.setBounds(114, 160, 232, 16);
		contentPane.add(lblAnzteil2);
	}
}
