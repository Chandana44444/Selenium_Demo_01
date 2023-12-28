package TASK_DWS_TEST_SCRIPTS;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TASK_DWS_ELEMENT_REPO.Apparel_shoes_Page;
import TASK_DWS_ELEMENT_REPO.LoginPage;
import TASK_DWS_ELEMENT_REPO.WishListPage;
import TASK_DWS_GENERIC_LIBRARY.BaseClass;
import TASK_DWS_GENERIC_LIBRARY.BasePage;
import TASK_DWS_GENERIC_LIBRARY.Excel_Library;

/***
 * 
 * @author Chandana
 * 
 */

public class Login_wishlistcart_TC_006_Test extends BaseClass {

	@Test(groups = "Integration")

	public void Login_wishlist() {
		Reporter.log("TC_006",true);
		SoftAssert softassert = new SoftAssert();
		String actual_welcome_url = "https://demowebshop.tricentis.com/";
		String expected_welcome_url = driver.getCurrentUrl();
		softassert.assertEquals(actual_welcome_url, expected_welcome_url, "Welcome page is displayed");
		//1.Click on Login link.
		BasePage homePage = new BasePage(driver);
		boolean loginlink_res = homePage.getLoginLink().isDisplayed();
		Assert.assertTrue(loginlink_res);
		homePage.getLoginLink().click();
		Reporter.log("Login link is present in home page and is clicked", true);
		//2.Enter the registered email in Email textbox.
		LoginPage loginPage = new LoginPage(driver);
		String email_id = Excel_Library.readStringData("Sheet1", 7, 0);
		loginPage.getEmailTextBox().sendKeys(email_id);
		//3.Enter the valid password in Password textbox.
		String password = Excel_Library.readStringData("Sheet1", 8, 0);
		loginPage.getPasswordTextBox().sendKeys(password);
		//4.Click on Login button.
		loginPage.getLoginButton().click();
		Reporter.log("Login is successfull iff already registered details are provided",true);
		boolean logout = driver.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(logout);
		Reporter.log("was able to Login successfully iff already registered details are provided",true);
		//2.Click On apparel and shoes link
		boolean apparels_link = homePage.getApparalesAndShoes().isDisplayed();
		Assert.assertTrue(apparels_link,"Apparels and shoes link is presentin nav bar");
		homePage.getApparalesAndShoes().click();
		Reporter.log("Apparels and shoes link present in nav bar is clicked",true);
		//3.Click on blue and green Sneaker .
		boolean apparels_res = driver.findElement(By.xpath("//h1[text()='Apparel & Shoes']")).isDisplayed();
		Assert.assertTrue(apparels_res, "is in apparels and shoes webpage");
		Reporter.log("Apparels page is opened",true);
		Apparel_shoes_Page prdt=new Apparel_shoes_Page(driver);
		boolean shoe1 = prdt.getBlue_and_green_Sneaker_Prdt1().isDisplayed();
		Assert.assertTrue(shoe1,"blue and green Sneaker is present");
		prdt.getBlue_and_green_Sneaker_Prdt1().click();
		Reporter.log("blue and green Sneaker is present in Apparels and shoes Webpage and is clicked",true);
		boolean prdtname = driver.findElement(By.xpath("//h1[@itemprop=\"name\"]")).isDisplayed();
		Assert.assertTrue(prdtname);
		Reporter.log("is in blue and green Sneaker product page",true);
		//4.Click on  "Add to wishlist" button.
		boolean wish_btn = prdt.getWishlist_button().isDisplayed();
		Assert.assertTrue(wish_btn,"Wishlist button is present");
		prdt.getWishlist_button().click();
		Reporter.log("Wishlist button of particular product is clicked",true);
		boolean added_msg = driver.findElement(By.xpath("//p[text()='The product has been added to your ']")).isDisplayed();
		Assert.assertTrue(added_msg);
		Reporter.log("The product has been added to your wishlist",true);
		//5.Click on "WishList" link.
		boolean wishlink = homePage.getWishlistLink().isDisplayed();
		Assert.assertTrue(wishlink, "WishlistLink is present");
		homePage.getWishlistLink().click();
		Reporter.log("Wishlist link is clicked",true);
		String actual_title = driver.getTitle();
		String Expected_title = "Demo Web Shop. Wishlist";
		Assert.assertEquals(actual_title,Expected_title);
		Reporter.log("is in Wishlist page",true);
		//6.Select the remove checkbox of particular product.
		WishListPage wish=new WishListPage(driver);
		boolean remove_chckbox = wish.getRemove_checkbox().isDisplayed();
		Assert.assertTrue(remove_chckbox, "Remove checkbox is present");
		wish.getRemove_checkbox().click();
		Reporter.log("remove checkbox is present in wishlist page and is clicked",true);
		//7.Click on "Update Wishlist" button.
		boolean update = wish.getUpdate_link().isDisplayed();
		Assert.assertTrue(update,"Update link is present");
		wish.getUpdate_link().click();
		Reporter.log("update link is present in wishlist page and is clicked",true);
		boolean wish_msg = driver.findElement(By.xpath("//div[@class=\"page wishlist-page\"]")).isDisplayed();
        Assert.assertTrue(wish_msg);
		Reporter.log("The wishlist is empty! successfully deleted particular product",true);
	}

}
