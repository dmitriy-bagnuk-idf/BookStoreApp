import pageObjects.bookStore.LoginPage;
import restAPI.BookStoreAPI;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.bookStore.BookStorePage;

public class LoginTest extends BaseTest {
    @BeforeTest
    public void preconditions() {
        get(BookStorePage.class)
                .open();
    }

    @Test(description = "User login test",
            priority = 1,
            enabled = true)
    public void userLoggedInTest() {
        get(BookStorePage.class)
                .verifyBookStorePageIsOpen()
                .clickLoginBtn();
        String userName = get(BookStoreAPI.class).newUserRegistration();
        get(LoginPage.class)
                .verifyLoginPageIsOpen()
                .enterUserName(userName)
                .enterPassword(properties.getProperty("password"))
                .clickLoginBtn()
                .verifyUserDisplayName(userName)
                .verifyUserLoggedIn();
    }
}
