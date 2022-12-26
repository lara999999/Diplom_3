import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RecoveryPasswordPage;
import pageobject.RegistrationPage;

public class LoginYandexTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver= new ChromeDriver(options);
    }
    @Test
    @Description("Check login with enter account button")
    public void checkLoginWithEnterAccountButton_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName12);
        objRegisterPage.enterEmail(Generator.userEmail12);
        objRegisterPage.enterPassword(Generator.userPassword12);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objMainPage.open();
        objMainPage.clickEnterAccountButton();


        objLoginPage.enterEmail(Generator.userEmail12);
        objLoginPage.enterPassword(Generator.userPassword12);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }
    @Test
    @Description("Check login with account profile button")
    public void checkLoginWithAccountProfileButton_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName13);
        objRegisterPage.enterEmail(Generator.userEmail13);
        objRegisterPage.enterPassword(Generator.userPassword13);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objMainPage.open();
        objMainPage.clickAccountButton();


        objLoginPage.enterEmail(Generator.userEmail13);
        objLoginPage.enterPassword(Generator.userPassword13);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }

    @Test
    @Description("Check login from recovery password form")
    public void checkLoginFromPasswordRecoveryPage_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RecoveryPasswordPage objRecoveryPasswordPage= new RecoveryPasswordPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName14);
        objRegisterPage.enterEmail(Generator.userEmail14);
        objRegisterPage.enterPassword(Generator.userPassword14);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objRecoveryPasswordPage.open();
        objRecoveryPasswordPage.clickEnterButtonRecoveryPage();


        objLoginPage.enterEmail(Generator.userEmail14);
        objLoginPage.enterPassword(Generator.userPassword14);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }

    @Test
    @Description("Check login from registration form")
    public void checkLoginFromRegistrationPage_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName15);
        objRegisterPage.enterEmail(Generator.userEmail15);
        objRegisterPage.enterPassword(Generator.userPassword15);
        objRegisterPage.clickRegisterButton();
        Thread.sleep(1000);
        objRegisterPage.checkStatus();

        objRegisterPage.open();
        objRegisterPage.clickEnterButtonRegistrationPage();


        objLoginPage.enterEmail(Generator.userEmail15);
        objLoginPage.enterPassword(Generator.userPassword15);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();


    }





    @After
    public void teardown() {
        driver.quit();

    }
}

