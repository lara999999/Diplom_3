package pageobject;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AccountPage {
    private WebDriver driver;
    private String accountURL = "https://stellarburgers.nomoreparties.site/account/";
    private By accountText = By.xpath("//div/nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private By exitButton = By.xpath("//nav/ul/li[3]/button");
    private By constructorButton = By.xpath("//header/nav/ul/li[1]/a");
    private By logoButton = By.xpath("/html/body/div/div/header/nav/div/a");


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
