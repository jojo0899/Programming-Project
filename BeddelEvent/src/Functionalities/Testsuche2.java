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
		System.out.println(fin);
		
		//System.out.println(latuser);
		//System.out.println(ausgabe);
	}
	public static String checkAddress(String address) {
		address= address.replace("ä", "ae").replace("ö", "oe").replace("ü", "ue").replace("ß", "ss").replace("Ã", "ss");
			return address;
	}	
}
