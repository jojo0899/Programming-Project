package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Functionalities.Event;
import Functionalities.SendMail;
import Functionalities.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.GeneralSecurityException;
import java.awt.event.ActionEvent;

public class HistoryView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //look and feel �ndern
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryView frame = new HistoryView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); //fenster in mitte plazieren
					frame.setResizable(false); //gr��e nicht anpassbar
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HistoryView() {
		setTitle("Event informationen");
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
				lblDatum.setBounds(24, 126, 52, 16);
				contentPane.add(lblDatum);
				
				JLabel lblKOstne = new JLabel("Kosten:");
				lblKOstne.setBounds(24, 187, 52, 16);
				contentPane.add(lblKOstne);
				
			
				
				JButton btnBestätigen = new JButton("Per Mail");
				btnBestätigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { //click on best�tigen
						try {
							SendMail.ActiveEventsMail(User.email, User.username, Event.HistoryDate, Event.HistoryTime, Event.HistorySport, Event.HistoryZip,Event.HistoryCity,Event.HistoryStreet,Event.HistoryHnr,Event.HistoryKosten,Event.HistoryAnz);
						} catch (GeneralSecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose(); //fenster schlie�en 
						MainWindow.main(null); //main fenster �ffnen
						
					}
				});
				btnBestätigen.setBounds(331, 215, 97, 26);
				contentPane.add(btnBestätigen);
				
				JButton btnZurueck= new JButton("Zur�ck");
				btnZurueck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { //click on zur�ck
						dispose(); //fenster schlie�en
						HistoryList.main(null); //Vorheriges fenster �ffnen
					}
				});
				btnZurueck.setBounds(6, 215, 97, 26);
				contentPane.add(btnZurueck);
				
				
				JLabel lblSports2 = new JLabel(Event.HistorySport);
				lblSports2.setBounds(114, 48, 314, 16);
				contentPane.add(lblSports2);
				

				JLabel lblDatum2 = new JLabel(Event.HistoryDate);
				lblDatum2.setBounds(114, 126, 314, 16);
				contentPane.add(lblDatum2);
				
				JLabel lblKosten2 = new JLabel(Double.toString(Event.HistoryKosten));
				lblKosten2.setBounds(114, 187, 52, 16);
				contentPane.add(lblKosten2);
				
				JTextArea textArea = new JTextArea(Event.HistoryZip+" "+Event.HistoryCity+"\n"+Event.HistoryStreet+ " "+Event.HistoryHnr);
				textArea.setBounds(114, 74, 314, 40);
				contentPane.add(textArea);
				
				JLabel lblNewLabel = new JLabel("\u20AC");
				lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel.setBounds(77, 187, 18, 16);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Uhrzeit:");
				lblNewLabel_1.setBounds(24, 154, 52, 16);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel(Event.HistoryTime);
				lblNewLabel_2.setBounds(114, 154, 52, 16);
				contentPane.add(lblNewLabel_2);
				
				
				
	}

}
