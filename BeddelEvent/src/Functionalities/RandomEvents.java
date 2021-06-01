package Functionalities;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEvents {
	public static String randomSport() {
		final String[] Sportart= {"Aerobic", "Badminton", "Ballett", "Baseball", "Basketball", "Bauchtanz", "Beachvolleyball", "Bergsteigen", "Bergwandern", "Billard", "Bodybuilding", "Bogenschie\u00DFen", "Bowling", "Boxen", "Broomball", "Crosstrainer", "Crunches", "Darts", "Dauerlaufen", "Fechten", "Fitnesstraining", "Football", "Fu\u00DFball", "Gehen", "Gewichtheben", "Golf", "Gymnastik", "Hacky Sack", "Handball", "Hockey", "Inline-Skaten", "Jazz/Modern Dance", "Joggen", "Judo", "Kanu fahren", "Karate", "Kinderspiele", "Klettern", "Krafttraining", "Leichtathletik", "Liegest\u00FCtze", "Mountainbiken", "Pilates", "Polo", "Qigong", "Radfahren", "Reiten", "Rollschuhlaufen", "Rudern", "Schlittschuhlaufen", "Schwimmen", "Segeln", "Seilspringen", "Sit-Ups", "Skateboarden", "Skifahren", "Skilanglauf", "Snowboarden", "Softball", "Squash", "Stretching", "Taekwondo", "Tai-Chi", "Tanzen", "Tauchen", "Tennis", "Thai Bo/ Tae Bo", "Tischtennis", "Trampolinspringen", "Volleyball", "Wakeboarden", "Walking", "Wandern", "Wasseraerobic", "Windsurfen", "Yoga"};
		Random random = new Random();
		int index = random.nextInt(Sportart.length);
		return Sportart[index];
		}
	public static String randomCity() {
		final String[] City= {"Berlin",	"Hamburg",	"München",	"Köln",	"Frankfurt am Main",	"Stuttgart",	"Düsseldorf",	"Leipzig",	"Dortmund",	"Essen",	"Bremen",	"Dresden",	"Hannover",	"Nürnberg",	"Duisburg",	"Bochum",	"Wuppertal",	"Bielefeld",	"Bonn",	"Münster",	"Karlsruhe",	"Mannheim",	"Augsburg",	"Wiesbaden",	"Mönchen­gladbach",	"Gelsenkirchen",	"Braunschweig",	"Aachen",	"Kiel",	"Chemnitz",	"Halle (Saale)",	"Magdeburg",	"Freiburg im Breisgau",	"Krefeld",	"Mainz",	"Lübeck",	"Erfurt",	"Oberhausen",	"Rostock",	"Kassel",	"Hagen",	"Saarbrücken",	"Potsdam",	"Hamm",	"Ludwigshafen am Rhein",	"Mülheim an der Ruhr",	"Oldenburg (Oldb)",	"Osnabrück",	"Leverkusen",	"Heidelberg",	"Darmstadt",	"Solingen",	"Herne",	"Neuss",	"Regensburg",	"Paderborn",	"Ingolstadt",	"Offenbach am Main",	"Fürth",	"Würzburg",	"Ulm",	"Heilbronn",	"Pforzheim",	"Wolfsburg",	"Göttingen",	"Bottrop",	"Reutlingen",	"Koblenz",	"Bremer­haven",	"Erlangen",	"Bergisch Gladbach",	"Trier",	"Recklinghausen",	"Jena",	"Remscheid",	"Salzgitter",	"Moers",	"Siegen",	"Hildesheim",	"Gütersloh",	"Kaiserslautern"};
		Random random = new Random();
		int index = random.nextInt(City.length);
		return City[index];
		}
	public static int randomAnz() {
		final int[] Anz= {0,2,4,6,8,10,0,12,0,14,16,18,20,0,22,24,26};
		Random random = new Random();
		int index = random.nextInt(Anz.length);
		return Anz[index];
		}
	public static double randomKosten() {
		final double[] Kosten= {0.00,15.00,0.00,5.00,0.00,2.00,0.00,6.00,8.00,0.00,10.00,0.00,4.00,};
		Random random = new Random();
		int index = random.nextInt(Kosten.length);
		return Kosten[index];
		}
	
	public static String randomDate() {
		  LocalDate startDate = LocalDate.of(2021, 5, 15); //start date
		     long start = startDate.toEpochDay();
		    LocalDate endDate = LocalDate.of(2022, 5, 15); //end date
		    long end = endDate.toEpochDay();
		    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
		 		    
		    LocalDate date1 = LocalDate.ofEpochDay(randomEpochDay);
		    String date2 = date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		    
		    
		    
		    return date2.toString();
		
	}
	
	@SuppressWarnings("deprecation")
	public static String randomTime() {
		
	int beginH = 8;
	int endH = 23;
	int beginM = 0;
	int endM = 59;
	SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	Random r = new Random();
	int resultH = r.nextInt(endH-beginH)+beginH;
	int resultM = r.nextInt(endM-beginM)+beginM;
	
	
	Date d1 = new Date();
	 d1.setHours(resultH);
	 d1.setMinutes(resultM);
	 
	 String dateString = format.format(d1);
	 	    
		    
		    return dateString;
		
	}
	public static String randomUser() {
		final String[] User= {"Schatzmeister3","SibilleStein32","MrSlave44","Sigmund_XoXo","MiguelMetropolis","MariaUrukhai","McLovin","SadCowboy"};
		Random random = new Random();
		int index = random.nextInt(User.length);
		return User[index];
		}
	
	
public static void main(String[] args) {
	System.out.println(randomSport());
	System.out.println(randomDate());
	System.out.println(randomCity());
	System.out.println(randomAnz());
	System.out.println(randomKosten());
	System.out.println(randomTime());
//	for(int i =0;i<400;i++) {
//		DB.DB.InsertDataIntoEvent(randomSport(), randomDate(),randomTime(),randomCity(),randomAnz(),randomKosten(),randomUser());
//	}
}






}
