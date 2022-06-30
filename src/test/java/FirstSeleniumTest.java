import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

@Test
    public void checkPageTitle(){
    String url = "https://www.saucedemo.com/";
    WebDriver chromeBrowseris = new ChromeDriver();
    chromeBrowseris.get(url);
    String expectedTitle = "Swag Labs";
    String actualTtitle = chromeBrowseris.getTitle();
    Assert.assertEquals(actualTtitle,expectedTitle);
    chromeBrowseris.quit();

}
}
