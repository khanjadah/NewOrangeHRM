package utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverManager {

	/* Unconditional - Thread.sleep().
	 * Implicit wait, expilicit wait and fluent wait for Synchronization.
	 * Implicit wait- only used throughout the entire run.It is the wait from the DOM.Some amount of time-
	 * will be assigned.IT  is used for find element and find elements.
	 * Explicit wait- has more condition not just time. it will only wait for that specific element, used for element by element case.
	 * Fluent wait- it similar to explicit wait but it has polling time.Meaning it has intervals.eg: checking every 5 sec in the duration of the entire wait time
	 * If the Code has both implicit and explicit wait, what will be the total wait time?
	 */

	private static WebDriver driver = null;


	public static WebDriver getDriver() {
		return driver;
	}


	public WebDriver openBrowser(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","/Users/hurayra/Downloads/chromedriver");
			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("FireFox")) {

			//System.setProperty("webdriver.gecko.driver","//Drivers/geckodriver");

			driver = new FirefoxDriver();

		}
		else if(browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver","/Users/hurayra/Downloads/edgedriver_mac64/msedgedriver");

			driver = new EdgeDriver();

		}

		else if(browser.equalsIgnoreCase("Safari")) {

			driver = new SafariDriver();

		}

		else if(browser.equalsIgnoreCase("opera")) {

			System.setProperty("webdriver.gecko.driver","/Users/hurayra/Downloads/operadriver_mac64 3/operadriver");

			driver = new OperaDriver();
		}

		else {

			System.out.println("Incorrect Driver, Please choose a correct driver");
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		return driver;
	}

	public void quitBrowser() {

		driver.quit();
	}

	public void closeBrowser() {

		driver.close();
	}

}
