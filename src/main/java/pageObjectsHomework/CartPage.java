package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;

    private By checkoutButton = By.id("checkout");
    private By shoppingCartLink = By.cssSelector("a.shopping_cart_link");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }

    public WebElement getShoppingCartLink() {
        return driver.findElement(shoppingCartLink);
    }

}
