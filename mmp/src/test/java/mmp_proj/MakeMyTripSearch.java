package mmp_proj;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MakeMyTripSearch {
	
	 JavascriptExecutor js;
	    WebDriver driver;
	    @Test
	    public  void makeMyTripSearch() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver=new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("https://www.makemytrip.com/");
	        driver.manage().window().maximize();
	        Thread.sleep(5000);
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
	        /*List<WebElement> des=driver.findElements(By.xpath("//div[@class='dest-search-list']/div/div/div/div"));
	        Thread.sleep(3000);
	       // String expecteddcity="Singapore",destinationcity="";
	        for(WebElement wb:des){
	            //System.out.println(wb.getText());
	            if(wb.getText().equalsIgnoreCase("Singapore")){
	                System.out.println(wb.getText());
	                //sourcecity=wb.getText();
	                wb.click();
	                break;
	         }*/
	        //driver.findElement(By.xpath("//div[text()='Singapore']")).click();
	       
	        driver.findElement(By.xpath("//div[@class='dest-search-list']/div/div/div/div[1]")).click();
	        Thread.sleep(3000);
	        //driver.findElement(By.xpath("//div[text()='July 2023']"));
	       // Thread.sleep(2000);
	        driver.findElement(By.xpath("(//*[@class='DayPicker-Day'])[9]")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[@class='applyBtn']")).click();
	        Thread.sleep(2000);
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("window.scrollTo(0,150)");
	        driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[text()='Search']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[text()='SKIP']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("searchBtn")).click();
	        Thread.sleep(5000);
	         js=(JavascriptExecutor)driver;
	        js.executeScript("window.scrollTo(0,1050)");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[@class='close closeIcon']")).click();
	        Thread.sleep(2000);
	      //  driver.findElement(By.xpath("(//div[@class='rc-slider'])[2]")).click();
	        driver.findElement(By.xpath("//h4[text()='Enchanting Goa Vacation']")).click();
	        String win1=driver.getWindowHandle();


	        Set<String> x=driver.getWindowHandles();
	        for(String s:x){
	            System.out.println(s);
	            driver.switchTo().window(s);
	        }

	        driver.findElement(By.xpath("//button[text()='SKIP']")).click();
	        Thread.sleep(2000);
	        //driver.findElement(By.id("searchBtn")).click();
	        js.executeScript("window.scrollTo(0,1050)");
	        Thread.sleep(2000);
	       driver.findElement(By.xpath("(//span[text()='Change'])[3]")).click();
	        Thread.sleep(2000);
	        js=(JavascriptExecutor)driver;
	        js.executeScript("window.scrollTo(0,850)");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("(//span[text()='Select'])[9]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//p[text()='Update Package']")).click();
	        Thread.sleep(2000);
	        js.executeScript("window.scrollTo(0,850)");
	        driver.findElement(By.xpath("(//div[@id='chooseAndAddBtn'])[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(("(//span[text()='Select'])[1]"))).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//p[text()='Update Package']")).click();

	        //driver.quit();

	    }

}
