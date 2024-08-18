import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SamokatMainPage;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CheckQuestionsTest {
    private final WebDriver driver;
    private final SamokatMainPage samokatMainPage;
    private final int index;
    private final String expectedText;

    public CheckQuestionsTest(int index, String expectedText) {
        driver = new FirefoxDriver();
        samokatMainPage = new SamokatMainPage(driver);
        this.index = index;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                { 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
        };
    }

    @Test
    public void checkQuestions() {
            samokatMainPage.clickQuestion(index);
            String actualText = samokatMainPage.getActualAnswer(index);
            assertTrue(actualText.contains(expectedText));
    }

    @Before
    public void before() {
        driver.manage().deleteAllCookies();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        samokatMainPage.clickCloseCookiesButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}