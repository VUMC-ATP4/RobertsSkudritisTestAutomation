package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    public WebDriver driver;

    private By usernameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.id("login-button");
   // private By errorText = By.cssSelector("h3[data-test='error']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameInputField(){
        return driver.findElement(usernameInputField);
    }

    public WebElement getPasswordInputField(){
        return driver.findElement(passwordInputField);
    }

    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }

//    public WebElement getErrorText() {
//        return driver.findElement(errorText);
//    }

}
