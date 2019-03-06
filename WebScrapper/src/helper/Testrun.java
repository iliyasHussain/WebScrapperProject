/*package helper;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;

public class Testrun {
	int k=0;
	HashSet<String> UnikURL = new HashSet<String>();
	WebDriver driver;
	
	Date date = new Date();
	String date1 = new SimpleDateFormat("yyyy/MM/dd").format(date);
	String date2 = new SimpleDateFormat("MM/d/yyyy").format(date);
	//String date3 = new SimpleDateFormat("d/MM/yyyy").format(date);
	//String date4 = new SimpleDateFormat("dd/M/yyyy").format(date);
	
	public Testrun(WebDriver driver) {
		this.driver=driver;
	}
	public void UniqueLinks(HashSet<String> links) {
		Iterator<String> it = links.iterator();
		while(it.hasNext())
		{
			UnikURL.add(it.next());
		}

		String[] uniqLinks = UnikURL.toArray(new String[UnikURL.size()]);
		for(int i=0;i<uniqLinks.length;i++){
			if(uniqLinks[i].contains(date1)||uniqLinks[i].contains(date2)||uniqLinks[i].contains("2018/08/07")||uniqLinks[i].contains("2018/8/8"))
			{
				System.out.println(uniqLinks[i] +"\n");
				k++;
			}
		}
		if(k==0)
		{
			System.out.println("Sorry no new articles found");
		}
		//flush the set to remove already printed links 
		UnikURL.clear();
	}
}*/