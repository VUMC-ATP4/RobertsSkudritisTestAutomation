package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

    public WebDriver driver;
    private By backHomeButton = By.id("back-to-products");
//    private By orderSuccessText = By.cssSelector("h2[complete-header='THANK YOU FOR YOUR ORDER']");
    private By orderSuccessText = By.cssSelector("#checkout_complete_container > h2");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }

    public WebElement getOrderSuccessText() {
        return driver.findElement(orderSuccessText);
}

}
