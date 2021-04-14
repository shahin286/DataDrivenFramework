package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotName;
	public static String screenshotPath;

	//TO CAPTURE A SCREENSHOT
	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		screenshotName = d.toString().replace(":", "__").replace(" ", "_") + ".jpg";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	//TO FID DATA FROM EXCEL FILE
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));

				data[rowNum - 2][0] = table;

			}
		}

		return data;
	}
	
	//TO RUN A PARTICULAR DATA FROM EXCEL SHEET
	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "TestSuite";
		int rows = excel.getRowCount(sheetName);
		
		for (int rNum=2; rNum<=rows; rNum++) {
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if(testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, "Runmode", rNum);
				if(runMode.equalsIgnoreCase("Y")) 
					return true;
				else
					return false;
			}
			
		}
		
		return false;	
	}

}
