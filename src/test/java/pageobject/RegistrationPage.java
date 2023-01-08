package pageobject;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private WebDriver driver;

    private String registrationURL = "https://stellarburgers.nomoreparties.site/register";

    private By nameInput = By.xpath("//fieldset[1]/div/div/input");
    private By emailInput = By.xpath("//fieldset[2]/div/div/input");
    private By passwordInput = By.xpath("//fieldset[3]/div/div/input");
    private By registrationButton = By.xpath("//form/button");
    private By enterText = By.xpath("//*[.='Вход']");
    private By passwordAlert = By.xpath("//fieldset[3]/div/p");
    private By enterButton = By.xpath("//div/p/a");




    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage open() {
        driver.get(registrationURL);
        return this;
    }


    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(registrationButton).click();
    }
    public void checkStatus() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MatcherAssert.assertThat(driver.findElement(enterText).getText(), CoreMatchers.startsWith("Вход"));
    }
    public void checkAlert() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MatcherAssert.assertThat(driver.findElement(passwordAlert).getText(), CoreMatchers.startsWith("Некорректный пароль"));
    }
    public void clickEnterButtonRegistrationPage() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(enterButton).click();
    }

}