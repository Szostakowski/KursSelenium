package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class MyStoreAddDataPage {

    private WebDriver driver;

    public MyStoreAddDataPage(WebDriver driver) {

        this.driver = driver;
    }


    public void addCompany(String alias, String company) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement companyInput = driver.findElement((By.name("company")));
        companyInput.clear();
        companyInput.sendKeys(company);
    }


    public void addUser(String firstName, String surname) {
        WebElement nameInput = driver.findElement(By.name("firstname"));
        nameInput.clear();
        nameInput.sendKeys(firstName);

        WebElement surnameInput = driver.findElement(By.name("lastname"));
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }


    public void addAddress(String address, String city, String zipCode) {
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.clear();
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement zipcodeInput = driver.findElement(By.name("postcode"));
        zipcodeInput.clear();
        zipcodeInput.sendKeys(zipCode);

        WebElement countryInput = driver.findElement(By.name("id_country"));
        countryInput.click();
        countryInput.sendKeys(Keys.ARROW_DOWN);
        countryInput.click();
    }


    public String checkIfSave() {
        WebElement checkIfSave = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        return checkIfSave.getText();
    }


}
