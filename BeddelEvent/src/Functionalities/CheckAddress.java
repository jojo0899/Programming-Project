package Functionalities;
//test
import java.util.Map;

public class CheckAddress {

	public static void convert(String adresse) {
//	public static void main(String[] args) {
		
				
		String address = adresse;
		String result;
		String hnr = null;
		String street= null;
		String city= null ;
		String zip = null;
		MapSearch test = new MapSearch();

		Map<String, String> coords;
		
		coords=test.getCoordinates(address);
		
		result=coords.get("Fullname");
		
		
		String fin = checkAddress(result);


//		String[] splitted = fin.split(",");
//		if(splitted.length==8) {
//		if(isNumeric(splitted[0])) {
//			hnr =splitted[0].trim();
//			street=splitted[1].trim();
//			city =splitted[4].trim();
//			zip =splitted[6].trim();
//	
//		}else if(isNumeric(splitted[1])){
//			hnr =splitted[1].trim();
//			street=splitted[2].trim();
//			city =splitted[4].trim();
//			zip =splitted[splitted.length-2].trim();
//		}else {
//			hnr =splitted[0].trim();
//			street=splitted[1].trim();
//			city =splitted[splitted.length-4].trim();
//			zip =splitted[splitted.length-2].trim();
//			
//		}
//		}else	if(splitted.length==7&&!isNumeric(splitted[0])) {
//			hnr ="";
//			street=splitted[0].trim();
//			city =splitted[splitted.length-5].trim();
//			zip =splitted[splitted.length-2].trim();
//			
//		}else if(splitted.length==9 &&!isNumeric(splitted[0])) {
//			
//		}else if(splitted.length==9&&isNumeric(splitted[1])) {
//			hnr =splitted[1];
//			street=splitted[2].trim();
//			city =splitted[splitted.length-5].trim();
//			zip =splitted[splitted.length-2].trim();
//		}
		
		
		
		

//		
//		Event.hnr = hnr;
//		Event.street = street;
//		Event.city = city;
//		Event.zip = zip;

		
	}
	public static String checkAddress(String address) {
		address= address.replace("ä", "\u00e4").replace("Ä", "\u00c4").replace("Ã¶", "\u00f6").replace("Ö", "\u00d6").replace("Ã¼", "\u00fc").replace("Ü","\u00dc").replace("ÃŸ", "\u00df");
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
