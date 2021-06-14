package testautomationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
	
	private static DriverManager driverManager;
	
	private DriverManager() {
		
	}
	
	static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void closeDriver() {
		if (driver != null) {
			driver.get().close();
			driver.get().quit();
			driver.remove();
		}
	}
	
	public static void setDriver(String browser) {
		driver.set(BrowserManager.getDriver(browser));
	}

}
