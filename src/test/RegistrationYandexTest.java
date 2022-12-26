import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationYandexTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver= new ChromeDriver(options);
    }
    @Test
    @Description("Check registration")
    public void checkRegistration_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName18);
        objRegisterPage.enterEmail(Generator.userEmail18);
        objRegisterPage.enterPassword(Generator.userPassword18);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();
    }
    @Test
    @Description("Check registration with invalid password")
    public void checkRegistrationWithIncorrectPassword_False() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName19);
        objRegisterPage.enterEmail(Generator.userEmail19);
        objRegisterPage.enterPassword(Generator.userPasswordFalse);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkAlert();
    }
    @After
    public void teardown() {
        driver.quit();

    }
}
