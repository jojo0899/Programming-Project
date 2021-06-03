package Functionalities;

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
		if(splitted.length==8) {
		if(isNumeric(splitted[0])) {
			System.out.println("ist nummer");
			hnr =splitted[0].trim();
			street=splitted[1];
			city =splitted[4];
			zip =splitted[6];
			
		}}else if(splitted.length>8) {
			zip = splitted[splitted.length-2];
			city= splitted[splitted.length-4];
			street= splitted[splitted.length-7];
			hnr = splitted[0];		
			
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
