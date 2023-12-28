package TASK_DWS_ELEMENT_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TASK_DWS_GENERIC_LIBRARY.BasePage;

public class BooksPage extends BasePage {
	public BooksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Computing and Internet")
	private WebElement Computing_and_Internet_prdt1;

	@FindBy(xpath = "(//input[@value=\"Add to cart\"])[1]")
	private WebElement addtocart_button;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingcart_button;

	public WebElement getComputing_and_Internet_Prdt1() {
		return Computing_and_Internet_prdt1;
	}

	public WebElement getAddtocart_button() {
		return addtocart_button;
	}

	public WebElement getShoppingcart_button() {
		return shoppingcart_button;
	}

}
