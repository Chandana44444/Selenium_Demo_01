package TASK_DWS_ELEMENT_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TASK_DWS_GENERIC_LIBRARY.BasePage;

public class CheckoutPage extends BasePage {
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement country_dropdown;

	@FindBy(id = "BillingNewAddress_City")
	private WebElement city_textbox;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1_textbox;

	@FindBy(id = "BillingNewAddress_Address2")
	private WebElement address2_textbox;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement pincode_textbox;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneno_textbox;

	@FindBy(xpath = "(//input[@title=\"Continue\"])[1]")
	private WebElement continue1_button;

	@FindBy(xpath = "(//Input[@title=\"Continue\"])[2]")
	private WebElement continue2_button;

	@FindBy(id = "shippingoption_0")
	private WebElement ground_radio_button;

	@FindBy(xpath = "(//input[@value=\"Continue\"])[3]")
	private WebElement continue3_button;

	@FindBy(id = "paymentmethod_0")
	private WebElement cod_radiobutton;

	@FindBy(xpath = "(//input[@value=\"Continue\"])[4]")
	private WebElement continue4_button;

	@FindBy(xpath = "(//input[@value=\"Continue\"])[5]")
	private WebElement continue5_button;

	@FindBy(xpath = "(//input[@value=\"Continue\"])[6]")
	private WebElement continue6_button;

	public WebElement getCountry_dropdown() {
		return country_dropdown;
	}

	public WebElement getCity_textbox() {
		return city_textbox;
	}

	public WebElement getAddress1_textbox() {
		return address1_textbox;
	}

	public WebElement getAddress2_textbox() {
		return address2_textbox;
	}

	public WebElement getPincode_textbox() {
		return pincode_textbox;
	}

	public WebElement getPhoneno_textbox() {
		return phoneno_textbox;
	}

	public WebElement getContinue1_button() {
		return continue1_button;
	}

	public WebElement getContinue2_button() {
		return continue2_button;
	}

	public WebElement getGround_radio_button() {
		return ground_radio_button;
	}

	public WebElement getContinue3_button() {
		return continue3_button;
	}

	public WebElement getCod_radiobutton() {
		return cod_radiobutton;
	}

	public WebElement getContinue4_button() {
		return continue4_button;
	}

	public WebElement getContinue5_button() {
		return continue5_button;
	}

	public WebElement getContinue6_button() {
		return continue6_button;
	}
	
	@FindBy(xpath = "//input[@value=\"Confirm\"]")
	private WebElement confirm_button;
	
	public WebElement getconfirm_button() {
		return confirm_button;
	}

	

}
