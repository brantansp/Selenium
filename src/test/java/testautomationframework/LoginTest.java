package testautomationframework;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;


public class LoginTest {
	
	@Test
	public void loginToShipperApplication () throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-gpu");
		DriverManager.setDriver("chrome");
		WebDriver delegate = DriverManager.getDriver();
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);

        driver.get("http://google.com");
        Thread.sleep(2000);
        
        
        String a = "window.open('about:blank','_blank');";
        ((JavascriptExecutor)driver).executeScript(a);
        
		Set<String> winHandlesList = driver.getWindowHandles();
		int i = 1;
		for (String winHandle : winHandlesList) {
			if (i == Integer.parseInt("0")) {
				driver.switchTo().window(winHandle);
				break;
			}
			i++;
		}
		
        driver.get("https://www.epa.gov/sites/production/files/2017-12/documents/lcr_federalism_consultation_letter.signed.12_14_17.pdf");
        Thread.sleep(2000);
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            System.out.println("title " +driver.getTitle());
        }
        Thread.sleep(2000);
        driver.close();
        driver.quit();
	}
	
	@Test
	public void deleteMail() throws InterruptedException {
		DriverManager.setDriver("chrome");
		WebDriver delegate = DriverManager.getDriver();
		SelfHealingDriver driver = SelfHealingDriver.create(delegate);
		try {

			driver.get("http://35.154.192.224:5080/email");
			Thread.sleep(5000);
			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement element =
			 * driver.findElement(By.xpath("(//p/span)[2]"));
			 * js.executeScript("arguments[0].scrollIntoView(true)", element); int total =
			 * Integer.valueOf(element.getText()) * 10;
			 */
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			for (int i = 0; i < 500; i++) {
				driver.get("http://35.154.192.224:5080/email");
				driver.findElement(By.xpath("//i[text()='delete']/../self::button")).click();
				Thread.sleep(100);
			}
			
		} catch (Exception e) {
			
		} finally {
			driver.close();
			driver.quit();
		}
		
	}
	
	public static void main(String[] args) {
		int unique_id= (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
		System.out.println(unique_id);
	}
	

}
