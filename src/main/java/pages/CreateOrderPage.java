package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateOrderPage {
    private WebDriver driver;
    // локатор Инпут Имя
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    // локатор Инпут Фамилия
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор Инпут Адрес
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор Инпут Метро
    private By MetroInput = By.xpath(".//input[@placeholder='* Станция метро']");
//    Select metroDropdown;

    // локатор Инпут Телефон
    private By PhoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public CreateOrderPage(WebDriver driver){
        this.driver = driver;
//        metroDropdown = new Select(driver.findElement(By.className("select-search__value")));
    }

    public void setName(String name) {
//        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setLastName(String lastName) {
//        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(MetroInput).click();
        driver.findElement(MetroInput).sendKeys(metro);
        driver.findElement(By.xpath(".//*[text()='"+metro+"']")).click();
//        driver.findElement(MetroInput).sendKeys(Keys.RETURN);

    }

    public void setPhone(String phone) {
        driver.findElement(PhoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
