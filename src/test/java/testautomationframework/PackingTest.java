package testautomationframework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class PackingTest {
	

	public void alertHandling1() throws InterruptedException {
		DriverManager.setDriver("chrome");
        WebDriver driver = DriverManager.getDriver();
        
        driver.get("https://development13.pandostaging.in/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("pandodevelopment13@gmail.com");
        loginPage.enterPassword("test@1234");
        loginPage.clickLoginButton();
        loginPage.assertLogin();
        DriverManager.closeDriver();
	}
	

	public void alertHandling2() throws InterruptedException {
		DriverManager.setDriver("chrome");
        WebDriver driver = DriverManager.getDriver();
        
        driver.get("https://development13.pandostaging.in/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("pandodevelopment13@gmail.com");
        loginPage.enterPassword("test@1234");
        loginPage.clickLoginButton();
        loginPage.assertLogin();
        DriverManager.closeDriver();
	}
	

	public void alertHandling3() throws InterruptedException {
		DriverManager.setDriver("chrome");
        WebDriver driver = DriverManager.getDriver();
        
        driver.get("https://development13.pandostaging.in/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("pandodevelopment13@gmail.com");
        loginPage.enterPassword("test@1234");
        loginPage.clickLoginButton();
        loginPage.assertLogin();
        DriverManager.closeDriver();
	}
	

	public void alertHandling4() throws InterruptedException {
		DriverManager.setDriver("chrome");
        WebDriver driver = DriverManager.getDriver();
        
        driver.get("https://development13.pandostaging.in/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("pandodevelopment13@gmail.com");
        loginPage.enterPassword("test@1234");
        loginPage.clickLoginButton();
        loginPage.assertLogin();
        DriverManager.closeDriver();
	}
	

	public void alertHandling5() throws InterruptedException {
		DriverManager.setDriver("chrome");
        WebDriver driver = DriverManager.getDriver();
        
        driver.get("https://development13.pandostaging.in/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("pandodevelopment13@gmail.com");
        loginPage.enterPassword("test@1234");
        loginPage.clickLoginButton();
        loginPage.assertLogin();
        DriverManager.closeDriver();
	}

}
