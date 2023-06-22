package Resources;


import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class commonUtilities {
	public static WebDriver driver;
	//to handle assertions
	public static void handleAssertions(String expected, String actual) {
		SoftAssert sa = new SoftAssert();
		String expectedString = expected;
		String actualString = actual;
		sa.assertEquals(actualString, expectedString);
		sa.assertAll();
	}
}
