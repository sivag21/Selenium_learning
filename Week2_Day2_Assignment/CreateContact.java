package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		wd.manage().window().maximize();		
		wd.get("http://leaftaps.com/opentaps/control/main");	
		
		// 2. Enter UserName and Password Using Id Locator
		wd.findElement(By.id("username")).sendKeys("DemoSalesManager");       
		wd.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator
		wd.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(500);
		
		// 4. Click on CRM/SFA Link
		wd.findElement(By.xpath("//a[contains(text(),\"CRM/SFA\")]")).click();
		Thread.sleep(500);
			   
		// 5. Click on contacts Button 
		wd.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		Thread.sleep(500);
		  
		// 6. Click on Create Contact
		wd.findElement(By.xpath("//a[text()=\"Create Contact\"]")).click();
		Thread.sleep(500);
		   
		// 7. Enter FirstName Field Using id Locator
		WebElement firstName=wd.findElement(By.id("firstNameField"));			
		
		// 8. Enter LastName Field Using id Locator
		WebElement lastName=wd.findElement(By.id("lastNameField"));
		 
		//9. Enter FirstName(Local) Field Using id Locator
		firstName.sendKeys("Jonny");
		
		 //10. Enter LastName(Local) Field Using id Locator
		lastName.sendKeys("Don");
		
		 //11. Enter Department Field Using any Locator of Your Choice
		 wd.findElement(By.xpath("//input[@id=\"createContactForm_departmentName\" and @name=\"departmentName\"]")).sendKeys("IT");
		 
		// 12. Enter Description Field Using any Locator of your choice 
		wd.findElement(By.xpath("//textarea[@id=\"createContactForm_description\" and @class=\"inputBox\"]")).sendKeys("Working for IT department");
				 
		//13. Enter your email in the E-mail address Field using the locator of your choice
		wd.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc1234@gmail.com");
		 
		// 14. Select State/Province as NewYork Using Visible Text
		WebElement stPrvs=wd.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select options=new Select(stPrvs);
		options.selectByValue("AK");
		  
		//15. Click on Create Contact
		wd.findElement(By.xpath("//input[@value=\"Create Contact\"]")).click();
	
		Thread.sleep(500);
		// 16. Click on edit button 
		wd.findElement(By.xpath("//a[text()=\"Edit\"]")).click();
		
		 // 17. Clear the Description Field using .clear
		wd.findElement(By.xpath("//textarea[@id=\"updateContactForm_description\" and @class=\"inputBox\"]")).clear();
		
		// 18. Fill ImportantNote Field with Any text
		wd.findElement(By.xpath("//textarea[@id=\"updateContactForm_importantNote\" and @class=\"inputBox\"]")).sendKeys("Working for Accounts department");
		
		// 19. Click on update button using Xpath locator
		wd.findElement(By.xpath("//input[@value=\"Update\"]")).click();
		
	//20. Get the Title of Resulting Page.
		String getTitle= wd.getTitle();
		System.out.println(getTitle);
         
	
	}

}
