package TASK_DWS_ELEMENT_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TASK_DWS_GENERIC_LIBRARY.BasePage;

public class Apparel_shoes_Page extends BasePage {
	public WebElement getBlue_and_green_Sneaker_Prdt1() {
		return Blue_and_green_Sneaker_prdt1;
	}

	public WebElement getWishlist_button() {
		return wishlist_button;
	}

	public Apparel_shoes_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Blue and green Sneaker")
	private WebElement Blue_and_green_Sneaker_prdt1;

	@FindBy(id = "add-to-wishlist-button-28")
	private WebElement wishlist_button;

}
