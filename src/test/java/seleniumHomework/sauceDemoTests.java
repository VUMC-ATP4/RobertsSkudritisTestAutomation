package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjectsHomework.InventoryPage;

import java.time.Duration;

public class sauceDemoTests {
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
        System.out.println("Pirms testa izveidojam pārlūku.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc testa aizveram pārlūku.");
        driver.close();
    }
//firstScenario
//1. Navigēt uz saiti https://www.saucedemo.com/
//2. Ielogoties ar pareizu lietotāja vārdu/paroli
//3. Pārbaudīt, ka lietotājs ir ielogojies

//4. Ievietot Grozā 1 produktu
//5. Doties uz grozu
//6. Pārbaudīt, kā šī prece ir grozā
//7. Doties uz Checkout
//8. Ievadīt vārdu/uzvārdu/pasta indeksu
//9. Doties uz Checkout overview lapu, pārbaudīt datus
//10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
//11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'

    @Test
    public void firstScenarioPageObjectTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
       // WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
       // System.out.println(acceptedUsernamesText.getText());
        //login
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(5000);

        //Parbaudam inventory lapu
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(),"PRODUCTS");

        //pievienojam preci groza
        WebElement addToCartButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton1.click();
        Thread.sleep(5000);
//        Select addToCart = new Select(driver.findElement(By.cssSelector("")));
    }



}
