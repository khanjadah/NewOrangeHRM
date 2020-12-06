package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class SeleniumHelper {

	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait;

	// will return title of the page
	public String getTitle() {

		return driver.getTitle();
	}


	public String getCurrentURL() {

		return driver.getCurrentUrl();
	}


	// will go to the given website.
	public void goToUrl(String url) {

		driver.get(url);
	}

	//navigate to given website	
	public void navigateToUrl(String url) {

		driver.navigate().to(url);
	}

	//Go to previous page
	public void navigateBack() {

		driver.navigate().back();
	}

	//Go to forward page
	public void navigateForward() {

		driver.navigate().forward();
	}

	//Refresh page.
	public void refreshPage() {

		driver.navigate().refresh();
	}


	//Hard sleep,with given amount in second
	public void sleep(int sec) {

		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {


			e.printStackTrace();
			System.out.println("System broke while sleeping");
		}

	}

	// Will get the element and return element.
	public WebElement getElement(String locator) {

		return driver.findElement(By.xpath(locator));



	}


	//Explicit wait function:  will search for element until given condition is met.
	public WebElement waitForElement(WebElement element) {


		wait = new WebDriverWait(driver, 20);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		highlightElement(element);
		unhighlightElement(element);

		return webElement;
	}

	//Fluent wait will search for an element after every interval of time until the condition is met
	public WebElement waitForElementFluent(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);


		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	//Will check if WebElement exist and return true or false.
	public boolean ifWebElementExist(WebElement element) {
		boolean isPresent;

		try {

			wait = new WebDriverWait(driver,20);
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			return isPresent;

		}
		catch(Exception e) {
			return false;
		}

	}
	//High light element
	public void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '3px solid red'",element);
		sleep(1);
	}

	//UNHigh light element
	public void unhighlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '0px solid red'",element);
		sleep(1);
	}

	//select from the dropdown, by index
	public void selectFromDropDown(WebElement element,int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	//select by value
	public void selectFromDropDown(WebElement element,String value) {

		Select s = new Select(element);
		s.selectByValue(value);

	}

	//handle alert
	public void acceptAlert() {

		Alert a = driver.switchTo().alert();
		a.accept();
	}

	//Dissmiss alert
	public void dismissAlert() {

		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	//Switch to iFrame
	public void switchToIframe(int index) {
		driver .switchTo().frame(index);
	}

	public void switchToIframe(String value) {
		driver .switchTo().frame(value);
	}

	//switch to parent
	public void switchToParentframe() {
		driver .switchTo().parentFrame();
	}

	//Get window handeld
	public String getCurrentWindowHandle() {

		return driver.getWindowHandle();
	}

	//Switch to new window
	public String switchWindow() {

		String parentWindow = getCurrentWindowHandle();
		Set <String> allWindows = driver.getWindowHandles();
		for(String windows : allWindows) {

			driver.switchTo().window(windows);
		}

		String childWindow = getCurrentWindowHandle();
		return childWindow;

	}

	//Switch to next window
	public void switchToNextWindow() {

		String parent = getCurrentWindowHandle();
		Set <String> AllWindow = driver.getWindowHandles();
		for(String window : AllWindow) {

			if(!window.equals(parent)) {

				driver.switchTo().window(window);
			}
		}

	}

	//Open new window
	public void openNewWindow(WebElement element) {

		element.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));

	}

	//Open url in a new window
	public void openUrlNewWindow(String url) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + url + "')");
		// "window.open('www.google.com')"
	}

	//Date Function
	public String date() {

		DateFormat df = new SimpleDateFormat("MM-dd-yy HH.mm.ss");
		Date date = new Date();
		String finaldate = df.format(date);
		return finaldate;
	}

	//Take screen shot-
	public void takeScreenShot() {

		String name = "Screen Shot " + date() + ".png" ;
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {

			File localScreenshot = new File(new File("Build"), "Screenshots");

			if(!localScreenshot.exists() || !localScreenshot.isDirectory()) {

				localScreenshot.mkdirs();

			}
			File Screenshot = new File(localScreenshot,name);
			Files.copy(sourceFile,Screenshot);
		}
		catch(IOException e) {

			System.out.println("Screenshot capture failed");

		}
	}

	//To raed Excel sheet
	public String getDataFromExcelSheet(String path, String sheetName,int rownum,int cellnum ) {

		String data = null;
		try {

			File file = new File(path);
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetName);
			data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();



		}
		catch(IOException e) {
			System.out.println("Unable to raed file");
		}

		return data;
	}

	//Action- to handle keyboard and mouse action-
	public Actions action() {

		Actions actions = new Actions(driver);
		return actions;
	}

}
