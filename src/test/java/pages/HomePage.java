package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartItem = By.className("inventory_item_name");

    // Actions
    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartItemText() {
        return driver.findElement(cartItem).getText();
    }
    
 // Locator for remove button in cart
    By removeButton = By.id("remove-sauce-labs-backpack");

    // Action: remove item
    public void removeItemFromCart() {
        driver.findElement(removeButton).click();
    }

}
