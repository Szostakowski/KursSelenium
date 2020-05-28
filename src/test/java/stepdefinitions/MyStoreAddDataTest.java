package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyStoreAddDataPage;
import przyklad1.AddressData;
import przyklad1.CompanyData;
import przyklad1.UsersData;

import java.util.concurrent.TimeUnit;

public class MyStoreAddDataTest {

    private WebDriver driver;

// użycie metody Gherkin

    @Given("open browser with prod-kurs.coderslab.pl")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    // Dodanie danych firmy z klasy CompanyData
    @When("user enters company data in input fields")
    public void companyInput() {
        MyStoreAddDataPage addCompanyData = new MyStoreAddDataPage(this.driver);
        addCompanyData.addCompany(CompanyData.getRandomAlias(), CompanyData.getRadomCompany());
    }

    // Dodanie danych użytkownika z klasy UserData
    @And("user enter user data in input fields")
    public void userInput() {
        MyStoreAddDataPage addUserData = new MyStoreAddDataPage(this.driver);
        addUserData.addUser(UsersData.getRandomMaleName(), UsersData.getRandomSurname());
    }

    // Dodanie adresu z klasy AddressData
    @And("user enter address data in input fields")
    public void addressInput() {
        MyStoreAddDataPage addAddressData = new MyStoreAddDataPage(this.driver);
        addAddressData.addAddress(AddressData.getRandomAddress(), AddressData.getRandomCity(), AddressData.getRandomZip());
    }


    @Then("click \"Save\" to save all data")
    public void clickSave() {
        WebElement save = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        save.click();
    }

    // sprawdzenie, czy po zapisaniu danych pojawia się informacja "Address successfully added!"
    @And("check if all data saved")
    public void checkSave() {
        MyStoreAddDataPage checkSuccesfully = new MyStoreAddDataPage(this.driver);
        Assert.assertEquals("Address successfully added!", checkSuccesfully.checkIfSave());
    }


}

