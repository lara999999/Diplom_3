package pageobject;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AccountPage {
    private WebDriver driver;
    private String accountURL = "https://stellarburgers.nomoreparties.site/account/";
    private By accountText = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private By exitButton = By.xpath(".//button[text()='Выход']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
//тут поправила

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage open() {
        driver.get(accountURL);
        return this;
    }

    public void checkProfileText() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MatcherAssert.assertThat(driver.findElement(accountText).getText(), CoreMatchers.startsWith("В этом разделе вы можете изменить свои персональные данные"));
    }

    public void clickExitButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(exitButton).click();
    }

    public void clickLogoButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(logoButton).click();
    }

    public void clickConstructorButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(constructorButton).click();
    }




}
