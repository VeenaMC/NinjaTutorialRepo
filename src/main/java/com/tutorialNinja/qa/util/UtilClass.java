package com.tutorialNinja.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.tutorialNinja.qa.base.BaseClass;

public class UtilClass extends BaseClass{
	
	public static long IMPLICIT_WAIT = 20;
	
	//Common code for switching into frame
	public void switchToFrame() {
		driver.switchTo().frame("framename");
	}
	
	//To fetch test data from excel file
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH= "C:\\Users\\veena.mc\\eclipse-workspace\\MavenHybridFramework\\TutorialsNinjaDemoProj\\src\\main\\java\\com\\tutorialNinja\\qa\\testdata\\NinjaTutorial_TestData.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}		
		return data;	
	}
}
