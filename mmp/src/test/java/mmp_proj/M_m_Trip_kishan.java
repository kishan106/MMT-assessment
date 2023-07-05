package mmp_proj;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class M_m_Trip_kishan {
	WebDriver driver;
    Actions act;
    JavascriptExecutor js;
    String addActivity;
   
 
    String str1="https://www.makemytrip.com";
    
    @BeforeTest
    public void bt() throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
    	 ChromeOptions op = new ChromeOptions();
		 op.addArguments("--disable-notifications");
		 driver=new ChromeDriver();
	     driver.manage().window().maximize();    
	     driver.get(str1);
	     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     Thread.sleep(5000);
    }
    
    @Test(priority = 0)
    public void from_to() throws InterruptedException
    {
    	 driver.findElement(By.xpath("(//span[@class='chNavText darkGreyText'] )[4]")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.xpath("//span[text()='From City']")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bang");
	     List<WebElement> sc=driver.findElements(By.xpath("//div[@class='autoSuggest_list']/ul/li"));
	     Thread.sleep(3000);
	     String expectedcity="Bangalore",sourcecity="";
	     for(WebElement wb:sc){
	            //System.out.println(wb.getText());
	            if(wb.getText().equalsIgnoreCase("Bangalore")){
	              //  System.out.println(wb.getText());
	                 sourcecity=wb.getText();
	                wb.click();
	                break;
	            }
	        }
	     
	     Assert.assertEquals(sourcecity,expectedcity,"both are not same");
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//span[text()='To City/Country/Category']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("sing");
	     driver.findElement(By.xpath("//div[text()='Singapore']")).click();
	     Thread.sleep(3000);
	        //driver.findElement(By.xpath("//div[text()='July 2023']"));
	       // Thread.sleep(2000);
	     driver.findElement(By.xpath("(//p[@class='dateInnerPara'])[15]")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//button[@class='applyBtn']")).click();
	     
	     Thread.sleep(2000);
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollTo(0,150)");
	     driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//button[text()='Search']")).click();
    }
	     @Test(priority = 1)
	     public void hotel_booking() throws InterruptedException
	     
	     {
	     
	     Thread.sleep(5000);
	     //driver.findElement(By.xpath("//button[text()='SKIP']")).click();
	    
	     
	    // js=(JavascriptExecutor)driver;
	     //js.executeScript("window.scrollTo(0,900)");
	     
	   

	    // Thread.sleep(2000);
	     
	     driver.findElement(By.xpath("//span[@class='close closeIcon']")).click();
	     Thread.sleep(5000);
	     WebElement roomview = driver.findElement(By.xpath("(//*[contains(text(),'Specially curated Packages ')])"));
	     js.executeScript("arguments[0].scrollIntoView();", roomview);

	     }
	     
	     @Test(priority = 2)
	     public void move_to_new_tab() throws InterruptedException
	     {
	     
	     Thread.sleep(5000);
	     
	     
	     driver.findElement(By.xpath("//h4[text()='Uncover Singapore Beauty']")).click();
	     Thread.sleep(5000);
	     
	     String win1=driver.getWindowHandle();
	     System.out.println("present"+win1);
	     Set<String> x=driver.getWindowHandles();
	     for(String s:x){
	          System.out.println(s);
	           driver.switchTo().window(s);
	        }

	    // driver.findElement(By.xpath("//button[text()='SKIP']")).click();
	     js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollTo(0,400)");
	     //
	     }

	     
	     
	     @Test(priority = 3)
	     public void change_hotel() throws InterruptedException
	     {
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//*[@class='initerary-nav'])/li[3]")).click();
	     //change
	     driver.findElement(By.xpath("//span[@id='change']")).click();
	     Thread.sleep(9000);
	     js=(JavascriptExecutor)driver;
	     js.executeScript("window.scrollTo(0,400)");
	     
	     driver.findElement(By.xpath("((//span[@class='primaryBtn fill selectBtn'])[2]")).click();  //M social singappore
	     Thread.sleep(3000);
	     String actualChangedHotel = driver.findElement(By.xpath("(//*[text()='M Social Singapore - Holidays Selections			'])[2]")).getText();
	     System.out.println(actualChangedHotel);
	     driver.findElement(By.xpath("//p[@class='updatePackageBtnText font10']")).click();   //update package
	     Thread.sleep(3000);
	     String expectdChangedHotel=driver.findElement(By.xpath("//*[text()='M Social Singapore - Holidays Selections			']")).getText();
	     Assert.assertEquals(actualChangedHotel,expectdChangedHotel);
	      
	     }
	     
	     @Test(priority = 4)
	     public void add_activity() throws InterruptedException {
	    	 
	    	 Thread.sleep(2000);
	    	 driver.findElement(By.xpath("(//*[@class='initerary-nav'])/li[1]")).click();
	    	 Thread.sleep(4000);
	    	 js=(JavascriptExecutor)driver;
		     js.executeScript("window.scrollTo(0,450)");
		     driver.findElement(By.xpath("(//div[@id='chooseAndAddBtn'])[1]")).click();
		      addActivity = driver.findElement(By.xpath("(//*[@class='activityHeading'])[1]")).getText();
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("(//span[@class='primaryBtn fill selectBtn'])[1]")).click();
		     Thread.sleep(2000);
		     
		     driver.findElement(By.xpath("//p[text()='Update Package']")).click();
		     
		     
	    	 
	     }
	     
	     @Test(priority = 5)
	     public void validate() throws InterruptedException {
	    	 Thread.sleep(3000);
	    	 driver.findElement(By.xpath("//li[text()='Activities']")).click();
	    	 String expectedaddActivity = driver.findElement(By.xpath("(//p[@class='activity-row-details-title'])[1]")).getText();
	    	 System.out.println(expectedaddActivity);
	    	 Assert.assertEquals(addActivity, expectedaddActivity);
	    	 
	     }
	     
	     @AfterTest
	     public void close()
	     {
	    	 driver.close();
	     }
}  
	        
	     
	     
	     
	     
	     
	     
    
	


