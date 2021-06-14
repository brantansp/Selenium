package testautomationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {
	
	

	public static RemoteWebDriver getDriver(String browser) {
		
		DesiredCapabilities caps = null;
		ChromeOptions options = null;
		WebDriver driver;
		
		switch (browser) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			driver = new ChromeDriver(options);	
			break;
		case "chrome_headless":
			WebDriverManager.chromedriver().setup();
			caps = DesiredCapabilities.chrome();
			options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		default :
			driver = new ChromeDriver();
		}
		
		return (RemoteWebDriver) driver;
	}

}
