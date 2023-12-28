package TASK_DWS_ELEMENT_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TASK_DWS_GENERIC_LIBRARY.BasePage;

public class WishListPage extends BasePage {
	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name=\"addtocartbutton\"]")
	private WebElement addtocart_button;
	
	public WebElement getAddtocart_button() {
		return addtocart_button;
	}

	@FindBy(xpath = "//input[@name=\"removefromcart\"]")
	private WebElement remove_checkbox;

	@FindBy(xpath = "//input[@value=\"Update wishlist\"]")
	private WebElement update_link;

	public WebElement getRemove_checkbox() {
		return remove_checkbox;
	}

	public WebElement getUpdate_link() {
		return update_link;
	}

	@FindBy(xpath = "//input[@value=\"Add to cart\"]")
	private WebElement addtocart_link;

	@FindBy(xpath = "//input[@name=\"addtocart\"]")
	private WebElement addtocart_checkbox;

	public WebElement getAddtocart_link() {
		return addtocart_link;
	}

	public WebElement getAddtocart_checkbox() {
		return addtocart_checkbox;
	}

}
