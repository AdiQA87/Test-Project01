package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.TestUtil;
import com.crm.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

	

	public class TestBase {
		public static WebDriver driver;
		public static Properties prop;
		public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		
		public TestBase(){
			try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Aditya Gupta\\git\\Test-Project01\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\configs\\config.properties");
			prop.load(ip);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
		
		public static void initialization(){
			
			 String BrowserName = prop.getProperty("browser");
			 if(BrowserName.equalsIgnoreCase("chrome")){
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
			 }
			 else if(BrowserName.equalsIgnoreCase("Edge")){
				WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
			 }
			 
			 e_driver = new EventFiringWebDriver(driver);
				// Now create object of EventListerHandler to register it with EventFiringWebDriver
				eventListener = new WebEventListener();
				e_driver.register(eventListener);
				driver = e_driver;
			 
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			 String urlName = prop.getProperty("url");
			 driver.get(urlName);
			 
		}	 	
		
		
		
		}


