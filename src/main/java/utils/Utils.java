package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    /*private static final Properties locators;
    private static final String PROPERTIES_FILE_PATH = "/locators.properties";

    static {
        locators = new Properties();
        InputStream is = Utils.class.getResourceAsStream(PROPERTIES_FILE_PATH);
        try {
            locators.load(is);
        } catch (IOException e) {
            throw new RuntimeException("The locators properties file cannot be read from '"
                    + PROPERTIES_FILE_PATH + "'. Caused by:" + e.getMessage());
        }
    }

    public static By getParametrizedLocator(String locator, int param) {
        String propertyValue = locators.getProperty(locator);
        String parametrizedValue = String.format(propertyValue, param);
        return parseLocatorProperty(parametrizedValue);
    }

    public static By getLocator(String locator) {
        String propertyValue = locators.getProperty(locator);
        return parseLocatorProperty(propertyValue);
    }

    private static By parseLocatorProperty(String propertyValue) {
        String [] locatorParts = propertyValue.split(":", 2);
        String locatorType = locatorParts[0].trim();
        String locatorValue = locatorParts[1].trim();

        switch (locatorType) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            case "class":
                return By.className(locatorValue);
            case "tag":
                return By.tagName(locatorValue);
            case "link":
                return By.linkText(locatorValue);
            case "partLink":
                return By.partialLinkText(locatorValue);
            default:
                throw new IllegalArgumentException("Unknown locator type: " + locatorType);
        }
    }
    public static boolean isPresent(WebDriver webdriver, By selector) {
        // try to find element by specified selector
        try {
            webdriver.findElement(selector);
        } catch (NoSuchElementException e) {
            // if element not exist return false
            return false;
        }
        return true;
    }
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
    */

       public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
        return element;
    }

    public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
        WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
        return element;
    }

    public static void waitForTitle(WebDriver driver, String title, int waitInterval){
        (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
    }

}
