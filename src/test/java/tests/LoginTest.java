package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {
	
	LoginPage loginPage ;
	
	@BeforeMethod
	public void setUp() {
		
		DriverFactory.initBrowser();
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
		loginPage = new LoginPage(DriverFactory.getDriver());
	}
	
	 @Test(priority = 1, enabled = false)
	    public void testValidLogin() {
	        loginPage.enterUsername("standard_user");
	        loginPage.enterPassword("secret_sauce");
	        loginPage.clickLogin();
	        
	        
	        try {
	            Thread.sleep(3000);  // 3 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Here you can add an assertion later to verify successful login
	     // Assertion: Check if "Products" title is visible
	        String actualText = DriverFactory.getDriver().findElement(By.className("title")).getText();
	        Assert.assertEquals(actualText, "Products", "Login failed or landing page incorrect.");

	        System.out.println("Login test executed and verified.");

	       
	    }
	 
	 @Test(priority = 2, enabled = false)
	 public void testInvalidLogin() {
	     loginPage.enterUsername("invalid_user");
	     loginPage.enterPassword("invalid_pass");
	     loginPage.clickLogin();

	     try {
	         Thread.sleep(2000);  // wait to see the message
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     String actualError = loginPage.getErrorMessage();
	     String expectedError = "Epic sadface: Username and password do not match any user in this service";

	     Assert.assertEquals(actualError, expectedError, "Error message did not match.");
	     System.out.println("Invalid login test passed.");
	 }

	 
	 @Test(priority = 3, enabled = false)
	 public void testLogoutAfterLogin() {
	     // Step 1: Login
	     loginPage.enterUsername("standard_user");
	     loginPage.enterPassword("secret_sauce");
	     loginPage.clickLogin();

	     // Optional wait to see the login complete
	     try {
	         Thread.sleep(2000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     // Step 2: Logout
	     loginPage.logout();

	     // Optional wait for logout to complete
	     try {
	         Thread.sleep(2000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     // Step 3: Verify that we are back on the login page
	     String currentUrl = DriverFactory.getDriver().getCurrentUrl();
	     Assert.assertEquals(currentUrl, "https://www.saucedemo.com/", "Logout failed – user is not on login page.");

	     System.out.println("Logout test passed.");
	 }

	 @Test(priority = 4, enabled = false)
	 public void testAddItemToCart() {
	     loginPage.enterUsername("standard_user");
	     loginPage.enterPassword("secret_sauce");
	     loginPage.clickLogin();

	     // Wait for inventory page to load
	     try {
	         Thread.sleep(2000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     HomePage homePage = new HomePage(DriverFactory.getDriver());
	     homePage.addToCart();
	     homePage.goToCart();

	     // Wait for cart page to load
	     try {
	         Thread.sleep(2000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     String itemName = homePage.getCartItemText();
	     Assert.assertEquals(itemName, "Sauce Labs Backpack", "Item not found in cart.");
	     System.out.println("Add to cart test passed.");
	 }
	 
	 
	 @Test(priority = 5)
	 public void testRemoveItemFromCart() {
	     loginPage.enterUsername("standard_user");
	     loginPage.enterPassword("secret_sauce");
	     loginPage.clickLogin();

	     // Wait for login
	     try {
	         Thread.sleep(2000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     HomePage homePage = new HomePage(DriverFactory.getDriver());
	     homePage.addToCart();
	     homePage.goToCart();

	     // Wait for cart
	     try {
	         Thread.sleep(2000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     homePage.removeItemFromCart();

	     // Assert item is removed by checking item count or name not present
	     boolean isItemRemoved = DriverFactory.getDriver()
	         .findElements(By.className("inventory_item_name"))
	         .isEmpty();

	     Assert.assertTrue(isItemRemoved, "Item was not removed from the cart.");
	     System.out.println("Remove from cart test passed.");
	 }


	 
	 @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitBrowser();
	    }

}
