package websites;

import org.openqa.selenium.WebDriver;

public class VergePage {

	WebDriver driver;
	public VergePage(WebDriver driver) {
		this.driver = driver;
	}

	String site = "https://www.theverge.com/search?q=";

	public String GetURL() {
		return site;
	}
	
}