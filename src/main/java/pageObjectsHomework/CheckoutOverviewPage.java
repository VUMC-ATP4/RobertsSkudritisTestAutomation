package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {


    public WebDriver driver;
    private By finishButton = By.id("finish");
    private By cartItem = By.cssSelector("div[id='checkout_summary_container'] span[class='cart_quantity']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }

    public WebElement getCartItem(){
        return driver.findElement(cartItem);
    }




}
