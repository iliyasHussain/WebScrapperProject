package websites;

import org.openqa.selenium.WebDriver;


public class TheNextWebPage {
	
	WebDriver driver;
	public TheNextWebPage(WebDriver driver) {
		this.driver = driver;
	}
	
	String site = "https://thenextweb.com/?q=";
		
	public String GetURL() {
		return site;
	}
}
