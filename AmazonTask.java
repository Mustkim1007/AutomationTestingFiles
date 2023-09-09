package Task1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonTask {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mustkim.shaikh\\Desktop\\Mustkim\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void amazonTest() throws IOException, InterruptedException {
    	 
    	 driver.get("https://www.amazon.com/");
    	 Thread.sleep(2000);
         FileInputStream file = new FileInputStream(new File("C:\\Users\\mustkim.shaikh\\Desktop\\AmazonData.xlsx"));
         Workbook workbook = new XSSFWorkbook(file);

         Sheet sheet1 = workbook.getSheetAt(0);
    	       
    	 for (Row row : sheet1) 
    	 {
    		 //login
    		 String username = row.getCell(0).getStringCellValue();
    		 String password = row.getCell(1).getStringCellValue();
    	    	      
    		 driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    	    	          	    	             
    		 driver.findElement(By.id("ap_email")).sendKeys(username);
    		 driver.findElement(By.id("continue")).click();
    		 Thread.sleep(2000);
    		 driver.findElement(By.id("ap_password")).sendKeys(password);
    		 driver.findElement(By.id("signInSubmit")).click();
    	        	  
    		 Sheet sheet2 = workbook.getSheetAt(1);
    	     
    		 //search items
    		 for (Row rows : sheet2) 
    		 {
    			 String item = rows.getCell(0).getStringCellValue();
    			 String itemxpath = rows.getCell(1).getStringCellValue();
    			 
    			 WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    			 searchBox.clear();
    			 searchBox.sendKeys(item);
    			 searchBox.submit();
    			 
    			 //Check add to cart button shows on page or not
    			 try 
    			 {
        			 WebElement ItemsXpath=driver.findElement(By.xpath(itemxpath));
        			 ItemsXpath.click();
        			 
        			 WebElement addtocart=driver.findElement(By.id("add-to-cart-button"));
    			        
    				 if (!addtocart.isDisplayed()) 
    				 {
    					 System.out.println("Add to cart button not found for " + item);
    					 continue;
    				 } 
    				 else 
    				 {
    					 addtocart.click();
    				 }
    			 }
    			 
    			 catch (Exception e) 
    			 {
    				 System.out.println("Add to cart button not found for: " + item + e);
    				 continue; 
    			 } 
    		 }
    		 
    		 Thread.sleep(2000);
    	        
    		 //add items to cart
    		 driver.findElement(By.xpath("//a[@id=\"nav-cart\"]")).click();
    		 Thread.sleep(2000);
    		 
    		 //proceed to checkout
    		 driver.findElement(By.xpath("//span[@id=\"sc-buy-box-ptc-button\"]//span[@class=\"a-button-inner\"]")).click();
    		 Thread.sleep(2000);
    		 driver.navigate().back();
    		
    		 //Delete
    		 while (true) {
    			    Thread.sleep(2000);

    			    List<WebElement> deleteButtons = driver.findElements(By.xpath("//input[@data-action=\"delete\"]"));
    			    
    			    if (deleteButtons.isEmpty()) {
    			        break;
    			    } else {
    			        
    			        deleteButtons.get(0).click();
    			        Thread.sleep(4000);
    			    }
    			}

    		
    		 //Logout
    		 WebElement acount = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
    		 WebElement signout = driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
    		 Thread.sleep(300);
    		  
    		 Actions action = new Actions(driver);
    		 action.moveToElement(acount).moveToElement(signout).click().build().perform();
    	 }
    	 
    }
    	
    	
    @AfterTest
    public void tearDown() throws IOException {
    	driver.quit();
    }
}
