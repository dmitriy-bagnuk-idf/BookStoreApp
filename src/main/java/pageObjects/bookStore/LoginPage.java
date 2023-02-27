package pageObjects.bookStore;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

@Log4j
public class LoginPage extends BasePage {
    private final By userName = By.id("userName");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login");

    public LoginPage enterUserName() {
        log.debug("Enter username");
        return this;
    }

    public LoginPage enterPassword() {
        log.debug("Enter password");
        return this;
    }

    public LoginPage clickLoginBtn() {
        log.debug("Click login btn");
        click(loginBtn);
        return this;
    }

    public LoginPage verifyLoginPageIsOpen() {
        log.debug("Verify login page is open");
        return this;
    }

    public LoginPage verifyUserIsLoggedIn() {
        log.debug("Verify user is logged in");
        return this;
    }
}
