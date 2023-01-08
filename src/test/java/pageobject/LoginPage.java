package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    private String loginURL = "https://stellarburgers.nomoreparties.site/login";

  //  private By emailInput = By.xpath("//fieldset[1]/div/div");
    private By emailInput = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    private By passwordInput = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    private By enterButton = By.xpath("//div/form/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(loginURL);
        return this;
    }

    public void enterEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(emailInput));
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickEnterButton() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(enterButton).click();
    }

}
