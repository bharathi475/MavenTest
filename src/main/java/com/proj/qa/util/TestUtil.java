package com.proj.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.proj.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long pageLoadTime = 20;
	public static long implicitTime = 10;	
	
	public static int xOffset = 200;
	public static int yOffset = 200;
	
	
	public static String loginPageTitle = "Cogmento CRM";
	public static String homePageTitle = "Cogmento CRM";
	public static String userNameLabel = "Bharathi kannan";
	public static String contactName1 = "Tester1 One";
	public static String contactName2 = "Tester2 Two";
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\admin\\eclipse-workspace\\MavenTest\\src\\main\\java\\com\\proj\\qa\\testdata\\FreeCRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	//Actions:
	Actions action = new Actions(driver);
	
	public void hoverAndMoveToElement(WebElement hoverElement, WebElement DestinationElement) {
		action.moveToElement(hoverElement).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));
		DestinationElement.click();		
	}
	
	public void actionMoveToElement(WebElement hoverElement) {
		action.moveToElement(hoverElement).build().perform();
	}
	
	public void mouseMoveByOffset(int xOff, int yOff) {
		action.moveByOffset(xOff, yOff).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicitTime));
	}
	
	public void selectDropDown(WebElement element, String text) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		 System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//				 System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public void takeScreenshots() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
		}

}
