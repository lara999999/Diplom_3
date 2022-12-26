import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RecoveryPasswordPage;
import pageobject.RegistrationPage;

public class LoginChromeTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    @Description("Check login with enter account button")
    public void checkLoginWithEnterAccountButton_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName8);
        objRegisterPage.enterEmail(Generator.userEmail8);
        objRegisterPage.enterPassword(Generator.userPassword8);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objMainPage.open();
        objMainPage.clickEnterAccountButton();


        objLoginPage.enterEmail(Generator.userEmail8);
        objLoginPage.enterPassword(Generator.userPassword8);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }
    @Test
    @Description("Check login with account profile button")
    public void checkLoginWithAccountProfileButton_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName9);
        objRegisterPage.enterEmail(Generator.userEmail9);
        objRegisterPage.enterPassword(Generator.userPassword9);
        objRegisterPage.clickRegisterButton();
       objRegisterPage.checkStatus();

        objMainPage.open();
        objMainPage.clickAccountButton();


        objLoginPage.enterEmail(Generator.userEmail9);
        objLoginPage.enterPassword(Generator.userPassword9);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }

    @Test
    @Description("Check login from recovery password form")
    public void checkLoginFromPasswordRecoveryPage_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RecoveryPasswordPage objRecoveryPasswordPage= new RecoveryPasswordPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName10);
        objRegisterPage.enterEmail(Generator.userEmail10);
        objRegisterPage.enterPassword(Generator.userPassword10);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objRecoveryPasswordPage.open();
        objRecoveryPasswordPage.clickEnterButtonRecoveryPage();


        objLoginPage.enterEmail(Generator.userEmail10);
        objLoginPage.enterPassword(Generator.userPassword10);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }

    @Test
    @Description("Check login from registration form")
    public void checkLoginFromRegistrationPage_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName11);
        objRegisterPage.enterEmail(Generator.userEmail11);
        objRegisterPage.enterPassword(Generator.userPassword11);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objRegisterPage.open();
        objRegisterPage.clickEnterButtonRegistrationPage();


        objLoginPage.enterEmail(Generator.userEmail11);
        objLoginPage.enterPassword(Generator.userPassword11);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }





    @After
    public void teardown() {
        driver.quit();

    }
}
