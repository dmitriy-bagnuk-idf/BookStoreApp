package pageObjects.baseObjects;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNgUtils.SelenideListener;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static propertyHelper.PropertyReader.getProperties;
@Log4j
@Listeners(SelenideListener.class)
public class SelenideBaseTest {
    protected Properties properties;
    @BeforeTest
    public void setUp() {
        log.debug("I'm started new webDriver!");
        properties = getProperties();
    }

    protected <T> T get(Class<T> page) {
        return driver().hasWebDriverStarted() ? page(page) : open(Configuration.baseUrl, page);
    }
}
