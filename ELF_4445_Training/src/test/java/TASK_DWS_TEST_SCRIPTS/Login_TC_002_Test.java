package TASK_DWS_TEST_SCRIPTS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import TASK_DWS_ELEMENT_REPO.LoginPage;
import TASK_DWS_GENERIC_LIBRARY.BaseClass;
import TASK_DWS_GENERIC_LIBRARY.BasePage;
import TASK_DWS_GENERIC_LIBRARY.Excel_Library;

/***
 * 
 * @author Chandana
 * 
 */

public class Login_TC_002_Test extends BaseClass {

	@Test(groups = "Function")

	public void Login() throws AWTException {
		Reporter.log("TC_002",true);
		BasePage homePage = new BasePage(driver);
		// 1.Click on Login link.
		homePage.getLoginLink().click();
		String actual_url = "https://demowebshop.tricentis.com/login";
		String expected_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url, "Log in is present");
		Reporter.log("Login link is clicked", true);
		LoginPage loginPage = new LoginPage(driver);
		// 2.Enter the registered email in Email textbox.
		boolean res = driver.findElement(By.xpath("//strong[text()='Returning Customer']")).isDisplayed();
		Assert.assertTrue(res, "is in login page");
		String email_id = Excel_Library.readStringData("Sheet1", 7, 0);
		boolean email_res = loginPage.getEmailTextBox().isDisplayed();
		Assert.assertTrue(email_res, "email id textbox is present");
		loginPage.getEmailTextBox().sendKeys(email_id);
		Reporter.log("Email-id is Entered already registered", true);
		// 3.Enter the valid password in Password textbox.
		boolean password_res = loginPage.getPasswordTextBox().isDisplayed();
		Assert.assertTrue(password_res, "password textbox is present");
		String password = Excel_Library.readStringData("Sheet1", 8, 0);
		loginPage.getPasswordTextBox().sendKeys(password);
		Reporter.log("Password is Entered already registered", true);
		// loginPage.getRememberMeCheckBox().click();
		// 4.Click on Login button.
		boolean login_button_res = loginPage.getLoginButton().isDisplayed();
		Assert.assertTrue(login_button_res, "login button is present");
		loginPage.getLoginButton().click();
		Reporter.log("Login Button is clicked and login is successfull", true);

	}

}
