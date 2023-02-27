import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.bookStore.HomePage;

public class TestTest extends BaseTest {
    @Test
    public void openTest() {
        get(HomePage.class)
                .open("https://demoqa.com/books/");
    }
}
