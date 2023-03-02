package pageObjects.bookStoreSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j
public class SelenideBookStorePage {
    private final SelenideElement loginBtn = $(By.id("login"));
    private final ElementsCollection bookTitles = $$(By.xpath("//span/a"));

    private SelenideElement bookTitle(int count) {
        return $(By.xpath("(//span/a)[" + count + "]"));
    }

    public SelenideBookStorePage verifyBookStorePageIsOpen() {
        log.debug("Book store page is open");
        Assert.assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("books"));
        return this;
    }

    public SelenideBookStorePage clickLoginBtn() {
        log.debug("Click login btn");
        loginBtn.click();
        return this;
    }

    public List<String> getListOfBookTitles() {
        log.debug("Get count of books");
        int countOfBooks = bookTitles.size();
        log.debug("Get list of book titles");
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < countOfBooks; i++) {
            titles.add(i, bookTitle(i + 1).getText());
        }
        return titles;
    }
}
