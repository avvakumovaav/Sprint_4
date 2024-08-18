package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SamokatMainPage {
    private WebDriver driver;
    // локатор Кнопка «Заказать» вверху страницы
    private By orderUpButton = By.className("Button_Button__ra12g");
    // локатор Кнопка «Заказать» внизу страницы
    private By orderDownButton = By.xpath(".//*[text()='Заказать' and contains(@class, 'Button_Middle__1CSJM')]");
    private By closeCookiesButton = By.xpath(".//button[text()='да все привыкли']");


    public SamokatMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickQuestion(int index) {
        // локатор Элемент списка с вопросами
        By questionElement = By.xpath(".//div[@class='accordion__item']["+index+"]");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionElement));
        driver.findElement(questionElement).click();
    }

    public String getActualAnswer(int index) {
        By textElement = By.xpath(".//div[@class='accordion__panel']/p["+index+"]");
        return driver.findElement(textElement).getText();
    }

    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }

    public void clickOrderDownButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderDownButton));
        driver.findElement(orderDownButton).click();
    }

    public void clickCloseCookiesButton() {
        driver.findElement(closeCookiesButton).click();
    }
}
