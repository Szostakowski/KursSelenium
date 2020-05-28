package junit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyStoreAddDataPage;
import przyklad1.CompanyData;
import przyklad1.UsersData;

import java.util.concurrent.TimeUnit;

public class MyStoreAddDataTest {

    private WebDriver driver;


    @Given("an open browser with prod-kurs.coderslab.pl")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @When("user enter company data in input fileds")
    public void companyInput(){
        MyStoreAddDataPage addCompanyData = new MyStoreAddDataPage(this.driver);
        addCompanyData.addCompany(CompanyData.getRandomAlias(),CompanyData.getRadomCompany());
    }

    @And("user enter user data in input fileds")
    public void userInput(){
        MyStoreAddDataPage addUserData = new MyStoreAddDataPage(this.driver);
        addUserData.addUser(UsersData.getRandomMaleName(),UsersData.getRandomSurname());
    }

}

