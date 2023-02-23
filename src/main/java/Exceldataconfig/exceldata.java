package Exceldataconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldata {

	XSSFWorkbook wb;
	XSSFSheet Sheet1;

	public exceldata(String excelpath) {
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getexceldata(int sheetno, int row, int column) {
		Sheet1 = wb.getSheetAt(sheetno);

		String boom = Sheet1.getRow(row).getCell(column).getStringCellValue();
		
		
		

		return boom;

	}

	public int getrow(int sheetindex) {
		int row = wb.getSheetAt(sheetindex).getLastRowNum();

		row = row + 1;
		
	

		return row;

	}

}
