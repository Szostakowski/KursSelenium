package przyklad1;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginTest {

    private WebDriver driver;

    @Before

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/prod-kurs.coderslab.pl");
    }


    // ustawienie metody, która pobiera aktualną datę i czas
    //metoda jest dodawana do adresu email przez co się nie powtarza.

    String DateFormat = "yyyyMMdd-HHmmss";
    LocalDateTime localDate = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormat);
    String formatDateTime = localDate.format(formatter);


    @Test
    public void LoginTest() {
        WebElement logIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        logIn.click();

        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        createAccount.click();

        //Dane użytkownika pobieram z klasy UserData
        WebElement name = driver.findElement(By.name("firstname"));
        name.clear();
        name.sendKeys(UsersData.getRandomMaleName());

        WebElement surname = driver.findElement(By.name("lastname"));
        surname.clear();
        surname.sendKeys(UsersData.getRandomSurname());


        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("test+" + formatDateTime + "@test.com");


        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("pas123");

        WebElement dob = driver.findElement(By.name("birthday"));
        dob.clear();
        dob.sendKeys("03/20/1999");

        WebElement clickSave = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
        clickSave.click();

        // przeście do panelu uzytkownika

        WebElement adminAccount = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
        adminAccount.click();

        WebElement addAddress = driver.findElement(By.xpath("//*[@id=\"address-link\"]/span/i"));
        addAddress.click();

        // Dane pobieram z Klasy CompanyData
        WebElement addAlias = driver.findElement((By.name("alias")));
        addAlias.clear();
        addAlias.sendKeys(CompanyData.getRandomAlias());


        WebElement addCompany = driver.findElement((By.name("company")));
        addCompany.clear();
        addCompany.sendKeys(CompanyData.getRadomCompany());
    }


}