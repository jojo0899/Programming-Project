package Functionalities;
//test
import java.util.Map;

public class Testsuche2 {

	public static void convert(String adresse) {
//	public static void main(String[] args) {
		
				
		String address = adresse;
		String result;
		String hnr = null;
		String street= null;
		String city= null ;
		String zip = null;
		TestSuche test = new TestSuche();

		Map<String, String> coords;
		
		coords=test.getCoordinates(address);
		
		result=coords.get("Fullname");
		
		
		String fin = checkAddress(result);


		String[] splitted = fin.split(",");
		
		if(isNumeric(splitted[0])) {
			if(splitted.length==8) {
			System.out.println("ist nummer");
			hnr =splitted[0].trim();
			street=splitted[1].trim();
			city =splitted[3].trim();
			zip =splitted[6].trim();
			
		}else {
			System.out.println(splitted.toString());
			zip = splitted[splitted.length-2].trim();
			city= splitted[3].trim();
			street= splitted[1].trim();
			hnr = splitted[0].trim();		
			
		}}else {
			hnr =splitted[1].trim();
			street=splitted[2].trim();
			city =splitted[4].trim();
			zip =splitted[splitted.length-2].trim();
		}
		
		
		
		

//		
		Event.hnr = hnr;
		Event.street = street;
		Event.city = city;
		Event.zip = zip;
		
	}
	public static String checkAddress(String address) {
		address= address.replace("ä", "ae").replace("ö", "oe").replace("ü", "ue").replace("ß", "ss").replace("Ã¶","ö").replace("Ã", "ss");
			return address;
	}
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	

}
