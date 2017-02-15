import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class OandaChromeTestBase {
    static protected WebDriver _driver;

    @BeforeClass
    static public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/wenwenyang/Drivers/chromedriver");
        _driver = new ChromeDriver();
        _driver.get("http://www.oanda.com/currency/converter/");
    }

    @AfterClass
    static public void afterClass() {
        _driver.close();
    }
}
