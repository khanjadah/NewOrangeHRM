package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.SeleniumHelper;

public class HomePageFactory {
	// Page object model: organize based on pages by page
	
	SeleniumHelper sh = new SeleniumHelper()
;	
	public HomePageFactory(WebDriver driver) {

		driver = DriverManager.getDriver();
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@id='logInPanelHeading']")
	public WebElement loginPanelTitle;

	@FindBy(xpath = "//input[@id='txtUsername']")
	public WebElement ueserNameTextBox;

	@FindBy(xpath = "//input[@id='txtPassword']")
	public WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='btnLogin']")
	public WebElement loginButton;

	public void enterUserName(String userName) {

		sh.waitForElement(ueserNameTextBox).sendKeys(userName);
		
	}

	public void enterUserPassword(String userPassword) {

		sh.waitForElement(passwordTextBox).sendKeys(userPassword);
		
	}

	public void clickLoginButton() {

		loginButton.click();
	}

}
