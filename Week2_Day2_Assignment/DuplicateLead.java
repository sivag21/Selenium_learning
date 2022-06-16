package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException
	{
	
		 
		//1	Launch the browser http://leaftaps.com/opentaps/control/main
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver wd=new ChromeDriver(options);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		wd.manage().window().maximize();
		wd.get("http://leaftaps.com/opentaps/control/main");
		
	    // 2-Enter the username
		wd.findElement(By.xpath("//form[@id='login']//input[@id='username']")).sendKeys("DemoSalesManager");
		
	    //3-Enter the password
		wd.findElement(By.xpath("//p/input[@id='password']")).sendKeys("crmsfa");
		
	    //4-Click Login
		wd.findElement(By.xpath("//input[@id='password']/following::input[@value='Login']")).click();
		
		//5	Click crm/sfa link
		wd.findElement(By.xpath("//a[contains(text(),\"CRM/SFA\")]")).click();
		Thread.sleep(500);
		
		//6	Click Leads link
		wd.findElement(By.xpath("//a[contains(text(),\"Leads\")]")).click();
		Thread.sleep(500);
		
		//7	Click Find leads
		wd.findElement(By.xpath("//a[contains(text(),\"Find Leads\")]")).click();
		Thread.sleep(500);
		
		//8	Click on Email
		wd.findElement(By.xpath("//span[contains(text(),\"Email\")]")).click();
		Thread.sleep(500);
		
		//9	Enter Email
		wd.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("kmounika9618@gmail.com");
	
		//10	Click find leads button
		wd.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(500);	
		
		//11	Capture name of First Resulting lead
		List<WebElement> firstLeadList=wd.findElements(By.xpath("//table[@class=\"x-grid3-row-table\"]/tbody/tr/td[@class=\"x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first \"]/div/a[@class=\"linktext\"]"));
		WebElement firstLead=firstLeadList.get(0);
		
		List<WebElement> firstnameList=wd.findElements(By.xpath("//table[@class=\"x-grid3-row-table\"]/tbody/tr/td[@class=\"x-grid3-col x-grid3-cell x-grid3-td-firstName \"]/div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		WebElement firstName=firstnameList.get(0);
		String fstName=firstName.getText();
		
		//12	Click First Resulting lead
		firstLead.click();
		System.out.println(fstName);
		Thread.sleep(1000);
		
		//13	Click Duplicate Lead
		wd.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);
		String title=wd.getTitle();
		System.out.println(title);
		
		//14	Verify the title as 'Duplicate Lead'
		if (title.contains("Duplicate Lead")==true)
		{
			System.out.println("Title Matching: "+"Duplicate Lead");
		}
		else
		{
			System.out.println("Title Not Matching");
		}
		 
		Thread.sleep(2000);
		
		//15	Click Create Lead
		wd.findElement(By.xpath("//input[@value=\"Create Lead\"]")).click();	
		Thread.sleep(1000);
		
		String DupFirstname=wd.findElement(By.xpath("//span[@id=\"viewLead_firstName_sp\"]")).getText();
		System.out.println(DupFirstname);
		 
		//16	Confirm the duplicated lead name is same as captured name
		
			System.out.println("Captured Lead name:"+fstName);
		
			System.out.println("Duplicated Lead name:"+DupFirstname);
		
	
		//17	Close the browser (Do not log out)
		wd.quit();
		

	}
	
}
