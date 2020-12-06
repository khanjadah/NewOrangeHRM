package practice;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;



public class HookPractice2 extends HookPractice{
	
	@Test(groups ="Even")
	public void test4() {

		System.out.println("this is test 4");
	}
	@Test(groups ="Odd")
	public void test5() {

		System.out.println("this is test 5");
	}
	@Test(groups ="Even")
	public void test6() {

		System.out.println("this is test 6");
	}

}
