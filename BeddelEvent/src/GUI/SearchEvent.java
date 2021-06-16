package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.toedter.calendar.JCalendar;

import Functionalities.Event;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Toolkit;

public class SearchEvent extends JFrame {


	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtEnterCity;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public static String SearchBefore;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme"); //set look and feel
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEvent frame = new SearchEvent();
					frame.setLocationRelativeTo(null); //fenster in mitte plazieren  
					frame.setResizable(false); //größe nicht anpassbar
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
	public SearchEvent() throws PropertyVetoException, ParseException {
	//	setIconImage(Toolkit.getDefaultToolkit().getImage("./pic/32.png"));
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
		
		JLabel lblSelectSports = new JLabel("Welche Sportart suchst du?");
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
				dispose();
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
				Event.SearchSport =String.valueOf(SelectSports.getSelectedItem());
			}
		});
		btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext.setBounds(451, 246, 97, 26);
		Sportart.add(btnNext);
		
		JButton btnSuchen_2 = new JButton("Suchen");
		btnSuchen_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEvent.SearchBefore = "Sport";
				Event.SearchSport =String.valueOf(SelectSports.getSelectedItem());
				dispose();
				SearchEventResultList.main(null);
				
			}
		});
		btnSuchen_2.setBounds(234, 246, 97, 26);
		Sportart.add(btnSuchen_2);
		
		JPanel Datum = new JPanel();
		tabbedPane.addTab("Datum", null, Datum, null);
		Datum.setLayout(null);
		
		JLabel lblSelectDatum = new JLabel("W\u00E4hle das Datum: ");
		lblSelectDatum.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectDatum.setBounds(6, 6, 117, 16);
		Datum.add(lblSelectDatum);
		

		
		
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
		
		
			JButton btnNext2 = new JButton("Weiter");
			btnNext2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(2);		//in nächsten tab springen
					Event.SearchDate = CreateEvent.getDateAsString(Calender.getDayChooser().getDay(), Calender.getMonthChooser().getMonth()+1, Calender.getYearChooser().getYear()); 
				}
			});
			btnNext2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			btnNext2.setBounds(451, 248, 97, 26);
			Datum.add(btnNext2);
			
			JButton btnSuchen = new JButton("Suchen");
			btnSuchen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						SearchEvent.SearchBefore="Datum";
						Event.SearchDate = CreateEvent.getDateAsString(Calender.getDayChooser().getDay(), Calender.getMonthChooser().getMonth()+1, Calender.getYearChooser().getYear()); 
						dispose();
						SearchEventResultList.main(null);
					
				}
			});
			btnSuchen.setBounds(226, 248, 97, 26);
			Datum.add(btnSuchen);
		
		JPanel Ort = new JPanel();
		tabbedPane.addTab("Ort", null, Ort, null);
		Ort.setLayout(null);
		
		JLabel lblSelectCity = new JLabel("Wo suchst du?");
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
		

		
		txtEnterCity = new JTextField();
		txtEnterCity.setBounds(6, 61, 252, 26);
		Ort.add(txtEnterCity);
		txtEnterCity.setColumns(10);
		
		JButton btnNext3 = new JButton("Weiter");
		btnNext3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtEnterCity.getText().equals("")) {
					Event.Searchcity = txtEnterCity.getText();
					tabbedPane.setSelectedIndex(3); //nächsten tab öffnen 
				}else {
					JOptionPane.showMessageDialog(null, "Fülle trage eine Stadt ein!", "Eingabe Error",JOptionPane.WARNING_MESSAGE);

				}}
		});
		btnNext3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext3.setBounds(451, 245, 97, 26);
		Ort.add(btnNext3);
		
		JButton btnSuchen_1 = new JButton("Suchen");
		btnSuchen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtEnterCity.getText().equals("")) {
				SearchEvent.SearchBefore = "Ort";
				Event.Searchcity = txtEnterCity.getText();
				dispose();
				SearchEventResultList.main(null);
				}else {
					JOptionPane.showMessageDialog(null, "Fülle trage eine Stadt ein!", "Eingabe Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSuchen_1.setBounds(225, 245, 97, 26);
		Ort.add(btnSuchen_1);
		
		JPanel Kosten = new JPanel();
		tabbedPane.addTab("Kosten", null, Kosten, null);
		Kosten.setLayout(null);
		
		JLabel lblKosten = new JLabel("D\u00FCrfen Kosten f\u00FCr das Event anfallen?");
		lblKosten.setHorizontalAlignment(SwingConstants.LEFT);
		lblKosten.setBounds(6, 6, 236, 16);
		Kosten.add(lblKosten);
		
		
		
		

		JLabel ShowSliderValue = new JLabel("25"); //slider erstellen mit default value 50€ 
		ShowSliderValue.setHorizontalAlignment(SwingConstants.RIGHT);
		ShowSliderValue.setBounds(242, 99, 52, 16);
		Kosten.add(ShowSliderValue);
		
		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setValue(25);
		
		slider.setMaximum(50);

		slider.setEnabled(false); //slider standardgemäß deaktivieren
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
					int val = ((JSlider)e.getSource()).getValue();
					String val2 = Integer.toString(val);
					Event.SearchKosten = (double) val;
					ShowSliderValue.setText(val2);			//wert des Sliders in textfeld eintragen bei veränderung
						//wert des Sliders in textfeld eintragen bei veränderung
				
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
				Event.SearchKosten = 25;
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
		
		JButton btnNext4 = new JButton("Fertig");
		btnNext4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNein.isSelected()) {
				Event.Kosten=0.00;	
				}
				
				dispose();
				SearchEventResultList.main(null);
		
	
				
				
			}
		});
		btnNext4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNext4.setBounds(451, 245, 97, 26);
		Kosten.add(btnNext4);
		
		JLabel lblNewLabel = new JLabel("Max:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(134, 68, 52, 16);
		Kosten.add(lblNewLabel);
		
	
		
	
	}
}
