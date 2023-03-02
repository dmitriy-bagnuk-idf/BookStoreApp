package seleniumTests;

import pageObjects.bookStoreSelenium.SeleniumLoginPage;
import restAPI.BookStoreAPI;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.bookStoreSelenium.SeleniumBookStorePage;

public class SeleniumLoginTest extends BaseTest {
    @BeforeTest
    public void preconditions() {
        get(SeleniumBookStorePage.class)
                .open();
    }

    @Test(description = "User login test",
            priority = 1,
            enabled = true)
    public void userLoggedInTest() {
        get(SeleniumBookStorePage.class)
                .verifyBookStorePageIsOpen()
                .clickLoginBtn();
        String userName = get(BookStoreAPI.class).newUserRegistration();
        get(SeleniumLoginPage.class)
                .verifyLoginPageIsOpen()
                .enterUserName(userName)
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn()
                .verifyUserDisplayName(userName)
                .verifyUserLoggedIn();
    }
}
