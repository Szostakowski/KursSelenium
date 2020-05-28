package przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyFirstTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }


    @Test
    public void myFirstTest() {

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.clear();
        firstName.sendKeys("Karol");


        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.clear();
        lastName.sendKeys("Kowalski");

        // lista elementów do wyboru "gender"
        // get 0 - Male
        // get 1 - Female
        // get 2 - Between
        List<WebElement> genderList = driver.findElements(By.name("gender"));
        genderList.get(0).click();

        // sposób na pobranie konkretnego elementu o nazwie "gender"
//        WebElement gender = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
//        gender.click();

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.clear();
        dateOfBirth.sendKeys("05/22/2010");


        WebElement address = driver.findElement(By.id("address"));
        // zeby zniknął kalendarz
        address.click();
        address.clear();
        address.sendKeys("Prosta 51");


        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("karol.kowalski@mailinator.com");


        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("pas123");


        WebElement company = driver.findElement(By.id("company"));
        company.clear();
        company.sendKeys("Coders Lab");


        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");


        WebElement jobExpec = driver.findElement(By.xpath("//*[@id=\"expectation\"]/option[5]"));
        jobExpec.click();


        WebElement waysOfDev = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[11]/div/div[3]/label/input"));
        waysOfDev.click();

        WebElement comment = driver.findElement(By.id("comment"));
        comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testowy.");

        // Zdjęcie tego komentarza powoduje zamknięcie przeglądarki po wykonanym teście:

//        WebElement submit = driver.findElement(By.id("submit"));
//        submit.click();

//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();

    }
}