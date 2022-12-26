import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

public class AccountChromeTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    @Description("Check click on constructor button")
    public void checkClickOnConstructorButton_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName);
        objRegisterPage.enterEmail(Generator.userEmail);
        objRegisterPage.enterPassword(Generator.userPassword);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objLoginPage.enterEmail(Generator.userEmail);
        objLoginPage.enterPassword(Generator.userPassword);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();

      //  objMainPage.open();
        objMainPage.clickAccountButton();

        objAccountPage.clickConstructorButton();

        objMainPage.checkMainButton();


    }

    @Test
    @Description("Check click on logo button")
    public void checkClickOnLogoButton_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName2);
        objRegisterPage.enterEmail(Generator.userEmail2);
        objRegisterPage.enterPassword(Generator.userPassword2);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();


        objLoginPage.enterEmail(Generator.userEmail2);
        objLoginPage.enterPassword(Generator.userPassword2);
        objLoginPage.clickEnterButton();
        objMainPage.checkMainButton();

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
        objRegisterPage.enterName(Generator.userName3);
        objRegisterPage.enterEmail(Generator.userEmail3);
        objRegisterPage.enterPassword(Generator.userPassword3);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objLoginPage.enterEmail(Generator.userEmail3);
        objLoginPage.enterPassword(Generator.userPassword3);
        objLoginPage.clickEnterButton();

        // objMainPage.open();
        Thread.sleep(1000);
        objMainPage.clickAccountButton();

        objAccountPage.checkProfileText();


    }
    @Test
    @Description("Exit account profile")
    public void checkExitProfile_True() {
        RegistrationPage objRegisterPage = new RegistrationPage(driver);
        MainPage objMainPage = new MainPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        AccountPage objAccountPage = new AccountPage(driver);

        objRegisterPage.open();
        objRegisterPage.enterName(Generator.userName4);
        objRegisterPage.enterEmail(Generator.userEmail4);
        objRegisterPage.enterPassword(Generator.userPassword4);
        objRegisterPage.clickRegisterButton();
        objRegisterPage.checkStatus();

        objLoginPage.enterEmail(Generator.userEmail4);
        objLoginPage.enterPassword(Generator.userPassword4);
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
