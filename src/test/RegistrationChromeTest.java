import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.RegistrationPage;

public class RegistrationChromeTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    @Description("Check registration")
    public void checkRegistration_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName16);
        objRegisterPage.enterEmail(Generator.userEmail16);
        objRegisterPage.enterPassword(Generator.userPassword16);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();
}
    @Test
    @Description("Check registration with invalid password")
    public void checkRegistrationWithIncorrectPassword_False() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName17);
        objRegisterPage.enterEmail(Generator.userEmail17);
        objRegisterPage.enterPassword(Generator.userPasswordFalse);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkAlert();
    }


    @After
    public void teardown() {
        driver.quit();

    }
}
