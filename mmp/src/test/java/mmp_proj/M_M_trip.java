package mmp_proj;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class M_M_trip {
	
	WebDriver driver;
    Actions act;
    JavascriptExecutor jav;
    @BeforeTest
    public void BT() {
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();    
      driver.get("https://www.makemytrip.com");
      driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
  }
    
    @Test
    public void test() throws InterruptedException {
        
        driver.findElement(By.xpath("(//*[@class='menu_Holidays removeItemMargin'])")).click();
        driver.findElement(By.xpath("//*[@for='fromCity']")).click();
        driver.findElement(By.xpath("(//*[@class='font14 blackText appendBottom6 autoSuggestValue'])[3]")).click();
    
        Thread.sleep(3000);
        driver.findElement(By.id("toCity")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("dest-search-input")).sendKeys("Singapore");
        Thread.sleep(2000);
        WebElement SGP = driver.findElement(By.className("dest-city-name"));
        Actions act=new Actions(driver);
        act.click(SGP).build().perform();
        driver.findElement(By.xpath("//*[@aria-label='Fri Jun 30 2023']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='applyBtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='action']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("search_button")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@class='nextBtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@class='close closeIcon']")).click();
        Thread.sleep(2000);
        JavascriptExecutor jav=(JavascriptExecutor)driver;
        Thread.sleep(10000);
        jav.executeScript("window.scrollBy(0,1250);");
        Thread.sleep(5000);
        jav.executeScript("window.scrollBy(0,1100);");
	
}
    
    @Test
    public void select() throws InterruptedException {
        Thread.sleep(5000);
      WebElement sec = driver.findElement(By.xpath("(//*[@class='sliderCardShadow'])[1]"));
      Actions act=new Actions(driver);
       act.click(sec).build().perform();
       Set<String> handles = driver.getWindowHandles();
       
       Iterator<String> values = handles.iterator();
       
       
   
}
}
