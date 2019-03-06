package helper;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SimpleSender {
	
	public static void main(String args[]) {
		
			String smtpServer="exchange.amazon.com";
			String to="iliyash@amazon.com";
			String from="iliyash@amazon.com";
			String subject="***Amazon in News Today***";
			String body= "Hi There!!!!";
			send(smtpServer, to, from, subject, body);
		
	}
	public static void send(String smtpServer, String to, String from, String subject, String body) {
		try
		{
			Properties props = System.getProperties();
			// -- Attaching to default Session, or we could start a new one --
			props.put("mail.smtp.host", smtpServer);
			Session session = Session.getDefaultInstance(props, null);
			// -- Create a new message --
			Message msg = new MimeMessage(session);
			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to, false));
			// -- We could include CC recipients too --
			// if (cc != null)
			// msg.setRecipients(Message.RecipientType.CC
			// ,InternetAddress.parse(cc, false));
			// -- Set the subject and body text --
			msg.setSubject(subject);
			msg.setText(body);
			// -- Set some other header information --
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			// -- Send the message --
			Transport.send(msg);
			System.out.println("Message sent OK.");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}