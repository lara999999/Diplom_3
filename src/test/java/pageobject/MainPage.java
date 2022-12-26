package pageobject;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;

    private String mainURL = "https://stellarburgers.nomoreparties.site/";

    private By enterAccountButton = By.xpath("//section[2]/div/button");
    private By accountButton = By.xpath("/html/body/div/div/header/nav/a");

    private By orderButton = By.xpath("//section[2]/div/button[text()='Оформить заказ']");
    private By tabBun = By.xpath("//main/section[1]/div[1]/div[1]");
    // private By chosenBun = By.xpath("//div/main/section[1]/div[1]/div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    private By tabSauce = By.xpath("//section[1]/div[1]/div[2]");
    //  private By chosenSauce = By.xpath("//div/main/section[1]/div[1]/div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    private By tabFiller = By.xpath("//section[1]/div[1]/div[3]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(mainURL);
        return this;
    }

    public void clickEnterAccountButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(enterAccountButton).click();
    }

    public void clickAccountButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(accountButton).click();
    }

    public void checkMainButton() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MatcherAssert.assertThat(driver.findElement(orderButton).getText(), CoreMatchers.startsWith("Оформить заказ"));
    }

    public void clickTabSauce() {
        driver.findElement(tabSauce).click();
    }

    public void clickTabBun() {
        driver.findElement(tabBun).click();
    }
    public void clickTabFiller() {
        driver.findElement(tabFiller).click();
    }

    public String getSauceTabClassValue() {
        return driver.findElement(tabSauce).getAttribute("class");
    }
    public String getBunTabClassValue() {
        return driver.findElement(tabBun).getAttribute("class");
    }
    public String getFillerTabClassValue() {
        return driver.findElement(tabFiller).getAttribute("class");
    }
}
