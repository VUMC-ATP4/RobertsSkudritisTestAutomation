package seleniumHomework.seleniumHomeworkTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.CheckoutPage;

public class tempDemoTests {
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
import pageObjectsHomework.CheckoutPage;
import pageObjectsHomework.InventoryPage;

import java.time.Duration;

    public class sauceDemoTests {
        public final String SAUCELABS_URL = "https://www.saucedemo.com/";
        public final String SAUCELABS_CART = "https://www.saucedemo.com/cart.html";
        WebDriver driver;

        @BeforeMethod
        public void setupBrowser() throws InterruptedException {
            System.out.println("Pirms testa izveidojam pārlūku.");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get(SAUCELABS_URL);
            WebElement usernameInputField = driver.findElement(By.id("user-name"));
            usernameInputField.sendKeys("standard_user");
            WebElement passwordInputField = driver.findElement(By.id("password"));
            passwordInputField.sendKeys("secret_sauce");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            Thread.sleep(1000);

        }

        @AfterMethod
        public void tearDownBrowser() {
            System.out.println("Pēc testa aizveram pārlūku.");
            driver.close();
        }
//firstScenario
//1. Navigēt uz saiti https://www.saucedemo.com/
//2. Ielogoties ar pareizu lietotāja vārdu/paroli
//3. Pārbaudīt, ka lietotājs ir ielogojies
//4. Ievietot Grozā 1 produktu
//5. Doties uz grozu

//>>>>6. Pārbaudīt, kā šī prece ir grozā
//7. Doties uz Checkout
//8. Ievadīt vārdu/uzvārdu/pasta indeksu
//9. Doties uz Checkout overview lapu, pārbaudīt datus
//10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
//11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'

        @Test
        public void firstScenarioPageObjectTest() throws InterruptedException {
            //Parbaudam inventory lapu
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
            WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
            Assert.assertEquals(pageTitleText.getText(), "PRODUCTS");
            Thread.sleep(1000);

            //pievienojam preci groza
            WebElement addToCartButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            addToCartButton1.click();
            Thread.sleep(1000);

            //ejam uz shopping cart
            WebElement selectShoppingCart = driver.findElement(By.cssSelector("div[id='shopping_cart_container'] a[class='shopping_cart_link']"));
            selectShoppingCart.click();
            Thread.sleep(1000);

            //parbaudam vai prece ir grozā
            //  WebElement checkShoppingCart = driver.findElement(By.xpath("<div class='cart_quantity'>1</div>")).getAttribute("quantity");;

            // checkShoppingCart = checkShoppingCart;
//       if checkShoppingCart.getCssValue(cart_quantity)
//                Assert.assertNotEquals
//        if (aTitle.equals(eTitle))

            //ejam uz checkout
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();
            Thread.sleep(1000);

            //aizpildam formu
            WebElement firstNameInputField = driver.findElement(By.id("first-name"));
            firstNameInputField.sendKeys("Roberts");
            WebElement lastNameInputField = driver.findElement(By.id("last-name"));
            lastNameInputField.sendKeys("Skudritis");
            WebElement postalCodeInputField = driver.findElement(By.id("postal-code"));
            postalCodeInputField.sendKeys("LV1082");
            Thread.sleep(1000);

            //apstiprinam formu
            WebElement continueButton = driver.findElement(By.id("continue"));
            continueButton.click();
            Thread.sleep(1000);

            //apstiprinam pasutijumu
//        WebElement checkoutInvenvtory = driver.findElement(By.cssSelector("inventory_item_name"));
//        Assert.assertNotEquals(checkoutInvenvtory.getText(),"");

            WebElement finishButton = driver.findElement(By.id("finish"));
            finishButton.click();
            Thread.sleep(1000);

            //atpakal uz sakumu
            WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
            backHomeButton.click();
            Thread.sleep(1000);
        }

        @Test
        public void secondScenarioPageObjectTest() throws InterruptedException {
            // ejam uz grozu, defineta saite
            driver.get(SAUCELABS_CART);
            Thread.sleep(1000);

            //ejam uz checkout
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();
            Thread.sleep(1000);
        }
        //first name parbaude
        @Test
        public void secondScenarioFistNameTest() throws InterruptedException {
            // ejam uz grozu, defineta saite
            driver.get(SAUCELABS_CART);
            Thread.sleep(1000);

            //ejam uz checkout
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();
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

    }


    @Test
    public void secondScenarioFistNameTest() throws InterruptedException {
        // ejam uz grozu, defineta saite
        driver.get(SAUCELABS_CART);
        Thread.sleep(1000);

        //ejam uz checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("");
        checkoutPage.getLastNameInputField().sendKeys("Skudritis");
        checkoutPage.getPostalCodeInputField().sendKeys("1082");
        Thread.sleep(1000);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorText().getText(), "Error: First Name is required");
        Thread.sleep(1000);


        //        WebElement firstNameInputField = driver.findElement(By.id("first-name"));
//        firstNameInputField.sendKeys("");
//        WebElement lastNameInputField = driver.findElement(By.id("last-name"));
//        lastNameInputField.sendKeys("Skudritis");
//        WebElement postalCodeInputField = driver.findElement(By.id("postal-code"));
//        postalCodeInputField.sendKeys("LV1082");
//
//        WebElement continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
//        Thread.sleep(1000);
//
//        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        String expectedText = errorText.getText();
//        Assert.assertEquals(errorText.getText(),"Error: First Name is required");
//        Thread.sleep(1000);

        //last name parbaude
//        firstNameInputField = driver.findElement(By.id("first-name"));
//        firstNameInputField.sendKeys("Roberts");
//        lastNameInputField = driver.findElement(By.id("last-name"));
//        lastNameInputField.sendKeys("Lastname");
//        postalCodeInputField = driver.findElement(By.id("postal-code"));
//        postalCodeInputField.sendKeys("LV1082");
//
//        continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
//        Thread.sleep(1000);
//
//        errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        expectedText = errorText.getText();
//        Assert.assertEquals(errorText.getText(),"Error: Last Name is required");
//        Thread.sleep(1000);

        //postcode parbaude
//        firstNameInputField = driver.findElement(By.id("first-name"));
//        firstNameInputField.sendKeys("Roberts");
//        lastNameInputField = driver.findElement(By.id("last-name"));
//        lastNameInputField.sendKeys("Lastname");
//        postalCodeInputField = driver.findElement(By.id("postal-code"));
//        postalCodeInputField.sendKeys("");
//
//        continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
//        Thread.sleep(1000);
//
//        errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        expectedText = errorText.getText();
//        Assert.assertEquals(errorText.getText(),"Error: Last Name is required");
//        Thread.sleep(1000);

    }
}
