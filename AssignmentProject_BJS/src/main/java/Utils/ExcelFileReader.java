package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	public void excelRader() throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\CodeRepo\\AssignmentQATest\\AssignmentProject_BJS\\DataFolder\\TestData.xlsx");
		
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			
			int rows = sheet.getLastRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();
			
			System.out.println(rows);
			System.out.println(colcount);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ExcelFileReader obj = new ExcelFileReader();
		obj.excelRader();
	}

	
}
