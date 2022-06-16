package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	
	public static void main(String[] args) throws InterruptedException {
	// create & Delete Lead:
	//1	Launch the browser http://leaftaps.com/opentaps/control/main
	WebDriverManager.chromedriver().setup();
	WebDriver wd=new ChromeDriver();
	wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	wd.manage().window().maximize();
	wd.get("http://leaftaps.com/opentaps/control/main");
	
	  //2	Enter the username
	wd.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("DemoSalesManager");
	
	//3	Enter the password
	wd.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("crmsfa");
	
	//4	Click Login
	//wd.findElement(By.xpath("//input[@value=\"login\"]")).click();
	wd.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	
	//5 Click crm/sfa link
	wd.findElement(By.partialLinkText("CRM")).click();
	
	//	6	Click Leads link
	wd.findElement(By.linkText("Leads")).click();
	
	//7 Click Find leads 91 123456789
	wd.findElement(By.xpath("//a[text()=\"Find Leads\"]")).click();

	//8	Click on Phone
	wd.findElement(By.xpath("//span[text()=\"Phone\"]")).click();
	
	//9	Enter phone number
	wd.findElement(By.xpath("//input[@name=\"phoneNumber\"]")).sendKeys("123456789");
	
	//	10	Click find leads button
	wd.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
	
	Thread.sleep(1000);
	//11	Capture lead ID of First Resulting lead	
	List<WebElement> firstLeadId=wd.findElements(By.xpath("//table[@class=\"x-grid3-row-table\"]/tbody/tr/td[@class=\"x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first \"]/div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a"));
		WebElement firstLead=firstLeadId.get(0);
		String firstId=firstLead.getText();
		System.out.println(firstId);
			
	Thread.sleep(1000);	
	//12	Click First Resulting lead
	firstLead.click();			
	
	//13	Click Delete
	wd.findElement(By.xpath("//div/a[text()=\"Delete\"]")).click();
		
	Thread.sleep(1000);
    //	14	Click Find leads	
	wd.findElement(By.xpath("//a[text()=\"Find Leads\"]")).click();
	
	//15 Enter captured lead ID
	wd.findElement(By.xpath("//input[@name=\"id\"]")).sendKeys(firstId);
	
	//16	Click find leads button
	wd.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
	
	//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	String message=wd.findElement(By.xpath("//div[@class=\"x-paging-info\"]")).getText();
	System.out.println("Message"+message);
	
	//18	Close the browser (Do not log out)
	wd.quit();
}
}
