package Functionalities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import org.apache.log4j.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TestSuche {
	
	public TestSuche() {
 		BasicConfigurator.configure(); //NEU
 }

/**
 * This function replaces spacial chracters used in adress like ä,ß ü,ö to ensure functioning search results
 * @param address Is the handed over address of the logged in user
 * @return a cleaned address. E.g Herrstraße into Herrstarasse
 */
 private String getRequest(String url) throws Exception {

     final URL obj = new URL(url);
     final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

     con.setRequestMethod("GET");

     int httpCode = con.getResponseCode();
//     System.out.println("HTTP Status Code: "+httpCode);
     if (httpCode != 200)// 200 = OK
     {
         return null;
     }

     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
     
     StringBuffer response = new StringBuffer();
     String inputLine;
     
     while ((inputLine = in.readLine()) != null)
     {
         response.append(inputLine);
//         System.out.println("Inputline: "+inputLine);
     }
     
     in.close();
     
     return response.toString();
 }
 
 

 public Map<String, String> getCoordinates(String address) {
	// address=checkAddress(address);
     Map<String, String> res = new HashMap<String, String>();
     StringBuffer query = new StringBuffer(); //URL mit Adresse
     String[] split = address.split(" ");
     String queryResult = null;     
     
     if (split.length == 0) //Bei fehlender Eingabe
         return null;
     
     query.append("https://nominatim.openstreetmap.org/search.php?format=jsonv2&addressdetails=1&zoom=18&q=");
     for (int i = 0; i < split.length; i++) //fügt adresse mit + statt leerzeichen ein
     {
         query.append(split[i]);
         if (i < (split.length - 1))
             query.append("+");
     }
   //  query.add("&zoom=18");


     try {
         queryResult = getRequest(query.toString());
                   } catch (Exception e) {
        System.out.println("Error when trying to get data with the following query " + query);
     }

//     System.out.println("QueryResult= "+queryResult);
     if (queryResult == null) {
         return null;
     }
     


     Object obj = JSONValue.parse(queryResult);
  
     
     
     if (obj instanceof JSONArray) {
         JSONArray array = (JSONArray) obj;  
                 
         if (array.size() > 0) {
             JSONObject jsonObject = (JSONObject) array.get(0);
          
                      
           
             
            JSONObject req = new JSONObject();
            
            req= (JSONObject) jsonObject.get("address");
            
            if(req.get("road")!=null) {
            	Event.street  =Testsuche2.checkAddress(req.get("road").toString());
            }else if(req.get("road")==null){
            	Event.street =	"";
                }
            
            if(req.get("city")!=null) {
            	Event.city =	Testsuche2.checkAddress(req.get("city").toString());
            }else if(req.get("city")==null) {
            	if(req.get("town")!=null) {
            		Event.city = Testsuche2.checkAddress(req.get("town").toString());
            	}else  if(req.get("village")!=null){
            		Event.city = Testsuche2.checkAddress(req.get("village").toString());
    			}else  if(req.get("hamlet")!=null){
            		Event.city = Testsuche2.checkAddress(req.get("hamlet").toString());
    			}else if(req.get("suburb")!=null) {
            		Event.city = Testsuche2.checkAddress(req.get("suburb").toString());
            	}else {
            				Event.city="";
            	            	}
            }
            	
            	
             	Event.zip =	Testsuche2.checkAddress(req.get("postcode").toString());
             	
             	if(req.get("house_number")!=null) {
                	Event.hnr =	Testsuche2.checkAddress(req.get("house_number").toString());	
             	}else if(req.get("building")!=null) {

                	Event.hnr =	Testsuche2.checkAddress(req.get("building").toString());
             		            		
             	}else if(req.get("leisure")!=null){
             		Event.hnr =	Testsuche2.checkAddress(req.get("leisure").toString());
             		
             		
             	}else if(req.get("amenity")!=null) {
             		Event.hnr =	Testsuche2.checkAddress(req.get("amenity").toString());
             		
             	}           			else if(req.get("highway")!=null){

             		Event.hnr =	Testsuche2.checkAddress(req.get("highway").toString());
             		
             	}else if(req.get("historic")!=null){
             		Event.hnr =	Testsuche2.checkAddress(req.get("historic").toString());
                 		
             	}
             	else	{
             	         		Event.hnr ="";
             	}
             
              
            
             
            String fullname = (String) jsonObject.get("display_name");
             
            res.put("Fullname", fullname);
         

         }
     }

     return res;
 }

// public Map<String, Double> getcity(String address) {
//	// address=checkAddress(address);
//     Map<String, Double> res = new HashMap<String, Double>();
//     StringBuffer query = new StringBuffer(); //URL mit Adresse
//     String[] split = address.split(" ");
//     String queryResult = null;     
//     
// 
//     
////     query.append("https://nominatim.openstreetmap.org/reverse.php?lat=");
////     query.append(xval);
////     query.append("&lon=");
////     query.append(yval);
////     query.append("&zoom=16"); //for street Name //10 für stadt //18 für hnr
////     query.append("&format=jsonv2");     
//     
//     if (split.length == 0) //Bei fehlender Eingabe
//         return null;
//     
//     query.append("https://nominatim.openstreetmap.org/reverse.php?lat=");
//     for (int i = 0; i < split.length; i++) //fügt adresse mit + statt leerzeichen ein
//     {
//         query.append(split[i]);
//         if (i < (split.length - 1))
//             query.append("+");
//     }
//     query.append("&format=jsonv2");     
//     
////     System.out.println("Query: " + query);
//     System.out.println("link: "+ query);
//     
//     try {
//         queryResult = getRequest(query.toString());
//     } catch (Exception e) {
//        System.out.println("Error when trying to get data with the following query " + query);
//     }
//
////     System.out.println("QueryResult= "+queryResult);
//     if (queryResult == null) {
//    	 System.out.println("queryreuslt = null: "+queryResult);
//         return null;
//     }
//
//     Object obj = JSONValue.parse(queryResult);
//
//     if (obj instanceof JSONArray) {
//    	 System.out.println("instance of json array: ");
//         JSONArray array = (JSONArray) obj;
//         if (array.size() > 0) {
//        	 System.out.println("arraysize > 0");
//             JSONObject jsonObject = (JSONObject) array.get(0);
//
//             String std = (String) jsonObject.get("lat");
//             res.put("lat", Double.parseDouble(std));
//
//         }
//     }
//     return res;
// }
}

