package pageObjects.baseObjects;

import driver.UIElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.stream.Collectors;

import static driver.DriverManager.getDriver;
import static propertyHelper.PropertyReader.getProperties;

@Log4j
public abstract class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;
    protected Properties properties;

    protected BasePage() {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        properties = getProperties();
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void load() {
        log.debug("Open page :: " + properties.getProperty("url"));
        driver.get(properties.getProperty("url"));
    }

    protected String getPageUrl() {
        log.debug("Get page url");
        return driver.getCurrentUrl();
    }

    protected void enter(By locator, CharSequence... enterData) {
        log.debug("I enter :: " + enterData + ", by locator :: " + locator);
        findElement(locator).sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.DELETE));
        findElement(locator).sendKeys(enterData);
    }

    protected void click(By locator) {
        verifyElementClickable(locator);
        log.debug("I'm click by :: " + locator);
        findElement(locator).click();
    }

    protected String getText(By locator) {
        log.debug("I'm get text by  :: " + locator);
        return findElement(locator).getText();
    }

    protected void verifyElementClickable(By locator) {
        log.debug("Verify element clickable =>" + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
