package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver ;

	
	//Launch browser
	public static void initBrowser() {
	    WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito"); // ✅ FIX: clean session, no popup
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-notifications");
	    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	    options.setExperimentalOption("useAutomationExtension", false);

	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	}

	
	//close browser
	public static void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	//Getter method for driver
	public static WebDriver getDriver() {
		return driver ;
	}
}
