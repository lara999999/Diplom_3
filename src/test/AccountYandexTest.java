import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

public class AccountYandexTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        driver= new ChromeDriver(options);
    }
    @Test
    @Description("Check click on constructor button")
    public void checkClickOnConstructorButton_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName5);
        objRegisterPage.enterEmail(Generator.userEmail5);
        objRegisterPage.enterPassword(Generator.userPassword5);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objLoginPage.enterEmail(Generator.userEmail5);
        objLoginPage.enterPassword(Generator.userPassword5);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();

        //  objMainPage.open();
        objMainPage.clickAccountButton();

        objAccountPage.clickConstructorButton();

        objMainPage.checkMainButton();


    }

    @Test
    @Description("Check click on logo button")
    public void checkClickOnLogoButton_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName6);
        objRegisterPage.enterEmail(Generator.userEmail6);
        objRegisterPage.enterPassword(Generator.userPassword6);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();


        objLoginPage.enterEmail(Generator.userEmail6);
        objLoginPage.enterPassword(Generator.userPassword6);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();

        // objMainPage.open();
        objMainPage.clickAccountButton();

        objAccountPage.clickLogoButton();

        objMainPage.checkMainButton();


    }
    @Test
    @Description("Open account profile")
    public void checkOpenAccountProfile_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName20);
        objRegisterPage.enterEmail(Generator.userEmail20);
        objRegisterPage.enterPassword(Generator.userPassword20);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objLoginPage.enterEmail(Generator.userEmail20);
        objLoginPage.enterPassword(Generator.userPassword20);
        objLoginPage.clickEnterButton();

        // objMainPage.open();
        objMainPage.clickAccountButton();

        objAccountPage.checkProfileText();


    }

    @Test
    @Description("Exit account profile")
    public void checkExitProfile_True() throws InterruptedException {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName7);
        objRegisterPage.enterEmail(Generator.userEmail7);
        objRegisterPage.enterPassword(Generator.userPassword7);
        Thread.sleep(1000);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objLoginPage.enterEmail(Generator.userEmail7);
        objLoginPage.enterPassword(Generator.userPassword7);
        objLoginPage.clickEnterButton();


        objMainPage.clickAccountButton();
        objAccountPage.checkProfileText();
        objAccountPage.clickExitButton();

        objRegisterPage.checkStatus();



    }



    @After
    public void teardown() {
        driver.quit();

    }
}
