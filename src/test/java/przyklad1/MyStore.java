package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class MyStore {

    private WebDriver driver;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http:/prod-kurs.coderslab.pl");
    }

    @Test
    public void myStore() {

        String[] products = {"mug", "white", "notebook", "cushion"};

        Random random = new Random();
        int randomIntiger = random.nextInt(40);
        int productNum = randomIntiger % products.length;

        System.out.println(products[productNum]);



        WebElement wyszukiwarka = driver.findElement(By.name("s"));

        wyszukiwarka.clear();
        wyszukiwarka.sendKeys(products[productNum]);
        wyszukiwarka.submit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}