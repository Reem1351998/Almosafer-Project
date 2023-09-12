import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends parameter{

	
@BeforeTest 
public void BeforeTest() {
	
	driver.get(Almosafer1_TheWebSit);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
}

@Test(description="number 1",priority=1)
public void Check_Convert() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	String ActualLang=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
	MyAssert.assertEquals(ActualLang, ExpectEnglish);
}
@Test(description="number 2",priority=2)
public void CheckCurrency() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	String Actual_Currency=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button")).getText();
	
	MyAssert.assertEquals(Actual_Currency, Expect_Currency);
}

@Test(description="number 3",priority=3)
public void CheckNumber() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	
	String Actual_Number =driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[2]")).getText();
	
	MyAssert.assertEquals(Actual_Number, ExpectNumber);
}

@Test(description="number 4",priority=4)
public void Check_Qitaf() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	WebElement Footer =driver.findElement(By.tagName("footer"));
	List <WebElement>  The_List =Footer.findElements(By.tagName("svg"));
	for(int i=0;i<The_List.size();i++) {
	String Get_Attribute=The_List.get(i).getAttribute("data-testid"); 
		
		if(Get_Attribute == null) {  
			continue;
			
		}
		else if(Get_Attribute.contains("Footer__QitafLogo")) 
			Actual_Qitaf=true;
		
	}
	//System.out.println(Get_Attribute+" "+Get_Attribute.contains("Footer__QitafLogo"));}
	MyAssert.assertEquals(Actual_Qitaf, true);
}

@Test(description="number 5",priority=5)
public void Hotel_Tab_is_Not_Select() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	String ExpectedHotel="false";
	WebElement hotel=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
	String hotel_Attribute=hotel.getAttribute("aria-selected");
	//System.out.print(ExpectedHotel+"  "+hotel_Attribute+"  "+hotel_Attribute);
	MyAssert.assertEquals(hotel_Attribute, ExpectedHotel);
	
	
}

@Test(description="number 6",priority=6)
public void toDay_plus_Day() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	DateTimeFormatter toDay = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now().plusDays(1);
	String expectedDate =toDay.format(localDate);
	//System.out.println(toDay.format(localDate)); 
	
	MyAssert.assertEquals(toDay.format(localDate), expectedDate);
	  
}
@Test(description="number 7",priority=7)
public void toDay_plus_2Day() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	DateTimeFormatter toDay = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now().plusDays(2);
	String expectedDate =toDay.format(localDate);
	//System.out.println(toDay.format(localDate)); 
	
	MyAssert.assertEquals(toDay.format(localDate), expectedDate);
	  
}

//number 3
@Test(description="number 8",priority=8)

public void Random_Check_Langauge() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	String [] URL_Langauge={"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
	 int myIndex=rand.nextInt(0,2);
	 driver.get(URL_Langauge[myIndex]);
	 if(driver.getCurrentUrl().contains("ar")) {  
		String lang1= driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
	MyAssert.assertEquals(lang1, ExpectArabic);
	}
	 else {                                         
		String lang2 =driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
		 MyAssert.assertEquals(lang2, ExpectEnglish);
		 }
	
	
}

	//number 4
@Test(description="number 9",priority=9)
public void Search() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	String [] URL_Langauge={"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
	int myIndex=rand.nextInt(0,2);
	 driver.get(URL_Langauge[myIndex]);
	 
	String [] myArabic= {"دبي","جدة"};
	 int myArIndex=rand.nextInt(0,2);
	 
	String [] myEnglish= {"dubai","jeddah","riyadh"};
	int myEnIndex=rand.nextInt(0,3);
	
	
	 WebElement hotel_tab=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]/div"));
	 
	 
	 if(driver.getCurrentUrl().contains("ar")) {
		hotel_tab.click();
		Thread.sleep(200);
		WebElement SearchBar=driver.findElement(By.className("phbroq-2"));
		SearchBar.sendKeys(myArabic[myArIndex]+Keys.ARROW_DOWN);
		Thread.sleep(200);
		 WebElement SearchButton=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button/span"));
		 SearchButton.click();
		 Thread.sleep(200);
	 } 
		 
	 else {
		 hotel_tab.click();
		 Thread.sleep(200);
		 WebElement SearchBar=driver.findElement(By.className("phbroq-2"));
		
		 SearchBar.sendKeys(myEnglish[myEnIndex]+Keys.ARROW_DOWN);
		 Thread.sleep(200);
		 WebElement SearchButton=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button/span"));
		 SearchButton.click();
		 Thread.sleep(200);
			
		 
	 }
}
//number 5
@Test(description="number 10",priority=10)
public void Randomly_Select_Number_of_Vistor() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement Select_Vistor=driver.findElement(By.xpath("//*[@id=\"__next\"]/section[2]/div/section/div/div/div/div[1]/div[3]/div/select"));
	
	Select mySelect=new Select(Select_Vistor);
	int myIndex=rand.nextInt(0,2);
	Thread.sleep(200);
	mySelect.selectByIndex(myIndex);
	Thread.sleep(200);
	
}
//number 6
@Test(description="number 11",priority=11)
public void SearchButton() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement Search_button=driver.findElement(By.xpath("//*[@id=\"__next\"]/section[2]/div/section/div/div/div/div[1]/div[4]/button"));
	Thread.sleep(200);
	Search_button.click();
	Thread.sleep(200);
}

//number 7
@Test(description="number 12",priority=12)
public void Search_result_page() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement searchRes=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section/span"));
	
	String textRes=searchRes.getText();
	boolean SearchResultActual= (textRes.contains("found")||textRes.contains("وجدنا"));
	Thread.sleep(200);
	//System.out.println(textRes);
	
	MyAssert.assertEquals(SearchResultActual, true);

}

//number 8
@Test(description="number 13",priority=13)
public void sorting_Low_To_High() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement Lowest=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));
	Lowest.click();
	Thread.sleep(300);
	
	WebElement righ_tSide=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]"));
	
	List<WebElement> myPrices=righ_tSide.findElements(By.className("Price__Value"));
	String firstPrice=myPrices.get(0).getText();
	String LastPrice=myPrices.get(myPrices.size()-1).getText();
	int firstPriceInt=Integer.parseInt(firstPrice);
	int LastPriceInt=Integer.parseInt(LastPrice);
	
	MyAssert.assertEquals(firstPriceInt<LastPriceInt, true);
	
}
}
