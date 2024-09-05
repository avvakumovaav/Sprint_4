import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AboutRentPage;
import pages.CreateOrderPage;
import pages.SamokatMainPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private final WebDriver driver;
    private final SamokatMainPage samokatMainPage;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String rentStartDate;
    private final String rentTime;
    private final String color;
    private final boolean result;


    public CreateOrderTest(String name, String lastName, String address, String metro, String phone, String rentStartDate, String rentTime, String color, boolean result) {
        driver = new ChromeDriver(); // new FirefoxDriver();
        samokatMainPage = new SamokatMainPage(driver);

        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.rentStartDate = rentStartDate;
        this.rentTime = rentTime;
        this.color = color;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        String currentDateAsString = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        return new Object[][]{
                {"Иван", "Иванов", "ТестАдрес", "Сокольники", "12345678900", currentDateAsString, "сутки", "чёрный жемчуг", true},
                {"Петр", "Сидоров", "ТестАдрес2", "Царицыно", "22345678900", currentDateAsString, "двое суток", "серая безысходность", true},
        };
    }

    @Test
    public void checkCreateOrderUpButton() {
        samokatMainPage.clickOrderUpButton();

        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.setName(name);
        createOrderPage.setLastName(lastName);
        createOrderPage.setAddress(address);
        createOrderPage.setMetro(metro);
        createOrderPage.setPhone(phone);
        createOrderPage.clickNextButton();

        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        aboutRentPage.setWhenDeliverInput(rentStartDate);
        aboutRentPage.setRentTimeDropdown(rentTime);
        aboutRentPage.setColorInput(color);
        aboutRentPage.clickOrderButton();
        aboutRentPage.clickYesButton();

        assertEquals(result, aboutRentPage.checkSuccessOrderMessage());
    }

    @Test
    public void checkCreateOrderDownButton() {
        samokatMainPage.clickOrderDownButton();

        CreateOrderPage createOrderPage = new CreateOrderPage(driver);
        createOrderPage.setName(name);
        createOrderPage.setLastName(lastName);
        createOrderPage.setAddress(address);
        createOrderPage.setMetro(metro);
        createOrderPage.setPhone(phone);
        createOrderPage.clickNextButton();

        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        aboutRentPage.setWhenDeliverInput(rentStartDate);
        aboutRentPage.setRentTimeDropdown(rentTime);
        aboutRentPage.setColorInput(color);
        aboutRentPage.clickOrderButton();
        aboutRentPage.clickYesButton();

        assertEquals(result, aboutRentPage.checkSuccessOrderMessage());
    }


    @After
    public void teardown() {
        driver.quit();
    }

    @Before
    public void before() {
        driver.manage().deleteAllCookies();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        samokatMainPage.clickCloseCookiesButton();
    }
}