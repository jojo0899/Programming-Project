package Functionalities;

import java.util.Map;

public class Testsuche2 {

	public static void main(String[] args) {
		String address = "49.88772243545356 8.615341186523438";
		String latuser;
		String lonuser;
		String adr;
		TestSuche test = new TestSuche();

		Map<String, String> coords;
		
		coords=test.getCoordinates(address);
		
		latuser=coords.get("Fullname");
		System.out.println("TEST: ");
		String fin = checkAddress(latuser);
		String[] splitted = fin.split(",");
		String hnr =splitted[0].replace(" ","");
		String street=splitted[1].replace(" ","");;
		String city =splitted[3].replace(" ","");;
		String zip =splitted[6].replace(" ","");;
		
		System.out.println("hnr: "+hnr);
		System.out.println("street: "+street);
		System.out.println("city: "+city);
		System.out.println("zip: "+zip);
		
		//System.out.println(latuser);
		//System.out.println(ausgabe);
	}
	public static String checkAddress(String address) {
		address= address.replace("ä", "ae").replace("ö", "oe").replace("ü", "ue").replace("ß", "ss").replace("Ã", "ss");
			return address;
	}
	
	

}
