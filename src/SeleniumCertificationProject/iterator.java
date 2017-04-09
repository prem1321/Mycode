package SeleniumCertificationProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class iterator {
	private static final char[] L = null;
	public static WebDriver driver = null; 
	DesiredCapabilities caps;
	String Var;
	String USERNAME = sauceconnect.USERNAME;
	  String ACCESS_KEY = sauceconnect.ACCESS_KEY;
	 static String URL = sauceconnect.URL;

	 @BeforeTest
	public void browser() throws Exception {

		    caps = DesiredCapabilities.firefox();
		    caps.setCapability("name", "First SeleniumTest");
		    caps.setCapability("platform", "Windows 7");
		    caps.setCapability("version", "28.0");
		    //caps.setCapability("passed", "true");
		     driver = new RemoteWebDriver(new URL(URL), caps);
		    
		    
	}
	 
	
	 
	 @Test(dataProvider="Authentication")
	public void main(String uname , String pwd) throws Exception {
		// TODO Auto-generated method stub
		 driver.navigate().to("http://demo.opensourcecms.com/wordpress/wp-login.php");
	
	Thread.sleep(5000);
	
	
	
	
	//driver.manage().window().maximize();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='log']")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='log']")).sendKeys(uname);
	Thread.sleep(5000);
	
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
		   
			
		  }
	
	
@DataProvider(name = "Authentication")
    
    public static Object[][] credentials() {
   
          // The number of times data is repeated, test will be executed the same no. of times
   
          // Here it will execute two times
   
          return new Object[][] { { "admin", "demo123" }, { "admin", "demo123" }};
   
    }
@AfterTest
public void close(){
	
	driver.close();
	driver.quit();
}

	}


