package testRun;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asserts {

	/*There r 2 types of assert, it help us to determine the result of the test.
	Hard assert; if we have multiple assert, if the first assert fail, it fails the entire test
	it does not continue.
    Soft assert: however, soft assert continues throughout the test run , before failing the test
	 */ 
	@Test
	public void hardAssert() {

		AssertJUnit.assertEquals(2,2);

		AssertJUnit.assertEquals("shoshe","Hurayra");

		AssertJUnit.assertEquals(12,13);
	}

	@Test
	public void softAssert() {

		SoftAssert sa = new SoftAssert();
		AssertJUnit.assertEquals(1,1);

		AssertJUnit.assertEquals("Hurayra","Hurayra");

		AssertJUnit.assertEquals(12, "Hu");

		sa.assertAll();

		//Any time we are using soft assert, we have to finish it by - Assert all()
	}

}
