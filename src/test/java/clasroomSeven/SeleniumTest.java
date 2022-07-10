package clasroomSeven;

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

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    WebDriver driver;

    public final String SAUCELABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setupBrowser(){
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc testa");
        driver.close();
    }

    @Test
    public void errorMessagePasswordEmptyPageObjectTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("Juris");
        loginPage.getPasswordInputField().sendKeys("");
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getErrorText().getText(),"Epic sadface: Password is required");
    }

//    @Test
//            public void
//    driver.get(SAUCELABS_URL);
//    LoginPage loginPage = new LoginPage(driver);
//        loginPage.getUsernameInputField().sendKeys("standard_user");
//        loginPage.getPasswordInputField().sendKeys("secret_sauce");
//        loginPage.getLoginButton().click();
//    InventoryPage inventoryPage = new InventoryPage(driver);
//        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");



    @Test
    public void localHTMLExcerciseTest() throws InterruptedException {
        driver.get("file://E:\\Kursi\\LU automatizeta testesana\\JAVA\\RobertsSkudritisTestAutomation\\src\\test\\resources\\elements.html");
        WebElement descriptionTextArea = driver.findElement(By.name("description"));
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys("Šisi r teksts par mani, hello hgello");
        WebElement linkElements = driver.findElement(By.linkText("Link Text"));
        linkElements.click();
        WebElement isStudentCheckbox = driver.findElement(By.id("studentID"));
        Assert.assertEquals(isStudentCheckbox.isSelected(),false);
        isStudentCheckbox.click();
        Assert.assertEquals(isStudentCheckbox.isSelected(),true);
        Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasa.selectByIndex(0);
        milakaKrasa.selectByIndex(3);

        List<WebElement> sarakstsArKrasanm =  milakaKrasa.getOptions();
        for (int i = 0; i < sarakstsArKrasanm.size(); i++) {
            System.out.println(sarakstsArKrasanm.get(i));
        }

        WebElement nospiedManiPoga = driver.findElement(By.id("checkDataID"));
        nospiedManiPoga.click();


        WebElement vissIrLabiTeksts = driver.findElement(By.id("checkDataResultID"));
      //  wait.until(ExpectedConditions.elementToBeClickable(vissIrLabiTeksts));

        vissIrLabiTeksts.click();



        //    Thread.sleep(5000);

    }

    @Test
    public void successFullLoginTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
        System.out.println(acceptedUsernamesText.getText());
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
      //  Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(),"PRODUCTS");
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByValue("hilo");
        Thread.sleep(5000);
        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByIndex(1);
        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
        linkedInLink.click();

        Thread.sleep(5000);

    };

        @Test
        public void errorMessagePasswordEmptyTest() throws InterruptedException {
        //    WebDriver driver = new ChromeDriver();
            System.out.println("Tests");
            driver.get(SAUCELABS_URL);
           // driver.get("https://www.saucedemo.com/");
           // driver.close();
            WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
            System.out.println(acceptedUsernamesText.getText());
            WebElement usernameInputField = driver.findElement(By.id("user-name"));
            usernameInputField.sendKeys("Roberts");
            WebElement passwordInputField = driver.findElement(By.id("password"));
            passwordInputField.sendKeys("");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
            String expectedText = errorText.getText();
            Assert.assertEquals(errorText.getText(),"Epic sadface: Password is required");
            Thread.sleep(5000);
    }

    @Test
    public void errorMessageUsernameEmptyTest() throws InterruptedException {
        //    WebDriver driver = new ChromeDriver();
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
        // driver.get("https://www.saucedemo.com/");
        // driver.close();
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("RobertsParole");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String expectedText = errorText.getText();
        Assert.assertEquals(errorText.getText(),"Epic sadface: Username is required");
        Thread.sleep(5000);
    }

    @Test
    public void errorMessageWrongCredentials() throws InterruptedException {
        //    WebDriver driver = new ChromeDriver();
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
        // driver.get("https://www.saucedemo.com/");
        // driver.close();
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("Roberts");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("RobertsParole");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String expectedText = errorText.getText();
        Assert.assertEquals(errorText.getText(),"Epic sadface: Username and password do not match any user in this serviced");
        Thread.sleep(5000);

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    public void myTest2(){
        //    WebDriver driver = new ChromeDriver();
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
        // driver.get("https://www.saucedemo.com/");
        // driver.close();
    }


}
