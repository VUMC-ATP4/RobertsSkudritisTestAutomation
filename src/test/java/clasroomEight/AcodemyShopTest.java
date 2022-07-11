package clasroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AcodemyShopTest {
    WebDriver driver;
    WebDriverWait wait;

    public final String ACODEMY_SHOP_URL = "http://shop.acodemy.lv/";

//    @BeforeMethod
//    public void setupBrowser() {
//        System.out.println("Pirms testa");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
@BeforeMethod
public void setupBrowser() throws MalformedURLException {
//    System.out.println("Pirms testa");
//    ChromeOptions chromeOptions = new ChromeOptions();
//    driver = new RemoteWebDriver(new URL("https://oauth-r.skudritis-ce729:314aeb22-ba76-41b7-966d-5ad53dd49d8f@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), chromeOptions);
//    InternetExplorerOptions browserOptions = new InternetExplorerOptions();
//    browserOptions.setCapability("platformName", "Windows 10");
//    browserOptions.setCapability("browserVersion", "11");
//    Map<String, Object> sauceOptions = new HashMap<>();
//    sauceOptions.put("build", "R test 3");
//    sauceOptions.put("name", "R test 321");
//    browserOptions.setCapability("sauce:options", sauceOptions);


//    driver = new RemoteWebDriver(new URL("https://oauth-r.skudritis-ce729:314aeb22-ba76-41b7-966d-5ad53dd49d8f@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444"),chromeOptions);
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}



    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pēc testa");
        driver.quit();
    }

    @Test
    public void searchForItemTest() throws InterruptedException {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        System.out.println("Search results count:" + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(),2);
        List<WebElement> searchResults = mainPage.getSearchResults();
//        for (WebElement element : searchResults) {
//            System.out.println(element.findElement(By.cssSelector("h2")).getText());
//        }
        for (int i = 0; i < mainPage.getSearchResults().size(); i++) {
            System.out.println(mainPage.getSearchResults().get(i).findElement(By.cssSelector("h2")).getText());
            System.out.println(mainPage.getSearchResults().get(i).findElement(By.className("price")).getText());
        }
    }



//    System.out.println("DEBUG LINE");


    @Test
    public void searchForItemTestTwo() throws InterruptedException {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Hoodie");
        System.out.println("Search results count:" + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(), 3);
    }


    @Test
    public void switchTabsTest() {
        driver.get("https://www.w3schools.com/");
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By.cssSelector("a[title='W3Schools on LinkedIn']")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        System.out.println();


    }

    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        driver.get("https://www.lu.lv/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.className("footer__up")).click();
        Thread.sleep(2000);
        System.out.println();

        WebElement element = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @Test
    public void hoverTest(){
    driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
    driver.findElement(By.id ("accept-choices")).click();
        WebElement hoverMeButton = driver.findElement(By.cssSelector("div.dropdown2 button"));

        new Actions (driver).moveToElement(hoverMeButton).perform();


        driver.findElement(By.linkText("Link 1")).click();
    }

    @Test
    public void seleniumDocTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();
        Thread.sleep(5000);

        driver.findElement(By.id("docsearch-input")).sendKeys("Selenium");
        Thread.sleep(3000);

    }


    @Test
    public void keyboardClickTest() throws InterruptedException {
        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        driver.findElement(By.id("clickToUseButton")).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
              //  .keyDown(Keys.DELETE)
                .perform();
        Thread.sleep(5000);

        new Actions(driver)
                .keyUp(Keys.ALT)
                .perform();
        Thread.sleep(5000);

        new Actions(driver)
                .sendKeys("J")
                .sendKeys("U")
                .sendKeys("R")
                .sendKeys("I")
                .sendKeys("S")
                .perform();
        Thread.sleep(5000);


    }


    }







