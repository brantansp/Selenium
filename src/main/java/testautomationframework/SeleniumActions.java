package testautomationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActions {
	
	private WebDriver driver;
	
	public SeleniumActions (WebDriver driver) {
		this.driver = driver;
	}
	
	public int globalExplicitWaitTime = 10;
	
	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}
	
	public void sendKeys(WebElement element, String keysToSend) {
		waitForElementToBeVisible(element).sendKeys(keysToSend);
	}
	
	public WebElement waitForElementToBeClickable (WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, globalExplicitWaitTime);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, globalExplicitWaitTime);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

}
