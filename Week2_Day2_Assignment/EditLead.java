package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {	
			
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
		
		// 8	Enter first name
		List<WebElement> firstNameList=wd.findElements(By.xpath("//input[@name=\"firstName\"]"));
		 WebElement firstName=firstNameList.get(2);
		 firstName.sendKeys("Hindhuja");
		 
		 Thread.sleep(500);
		//9	Click Find leads button
		 wd.findElement(By.xpath("//button[contains(text(),\"Find Leads\")]")).click();
		 
		 Thread.sleep(500);
		// 10 Click on first resulting lead
		 List<WebElement> firstLeadList=wd.findElements(By.xpath("//table[@class=\"x-grid3-row-table\"]/tbody/tr/td[@class=\"x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first \"]/div/a[@class=\"linktext\"]"));
		 WebElement firstLead=firstLeadList.get(0);
		 firstLead.click();
		 Thread.sleep(500);
		 
		 // 11 Verify title of the page
		String title =wd.getTitle();
		System.out.println(title);
		Thread.sleep(500);
		
		//12 Click Edit
		wd.findElement(By.xpath("//a[contains(text(),\"Edit\")]")).click();
		Thread.sleep(1000);
		
		//13 Change the company name
		wd.findElement(By.xpath("//input[@name=\"companyName\"][@class=\"inputBox\"]")).clear();
		wd.findElement(By.xpath("//input[@name=\"companyName\"][@class=\"inputBox\"]")).sendKeys("Google");
		 
		// 14 Click Update
		wd.findElement(By.xpath("//input[@value=\"Update\"]")).click();
		Thread.sleep(500);
		
		// 15 Confirm the changed name appears
		String companyname=wd.findElement(By.xpath("//span[@id=\"viewLead_companyName_sp\"]")).getText();
		System.out.println(companyname);
		if (companyname.contains("Google")==true)
			System.out.println("Name Appers correct");
		else
			System.out.println("Name Appers Incorrect");
		Thread.sleep(500);
		
		//16 Close the browser (Do not log out)
		wd.quit();
		
		  
			
			

	}
	
}	
