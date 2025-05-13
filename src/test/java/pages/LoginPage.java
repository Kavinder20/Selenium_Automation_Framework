package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver ;
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
	}
	
	 By usernameField = By.id("user-name");
	    By passwordField = By.id("password");
	    By loginButton = By.id("login-button");
	   
	    
	    //Actions
	    
	    public void enterUsername(String username) {
	    	driver.findElement(usernameField).sendKeys(username);
	    }
	    
	    public void enterPassword(String password) {
	    	driver.findElement(passwordField).sendKeys(password);
	    }
	    
	    public void clickLogin() {
	    	driver.findElement(loginButton).click();
	    }
	    
	    
	 // Locator for error message
	    By errorMessage = By.cssSelector("h3[data-test='error']");

	    // Method to get error text
	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }
	    
	 // Locators for logout
	    By menuButton = By.id("react-burger-menu-btn");
	    By logoutLink = By.id("logout_sidebar_link");

	    // Method to perform logout
	    public void logout() {
	        driver.findElement(menuButton).click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Scroll down in case logout link is off-screen
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 250);");

	        wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
	        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));

	        driver.findElement(logoutLink).click();
	    }




}
