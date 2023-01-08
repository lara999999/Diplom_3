import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class TabYandexTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver= new ChromeDriver(options);
    }


    @Test
    @Description("Check click on the sauce tab")
    public void checkSauce_True() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickTabSauce();
        assertTrue(objMainPage.getSauceTabClassValue().contains("current"));
    }
    @Test
    @Description("Check click on the bun tab")
    public void checkBun_True() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickTabSauce();
        objMainPage.clickTabBun();
        assertTrue(objMainPage.getBunTabClassValue().contains("current"));

    }
    @Test
    @Description("Check click on the filler tab")
    public void checkFiller_True() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickTabFiller();
        assertTrue(objMainPage.getFillerTabClassValue().contains("current"));

    }
    @After
    public void teardown() {
        driver.quit();

    }
}
