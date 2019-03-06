package websites;

import org.openqa.selenium.WebDriver;

public class FirstPostPage {
	
	WebDriver driver;
	public FirstPostPage(WebDriver driver) {
		this.driver = driver;
	}
	
	String site = "https://www.firstpost.com/search/";
		
	public String GetURL() {
		return site;
	}
}
