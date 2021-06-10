package Functionalities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateCompare {


	public static void main(String[] args) throws ParseException {

		String s = "10.06.2021";
		String e = "09.06.2021";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(((java.util.Date) sdf.parseObject(e)).before(sdf.parse(s)));
		java.util.Date today = java.util.Calendar.getInstance().getTime();
		System.out.println(today);
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		String datum = format.format(today);
		System.out.println(datum);
	}
	public static boolean Datecheck(String DBdate) throws ParseException {
		java.util.Date datum = java.util.Calendar.getInstance().getTime(); //aktuelles datum aber mit uhrzeit 
		//System.out.println(datum);
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy"); // format erstellen 
		String today = format.format(datum); //aktuelles datum formatieren und in String speichern 
		//System.out.println(today);
		 
		  
		 if(((java.util.Date) format.parseObject(DBdate)).before(format.parse(today)) == true) {
			 return true;
		 }
		 else {return false;}
		 
		 
		  
}

}