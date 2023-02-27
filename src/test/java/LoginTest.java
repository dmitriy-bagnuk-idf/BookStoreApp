import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.bookStore.BookStorePage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends BaseTest {
    @BeforeTest
    public void preconditions () {
        get(BookStorePage.class)
                .open();
    }
    @Test(enabled = false)
    public void openTest() {
        get(BookStorePage.class)
                .verifyBookStorePageIsOpen()
                .clickLoginBtn();
    }

    @Test
    public void nameTest() {
        System.out.println(Arrays.toString(get(BookStorePage.class).getListOfBookTitles().toArray()));
    }
}
