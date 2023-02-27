package pageObjects.bookStore;

import pageObjects.baseObjects.BasePage;

public class HomePage extends BasePage {
    public HomePage open(String url) {
        load(url);
        return this;
    }
}
