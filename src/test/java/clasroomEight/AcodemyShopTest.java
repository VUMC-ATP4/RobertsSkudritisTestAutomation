package clasroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShop.MainPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AcodemyShopTest {
    WebDriver driver;
    WebDriverWait wait;

    public final String ACODEMY_SHOP_URL = "http://shop.acodemy.lv/";

    @BeforeMethod
    public void setupBrowser() {
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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







