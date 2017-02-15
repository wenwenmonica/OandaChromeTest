import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class OandaConverterMainFunctionTest extends OandaChromeTestBase {

    @Test
    public void testConvertCurrency() {
        List<String> currency = new ArrayList<>();
        currency.add("Euro");
        currency.add("Australia");
        currency.add("Pound");
        currency.add("Chinese");
        currency.add("US D");

        // Choose a currency in "Currency I Have"
        Random r = new Random();
        String picked = currency.get(r.nextInt(5));
        WebElement quoteSelection = _driver.findElement(By.id("quote_currency_input"));
        quoteSelection.sendKeys(picked);
        quoteSelection.sendKeys(Keys.RETURN);
        currency.remove(picked);

        // Choose a currency in "Currency I Want"
        picked = currency.get(r.nextInt(4));
        WebElement baseSelection = _driver.findElement(By.id("base_currency_input"));
        baseSelection.sendKeys(picked);
        baseSelection.sendKeys(Keys.RETURN);

        // Set amount in "Currency I Want"
        _driver.findElement(By.id("quote_amount_input")).sendKeys("2");
        // Get amount in "Currency I Have"
        WebElement baseValueA = _driver.findElement(By.id("sellMyCurrencyGet"));
        String s = baseValueA.getText().split(" ")[2];
        double baseNumberA = Double.parseDouble(s);

        // Set new amount in "Currency I Want"
        _driver.findElement(By.id("quote_amount_input")).sendKeys("0");
        // Get new amount in "Currency I Have"
        WebElement baseValueB = _driver.findElement(By.id("sellMyCurrencyGet"));
        s = baseValueB.getText().split(" ")[2];
        double baseNumberB = Double.parseDouble(s);

        // Check results
        Assert.assertEquals(baseNumberA * 10, baseNumberB, 0.01);
    }

    @Test
    public void testConvertSameCurrency() {
        // Choose a currency in "Currency I Have"
        WebElement quoteSelection = _driver.findElement(By.id("quote_currency_input"));
        quoteSelection.sendKeys("US D");
        quoteSelection.sendKeys(Keys.RETURN);

        // Choose a currency in "Currency I Want"
        WebElement baseSelection = _driver.findElement(By.id("base_currency_input"));
        baseSelection.sendKeys("US D");
        baseSelection.sendKeys(Keys.RETURN);

        // Set amount in "Currency I Want"
        _driver.findElement(By.id("quote_amount_input")).sendKeys("2");
        // Get amount in "Currency I Have"
        WebElement baseValue = _driver.findElement(By.id("sellMyCurrencyGet"));
        String s = baseValue.getText().split(" ")[2];
        double baseNumber = Double.parseDouble(s);

        // Check results
        Assert.assertEquals(baseNumber, 2.0, 0.01);
    }
}
