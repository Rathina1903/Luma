package org.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("In Valid Browser Type");
			break;
		}

	}

	public void getUrl(String url) {
		driver.get(url);

	}

	public void winMax() {
		driver.manage().window().maximize();
	}
	public WebElement element(String xpath)  {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

	public void textSend(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}
	public void textSendByJS(WebElement element, String keysToSend) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
	}

	public void screenCapture(String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\velu\\JavaEnt\\SELENIUM\\New folder\\" + name + ".png");
		FileUtils.copyFile(source, des);

	}

	public String getWindowsID(int index) {

		String parentWindowsID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> li = new LinkedList<String>();
		li.addAll(allWindowsID);
		String childWindowsID = li.get(index);
		return childWindowsID;

	}

	public void windowsHandle(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	public void selectByValue(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void framewSwitch(WebElement element) {

		driver.switchTo().frame(element);
	}

	public static String readExcell(int rownum, int cellnum) throws IOException {

		File file = new File("D:\\SUBJECT\\SELINIUM FRAMEWORK\\JD.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook book = new XSSFWorkbook(stream);

		Sheet sheet = book.getSheet("Sheet5");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();

		String value = null;

		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();

			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();
			}

			break;

		default:
			break;
		}
		return value;

	}

	public void scrollDown(WebElement element, String Scrolldown) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(Scrolldown, element);
		}
	
	public void ScrollUp(WebElement element, String ScrollUp) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(ScrollUp, element);
		}
	

	public void moveToElement(WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		}



	





}


