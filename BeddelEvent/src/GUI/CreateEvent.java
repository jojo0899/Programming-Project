package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.toedter.calendar.JCalendar;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateEvent extends JFrame {


	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtEnterCity;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtTeilnehmerAnz;

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
	 * @throws PropertyVetoException 
	 * @throws ParseException 
	 */
	public CreateEvent() throws PropertyVetoException, ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 554, 324);
		contentPane.add(tabbedPane);
		
		JPanel Sportart = new JPanel();
		tabbedPane.addTab("Sportart", null, Sportart, null);
		Sportart.setLayout(null);
		
		JLabel lblSelectSports = new JLabel("Bitte w\u00E4hle deine Sportart aus:");
		lblSelectSports.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectSports.setBounds(6, 6, 162, 16);
		Sportart.add(lblSelectSports);
		
		JComboBox SelectSports = new JComboBox(); //Sportarten in JcomboBox eintragen
		SelectSports.setModel(new DefaultComboBoxModel(new String[] {"Aerobic", "Badminton", "Ballett", "Baseball", "Basketball", "Bauchtanz", "Beachvolleyball", "Bergsteigen", "Bergwandern", "Billard", "Bodybuilding", "Bogenschie\u00DFen", "Bowling", "Boxen", "Broomball", "Crosstrainer", "Crunches", "Darts", "Dauerlaufen", "Fechten", "Fitnesstraining", "Football", "Fu\u00DFball", "Gehen", "Gewichtheben", "Golf", "Gymnastik", "Hacky Sack", "Handball", "Hockey", "Inline-Skaten", "Jazz/Modern Dance", "Joggen", "Judo", "Kanu fahren", "Karate", "Kinderspiele", "Klettern", "Krafttraining", "Leichtathletik", "Liegest\u00FCtze", "Mountainbiken", "Pilates", "Polo", "Qigong", "Radfahren", "Reiten", "Rollschuhlaufen", "Rudern", "Schlittschuhlaufen", "Schwimmen", "Segeln", "Seilspringen", "Sit-Ups", "Skateboarden", "Skifahren", "Skilanglauf", "Snowboarden", "Softball", "Squash", "Stretching", "Taekwondo", "Tai-Chi", "Tanzen", "Tauchen", "Tennis", "Thai Bo/ Tae Bo", "Tischtennis", "Trampolinspringen", "Volleyball", "Wakeboarden", "Walking", "Wandern", "Wasseraerobic", "Windsurfen", "Yoga"}));
		SelectSports.setBounds(6, 47, 162, 26);
		SelectSports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		Sportart.add(SelectSports);
		
		JButton btnBack = new JButton("Zur\u00FCck");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.main(null);			//Bei click auf zurück das  Mainwindow öffnen
			}
		});
		btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack.setBounds(6, 246, 97, 26);
		Sportart.add(btnBack);
		
		JButton btnNext = new JButton("Weiter");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);				//in nächsten Tab springen
			}
		});
		btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext.setBounds(451, 246, 97, 26);
		Sportart.add(btnNext);
		
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
				tabbedPane.setSelectedIndex(2);		//in nächsten tab springen
			}
		});
		btnNext2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext2.setBounds(451, 248, 97, 26);
		Datum.add(btnNext2);
		
		JButton btnBack2 = new JButton("Zur\u00FCck");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);	//vorherigen tab öffnen
			}
		});
		btnBack2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack2.setBounds(6, 248, 97, 26);
		Datum.add(btnBack2);
		
		 JInternalFrame internalFrame = new JInternalFrame() { //internal jframe für calender erzeugen
	           @Override
	           public void setUI(InternalFrameUI ui) {	//headline für interneal jframe für calender ausblenden
	               super.setUI(ui); // this gets called internally when updating the ui and makes the northPane reappear
	               BasicInternalFrameUI frameUI = (BasicInternalFrameUI) getUI(); // so...
	               if (frameUI != null) frameUI.setNorthPane(null); // lets get rid of it
	           }
	        };
		 internalFrame.setFrameIcon(null);
		 internalFrame.setSelected(true);
		 internalFrame.setBounds(6, 23, 548, 213);
		 Datum.add(internalFrame);
		 internalFrame.setVisible(true);
		 
		 
		 JCalendar Calender = new JCalendar();
		 Date begin=java.util.Calendar.getInstance().getTime(); //nur zukünftige daten in kalender anzeigen
	        
		 Calender.setSelectableDateRange(begin, new SimpleDateFormat("DD.MM.YYYY").parse("12.07.2022")); //nur events 1 Jahr im voraus planbar 
		 Calender.getYearChooser().getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		 Calender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		 internalFrame.getContentPane().add(Calender);
		
		
		
		
		
		JPanel Ort = new JPanel();
		tabbedPane.addTab("Ort", null, Ort, null);
		Ort.setLayout(null);
		
		JLabel lblSelectCity = new JLabel("Trage die Stadt ein");
		lblSelectCity.setBounds(6, 6, 126, 16);
		Ort.add(lblSelectCity);
		
		JButton btnBack3 = new JButton("Zur\u00FCck");
		btnBack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);			//vorherigen tab öffnen
			}
		});
		btnBack3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack3.setBounds(6, 245, 97, 26);
		Ort.add(btnBack3);
		
		JButton btnNext3 = new JButton("Weiter");
		btnNext3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3); //nächsten tab öffnen 
			}
		});
		btnNext3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext3.setBounds(451, 245, 97, 26);
		Ort.add(btnNext3);
		
		txtEnterCity = new JTextField();
		txtEnterCity.setBounds(6, 61, 252, 26);
		Ort.add(txtEnterCity);
		txtEnterCity.setColumns(10);
		
		JPanel Kosten = new JPanel();
		tabbedPane.addTab("Kosten", null, Kosten, null);
		Kosten.setLayout(null);
		
		JLabel lblKosten = new JLabel("Fallen f\u00FCr das Event kosten an?");
		lblKosten.setHorizontalAlignment(SwingConstants.LEFT);
		lblKosten.setBounds(6, 6, 172, 16);
		Kosten.add(lblKosten);
		
		
		
		

		JLabel ShowSliderValue = new JLabel("50"); //slider erstellen mit default value 50€ 
		ShowSliderValue.setHorizontalAlignment(SwingConstants.RIGHT);
		ShowSliderValue.setBounds(242, 99, 52, 16);
		Kosten.add(ShowSliderValue);
		
		JSlider slider = new JSlider();

		slider.setEnabled(false); //slider standardgemäß deaktivieren
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			int val = ((JSlider)e.getSource()).getValue();
			String val2 = Integer.toString(val);
			ShowSliderValue.setText(val2);			//wert des Sliders in textfeld eintragen bei veränderung
			
			}
		});
		slider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		slider.setBounds(188, 67, 200, 20);
		Kosten.add(slider);
		
		
		JRadioButton rdbtnNein = new JRadioButton("nein");
		rdbtnNein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slider.setEnabled(false);				//wenn nein gedrüctk wird slider deaktivierne
				
			}
		});
		rdbtnNein.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		rdbtnNein.setSelected(true);
		buttonGroup.add(rdbtnNein);
		rdbtnNein.setBounds(6, 34, 116, 20);
		Kosten.add(rdbtnNein);
		
		JRadioButton rdbtnJa = new JRadioButton("ja");
		rdbtnJa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slider.setEnabled(true);			//wenn ja ausgewählt wird slider aktivieren
			}
		});
		rdbtnJa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		buttonGroup.add(rdbtnJa); //button group erstellen. Nur euin button kann uasgewählt werden
		rdbtnJa.setBounds(6, 66, 116, 20);
		Kosten.add(rdbtnJa);
		

		
		JLabel lblEuro = new JLabel("\u20AC");
		lblEuro.setBounds(306, 99, 52, 16);
		Kosten.add(lblEuro);
		
		JButton btnBack4 = new JButton("Zur\u00FCck");
		btnBack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);		//nächsten tab öffnen
			}
		});
		btnBack4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack4.setBounds(6, 245, 97, 26);
		Kosten.add(btnBack4);
		
		JButton btnNext4 = new JButton("Weiter");
		btnNext4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4); //<vorherigen tab öffnen
			}
		});
		btnNext4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext4.setBounds(451, 245, 97, 26);
		Kosten.add(btnNext4);
		
		JPanel Teilnehmer = new JPanel();
		tabbedPane.addTab("Teilnehmer", null, Teilnehmer, null);
		Teilnehmer.setLayout(null);
		
		JButton btnBack5 = new JButton("Zur\u00FCck");
		btnBack5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);		//vorherigen tab öffnen
			}
		});
		btnBack5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack5.setBounds(6, 244, 97, 26);
		Teilnehmer.add(btnBack5);
		
		JButton btnNext5 = new JButton("Weiter");
		btnNext5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);		//nächsten tab öffnen
			}
		});
		btnNext5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext5.setBounds(451, 244, 97, 26);
		Teilnehmer.add(btnNext5);
		
		JLabel lblTeilnehmerInfo = new JLabel("Gibt es eine beschr\u00E4nkte Teilnehmerzahl?");
		lblTeilnehmerInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeilnehmerInfo.setBounds(6, 6, 249, 16);
		Teilnehmer.add(lblTeilnehmerInfo);
		
		txtTeilnehmerAnz = new JTextField();
		txtTeilnehmerAnz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		        if(!Character.isDigit(e.getKeyChar())){			//nur zahlen als input in txt feld erlauben
		            e.consume();
		            }
			}
		});
		txtTeilnehmerAnz.setBounds(104, 63, 47, 26);
		Teilnehmer.add(txtTeilnehmerAnz);
		txtTeilnehmerAnz.setColumns(10);
		
		JRadioButton rdbtnTeilnehmerNein = new JRadioButton("nein");
		rdbtnTeilnehmerNein.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTeilnehmerAnz.setEnabled(false);
			}
		});
		buttonGroup_1.add(rdbtnTeilnehmerNein);
		rdbtnTeilnehmerNein.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		rdbtnTeilnehmerNein.setSelected(true);
		rdbtnTeilnehmerNein.setBounds(6, 34, 68, 20);
		Teilnehmer.add(rdbtnTeilnehmerNein);
		
		JRadioButton rdbtnTeilnehmerja = new JRadioButton("ja");
		rdbtnTeilnehmerja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTeilnehmerAnz.setEnabled(true);
			}
		});
		rdbtnTeilnehmerja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		buttonGroup_1.add(rdbtnTeilnehmerja);
		rdbtnTeilnehmerja.setBounds(6, 66, 68, 20);
		Teilnehmer.add(rdbtnTeilnehmerja);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Teilnehmer");
		lblNewLabel_1.setBounds(152, 68, 79, 16);
		Teilnehmer.add(lblNewLabel_1);
		
		JPanel Gemischt = new JPanel();
		tabbedPane.addTab("Gemischt", null, Gemischt, null);
		Gemischt.setLayout(null);
		
		JButton btnBack6 = new JButton("Zur\u00FCck");
		btnBack6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnBack6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBack6.setBounds(6, 245, 97, 26);
		Gemischt.add(btnBack6);
		
		JButton btnNext6 = new JButton("Fertig");
		btnNext6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow.main(null);
			}
		});
		btnNext6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext6.setBounds(451, 245, 97, 26);
		Gemischt.add(btnNext6);
	}
}
