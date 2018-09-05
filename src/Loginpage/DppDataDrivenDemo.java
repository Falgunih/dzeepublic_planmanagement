package Loginpage;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ExcelHelper;

public class DppDataDrivenDemo {
	
	    WebDriver driver;
	    
	   
	    
	    
		@BeforeTest
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
}
		
		@DataProvider(name="action")
		public Object[] [] getdata(){
			ExcelHelper help=new ExcelHelper("C:/Framework/DzeepublicDemo/data/DppTestData.xlsx" );
			int row = help.getLastrow(0);
			
		Object[][]data	=new Object[2][6];
		for( int i =1;i<row;i++){
			data[i][0]=help.getdata(0, i, 0);
			data[i][1]=help.getdata(0, i, 1);
			data[i][2]=help.getdata(0, i, 2);
			data[i][3]=help.getdata(0, i, 3);
			data[i][4]=help.getdata(0, i, 4);
			data[i][5]=help.getdata(0, i, 5);
		}
			
		return data;
		}	
		
		@Test(dataProvider="action")
			
		public void demoTest(List<WebElement> PlanType,String PlanScope,String EmployerTag,String HealthcarePlanName,String EnrollmentYear,String CarrierName){
//plantype
			 driver.findElement(By.xpath("(//span[@class='jcf-select jcf-unselectable jcf-select-ng-pristine jcf-select-ng-untouched jcf-select-ng-empty jcf-select-ng-invalid jcf-select-ng-invalid-required'])[1]")).click();
			  List<WebElement> list = driver.findElements(By.xpath("//span[@class='jcf-list-content']//ul//li"));
			
			 
			 System.out.println(PlanType.size());
			
			 for(int i=0;i<list.size();i++){
				 System.out.println(list.get(i).getText());
			 }
			list.get(1).click();
		



		}
			
			
			
			
			
		}
		




