package SeleniumCertificationProject;


		import org.openqa.selenium.By;
// TODO Auto-generated method stub
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.remote.DesiredCapabilities;
		import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

		public class SampleSauceTest {

		 String USERNAME = sauceconnect.USERNAME;
		  String ACCESS_KEY = sauceconnect.ACCESS_KEY;
		 static String URL = sauceconnect.URL;
@Test
		  public  void main() throws Exception {

		    DesiredCapabilities caps = DesiredCapabilities.firefox();
		    caps.setCapability("name", "First SeleniumTest");
		    caps.setCapability("platform", "Windows 7");
		    caps.setCapability("version", "28.0");
		    //caps.setCapability("passed", "true");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		    /**
		     * Goes to Sauce Lab's guinea-pig page and prints title
		     */

		    driver.get("https://www.healthcare.gov/");
		    Thread.sleep(5000);
		    
		    driver.findElement(By.xpath("//a[contains(.,'Get Coverage')]")).click();
		    Thread.sleep(20000);
		    System.out.println("title of page is: " + driver.getTitle());
		    Thread.sleep(5000);
		   
		    driver.close();
		    driver.quit();
		  }
		
	}


