package TASK_DWS_TEST_SCRIPTS;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TASK_DWS_ELEMENT_REPO.RegistrationPage;
import TASK_DWS_GENERIC_LIBRARY.BaseClass;
import TASK_DWS_GENERIC_LIBRARY.BasePage;
import TASK_DWS_GENERIC_LIBRARY.Excel_Library;

/***
 * 
 * @author Chandana
 * 
 */

public class Registration_TC_001_Test extends BaseClass {

	@Test(groups = {"Integration","Function"})
	public void Register() throws EncryptedDocumentException, FileNotFoundException, IOException {
		Reporter.log("TC_001",true);
		SoftAssert softassert = new SoftAssert();
		String actual_welcome_url = "https://demowebshop.tricentis.com/";
		String expected_welcome_url = driver.getCurrentUrl();
		softassert.assertEquals(actual_welcome_url, expected_welcome_url, "Welcome page is displayed");
		BasePage homePage = new BasePage(driver);
		// 1.click on register link.
		softassert.assertTrue(homePage.getRegisterLink().isDisplayed(), "Registerlink is present");
		Reporter.log("Registerlink present in nav bar is clicked", true);
		homePage.getRegisterLink().click();
		String actual_url = driver.getCurrentUrl();
		String expected_url="https://demowebshop.tricentis.com/register";//will be given already
		Assert.assertEquals(actual_url, expected_url, "is in registration page");
		Reporter.log("driver focus is in registration page", true);
		RegistrationPage regPage = new RegistrationPage(driver);
		// 2.select the gender radio button.
		boolean gender_res = regPage.getGender_radio_button().isDisplayed();
		softassert.assertTrue(gender_res, "Gender radio button is present");
		regPage.getGender_radio_button().click();
		Reporter.log("gender is selected", true);
		// 3.Enter name in "First name" textbox.
		boolean fname_res = regPage.getFirstName_textbox().isDisplayed();
		softassert.assertTrue(fname_res, "first name textbox is present");
		String firstname = Excel_Library.readStringData("Sheet1", 1, 0);
		regPage.getFirstName_textbox().sendKeys(firstname);
		Reporter.log("firstname is entered", true);
		// 4.Enter last name in "Last name" textbox.
		boolean lname_res = regPage.getLastName_textbox().isDisplayed();
		softassert.assertTrue(lname_res, "last name textbox is present");
		String lastname = Excel_Library.readStringData("Sheet1", 2, 0);
		regPage.getLastName_textbox().sendKeys(lastname);
		Reporter.log("lastname is entered", true);
		// 5.Enter valid email-id in "Email" textbox.
		boolean email_res = regPage.getEmail_textbox().isDisplayed();
		softassert.assertTrue(lname_res, "email textbox is present");
		String email = Excel_Library.readStringData("Sheet1", 3, 0);
		regPage.getEmail_textbox().sendKeys(email);
		Reporter.log("Email-id is entered", true);
		// 6.Enter the password in "Password" textbox.
		boolean password_res = regPage.getPassword_textbox().isDisplayed();
		softassert.assertTrue(password_res, "password textbox is present");
		String password = Excel_Library.readStringData("Sheet1", 4, 0);
		regPage.getPassword_textbox().sendKeys(password);
		Reporter.log("Password is entered", true);
		// 7.Enter the same password in "Confirm password" textbox.
		boolean confirmpassword_res = regPage.getConfirmPassword_textbox().isDisplayed();
		softassert.assertTrue(confirmpassword_res, "confirm password textbox is present");
		String confirmpassword = Excel_Library.readStringData("Sheet1", 5, 0);
		regPage.getConfirmPassword_textbox().sendKeys(confirmpassword);
		Reporter.log("confirm password is entered", true);
		// 8.Click on "register" button.
		boolean reg_res = regPage.getRegister_button().isDisplayed();
		softassert.assertTrue(reg_res, "register button is present");
		regPage.getRegister_button().click();
		Reporter.log("Register button is clicked", true);
		//Reporter.log("successfully registered iff registering for the first time", true);
		boolean msg = driver.findElement(By.xpath("//li[text()='The specified email already exists']")).isDisplayed();
		Assert.assertTrue(msg);
		Reporter.log("The specified email already exists", true);
		softassert.assertAll();

	}

}
