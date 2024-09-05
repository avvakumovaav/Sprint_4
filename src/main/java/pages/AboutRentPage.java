package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class AboutRentPage {
    private WebDriver driver;
    private By whenDeliverInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentTimeDropdown = By.xpath(".//*[@class='Dropdown-control']"); //.//*[@class='Dropdown-control']/div[text()='сутки']
    private By blackColorInput = By.xpath(".//input[@id='black']");
    private By greyColorInput = By.xpath(".//input[@id='grey']");
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//*[text()='Заказать' and contains(@class, 'Button_Middle')]");
    private By yesModalWindowButton = By.xpath(".//button[text()='Да']");
    private By successOrderMessageModalWindow = By.xpath(".//*[text()='Заказ оформлен']");


    public AboutRentPage(WebDriver driver){
        this.driver = driver;
    }

    public void setWhenDeliverInput(String deliveryDate) {
//        driver.findElement(whenDeliverInput).clear();
        driver.findElement(whenDeliverInput).sendKeys(deliveryDate);
        driver.findElement(whenDeliverInput).sendKeys(Keys.RETURN);
    }

    public void setRentTimeDropdown(String rentTime) {
        driver.findElement(rentTimeDropdown).click();
//        driver.findElement(rentTimeDropdown).sendKeys(rentTime);
//        driver.findElement(rentTimeDropdown).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath(".//*[@class='Dropdown-option' and text()='"+rentTime+"']")).click(); // .//*[@class='Dropdown-option' and text()='сутки']
    }

    public void setColorInput(String color) {
        if (Objects.equals(color, "серая безысходность"))
            driver.findElement(greyColorInput).click();
        if (Objects.equals(color, "чёрный жемчуг"))
            driver.findElement(blackColorInput).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickYesButton() {
        driver.findElement(yesModalWindowButton).click();
    }
    public boolean checkSuccessOrderMessage() {
        return driver.findElement(successOrderMessageModalWindow).isDisplayed();
    }

}
