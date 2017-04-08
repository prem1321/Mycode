package SeleniumCertificationProject;

import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class iterator {
	private static final char[] L = null;
	String Var;
@Test(dataProvider="Authentication")
	public void main(String uname , String pwd) throws Exception {
		// TODO Auto-generated method stub
	
	
	WebDriver driver = new FirefoxDriver();
	Thread.sleep(5000);
	
	driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
	
	Thread.sleep(5000);
	driver.manage().window().maximize();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//input[@name='log']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(pwd);
	
	Thread.sleep(5000);
	driver.findElement(By.id("wp-submit")).click();  //click button
	
	Thread.sleep(5000);
	
	String	Var = driver.getTitle();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[contains(.,'Appearance')]")).click();
	
	Thread.sleep(2000);
	
	String Var1 = driver.findElement(By.xpath("//a[contains(.,'Fabthemes')]")).getText();
	
	Thread.sleep(2000);
	
	
	List<String> L = new LinkedList<String>();
		    L.add(Var+"   "+"||"+"  "+Var1);
		    
		    for (ListIterator<String> i = L.listIterator(); i.hasNext(); ) {
		      String x = i.next();
		      //i.add(x + 10);
		    }
		    
		    Thread.sleep(5000);
		    
		   System.out.println(L);
		   
		    driver.close();
		  }
	

@DataProvider(name = "Authentication")
    
    public static Object[][] credentials() {
   
          // The number of times data is repeated, test will be executed the same no. of times
   
          // Here it will execute two times
   
          return new Object[][] { { "admin", "demo123" }, { "admin", "demo123" }};
   
    }
	}


