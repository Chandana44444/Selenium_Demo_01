package TASK_DWS_ELEMENT_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TASK_DWS_GENERIC_LIBRARY.BasePage;

public class ShoppingCartPage extends BasePage {
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name=\"removefromcart\"]")
	private WebElement remove_checkbox;

	public WebElement getRemove_checkbox() {
		return remove_checkbox;
	}

	@FindBy(xpath = "//input[@name=\"updatecart\"]")
	private WebElement update_shopping_cart_button;

	public WebElement getUpdate_shopping_cart_button() {
		return update_shopping_cart_button;
	}

	@FindBy(id = "CountryId")
	private WebElement country_id_dropdown;

	@FindBy(id = "termsofservice")
	private WebElement terms_checkbox;

	@FindBy(id = "checkout")
	private WebElement checkoutbox;

	public WebElement getCountry_id_dropdown() {
		return country_id_dropdown;
	}

	public WebElement getTerms_checkbox() {
		return terms_checkbox;
	}

	public WebElement getCheckoutbox() {
		return checkoutbox;
	}

}
