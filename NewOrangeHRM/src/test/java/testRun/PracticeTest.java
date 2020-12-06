package testRun;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactory.DashBoardPageFactory;
import pageFactory.HomePageFactory;
import utils.DriverManager;
import utils.SeleniumHelper;

public class PracticeTest  {
	//When class object created,all the variable get initialized.

	@Test
	public void ourFirstTest() {

		DriverManager dm = new DriverManager();
		dm.openBrowser("chrome");

		SeleniumHelper sh =new SeleniumHelper();
		HomePageFactory hp = new HomePageFactory(DriverManager.getDriver());
		DashBoardPageFactory dashBoard = new DashBoardPageFactory(DriverManager.getDriver());
		SoftAssert sf = new SoftAssert();
		
		sh.goToUrl("https://opensource-demo.orangehrmlive.com/");
		
		/*sh.highlightElement(hp.passwordTextBox);
		sh.unhighlightElement(hp.passwordTextBox);
		//WebElement header = sh.getElement("//div[@id ='logInPanelHeading']");

		String title = header.getText();
		System.out.println(title);

		String title2 = sh.waitForElement(header).getText();
		System.out.println(title2);

		String title3 = sh.waitForElementFluent(header).getText();
		System.out.println(title3);*/
		
		String window1 = sh.getCurrentWindowHandle();
		System.out.println(window1);
		hp.enterUserName("Admin");
		hp.enterUserPassword("admin123");
		hp.clickLoginButton();
		sh.action().contextClick().perform();
		
		//sh.takeScreenShot();
//		sh.openUrlNewWindow("https://opensource-demo.orangehrmlive.com/");
		//sh.sleep(1);
//		sh.goToUrl("https://www.google.com/");
//	  //sh.switchWindow();
//		sh.switchToNextWindow();
//		sh.goToUrl("https://www.google.com/");
//		String window2 = sh.getCurrentWindowHandle();
//		System.out.println(window2);
		
		/*String expected = dashBoard.getTextDashBoardTitle();
		String actual ="Dashboard";

		Assert.assertEquals(actual,expected,"Hard test fail");
		sf.assertEquals(actual,expected,"Soft assert fail");
		sf.assertAll();

		System.out.println(actual);*/

		//header element not found,, bcoz it is on the home page.
		//System.out.println(sh.ifWebElementExist(header));

        sh.sleep(2);
		dm.quitBrowser();

}
	
	@Test
	public void test2() {
		
		SeleniumHelper sl = new SeleniumHelper();
		String cell1 = sl.getDataFromExcelSheet("documents/employees.xlsx","Sheet1", 1,0);
		System.out.println(cell1);
	}

}
