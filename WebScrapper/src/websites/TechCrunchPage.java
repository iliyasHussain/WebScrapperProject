package websites;

import org.openqa.selenium.WebDriver;


public class TechCrunchPage {

	WebDriver driver;
	public TechCrunchPage(WebDriver driver) {
		this.driver = driver;
	}

	String site = "https://techcrunch.com/search/";

	public String GetURL() {

		return site;
	}
}
