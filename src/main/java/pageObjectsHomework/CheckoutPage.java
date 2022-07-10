package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {


    public WebDriver driver;



    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By postalCodeInputField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorText = By.cssSelector("h3[data-test='error']");
    private By summaryTotal = By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_total_label");
    private By inventoryItemName = By.cssSelector("#item_4_title_link > div");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getFirstNameInputField(){
        return driver.findElement(firstNameInputField);
    }
    public WebElement getLastNameInputField(){
        return driver.findElement(lastNameInputField);
    }
    public WebElement getPostalCodeInputField(){
        return driver.findElement(postalCodeInputField);
    }
    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }
    public WebElement getErrorText() { return driver.findElement(errorText);}
    public WebElement getSummaryTotal() {return driver.findElement(summaryTotal);}
    public WebElement getInventoryItemName() {return driver.findElement(inventoryItemName);}

}
