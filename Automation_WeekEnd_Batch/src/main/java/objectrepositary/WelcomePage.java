package objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WelcomePage {
	@FindBy(linkText = "Register")
	private WebElement registrationlink;
	
	@FindBy(linkText = "Log In")
	private WebElement Loginlink;

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegistrationlink() {
		return registrationlink;
	}

	public WebElement getLoginlink() {
		return Loginlink;
	}
	
}
