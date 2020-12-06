package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.SeleniumHelper;

public class DashBoardPageFactory {
	// Page object model: organize based on pages

	SeleniumHelper sh = new SeleniumHelper();

	public DashBoardPageFactory(WebDriver driver) {

		driver = DriverManager.getDriver();
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	public WebElement dashBoardTitle;

	@FindBy(xpath = " //b[contains(text(),'PIM')]")
	public WebElement pimTitle;

	@FindBy(xpath = "//select[@id='empsearch_employee_status']")
	public WebElement employmentStatusDropDown;



	public String getTextDashBoardTitle() {

		return sh.waitForElement(dashBoardTitle).getText();
	}

	public void clickPim() {
		
		sh.waitForElement(pimTitle).click();

	}

	public void selectEmployeeStatus(int index) {
		
		sh.selectFromDropDown(employmentStatusDropDown, index);

	}

}	
