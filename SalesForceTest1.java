package Auto1test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Constant;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SalesForceTest1 {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\mustkim.shaikh\\Desktop\\Mustkim\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 ChromeOptions op = new ChromeOptions();
		 	
			op.addArguments("--disable-notifications");
		 driver=new ChromeDriver(op);
		  driver.manage().window().maximize();
		  driver.get("https://login.salesforce.com/");
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		  
		  
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() throws InterruptedException, AWTException {
		 driver.findElement(By.id("username")).sendKeys("testautomation@example.com");
		  driver.findElement(By.id("password")).sendKeys("Salesforce@123456");
		  driver.findElement(By.id("Login")).click();
		  
		
		  driver.findElement(By.xpath("//div[@aria-label='App']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"07p5j000000UwU2AAK\"]/div/lightning-formatted-rich-text/span/p")).click();
     	  Thread.sleep(2000);
		  
		  
		  driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[5]")).click();
		  Thread.sleep(3000);
		  
		   driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")).click();
		   Thread.sleep(2000);
		   
		   
		  
		   WebElement testDropDown = driver.findElement(By.xpath("//*[@id=\"combobox-button-155\"]")); 
		   Select dropdown = new Select(testDropDown);  
		   dropdown.selectByVisibleText("Working");
		   Thread.sleep(2000);
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		    /*WebElement input=driver.findElement(By.xpath("//input[@role='combobox']")); 
				   input.sendKeys("Automation Contact");
				   
				   Thread.sleep(2000);*/
		   
		   /*driver.findElement(By.xpath("//input[@role='combobox']")).click();
		   Select drpCountry = new Select(driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")));
		   drpCountry.selectByVisibleText("Automation Contact");*/
		   //Thread.sleep(2000);
		   
		  // driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).sendKeys("Automation Contact");
			/*
			 * driver.findElement(By.id("combobox-input-271")).click(); Thread.sleep(2000);
			 * 
			 * driver.findElement(By.xpath("//*[@id=\"combobox-input-276\"]")).
			 * sendKeys("Automation Account");
			 */
		
		  
	}

}
