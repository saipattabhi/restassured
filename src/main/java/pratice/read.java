 package pratice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class read {
	static Sheet sh;
	static Row row;
	static Workbook wb;

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\saipa\\Desktop\\construction\\New Microsoft Excel Worksheet.xlsx");
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet("Sheet1");

		// Get the current count of rows in excel file
		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		//int rowCount = sh.getLastRowNum();

		for (int i = 0; i < rowCount + 1; i++) { 
			row = sh.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue() + "||");
			}
			System.out.println();
		}
		fis.close();
		
		// Write Excel Data
		Row newRow = sh.createRow(rowCount + 1);

		for (int k = 0; k < row.getLastCellNum(); k++) {
			Cell cell = newRow.createCell(k);
			//cell.setCellType(CellType.STRING);
			cell.setCellValue("Pass");
		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\saipa\\Desktop\\construction\\New Microsoft Excel Worksheet.xlsx");
		wb.write(fos);
		fos.close();
		
		
		System.out.println("Particular row & col value from a cell is:" + getCellData(0, 1));
	}

	// To get the particular value from cell by using row & col index
	static String getCellData(int rowNum, int colNum) {

		Cell cell = sh.getRow(rowNum).getCell(colNum);
		String cellData = cell.getStringCellValue();
		return cellData;

	}
}
