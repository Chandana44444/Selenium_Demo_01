package TASK_DWS_TEST_SCRIPTS;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TASK_DWS_ELEMENT_REPO.BooksPage;
import TASK_DWS_ELEMENT_REPO.Books_Computing_and_internet_Page;
import TASK_DWS_ELEMENT_REPO.CheckoutPage;
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

public class Login_Buy_TC_005_Test extends BaseClass {

	@Test(groups = "Function")
	public void Login_wishlist_Buy() {
		Reporter.log("TC_005",true);
		// 1.Login to the application.
		SoftAssert softassert = new SoftAssert();
		String actual_welcome_url = "https://demowebshop.tricentis.com/";
		String expected_welcome_url = driver.getCurrentUrl();
		softassert.assertEquals(actual_welcome_url, expected_welcome_url, "Welcome page is displayed");
		BasePage homePage = new BasePage(driver);
		homePage.getLoginLink().click();
		String actual_url = "https://demowebshop.tricentis.com/login";
		String expected_url = driver.getCurrentUrl();
		System.out.println(expected_url);
		Assert.assertEquals(actual_url, expected_url);
		Reporter.log("Login link is clicked", true);
		LoginPage loginPage = new LoginPage(driver);
		String email_id = Excel_Library.readStringData("Sheet1", 7, 0);
		loginPage.getEmailTextBox().sendKeys(email_id);
		String password = Excel_Library.readStringData("Sheet1", 8, 0);
		loginPage.getPasswordTextBox().sendKeys(password);
		loginPage.getLoginButton().click();
		Reporter.log("Login is successfull if already registered", true);
		// 2..Click on "Books" link.
		boolean booklink_res = homePage.getBooks().isDisplayed();
		softassert.assertTrue(booklink_res, "Books link is present in nav bar");
		homePage.getBooks().click();
		Reporter.log("Books link is clicked");
		BooksPage book = new BooksPage(driver);
		// 3.Click on "Computing and Internet" book.
		boolean prdt1_res = book.getComputing_and_Internet_Prdt1().isDisplayed();
		softassert.assertTrue(prdt1_res, "Computing_and_Internet_Prdt1 is present in nav bar");
		book.getComputing_and_Internet_Prdt1().click();
		Reporter.log("Computing_and_Internet is clicked", true);
		Books_Computing_and_internet_Page prdt1 = new Books_Computing_and_internet_Page(driver);
		// 4.Click on "Add to cart" button.
		boolean add = prdt1.getAddtocart_button().isDisplayed();
		softassert.assertTrue(add, "Addtocart button is present");
		prdt1.getAddtocart_button().click();
		Reporter.log("Add to cart is clicked", true);
		// 5.Click on "Shopping cart" link.
		boolean shop_cart = homePage.getShoppingCartLink().isDisplayed();
		softassert.assertTrue(shop_cart, "ShoppingCartLink is present");
		homePage.getShoppingCartLink().click();
		Reporter.log("ShoppingCartLink is clicked", true);
		// 6.Select the country from country dropdown.
		ShoppingCartPage shop = new ShoppingCartPage(driver);
		boolean country_res = shop.getCountry_id_dropdown().isDisplayed();
		softassert.assertTrue(country_res, "Country dropdown is present");
		shop.getCountry_id_dropdown().click();
		Reporter.log("country dropdown is clicked", true);
		WebElement multilistbox1 = driver.findElement(By.id("CountryId"));
		Select op1 = new Select(multilistbox1);
		op1.selectByVisibleText("India");
		// 7.Select terms of service checkbox.
		boolean terms = shop.getTerms_checkbox().isDisplayed();
		Assert.assertTrue(terms);
		shop.getTerms_checkbox().click();
		Reporter.log("terms checkbox is clicked", true);
		// 8.click on "checkout" button.
		boolean shop_res = shop.getCheckoutbox().isDisplayed();
		Assert.assertTrue(shop_res);
		shop.getCheckoutbox().click();
		Reporter.log("checkout box is clicked", true);
		// 9.click on "Continue" buttons respectively
		CheckoutPage check = new CheckoutPage(driver);
		check.getContinue1_button().click();
		check.getContinue2_button().click();
		check.getContinue3_button().click();
		check.getContinue4_button().click();
		check.getContinue5_button().click();
		Reporter.log("respective continue buttons are clicked",true);
		// 10.click on "confirm" button.
		check.getconfirm_button().click();
		Reporter.log("confirm button is clicked",true);
		WebElement actual = driver.findElement(By.xpath("//h1[text()='Thank you']"));
		String actual_text = actual.getText();
		String expected_text = "Thank you";//will be given already
		Assert.assertEquals(actual_text, expected_text);
		Reporter.log("your order has been successfully processed!", true);

	}

}
