package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import przyklad1.UsersData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QlHotelSteps {
    private WebDriver driver;

    @Given("an open browser with qloapps.coderslab.pl/pl")
    public void openHotelWeb() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        // Uruchomiam przeglądarkę Chrome - nowe okno
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do strony
        driver.get("https://qloapps.coderslab.pl/pl");
    }

    // po wejściu na stronę hotelu wybieram przycisk "Zaloguj się"

    @When("click \"Zaloguj sie\" on website")
    public void clickLogin() {
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[7]/ul/li/a/span"));
        login.click();
    }

    // Stworzenie aktualnej daty i godziny, ktory dodam do adresu mejlowego - przez co adres email będzie niepowtarzalny

    String DateFormat = "yyyyMMdd-HHmmss";
    LocalDateTime localDate = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormat);
    String formatDateTime = localDate.format(formatter);


    @And("enter email address in input filed \"Create new account\"")
    public void enterEmail() {
        WebElement enterEmail = driver.findElement(By.name("email_create"));
        enterEmail.clear();
        enterEmail.sendKeys("rafal.szostakowski" + formatDateTime + "@gmail.com");
        enterEmail.submit();
    }

    // Metoda do wyczekania okreslonej ilości sekund, bez tego akrat ten formulaż nie zdąży się załadować

    @Then("wait 5sek, should open new website to create new account")
    public void WaitFiveSek() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // Wypełniam formularz

    @And("add account data: gender, first name, surname, password, date of birth, email address was added automatically")
    public void AddAccountData() {

        // Losowanie liczb w celu niepowtarzalności wyboru przy kolejnych testach

        Random randomGender = new Random();
        int g = randomGender.nextInt(1) + 1;

        WebElement gender = driver.findElement(By.id("id_gender" + g));
        gender.click();

        // imię i nazwisko pobieram z wcześniej napisanej klasy "RandomMaleName"

        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.clear();
        firstName.sendKeys(UsersData.getRandomMaleName());

        WebElement surname = driver.findElement(By.id("customer_lastname"));
        surname.clear();
        surname.sendKeys(UsersData.getRandomSurname());

        WebElement password = driver.findElement(By.id("passwd"));
        password.clear();
        password.sendKeys("pas123");

        // dla niepowtarzalności wyboru daty urodzenia zrobiłem losowanie liczb + pętle która ustala ile razy będzie
        // wciśnięty przycisk "strzałka w dół" którym można przesuwać się po dniach/miesiącach/latach.

        WebElement dobDay = driver.findElement(By.id("days"));
        Random randomDay = new Random();
        int d = randomDay.nextInt(31);

        for (int i = 0; i <= d; i++) {
            if (d == 0) d++;
            else dobDay.sendKeys(Keys.ARROW_DOWN);
        }
        dobDay.sendKeys(Keys.ENTER);


        WebElement dobMonth = driver.findElement(By.id("months"));

        Random randomMonth = new Random();
        int m = randomDay.nextInt(12);
        for (int i = 0; i <= m; i++) {
            if (m == 0) m++;
            else dobMonth.sendKeys(Keys.ARROW_DOWN);
        }
        dobMonth.sendKeys(Keys.ENTER);


        WebElement dobYear = driver.findElement(By.id("years"));
        Random randomYear = new Random();
        int y = randomDay.nextInt(101);

        for (int i = 0; i <= y; i++) {
            if (y < 18) y++;
            else dobYear.sendKeys(Keys.ARROW_DOWN);
        }
        dobYear.sendKeys(Keys.ENTER);
    }

    // wybór newlettera dla zakończenia testu

    @And("check newsletter")
    public void newsletter() {
        WebElement newsletter = driver.findElement(By.name("newsletter"));
        newsletter.click();
    }

}

