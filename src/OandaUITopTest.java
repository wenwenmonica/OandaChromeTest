import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;



public class OandaUITopTest extends OandaChromeTestBase {

    @Test
    public void testHeadBar() {
        // Check whether cookies notice exists in head bar
        Assert.assertNotNull(_driver.findElement(By.id("cookie-consent")));
    }

    @Test
    public void testSearch() {
        // Check whether search field exists
        Assert.assertNotNull(_driver.findElement(By.id("w-search")));
    }

    @Test
    public void testNameSearch() {
        // Check whether grey "SEARCH" word exists in the search field
        Assert.assertNotNull(_driver.findElement(By.name("q")));
    }

    @Test
    public void testLanguageButton() {
        // Check whether language choice button exists
        Assert.assertNotNull(_driver.findElement(By.id("m-lang")));
    }

    @Test
    public void  testSignButton() {
        // Check whether "sign in" button exists
        Assert.assertNotNull(_driver.findElement(By.id("w-signin")));
    }

    @Test
    public void  testOpenAccountButton() {
        // Check whether "open an account" button exists
        Assert.assertNotNull(_driver.findElement(By.id("w-open")));
    }

    @Test
    public void testLogo() {
        // Check whether logo exists
        Assert.assertNotNull(_driver.findElement(By.id("logo")));
    }

    @Test
    public void testHeader() {
        // Check whether header exists
        List<String> header = new ArrayList<>();
        header.add("/forex-trading");
        header.add("/currency/converter/");
        header.add("/fx-for-business/");
        header.add("/resources/");
        for (String s : header) {
            Assert.assertNotNull(_driver.findElements(By.linkText("s")));
        }
    }

    @Test
    public void testCurrentPage() {
        // Show user's current page
        Assert.assertNotNull(_driver.findElement(By.className("cur_page")));
    }

    @Test
    public void testAd() {
        // Check whether advertisement shows
        Assert.assertNotNull(_driver.findElements(By.linkText("https://tpc.googlesyndication.com/simgad/16142013697872632601")));
    }

}
