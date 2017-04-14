package SeleniumCertificationProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import sun.rmi.runtime.Log;

public class CSVOut {
	private static final char[] L = null;
	WebDriver driver;
	
//	String USERNAME = sauceconnect.USERNAME;
//	  String ACCESS_KEY = sauceconnect.ACCESS_KEY;
//	 static String URL = sauceconnect.URL;
@Test(dataProvider="Authentication",invocationCount=5)
	public void main(String uname , String pwd ,int cnt) throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
		// TODO Auto-generated method stub
	
//	  DesiredCapabilities caps = DesiredCapabilities.firefox();
//	    caps.setCapability("name", "First SeleniumTest");
//	    caps.setCapability("platform", "Windows 7");
//	    caps.setCapability("version", "28.0");
//	    //caps.setCapability("passed", "true");
 
	
	
	// Specify the file path which you want to create or write
	 
	String excelFileName = "C:\\Users\\DELL-PC\\Desktop\\Book2.xls";//name of excel file

	String sheetName = "Sheet1";//name of sheet

	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet(sheetName) ;

	//iterating r number of rows
	for(int i=0;i<10;i++){
		
		String	Var = uname+"A"+System.currentTimeMillis();
		HSSFRow row = sheet.createRow(0+i);
		//iterating c number of columns
		
			HSSFCell cell = row.createCell(0);

			cell.setCellValue(Var+uname);
			
			
			System.out.println(Var+uname);
			FileOutputStream fileOut = new FileOutputStream(excelFileName);

			//write this workbook to an Outputstream.
			wb.write(fileOut);
			
			fileOut.close();}
	}		
			
			
		
    
    
    
 

		
	

		  
	

@DataProvider(name = "Authentication")
    
    public static Object[][] credentials() {
   
          // The number of times data is repeated, test will be executed the same no. of times
   
          // Here it will execute two times
   
          return new Object[][] { { "admin", "demo123" ,1}, { "admin", "demo123",2 }};
   
    }



	}


