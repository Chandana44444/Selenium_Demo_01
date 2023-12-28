package Set2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lakme_01 
{
//	@Parameters("browsername")//cannot inject(if not given this(Xml))
	@Test
	//public void lakme(@Optional("firefox")String browsername)
//	public void lakme(String browsername)
	public void lakme()
	{
		WebDriver driver=null;
		String browsername = System.getProperty("bname");
		String url=System.getProperty("url");
		if(browsername.equalsIgnoreCase("firefox"))
		{
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver=new ChromeDriver();
		}
		else
		{
			Reporter.log("Invalid browser name",true);
		}
		driver.manage().window().maximize();
//		driver.get("https://www.lakmeindia.com/");
		driver.get(url);
		Reporter.log("From Lakme",true);
		driver.quit();
		}
}
