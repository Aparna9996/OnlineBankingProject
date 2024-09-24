package com.onlinebanking.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test2 {
	
	public static void main(String[]args) throws InterruptedException {
		
		String userAccountNumberAdminLogin= "";
		
		//WebDriver driver ;
	//WebDriverManager.chromedriver().setup();//for to call all browsers
	System.setProperty("webdriver.chrome.driver", ("C:\\Users\\Hi\\Downloads\\chromedriver-win64\\chromedriver.exe"));
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://onlinetestinghelp.com/projects/banking/admin/index.php");
	
	//To get the title of the page
	driver.findElement(By.xpath("//b[normalize-space()='Admin Login']")).click();
	//user name
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
	//password
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	//click button
	driver.findElement(By.xpath("//*[text()='Sign In']")).click();
	Thread.sleep(5000);
	
	//Create account
	 driver.findElement(By.xpath("//p[normalize-space()='Account Management']")).click();
	 //dropdoum
	 driver.findElement(By.xpath("//p[normalize-space()='New Account']")).click();
	//driver.findElement(By.xpath("//p[normalize-space()='New Account']")).click();
	//new account
	//driver.findElement(By.xpath("//a[@class='nav-link nav-manage_account active']")).click();
	//account number
	driver.findElement(By.xpath("//input[@name='account_number']")).sendKeys("949498800012345");
	//first name
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Suryana");
	//middle name
	driver.findElement(By.xpath("//input[@placeholder='(optional)']")).sendKeys("narayana");
	//last name
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bomma");
	//email id
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Srsimple1234@gmail.com");
	//password
	driver.findElement(By.xpath("//input[@name='generated_password']")).sendKeys("9441661213");
	//pin id
	driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("508115");
	//balance
	driver.findElement(By.xpath("//input[@name='balance']")).sendKeys("100000");
	//save
	driver.findElement(By.xpath("//button[@class='btn btn-primary mr-2']")).click();
	//Successfully 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//to conform user
	WebElement AccManage=driver.findElement(By.xpath("//p[normalize-space()='Account Management']"));
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	try {
		wait.until(ExpectedConditions.visibilityOf(AccManage));
	}catch(StaleElementReferenceException exeception) {
		driver.navigate().refresh();
		}
	
    Actions a= new Actions(driver);
    AccManage=driver.findElement(By.xpath("//p[normalize-space()='Manage Account']"));
    //WebElement AccManage=driver.findElement(By.xpath("//p[normalize-space()='Account Management']"));
	//a.moveToElement(AccManage).pause(3000).click().build().perform();
	Thread.sleep(3000);
	WebElement manageacc=driver.findElement(By.xpath("//p[normalize-space()='Manage Account']"));
	//a.moveToElement(manageacc).pause(3000).click().build().perform();
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("949498800012345");
	System.out.println("User is displayed :"+ driver.findElement(By.xpath("//td[normalize-space()='949498800012345']")).isDisplayed());
	Thread.sleep(3000);

	//click  on search
	//driver.findElement(By.xpath("//input[@type='search']")).sendKeys("949498800012345");
	//get rows & coloum
	List<WebElement> rows=driver.findElements(By.xpath("//table[@id='indi-list']/tbody/tr"));
	List<WebElement> cols=driver.findElements(By.xpath("//table[@id='indi-list']/tbody/tr[1]/td"));

	//click on Adminstr
	 
	for(int i=1;i<=rows.size();i++) {
		for(int j=1;j<cols.size();j++) {
			String text=driver.findElement(By.xpath("//table[@id='indi-list']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
			if(i==1 & j==2) {
				userAccountNumberAdminLogin = text;
	//user AccountnumberAdmintext	
			System.out.println("rows:"+ i +" column:"+ j +"Text:: "+ text);
			System.out.println("Account Numbe:"+ userAccountNumberAdminLogin);
			break;
		}
	}
 
}

	//logout from admin portal
			driver.findElement(By.xpath("//span[@class='ml-3']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[normalize-space()='User Login']")).click();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Srsimple1234@gmail.com");
		//enter password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9441661213");
		//login
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary btn-flat']")).click();
		Thread.sleep(2000);
		driver.quit();
}
		
}