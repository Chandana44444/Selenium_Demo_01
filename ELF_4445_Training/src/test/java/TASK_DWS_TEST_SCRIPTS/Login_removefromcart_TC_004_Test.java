package TASK_DWS_TEST_SCRIPTS;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TASK_DWS_ELEMENT_REPO.BooksPage;
import TASK_DWS_ELEMENT_REPO.Books_Computing_and_internet_Page;
import TASK_DWS_ELEMENT_REPO.LoginPage;
import TASK_DWS_ELEMENT_REPO.ShoppingCartPage;
import TASK_DWS_GENERIC_LIBRARY.BaseClass;
import TASK_DWS_GENERIC_LIBRARY.BasePage;
import TASK_DWS_GENERIC_LIBRARY.Excel_Library;

/***
 * 
 * @author Chandana
 * 
 */

public class Login_removefromcart_TC_004_Test extends BaseClass {

	@Test(groups = "Function")
	public void Login_removefromcart() {
		Reporter.log("TC_004",true);
		// 1.Login to the application.
		SoftAssert softassert = new SoftAssert();
		BasePage homePage = new BasePage(driver);
		String actual_welcome_url = "https://demowebshop.tricentis.com/";
		String expected_welcome_url = driver.getCurrentUrl();
		softassert.assertEquals(actual_welcome_url, expected_welcome_url, "Welcome page is displayed");
		homePage.getLoginLink().click();
		String actual_url = "https://demowebshop.tricentis.com/login";
		String expected_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url, "is in login page");
		Reporter.log("Login link is clicked", true);
		LoginPage loginPage = new LoginPage(driver);
		String email_id = Excel_Library.readStringData("Sheet1", 7, 0);
		loginPage.getEmailTextBox().sendKeys(email_id);
		String password = Excel_Library.readStringData("Sheet1", 8, 0);
		loginPage.getPasswordTextBox().sendKeys(password);
		loginPage.getLoginButton().click();
		Reporter.log("Login is successfull iff already registered else register and login", true);
		// 2..Click on "Books" link.
		boolean books_link = homePage.getBooks().isDisplayed();
		softassert.assertTrue(books_link);
		homePage.getBooks().click();
		Reporter.log("Books link is present in nav bar and is clicked", true);
		BooksPage book = new BooksPage(driver);
		// 3.Click on "Computing and Internet" book.
		boolean pdrt1_res = book.getComputing_and_Internet_Prdt1().isDisplayed();
		softassert.assertTrue(pdrt1_res, "Computing_and_Internet is present");
		book.getComputing_and_Internet_Prdt1().click();
		Reporter.log("Computing_and_Internet is clicked", true);
		Books_Computing_and_internet_Page prdt1 = new Books_Computing_and_internet_Page(driver);
		// 4.Click on "Add to cart" button.
		boolean addcart_button = prdt1.getAddtocart_button().isDisplayed();
		softassert.assertTrue(addcart_button, "Add to cart button is present");
		prdt1.getAddtocart_button().click();
		Reporter.log("Add to cart is clicked", true);
		// 5.Click on "Shopping cart" link.
		boolean shop_cart = homePage.getShoppingCartLink().isDisplayed();
		softassert.assertTrue(shop_cart, "ShoppingCartLink is present");
		homePage.getShoppingCartLink().click();
		Reporter.log("ShoppingCartLink is clicked", true);
		ShoppingCartPage shop = new ShoppingCartPage(driver);
		// 6.Select the "remove" checkbox.
		boolean remove_checkbox = shop.getRemove_checkbox().isDisplayed();
		softassert.assertTrue(remove_checkbox, "remove checkbox is present");
		shop.getRemove_checkbox().click();
		Reporter.log("Remove checkbox is clicked",true);
		// 7.Click on "update shopping cart" button.
		boolean update_shop_cart = shop.getUpdate_shopping_cart_button().isDisplayed();
		softassert.assertTrue(update_shop_cart, "update shopping cart is present");
		shop.getUpdate_shopping_cart_button().click();
		Reporter.log("update shopping cart button is clicked", true);

	}
}
