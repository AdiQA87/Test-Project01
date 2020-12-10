package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	public static WebDriver driver;
	String sheetName = "contacts";
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		driver.get("https://ui.cogmento.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys("aditya.gupta1016@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider ="getCRMTestData" )
	
	public void createNewContact(String firstName, String LastName, String emailID, String emailIDType) throws InterruptedException{		
		
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//*[@id='main-nav']/a[3]/span[contains(text(),'Contacts')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button[@class='ui linkedin button']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		driver.findElement(By.name("last_name")).sendKeys(LastName);
		driver.findElement(By.xpath("//div[label[contains(text(),'Email')]]//input")).sendKeys(emailID);
		driver.findElement(By.xpath("//div[label[contains(text(),'Email')]]//input[@name='name']")).sendKeys(emailIDType);
		driver.findElement(By.xpath("//i[@class='save icon']")).click();
		
		
	}
	
	
	
}
