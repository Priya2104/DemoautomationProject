package utilities;


	



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




	
	public class ExcelUtily 
	{
	
	public static List<Map<String,String>>getTestdatainMap() throws IOException 
	{
		List<Map<String,String>> getTestDataAllRows=null;
		
		Map<String,String> testData=null;
		try
		{
			
			DataFormatter formatter = new DataFormatter();
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Merchandise.xlsx");
			
			  XSSFWorkbook workbook = new XSSFWorkbook(fis);

		        // Get first/desired sheet from the workbook
		        
			  Sheet sheet=workbook.getSheetAt(0);
			//XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//XSSFSheet sheet = createSheet(workbook, "Sheet1", false);
			 //XSSFSheet sheet = workbook.getSheetAt("Sheet 1"); 
			 int lastRowCount=sheet.getLastRowNum();
			 
			 int lastColNumer=sheet.getRow(0).getLastCellNum();
			 
			 
			 List list =new ArrayList();
			 for(int i=0; i<lastColNumer;i++)
			 {
			 Row row = sheet.getRow(0);
			 //Cell keycell = row.getCell(0);
			 Cell cell=row.getCell(i);
			 String rowHeader=cell.getStringCellValue().trim();
			
			 list.add(rowHeader);
			
			 }
			 
			 getTestDataAllRows=new ArrayList<Map<String,String>>();
			 for( int j=1;j<=lastRowCount;j++)
			 {

			 Row row=sheet.getRow(j);
			 
			 //testData=new TreeMap<String,String>(String.Case_INSENSTIVE_ORDER);
			 testData= new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);
			 for (int k=0;k<lastColNumer;k++)
			 {
				 Cell cell=row.getCell(k);
				 String colvalue=cell.getStringCellValue().trim();
				 testData.put((String) list.get(k),colvalue);
				 
			
			 }
			 getTestDataAllRows.add(testData);
			 		
			 }
			 
			
		}
			catch(FileNotFoundException  e)  
	        {  
	            e.printStackTrace();
				System.out.println(e); 
	        }
		return getTestDataAllRows;  
		
		
	}

	private static XSSFSheet createSheet(XSSFWorkbook workbook, String string, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	}
	
	
		
		
		
		
	
	//String path = "C:\\Users\\gp105059\\feb27\\Pepkor Merx\\TestData\\TestData.xlsx";
	
	
	
