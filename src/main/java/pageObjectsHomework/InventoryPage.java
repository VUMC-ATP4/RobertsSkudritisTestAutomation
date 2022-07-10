package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

        public WebDriver driver;

      private By pageTitleText = By.cssSelector("div[id='header_container'] span[class='title']");
      private By addToCartButton1 = By.id("add-to-cart-sauce-labs-backpack");
      private By selectShoppingCart = By.cssSelector("div[id='shopping_cart_container'] a[class='shopping_cart_link']");





        public InventoryPage(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement getPageTitle(){
            return driver.findElement(pageTitleText);
        }

        public WebElement getAddToCartButton1(){
            return driver.findElement(addToCartButton1);
        }
        public WebElement getSelectShoppingCart(){
            return driver.findElement(selectShoppingCart);
        }

}
