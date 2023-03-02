package selenideTests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.bookStoreSelenide.SelenideBookStorePage;
import pageObjects.bookStoreSelenide.SelenideLoginPage;
import pageObjects.bookStoreSelenium.SeleniumBookStorePage;
import restAPI.BookStoreAPI;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Log4j
public class SelenideTitlesTest extends SelenideBaseTest {
    @BeforeTest
    public void preconditions() {
        open(baseUrl);
    }

    @Test(description = "Compare lists of book titles from book store page and API",
            priority = 1,
            enabled = true)
    public void listOfTitlesTest() {
        log.debug("Compare lists of book titles from book store page and API");
        Assert.assertEquals(get(SelenideBookStorePage.class).getListOfBookTitles(),
                get(BookStoreAPI.class).getListOfBookTitlesFromAPI());
    }

    @AfterTest
    public void postconditions() {
        closeWebDriver();
    }

}
