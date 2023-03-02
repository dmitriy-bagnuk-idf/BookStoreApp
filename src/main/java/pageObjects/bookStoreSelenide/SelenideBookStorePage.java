package pageObjects.bookStoreSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j
public class SelenideBookStorePage {
    private final SelenideElement loginBtn = $(By.id("login"));
    private final ElementsCollection bookTitles = $$(By.xpath("//span/a"));

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
        log.debug("Get list of book titles");
        return bookTitles
                .stream()
                .map(SelenideElement -> SelenideElement.getText())
                .collect(Collectors.toList());
    }
}
