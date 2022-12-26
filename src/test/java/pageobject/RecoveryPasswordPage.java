package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private WebDriver driver;

    private String recoverPasswordURL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private By enterButton = By.xpath("//div/p/a");


    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public RecoveryPasswordPage open() {
        driver.get(recoverPasswordURL);
        return this;
    }

    public void clickEnterButtonRecoveryPage() {
        driver.findElement(enterButton).click();
    }

}
