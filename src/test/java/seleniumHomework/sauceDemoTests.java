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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjectsHomework.*;

import java.time.Duration;

public class sauceDemoTests {
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";
    public final String SAUCELABS_CART = "https://www.saucedemo.com/cart.html";
    WebDriver driver;
//@BeforeTest
//    public void definePages() {
//    LoginPage loginPage = new LoginPage(driver);
//    CartPage cartPage = new CartPage(driver);
//    InventoryPage inventoryPage = new InventoryPage(driver);
//    CheckoutPage checkoutPage = new CheckoutPage(driver);
//    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
//    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
//}

    @BeforeMethod
    public void setupBrowser() throws InterruptedException {
        System.out.println("Pirms testa izveidojam pārlūku.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        Thread.sleep(1000);


    }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pēc testa aizveram pārlūku.");
        driver.close();
    }

    @Test
    public void firstScenarioPageObjectTest() throws InterruptedException {
        //Parbaudam inventory lapu
        CartPage cartPage = new CartPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
       // WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        //Assert.assertEquals(pageTitleText.getText(), "PRODUCTS");
        Thread.sleep(1000);

        //pievienojam preci groza
        inventoryPage.getAddToCartButton1().click();
        Thread.sleep(1000);

        //ejam uz shopping cart
        inventoryPage.getSelectShoppingCart().click();
        Thread.sleep(1000);

        //parbaudam vai prece ir grozā
//        Assert.assertEquals(cartPage.getShoppingCartLink().getText(),1);
//        Thread.sleep(1000);

        //ejam uz checkout
        cartPage.getCheckoutButton().click();
        Thread.sleep(1000);

        //aizpildam formu
        checkoutPage.getFirstNameInputField().sendKeys("Roberts");
        checkoutPage.getLastNameInputField().sendKeys("Skudritis");
        checkoutPage.getPostalCodeInputField().sendKeys("1082");
        Thread.sleep(1000);


        //apstiprinam formu
        checkoutPage.getContinueButton().click();
        Thread.sleep(1000);

        //apstiprinam pasutijumu
       // Assert.assertEquals(checkoutOverviewPage.getCartItem(),"1");
        Assert.assertEquals(checkoutPage.getInventoryItemName().getText(),"Sauce Labs Backpack");
        Assert.assertEquals(checkoutPage.getSummaryTotal().getText(),"Total: $32.39");
        checkoutOverviewPage.getFinishButton().click();
        Thread.sleep(1000);

        //atpakal uz sakumu
        Assert.assertEquals(checkoutSuccessPage.getOrderSuccessText().getText(),"THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.getBackHomeButton().click();
        Thread.sleep(1000);
    }

//    @Test
//    public void secondScenarioPageObjectTest() throws InterruptedException {
//        // ejam uz grozu, defineta saite
//        driver.get(SAUCELABS_CART);
//        Thread.sleep(1000);
//
//        //ejam uz checkout
//        WebElement checkoutButton = driver.findElement(By.id("checkout"));
//        checkoutButton.click();
//        Thread.sleep(1000);
//    }

        @Test //first name parbaude
        public void secondScenarioFirstNameTest() throws InterruptedException {
        // ejam uz grozu, defineta saite
        driver.get(SAUCELABS_CART);
        Thread.sleep(1000);

        //ejam uz checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("");
        checkoutPage.getLastNameInputField().sendKeys("Skudritis");
        checkoutPage.getPostalCodeInputField().sendKeys("1082");
        Thread.sleep(1000);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorText().getText(),"Error: First Name is required");
        Thread.sleep(1000);
    }
    @Test         //last name parbaude
    public void secondScenarioLastNameTest() throws InterruptedException {
        // ejam uz grozu, defineta saite
        driver.get(SAUCELABS_CART);
        Thread.sleep(1000);

        //ejam uz checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("Roberts");
        checkoutPage.getLastNameInputField().sendKeys("");
        checkoutPage.getPostalCodeInputField().sendKeys("1082");
        Thread.sleep(1000);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorText().getText(),"Error: Last Name is required");
        Thread.sleep(1000);
    }

    @Test //postal code parbaude
    public void secondScenarioPostalCodeTest() throws InterruptedException {
        // ejam uz grozu, defineta saite
        driver.get(SAUCELABS_CART);
        Thread.sleep(1000);

        //ejam uz checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("Roberts");
        checkoutPage.getLastNameInputField().sendKeys("Skudritis");
        checkoutPage.getPostalCodeInputField().sendKeys("");
        Thread.sleep(1000);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorText().getText(),"Error: Postal Code is required");
        Thread.sleep(1000);
    }

}