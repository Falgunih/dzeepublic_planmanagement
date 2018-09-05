package Loginpage;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class loginPagedemo {
    WebDriver driver;
	@Test
	public void setup() throws Exception{
		
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://dzeepublicplan.dzeecloud.com/planSelect1/#!/");
		String title = driver.getTitle();
	    System.out.println(title);
	    driver.findElement(By.id("loginEmail")).sendKeys("mytesting@dzee.com");
	    driver.findElement(By.id("loginPassword")).sendKeys("Test@123");
	    driver.findElement(By.id("loginButton")).click();
	    driver.findElement(By.xpath("//a[text()='Employer Group Management']")).click();
	    driver.findElement(By.xpath("//*[@id='tab-item-10']")).click();
	   title= driver.getTitle();
	   System.out.println(title);
	   //  WebElement dropdown = driver.findElement(By.xpath("(//select[@id='planType'][@name='planType'])[1]"));
	 // Select select=new Select(dropdown);
	 // select.selectByIndex(1);
//WebElement dropdown = driver.findElement(By.xpath("//td//div//select[@id='planType']//following::span[@class='jcf-select-opener'][1]"));
	
	  driver.findElement(By.xpath("(//span[@class='jcf-select jcf-unselectable jcf-select-ng-pristine jcf-select-ng-untouched jcf-select-ng-empty jcf-select-ng-invalid jcf-select-ng-invalid-required'])[1]")).click();
	  
	 List<WebElement> list = driver.findElements(By.xpath("//span[@class='jcf-list-content']//ul//li"));
	 
	 System.out.println(list.size());
	
	 for(int i=0;i<list.size();i++){
		 System.out.println(list.get(i).getText());
	 }
	 list.get(1).click();
	 
	 driver.findElement(By.xpath("//span[@class='jcf-select jcf-unselectable jcf-select-textAlignCenter jcf-select-ng-pristine jcf-select-ng-untouched jcf-select-ng-empty jcf-select-ng-valid jcf-select-ng-valid-required']")).click();
	 
 List<WebElement> list1= driver.findElements(By.xpath("//span[@class='jcf-list-content']//ul//li"));
	 
	 System.out.println(list1.size());
	
	 for(int i=0;i<list1.size();i++){
		 System.out.println(list1.get(i).getText());
	 }
	 list1.get(1).click();
	
	 driver.findElement(By.xpath(".//*[@id='createViewEditPlan.orgPlanDetailsForm']/div/table/tbody/tr[6]/td[2]/div/span[1]")).click();
 List<WebElement> list2= driver.findElements(By.xpath("//span[@class='jcf-list-content']//ul//li"));
	 
	 System.out.println(list2.size());
	
	 for(int i=0;i<list2.size();i++){
		 System.out.println(list2.get(i).getText());
	 }
	 list2.get(1).click();
	 driver.findElement(By.xpath("//input[@type='radio'] [@value='Yes']")).click();
   
	 
	 driver.close();
	 
	    }
	
	
	
	   
	
	    
	   
		
		
		

	}


