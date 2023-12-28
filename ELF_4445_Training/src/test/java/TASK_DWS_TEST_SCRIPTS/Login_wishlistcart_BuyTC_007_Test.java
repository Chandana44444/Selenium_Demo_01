package TASK_DWS_TEST_SCRIPTS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TASK_DWS_ELEMENT_REPO.Apparel_shoes_Page;
import TASK_DWS_ELEMENT_REPO.CheckoutPage;
import TASK_DWS_ELEMENT_REPO.LoginPage;
import TASK_DWS_ELEMENT_REPO.ShoppingCartPage;
import TASK_DWS_ELEMENT_REPO.WishListPage;
import TASK_DWS_GENERIC_LIBRARY.BaseClass;
import TASK_DWS_GENERIC_LIBRARY.BasePage;
import TASK_DWS_GENERIC_LIBRARY.Excel_Library;

/***
 * 
 * @author Chandana
 * 
 */

public class Login_wishlistcart_BuyTC_007_Test extends BaseClass {

	@Test(groups = "Integration")
	public void Login_wishlist() {
		Reporter.log("TC_007",true);
		SoftAssert softassert = new SoftAssert();
		String actual_welcome_url = "https://demowebshop.tricentis.com/";
		String expected_welcome_url = driver.getCurrentUrl();
		softassert.assertEquals(actual_welcome_url, expected_welcome_url, "Welcome page is displayed");
		BasePage homePage = new BasePage(driver);
		// 1.Click on Login link.
		boolean loginlink_res = homePage.getLoginLink().isDisplayed();
		Assert.assertTrue(loginlink_res);
		homePage.getLoginLink().click();
		Reporter.log("Login link is clicked", true);
		LoginPage loginPage = new LoginPage(driver);
		// 2.Enter the registered email in Email textbox.
		boolean res = driver.findElement(By.xpath("//strong[text()='Returning Customer']")).isDisplayed();
		Assert.assertTrue(res, "is in login page");
		String email_id = Excel_Library.readStringData("Sheet1", 7, 0);
		loginPage.getEmailTextBox().sendKeys(email_id);
		// 3.Enter the valid password in Password textbox.
		String password = Excel_Library.readStringData("Sheet1", 8, 0);
		loginPage.getPasswordTextBox().sendKeys(password);
		// 4.Click on Login button.
		loginPage.getLoginButton().click();
		Reporter.log("was able to login successfully with already registered details", true);
		// 5.Click On apparel and shoes link
		boolean prdt_res = homePage.getApparalesAndShoes().isDisplayed();
		Assert.assertTrue(prdt_res);
		homePage.getApparalesAndShoes().click();
		Reporter.log("Apparels link is clicked", true);
		Apparel_shoes_Page prdt = new Apparel_shoes_Page(driver);
		Reporter.log("Apparels page is opened", true);
		// 3.Click on blue and green Sneaker .
		boolean res1 = prdt.getBlue_and_green_Sneaker_Prdt1().isDisplayed();
		Assert.assertTrue(res1);
		prdt.getBlue_and_green_Sneaker_Prdt1().click();
		Reporter.log("blue and green Sneaker is clicked", true);
		// 4.Click on "Add to wishlist" button.
		boolean wish_res = prdt.getWishlist_button().isDisplayed();
		Assert.assertTrue(wish_res);
		prdt.getWishlist_button().click();
		Reporter.log("Wishlist button is clicked", true);
		// 5.Click on "WishList" link.
		boolean wishlink_res = homePage.getWishlistLink().isDisplayed();
		Assert.assertTrue(wishlink_res);
		homePage.getWishlistLink().click();
		Reporter.log("Wishlist link is clicked", true);
		// 6.Select the add to cart checkbox of particular product.
		WishListPage wish = new WishListPage(driver);
		boolean add = wish.getAddtocart_checkbox().isDisplayed();
		Assert.assertTrue(add);
		wish.getAddtocart_checkbox().click();
		Reporter.log("add to cart checkbox is clicked", true);
		// 7.Click on "add to cart" button.
		boolean add_button = wish.getAddtocart_button().isDisplayed();
		Assert.assertTrue(add_button, "Add to cart button is present");
		wish.getAddtocart_button().click();
		Reporter.log("add to cart button is clicked", true);
		ShoppingCartPage shop = new ShoppingCartPage(driver);
		// 8.Click on "Country" drop down.
		boolean country_dropdown = shop.getCountry_id_dropdown().isDisplayed();
		Assert.assertTrue(country_dropdown, "Country drop-down is present");
		shop.getCountry_id_dropdown().click();
		Reporter.log("country dropdown is clicked", true);
		WebElement multilistbox1 = driver.findElement(By.id("CountryId"));
		Select op1 = new Select(multilistbox1);
		op1.selectByVisibleText("India");
		// 9.Select terms of service checkbox.
		boolean terms = shop.getTerms_checkbox().isDisplayed();
		Assert.assertTrue(terms, "Terms checkbox is present");
		shop.getTerms_checkbox().click();
		Reporter.log("terms checkbox is clicked", true);
		// 10.click on "checkout" button.
		boolean checkout_box = shop.getCheckoutbox().isDisplayed();
		Assert.assertTrue(checkout_box, "Check out is present");
		shop.getCheckoutbox().click();
		Reporter.log("checkout box is clicked", true);
		// 9.click on "continue" button
		CheckoutPage check = new CheckoutPage(driver);
		check.getContinue1_button().click();
		check.getContinue2_button().click();
		check.getContinue3_button().click();
		check.getContinue4_button().click();
		check.getContinue5_button().click();
		Reporter.log("continue buttons are clicked");
		// 10.click on "confirm" button
		check.getconfirm_button().click();
		Reporter.log("confirm button is clicked");
		WebElement actual = driver.findElement(By.xpath("//h1[text()='Thank you']"));
		String actual_text = actual.getText();
		String expected_text = "Thank you";
		String msg = " Your order has been successfully processed!";
		Assert.assertEquals(actual_text, expected_text, msg);
		Reporter.log("your order has been successfully processed!", true);

	}
}
