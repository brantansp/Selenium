package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Packing {
	
	WebDriver driver;
	
	public Packing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
