import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;



public class OandaConverterDetailsTest extends OandaChromeTestBase {

    @Test
    public void testCurrencyIHaveDrop() {
        // Check whether drop down list exists in "Currency I Have" field
        Assert.assertNotNull(_driver.findElement(By.id("scroll-innerBox-1")));
    }

    @Test
    public void testCurrencyIWantDrop() {
        // Check whether drop down list exists in "Currency I Want" field
        Assert.assertNotNull(_driver.findElement(By.id("scroll-innerBox-2")));
    }

    @Test
    public void testCurrencySearchExists() {
        // Check whether currency search exists in the "Currency I Have" field
        Assert.assertNotNull(_driver.findElement(By.id("quote_currency_input")));
        // Check whether currency search exists in the "Currency I Want" field
        Assert.assertNotNull(_driver.findElement(By.id("base_currency_input")));

    }

    @Test
    public void testCurrencySearchPerforms() {
        // Randomly type letters in "Currency I Have" search field
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        WebElement quote = _driver.findElement(By.id("quote_currency_input"));
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            quote.sendKeys(sb.toString());
        }
        // Randomly type letters in "Currency I Want" search field
        char d = (char)(r.nextInt(26) + 'a');
        WebElement base = _driver.findElement(By.id("base_currency_input"));
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(d);
            base.sendKeys(sb.toString());
        }

        List<WebElement> searchResults = _driver.findElements(By.className("ltr_list_item"));
        for (WebElement searchResult : searchResults) {
            Assert.assertEquals(searchResult.getAttribute("style"), "display: none;");
        }
    }

    @Test
    public void testCurrencySearchInvalidPerforms() {
        // Randomly type invalid input in "Currency I Have" search field
        String[] s = {"1", "2", "3", "!", "%", "*"};
        Random r = new Random();
        WebElement s1 = _driver.findElement(By.id("quote_currency_input"));
        for (int i = 0; i < 10; i++) {
            s1.sendKeys(s[r.nextInt(6)]);
        }
        // Randomly type invalid input in "Currency I Want" search field
        WebElement s2 = _driver.findElement(By.id("base_currency_input"));
        for (int i = 0; i < 10; i++) {
            s2.sendKeys(s[r.nextInt(6)]);
        }

        List<WebElement> searchResults = _driver.findElements(By.className("ltr_list_item"));
        for (WebElement searchResult : searchResults) {
            Assert.assertEquals(searchResult.getAttribute("style"), "display: none;");
        }
    }

    @Test
    public void testFlipCurrencies() {
        String oldQuoteCurrency = _driver.findElement(By.id("quote_currency_input")).getAttribute("value");
        String oldBaseCurrency = _driver.findElement(By.id("base_currency_input")).getAttribute("value");
        _driver.findElement(By.id("flipper")).click();
        String newQuoteCurrency = _driver.findElement(By.id("quote_currency_input")).getAttribute("value");
        String newBaseCurrency = _driver.findElement(By.id("base_currency_input")).getAttribute("value");
        Assert.assertEquals(oldQuoteCurrency, newBaseCurrency);
        Assert.assertEquals(oldBaseCurrency, newQuoteCurrency);
    }
}
