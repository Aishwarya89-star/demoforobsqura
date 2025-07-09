package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	static FileInputStream f;   //to get details from file its an inbuit class FileInput stream
	static XSSFWorkbook wb;		//to get details from current workbook its also an inbuilt class
	static XSSFSheet sh;		// to get details from current sheet xssfsheet is also an class
	
	
	public static String getStringData(int a,int b, String sheetname) throws IOException // return type string and a represents for row and b represents for coloum
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx"); // got file from location
		wb= new XSSFWorkbook(f);  //assigned workbook to wb variabale from f variable
		sh=wb.getSheet(sheetname); //getSheet is an method and wb is an object/variable is used
		XSSFRow r =sh.getRow(a); //XSSFRow is an class , getting sheet using the method getRow by sh object
		XSSFCell c = r.getCell(b); // getcell method is uesd to get values from cell and XSSFcell is the cell
		return c.getStringCellValue();  //getStringCellValue is the method used to get string values
	}
	
	
	public static String getIntegerData(int a,int b,String sheetname) throws IOException {
		
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx");
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheetname);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int z=(int)c.getNumericCellValue();
		return String.valueOf(z);		//typecasting converted integer to string
	}
public static String getFloatData(int a,int b,String sheetname) throws IOException {
		
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx");
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheetname);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		float z=(float)c.getNumericCellValue();
		return String.valueOf(z);

}
}





