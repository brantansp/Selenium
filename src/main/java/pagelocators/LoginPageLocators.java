package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	
	@FindBy (xpath="//label[text()='User name:']/preceding-sibling::input")
	public WebElement userNameInputBox;
	
	@FindBy (xpath="//label[text()='Password:']/preceding-sibling::input")
	public WebElement passwordInputBox;
	
	@FindBy (xpath="//button[contains(text(),'Log in')]")
	public WebElement loginButton;
	
	@FindBy (xpath="//div[contains(@class,'order-header')]")
	public WebElement loginAssert;

}
