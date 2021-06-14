package testautomationframework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private BaseClass() {
		// restricting the instantiation of object
	}

	private static BaseClass instance = null;

	public static BaseClass getInstance() {
		if (instance == null) {
			instance = new BaseClass();
		}
		return instance;
	}

	ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	ThreadLocal<ExtentReports> report = new ThreadLocal<ExtentReports>();
	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	ThreadLocal<ExtentHtmlReporter> extentHtmlReporter = new ThreadLocal<ExtentHtmlReporter>();
	public int globalExplicitWaitTime = 10;

	public RemoteWebDriver getDriver() {
		return driver.get();
	}

	public ExtentReports getReport() {
		return report.get();
	}

	public ExtentTest getTest() {
		return test.get();
	}

	public ExtentHtmlReporter getExtentHtmlReporter() {
		return extentHtmlReporter.get();
	}

	public void closeDriver() {
		if (driver != null) {
			driver.get().close();
			driver.get().quit();
			driver.remove();
		}
	}

	public final void setDriver(String browser) {
		DesiredCapabilities caps = null;
		ChromeOptions options = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			driver.set(new ChromeDriver(options));	
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
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			
		}
		
		getInstance().getDriver().manage().window().maximize();
		
	}
	
	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}
	
	public void sendKeys(WebElement element, String keysToSend) {
		waitForElementToBeVisible(element).sendKeys(keysToSend);
	}
	
	public WebElement waitForElementToBeClickable (WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.getInstance().getDriver(), globalExplicitWaitTime);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.getInstance().getDriver(), globalExplicitWaitTime);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
