package pageObjects.bookStore;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class BookStorePage extends BasePage {
    private final By loginBtn = By.id("login");
    private final By bookTitles = By.xpath("//span/a");

    private By bookTitle(int count) {
        return By.xpath("(//span/a)[" + count + "]");
    }

    public void open() {
        load();
    }

    public BookStorePage verifyBookStorePageIsOpen() {
        log.debug("Book store page is open");
        Assert.assertEquals(properties.getProperty("url"), getPageUrl());
        return this;
    }

    public BookStorePage clickLoginBtn() {
        log.debug("Click login btn");
        click(loginBtn);
        return this;
    }

    private Integer getCountOfBooks() {
        log.debug("Get count of books");
        return findElements(bookTitles).size();
    }

    public List<String> getListOfBookTitles() {
        log.debug("Get list of book titles");
        List<String> books = new ArrayList<>();
        for (int i = 0; i < getCountOfBooks(); i++) {
            books.add(i, findElement(bookTitle(i + 1)).getText());
        }
        return books;
    }
}
