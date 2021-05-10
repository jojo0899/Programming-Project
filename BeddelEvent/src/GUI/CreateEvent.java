package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateEvent extends JFrame {

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
					CreateEvent frame = new CreateEvent();
					frame.setLocationRelativeTo(null);

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
	public CreateEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 422, 249);
		contentPane.add(tabbedPane);
		
		JPanel Sportart = new JPanel();
		tabbedPane.addTab("Sportart", null, Sportart, null);
		Sportart.setLayout(null);
		
		JLabel lblSelectSports = new JLabel("Bitte w\u00E4hle deine Sportart aus:");
		lblSelectSports.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectSports.setBounds(6, 6, 162, 16);
		Sportart.add(lblSelectSports);
		
		JComboBox SelectSports = new JComboBox();
		SelectSports.setModel(new DefaultComboBoxModel(new String[] {"Aerobic", "Badminton", "Ballett", "Baseball", "Basketball", "Bauchtanz", "Beachvolleyball", "Bergsteigen", "Bergwandern", "Billard", "Bodybuilding", "Bogenschie\u00DFen", "Bowling", "Boxen", "Broomball", "Crosstrainer", "Crunches", "Darts", "Dauerlaufen", "Fechten", "Fitnesstraining", "Football", "Fu\u00DFball", "Gehen", "Gewichtheben", "Golf", "Gymnastik", "Hacky Sack", "Handball", "Hockey", "Inline-Skaten", "Jazz/Modern Dance", "Joggen", "Judo", "Kanu fahren", "Karate", "Kinderspiele", "Klettern", "Krafttraining", "Leichtathletik", "Liegest\u00FCtze", "Mountainbiken", "Pilates", "Polo", "Qigong", "Radfahren", "Reiten", "Rollschuhlaufen", "Rudern", "Schlittschuhlaufen", "Schwimmen", "Segeln", "Seilspringen", "Sit-Ups", "Skateboarden", "Skifahren", "Skilanglauf", "Snowboarden", "Softball", "Squash", "Stretching", "Taekwondo", "Tai-Chi", "Tanzen", "Tauchen", "Tennis", "Thai Bo/ Tae Bo", "Tischtennis", "Trampolinspringen", "Volleyball", "Wakeboarden", "Walking", "Wandern", "Wasseraerobic", "Windsurfen", "Yoga"}));
		SelectSports.setBounds(6, 47, 162, 26);
		Sportart.add(SelectSports);
		
		JButton btnNext = new JButton("Weiter");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				
			}
		});
		btnNext.setBounds(319, 172, 97, 26);
		Sportart.add(btnNext);
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.main(null);
				dispose();
			}
		});
		btnBack.setBounds(6, 172, 97, 26);
		Sportart.add(btnBack);
		
		JPanel Datum = new JPanel();
		tabbedPane.addTab("Datum", null, Datum, null);
		Datum.setLayout(null);
		
		JLabel lblSelectDatum = new JLabel("W\u00E4hle das Datum aus:");
		lblSelectDatum.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectDatum.setBounds(6, 6, 117, 16);
		Datum.add(lblSelectDatum);
		
		JButton btnNext2 = new JButton("Weiter");
		btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNext2.setBounds(319, 172, 97, 26);
		Datum.add(btnNext2);
		
		JButton btnBack2 = new JButton("Zur\u00FCck");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack2.setBounds(6, 172, 97, 26);
		Datum.add(btnBack2);
		
		JPanel Ort = new JPanel();
		tabbedPane.addTab("Ort", null, Ort, null);
		
		JPanel Kosten = new JPanel();
		tabbedPane.addTab("Kosten", null, Kosten, null);
		
		JPanel Teilnehmer = new JPanel();
		tabbedPane.addTab("Teilnehmer", null, Teilnehmer, null);
		
		JPanel Gemischt = new JPanel();
		tabbedPane.addTab("Gemischt", null, Gemischt, null);
	}
}
