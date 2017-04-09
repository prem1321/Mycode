package SeleniumCertificationProject;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.apache.http.util.TextUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sun.rmi.runtime.Log;

public class CSVOut {
	private static final char[] L = null;
	WebDriver driver;
	String Var;
	String USERNAME = sauceconnect.USERNAME;
	  String ACCESS_KEY = sauceconnect.ACCESS_KEY;
	 static String URL = sauceconnect.URL;
@Test(dataProvider="Authentication")
	public void main(String uname , String pwd) throws Exception {
		// TODO Auto-generated method stub
	
	  DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("name", "First SeleniumTest");
	    caps.setCapability("platform", "Windows 7");
	    caps.setCapability("version", "28.0");
	    //caps.setCapability("passed", "true");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
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
	
	String excelFileName = "C:\\Users\\DELL-PC\\Desktop\\Book2.xls";//name of excel file

	String sheetName = "Sheet1";//name of sheet

	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet(sheetName) ;

	//iterating r number of rows
	for (int r=sheet.getLastRowNum();r<=2; r++ )
	{
		HSSFRow row = sheet.createRow(r);
		String V1 = Var;
		String V2 = Var1;
		String V3 = "A"+System.currentTimeMillis();
		//iterating c number of columns
		for (int c=0;c <1; c++ )
		{
			HSSFCell cell = row.createCell(c);

			cell.setCellValue(V1+"|"+V2+V3);
			
			
			System.out.println(Var);
			FileOutputStream fileOut = new FileOutputStream(excelFileName);

			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}
	}

		  }
	

@DataProvider(name = "Authentication")
    
    public static Object[][] credentials() {
   
          // The number of times data is repeated, test will be executed the same no. of times
   
          // Here it will execute two times
   
          return new Object[][] { { "admin", "demo123" }, { "admin", "demo123" }};
   
    }



	}


