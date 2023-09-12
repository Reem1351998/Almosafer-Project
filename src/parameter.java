import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class parameter {
	

	WebDriver driver =new ChromeDriver();
	
	String ExpectEnglish ="العربية";
	String ExpectArabic ="English";
	String Expect_Currency ="SAR";
	String ExpectNumber="+966554400000";
	String Almosafer1_TheWebSit= "https://www.almosafer.com/en";
	String ExpectedHotel="false";
	
	
	boolean Actual_Qitaf;
	Assertion MyAssert = new   Assertion();
	Random rand=new Random();

	
}
