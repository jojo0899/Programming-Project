package Functionalities;

	import java.security.GeneralSecurityException;
import java.util.Properties;

	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	import com.sun.mail.util.MailSSLSocketFactory;

	public class SendMail {
		static String recievermail;
		static String subject;
		static String msg;
		
		public static void registrationMail(String mail, String name) throws GeneralSecurityException {
			SendMail.recievermail = mail;
			SendMail.subject = "BeddelEvent Registrierung";
			msg = "Hi "+name+",\n \nWillkommen im Beddel-Team. Deine Registrierung war erfolgreich!"+
				"\nDu kannst nun anfangen deine eigenen Events zu erstellen und zu managenen. Viel Spaß! :)"+
					"\n\nViel Erfolg\n"+
					"Dein Beddel-Team";
			SendMail.main(null);
			
			
		}
		public static void createEventMail(String mail, String name, String date,String time, String sport, String zip,String city, String street, String hnr, double kosten, int anz) throws GeneralSecurityException {
			SendMail.recievermail = mail;
			SendMail.subject = "Event Erstellung";
			SendMail.msg ="Glückwunsch "+ name+ ", \n"+
						"dein Event wurde erfolgreich erstellt.\n\n\n"+ 
					"Zusammenfassung:\n\n "+
						"Sportart: "+sport+"\n"+
						"Datum: "+date+"\n"+
						"Uhrzeit: "+time+"\n"+
						"Ort: "+zip+" "+city+", "+street+" "+hnr+"\n"+
						"Kosten: "+kosten+"€\n"+
						"Teilnehmerzahl: "+anz+"\n\n\n"+
						"Wir wünschen dir viel spaß! \n\n"+
						"dein Beddel-Team";
			
			SendMail.main(null);
						
		}
		public static void deleteEventMail(String mail,String name, String date, String sport, String place) throws GeneralSecurityException {
			SendMail.recievermail = mail;
			SendMail.subject = "Event Absage";
			SendMail.msg ="Schade "+ name+ ", \n"+
					"deine Teilnahme an folgendem Event wurde abgesagt. \n\n\n "+ 
				"Zusammenfassung: "+
					"Sportart: "+sport+
					"Datum: "+date+"\n"+
					"Ort: "+place+"\n"+
					"\n\n\n"+
					"Wir wünschen dir viel spaß! \n\n"+
					"dein Beddel-Team";;
			
			SendMail.main(null);
			
			
			
			
		}
		public static void participateEventMail(String mail, String name, String date,String time, String sport, String zip,String city, String street, String hnr, double kosten,int anz) throws GeneralSecurityException {
			SendMail.recievermail = mail;
			SendMail.subject = "Event Teilnahme";
			SendMail.msg ="Glückwunsch "+ name+ ", \n"+
					"du hast dich erfolgreich für ein Event eingetragen. \n\n\n"+ 
				"Zusammenfassung: "+"\n"+
					"Sportart: "+sport+"\n"+
					"Datum: "+date+"\n"+
					"Uhrzeit: "+time+"\n"+
					"Ort: "+zip+" "+city+", "+street+" "+hnr+"\n"+
					"Teilneherzahl insg: "+anz+"\n"+
					"Kosten: "+kosten+"€\n\n\n"+					
					"Wir wünschen dir viel spaß! \n\n"+
					"dein Beddel-Team";;
			
			SendMail.main(null);
			
			
		}
		
		
		
	    public static void main(String[] args) throws GeneralSecurityException {
	  
	        String to = SendMail.recievermail;
	        // Mention the Sender's email address
	        String from = "beddelevent@outlook.com";
	        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
	        String host = "smtp-mail.outlook.com";

	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	    // or
	    // sf.setTrustedHosts(new String[] { "my-server" });  

	        // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication("beddelevent@outlook.com", "sabba2021");

	            }

	        });

	        // Used to debug SMTP issues
	       // session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject(SendMail.subject);

	            // Now set the actual message
	            message.setText(SendMail.msg);

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }

	    }

	}

