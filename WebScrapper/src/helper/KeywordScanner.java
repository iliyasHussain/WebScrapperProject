package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeywordScanner {
	WebDriver driver;
	HashSet<String> URL = new HashSet<String>();	
	public KeywordScanner(WebDriver driver) {
		this.driver=driver;
	}
	public void Count(String key) {

		//new code
		List<WebElement> links = driver.findElements(By.partialLinkText(key));
		if(links.size()==1)
		{
			URL.add(links.get(0).getAttribute("href"));

		}
		else
		{
			for(int i=0;i<links.size();i++)
			{

				URL.add(links.get(i).getAttribute("href"));
			}
		}
	}
	
	HashSet<String> UnikURL = new HashSet<String>();
	Date date = new Date();
	String date1 = new SimpleDateFormat("yyyy/MM/dd").format(date);
	String date2 = new SimpleDateFormat("MM/d/yyyy").format(date);
	String date3 = new SimpleDateFormat("d/MM/yyyy").format(date);
	String date4 = new SimpleDateFormat("dd/M/yyyy").format(date);
	
	
	public void UniqueLinks(HashSet<String> links) {
		Iterator<String> it = links.iterator();
		while(it.hasNext())
		{
			UnikURL.add(it.next());
		}

		String[] uniqLinks = UnikURL.toArray(new String[UnikURL.size()]);
		int k =0;
		for(int i=0;i<uniqLinks.length;i++){
			if(uniqLinks[i].contains(date1)||uniqLinks[i].contains(date2)||uniqLinks[i].contains(date3)||uniqLinks[i].contains(date4))
			{
				System.out.println(uniqLinks[i] +"\n");
				k++;
			}
		}
		if (k==0) {
			System.out.println("Sorry no new articles found");
		}
		//flush the set to remove already printed links 
		UnikURL.clear();
		URL.clear();
	}	
}//end of new code