package practice;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*Hooks are annotation its  used to run a piece of code over and over again without having to write it.
There are few different hooks , and each have differnt functionality.
1)@Before method- it will run before each test method.
2)@Before class- it will run before that class.
3)@Before Group- it will run before each group
4)@Before test- it will run before entire test run.
5)@Before suite- it will run before each test suite
All of them after annotation also.*/

public class HookPractice {
	//1
	@BeforeSuite
	public void beforesuite() {
		
		System.out.println("This is before suite ");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("This is After suite");
	}
	
	@BeforeGroups
	public void beforeGroup() {
		
		System.out.println("This is before group ");
	}
	
	@AfterGroups
	public void afterGroup() {
		
		System.out.println("This is After group ");
	}
	//2
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("This is before All test");
	}
	//14
	@AfterTest
	public void afterTest() {
		
		System.out.println("This is After All test");
	}
	//3
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("This is before class");
	}
	//13
	@AfterClass
	public void afterClass() {
		
		System.out.println("This is After  class");
	}
	//4  //7 //10
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}
	//6 //9 //12
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After method");
	}
	//5
	@Test(groups = {"Odd","Red"},priority = 0)
	public void test1() {

		System.out.println("this is test one");
	}
	
	//8
	@Test(groups = "Even")
	public void test2() {

		System.out.println("this is test Two");
	}
	//11
	@Test(groups = "Odd")
	public void test3() {

		System.out.println("this is test Three");
	}
}
