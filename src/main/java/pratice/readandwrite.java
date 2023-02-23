package pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readandwrite {

	static Row row;

	static Sheet sh;

	static Workbook wb;

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\saipa\\Desktop\\construction\\New Microsoft Excel Worksheet.xlsx");

		wb = new XSSFWorkbook(fis);

		sh = wb.getSheet("Sheet1");

		int rowcount =sh.getLastRowNum()- sh.getFirstRowNum();

		for (int i = 0; i < rowcount + 1; i++) {
			row = sh.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); i++) {

				System.out.print(row.getCell(j).getStringCellValue());

			}

			System.out.println();

		}
		
		
	fis.close();
	
	
	FileOutputStream fos=new FileOutputStream("C:\\Users\\saipa\\Desktop\\construction\\New Microsoft Excel Worksheet.xlsx");
		
		wb.write(fos);
		
		fos.close();
		
	 Row newrow = sh.createRow(rowcount+1);
	 
	 
	 for(int k=0;k<rowcount;k++)
	 {
		Cell cell = newrow.createCell(k);
		
		cell.setCellValue("pass");
		 
	 }
	 
	 ;
	
	System.out.println("value "+getdata(0,1));
	
		 
		 
		 
	 }
	
	
	 static String getdata(int rownum,int colnum)
	 {
		 
		Cell cell = sh.getRow(colnum).getCell(colnum);
		
		
		String data = cell.getStringCellValue();
		
		
		return data;
	 }
	 
		
		
			}
	
	
	
	
	
