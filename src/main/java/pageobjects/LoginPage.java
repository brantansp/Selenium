package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pagelocators.LoginPageLocators;
import testautomationframework.BaseClass;
import testautomationframework.SeleniumActions;

public class LoginPage {
	
	SeleniumActions action;
	LoginPageLocators login;
	
	public LoginPage (WebDriver driver) {
		this.action = new SeleniumActions(driver);
		this.login = new LoginPageLocators();
		PageFactory.initElements(driver, this.login);
	}
	
	public void enterUserName(String userName) {
		action.sendKeys(login.userNameInputBox, userName);
	}
	
	public void enterPassword(String password) {
		action.sendKeys(login.passwordInputBox, password);
	}
	
	public void clickLoginButton () {
		action.click(login.loginButton);
	}
	
	public void assertLogin() {
		action.waitForElementToBeVisible(login.loginAssert);
	}

}
