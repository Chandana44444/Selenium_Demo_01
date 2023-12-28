package TASK_DWS_TEST_SCRIPTS;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TASK_DWS_ELEMENT_REPO.BooksPage;
import TASK_DWS_ELEMENT_REPO.Books_Computing_and_internet_Page;
import TASK_DWS_ELEMENT_REPO.LoginPage;
import TASK_DWS_GENERIC_LIBRARY.BaseClass;
import TASK_DWS_GENERIC_LIBRARY.BasePage;
import TASK_DWS_GENERIC_LIBRARY.Excel_Library;
import junit.framework.Assert;

/***
 * 
 * @author Chandana
 * 
 */

public class Login_Addtocart_TC_003_Test extends BaseClass {

	@SuppressWarnings("deprecation")
	@Test(groups = "Function")
	public void Login_addtocart() {
		Reporter.log("TC_003",true);
		// 1.Login to the application.
		SoftAssert softassert = new SoftAssert();
		String actual_welcome_url = "https://demowebshop.tricentis.com/";
		String expected_welcome_url = driver.getCurrentUrl();
		softassert.assertEquals(actual_welcome_url, expected_welcome_url, "Welcome page is displayed");
		BasePage homePage = new BasePage(driver);
		boolean loginlink_res = homePage.getLoginLink().isDisplayed();
		Assert.assertTrue(loginlink_res);
		homePage.getLoginLink().click();
		Reporter.log("loginlink is clicked", true);
		boolean res = driver.findElement(By.xpath("//strong[text()='Returning Customer']")).isDisplayed();
		Assert.assertTrue(res);
		LoginPage loginPage = new LoginPage(driver);
		String email_id = Excel_Library.readStringData("Sheet1", 7, 0);
		loginPage.getEmailTextBox().sendKeys(email_id);
		String password = Excel_Library.readStringData("Sheet1", 8, 0);
		loginPage.getPasswordTextBox().sendKeys(password);
		loginPage.getLoginButton().click();
		Reporter.log("Login is successfull iff already registered else register and then login", true);
		// 2..Click on "Books" link.
		boolean book_link = homePage.getBooks().isDisplayed();
		Assert.assertTrue(book_link);
		homePage.getBooks().click();
		Reporter.log("Books link is present in nav bar and is clicked", true);
		BooksPage book = new BooksPage(driver);
		// 3.Click on "Computing and Internet" book.
		boolean prdt1_res = book.getComputing_and_Internet_Prdt1().isDisplayed();
		Assert.assertTrue(prdt1_res);
		book.getComputing_and_Internet_Prdt1().click();
		Reporter.log("Computing_and_Internet product is clicked", true);
		// 4.Click on "Add to cart" button.
		Books_Computing_and_internet_Page prdt1 = new Books_Computing_and_internet_Page(driver);
		boolean addtocart_button_res = prdt1.getAddtocart_button().isDisplayed();
		Assert.assertTrue(addtocart_button_res);
		prdt1.getAddtocart_button().click();
		Reporter.log("Add to cart is clicked", true);
		// 5.Click on "Shopping cart" link.
		boolean shopcart = homePage.getShoppingCartLink().isDisplayed();
		Assert.assertTrue(shopcart);
		homePage.getShoppingCartLink().click();
		Reporter.log("ShoppingCartLink is clicked",true);
	}
}
