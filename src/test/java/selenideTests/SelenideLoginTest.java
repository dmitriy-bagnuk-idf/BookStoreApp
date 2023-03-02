package selenideTests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.bookStoreSelenide.SelenideBookStorePage;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.bookStoreSelenide.SelenideLoginPage;
import restAPI.BookStoreAPI;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SelenideLoginTest extends SelenideBaseTest {
    @BeforeTest
    public void preconditions() {
        open(baseUrl);
    }

    @Test(description = "User login test",
            priority = 1,
            enabled = true)
    public void userLoggedInTest() {
        String userName = get(BookStoreAPI.class)
                .newUserRegistration();
        get(SelenideBookStorePage.class)
                .verifyBookStorePageIsOpen()
                .clickLoginBtn();
        get(SelenideLoginPage.class)
                .verifyLoginPageIsOpen()
                .enterUserName(userName)
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn()
                .verifyUserDisplayName(userName)
                .verifyUserLoggedIn();
    }

    @AfterTest
    public void postconditions() {
        closeWebDriver();
    }

}
