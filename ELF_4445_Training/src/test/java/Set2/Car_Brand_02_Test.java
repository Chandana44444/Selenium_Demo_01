package Set2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Car_Brand_02_Test 
{
	//@Test(groups={"Functional","Regression"})
	@Test
	public void MarutiSuzuki()
	{
		//int divide=10/0;
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.marutisuzuki.com/");
		Reporter.log("From Maruti suzuki",true);
		driver.quit();
	}
	
}
