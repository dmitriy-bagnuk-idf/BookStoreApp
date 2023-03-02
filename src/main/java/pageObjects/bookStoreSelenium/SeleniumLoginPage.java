package pageObjects.bookStoreSelenium;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;


@Log4j
public class SeleniumLoginPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private final By userName = By.id("userName");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login");
    private final By userDisplayName = By.id("userName-value");
    private final By userNameLabel = By.id("userName-label");

    public SeleniumLoginPage enterUserName(String userName) {
        log.debug("Enter username");
        enter(this.userName, userName);
        return this;
    }

    public SeleniumLoginPage enterPassword(String password) {
        log.debug("Enter password");
        enter(this.password, password);
        return this;
    }

    public SeleniumLoginPage clickLoginBtn() {
        log.debug("Click login btn with JavascriptExecutor");
        js.executeScript("arguments[0].click();", findElement(loginBtn));
        return this;
    }

    public SeleniumLoginPage verifyLoginPageIsOpen() {
        log.debug("Verify login page is open");
        Assert.assertTrue(getPageUrl().contains("login"));
        return this;
    }

    public SeleniumLoginPage verifyUserDisplayName(String userName) {
        log.debug("Verify user display name");
        Assert.assertEquals(getText(userDisplayName), userName);
        return this;
    }

    public SeleniumLoginPage verifyUserLoggedIn() {
        log.debug("Verify user logged in");
        Assert.assertTrue(findElement(userNameLabel).isDisplayed());
        return this;
    }
}
