package helper;

import helper.KeywordScanner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import websites.FirstPostPage;
import websites.TechCrunchPage;
import websites.TheNextWebPage;
import websites.VergePage;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
public class Helper {


	public void FetchKeywords() throws IOException{
		System.setProperty("webdriver.chrome.driver", "Resources/ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\iliyash\\Desktop\\WebScrapper.txt")));
		System.out.println("Hello Folks," +"\n\nBelow websites were scanned for new articel(s) using keywords Amazon, Alexa, Echo, Fire-TV & Fire TV as of: " +dtf.format(now));	
		
		String[] data = {"Amazon","Alexa","Echo","Fire-TV","Fire TV"};
		
		//call base class constructors
		KeywordScanner ks = new KeywordScanner(driver);
		VergePage vp = new VergePage(driver);
		TechCrunchPage tp = new TechCrunchPage(driver);
		TheNextWebPage np = new TheNextWebPage(driver);
		FirstPostPage fp = new FirstPostPage(driver);

		//Iterate through each of the websites
		for(int i=0;i<data.length;i++){
			driver.get(vp.GetURL()+data[i]);
			ks.Count(data[i]);
		}
		System.out.println("\nArticle(s) from Verge.com: ");
		ks.UniqueLinks(ks.URL);

		for(int i=0;i<data.length;i++)
		{
			driver.get(tp.GetURL()+data[i]);
			ks.Count(data[i]);
		}
		System.out.println("\nArticle(s) from Techcrunch.com: ");
		ks.UniqueLinks(ks.URL);

		for(int i=0;i<data.length;i++){
			driver.get(np.GetURL()+data[i]);
			ks.Count(data[i]);
		}
		System.out.println("\nArticle(s) from TheNextWebPage.com: ");
		ks.UniqueLinks(ks.URL);

		for(int i=0;i<data.length;i++){
			driver.get(fp.GetURL()+data[i]);
			ks.Count(data[i]);
		}
		System.out.println("\nArticle(s) from FirstPostPage.com: ");
		ks.UniqueLinks(ks.URL);

		//Append footer to the mail body
		System.out.println("\n\nThanks & Regards," +"\n" +"Iliyas Hussain");

		String smtpServer="exchange.amazon.com";
		String to="iliyash@amazon.com";
		String from="iliyash@amazon.com";
		String cc = "brsri@amazon.com";
		String subject="***Amazon in News Today***";
		StringBuffer sb = new StringBuffer();
		//read WebScrapper.txt file line by line
		FileInputStream fstream = new FileInputStream("C:\\Users\\iliyash\\Desktop\\WebScrapper.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String singleLine;
		while ((singleLine = br.readLine()) != null) {
			sb.append(singleLine + "\n");
		}
		br.close();
		driver.close();
		String allLines = sb.toString();

		Send(smtpServer, to, from, cc, subject, allLines);
	}
	public static void Send(String smtpServer, String to, String from, String cc, String subject, String allLines) {
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
			msg.setRecipients(Message.RecipientType.CC
			 ,InternetAddress.parse(cc, false));
			// -- Set the subject and body text --
			msg.setSubject(subject);
			msg.setText(allLines);
			// -- Set some other header information --
			//msg.setHeader("WebScrapper", "For IN managed team");
			//msg.setSentDate(new Date());
			// -- Send the message --
			Transport.send(msg);

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		Helper h = new Helper();
		h.FetchKeywords();

	}
}