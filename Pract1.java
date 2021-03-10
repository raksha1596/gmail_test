package codes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Pract1 {
	
	private static String baseUrl;
	
	public static void main(String[] args) throws Exception {
	//Setting webdriver property
	System.setProperty("webdriver.chrome.driver", "C:/Users/Raksha/Desktop/chromedriver.exe");
	
	
	//Go to URL 
	String username="testpractise12@gmail.com";
	String password="testpractise45";
	ComposeMail(username,password);
	}
	
	public static void ComposeMail(String username,String password) throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	String baseUrl = "https://gmail.com";
	String emailsubject="Test Mail";
	String tomailid ="xyz@gmail.com";
	String mailbody="Hi "+"\n"+"Great you sent email :-)"+"\n" + "Regards,"+"\n"+"testpractise";
	
	//Navigate to URL
	driver.get(baseUrl+"/intl/en/mail/help/about.html");
	
	driver.findElement(By.xpath("//a[@id='gmail-sign-in']")).click();
	//Enter username
	driver.findElement(By.id("identifierId")).clear();
	driver.findElement(By.id("identifierId")).sendKeys(username);
	//Click on Next
	driver.findElement(By.id("identifierNext")).click();
	//Enter password
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(password);
	//Click on Next
	driver.findElement(By.id("passwordNext")).click();
	
	//Verify if login session is successful for same user 
	driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
	WebElement gmailusername=driver.findElement(By.xpath("//div[@class='gb_ob']"));
	if(gmailusername.getText().equals(username)) {
		System.out.print("Login Successful");
	}
	else {
		System.out.print("Login UnSuccessful");
	}
	
	//Click on Compose Button
	driver.findElement(By.xpath("//div[@class='z0']/div")).click();

	//enter "to" mailid
	driver.findElement(By.className("vO")).sendKeys(tomailid);
	//enter email subject
	driver.findElement(By.className("aoT")).sendKeys(emailsubject);
	//enter email body 
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));
	driver.findElement(By.id("au")).sendKeys(emailsubject);
	driver.switchTo().defaultContent();
	//click on send 
	driver.findElement(By.xpath("//div[text()='Send']")).click();
	
	//Click on flyout menu
	driver.findElement(By.xpath("//img[@class='gb_Da gbii']")).click();
	
	//click on Sign out
	driver.findElement(By.id("gb_71")).click();
	}
	
}
