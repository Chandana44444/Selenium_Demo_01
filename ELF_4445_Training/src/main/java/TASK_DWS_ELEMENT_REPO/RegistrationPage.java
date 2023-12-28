package TASK_DWS_ELEMENT_REPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import TASK_DWS_GENERIC_LIBRARY.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender-female")
	private WebElement gender_radio_button;

	@FindBy(id = "FirstName")
	private WebElement firstName_textbox;

	@FindBy(id = "LastName")
	private WebElement lastName_textbox;

	public WebElement getGender_radio_button() {
		return gender_radio_button;
	}

	public WebElement getFirstName_textbox() {
		return firstName_textbox;
	}

	public WebElement getLastName_textbox() {
		return lastName_textbox;
	}

	public WebElement getEmail_textbox() {
		return email_textbox;
	}

	public WebElement getPassword_textbox() {
		return password_textbox;
	}

	public WebElement getConfirmPassword_textbox() {
		return confirmPassword_textbox;
	}

	public WebElement getRegister_button() {
		return register_button;
	}

	@FindBy(id = "Email")
	private WebElement email_textbox;

	@FindBy(id = "Password")
	private WebElement password_textbox;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword_textbox;

	@FindBy(id = "register-button")
	private WebElement register_button;

	
}
