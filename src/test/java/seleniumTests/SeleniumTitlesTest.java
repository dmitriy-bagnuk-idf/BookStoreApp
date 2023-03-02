package seleniumTests;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.bookStoreSelenium.SeleniumBookStorePage;
import restAPI.BookStoreAPI;
@Log4j
public class SeleniumTitlesTest extends BaseTest {
    @BeforeTest
    public void preconditions() {
        get(SeleniumBookStorePage.class)
                .open();
    }
    @Test(description = "Compare lists of book titles from book store page and API",
            priority = 1,
            enabled = true)
    public void listOfTitlesTest() {
        log.debug("Compare lists of book titles from book store page and API");
        Assert.assertEquals(get(SeleniumBookStorePage.class).getListOfBookTitles(),
                            get(BookStoreAPI.class).getListOfBookTitlesFromAPI());
    }
}
