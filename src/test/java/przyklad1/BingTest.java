package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingTest {
    private WebDriver driver;

    @Before

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http:/www.bing.com");

    }

    @Test
    public void testBing() {

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("Mistrzostwa Świata w piłce nożnej 2018");

        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
