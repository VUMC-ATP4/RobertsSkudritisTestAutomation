package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebTitleTest {

    WebDriver chromeBrowseris;

    @BeforeMethod //lai pirms katra testa izpilditu
    public void izveidoChrome(){
        System.out.println("Izveidojam Chrome pārlūku!");
        chromeBrowseris = new ChromeDriver();
            }

    @AfterMethod //lai pec katra testa izpilditu
    public void aizverChrome(){
        System.out.println("Aizveram Chrome pārlūku!");
        chromeBrowseris.quit();
    }

    @Test
    public void checkFirstPageTitle() {
        String url = "https://www.lsm.lv/";
        chromeBrowseris.get(url);
        String expectedTitle = "LSM.lv - Uzticamas ziņas";
        String actualTitle = chromeBrowseris.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void checkSecondPageTitle() {
        String url = "https://www.1a.lv/";
        chromeBrowseris.get(url);
        String expectedTitle = "Lielākais interneta veikals Latvijā | 1a.lv";
        String actualTitle = chromeBrowseris.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


}