package pageObjects.bookStoreSelenide;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j
public class SelenideLoginPage {
    private final SelenideElement userName = $(By.id("userName"));
    private final SelenideElement password = $(By.id("password"));
    private final SelenideElement loginBtn = $(By.id("login"));
    private final SelenideElement userDisplayName = $(By.id("userName-value"));
    private final SelenideElement userNameLabel = $(By.id("userName-label"));

    public SelenideLoginPage enterUserName(String userName) {
        log.debug("Enter username");
        this.userName.setValue(userName);
        return this;
    }

    public SelenideLoginPage enterPassword(String password) {
        log.debug("Enter password");
        this.password.setValue(password);
        return this;
    }
    public SelenideLoginPage clickLoginBtn() {
        log.debug("Click login btn with JavascriptExecutor");
        executeJavaScript("arguments[0].click();", loginBtn);
        return this;
    }

    public SelenideLoginPage verifyLoginPageIsOpen() {
        log.debug("Verify login page is open");
        Assert.assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("login"));
        return this;
    }

    public SelenideLoginPage verifyUserDisplayName(String userName) {
        log.debug("Verify user display name");
        Assert.assertEquals(userDisplayName.getText(), userName);
        return this;
    }

    public SelenideLoginPage verifyUserLoggedIn() {
        log.debug("Verify user logged in");
        userNameLabel.should(visible);
        return this;
    }
}
