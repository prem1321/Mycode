package SeleniumCertificationProject;


import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataconfig {

    XSSFWorkbook wb ;        //read workbook
	
	XSSFSheet sheet1 ;            //read first excel tab
	
	public  Exceldataconfig(String excelPath) {
			
				try {
					File src = new File(excelPath);//read file"
					
					FileInputStream fis = new FileInputStream(src);  //create io stream
					   wb = new XSSFWorkbook(fis);
					   sheet1 = wb.getSheetAt(0);
				} 
				
				catch (Exception e) {
					System.out.println(e.getMessage());}
					
				}
		
	public String getData(int sheetnum,int row, int col)	
	{
		sheet1 = wb.getSheetAt(0);
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}

}



