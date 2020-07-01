package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class ShoppingActions {
	
	private WebDriver driver;
	
	public ShoppingActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getWomanAddToCartBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[2]//div[1]//div[2]//div[2]//a[1]//span[1]"), 30);
		//*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]
		//*[@id="center_column"]/ul/li[2]/div/div[2]/div[2]/a[1]
	}
	public WebElement getDressAddToCartBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[1]//div[1]//div[2]//div[2]//a[1]//span[1]"), 30);
	}
	public WebElement getTShirtAddToCartBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[1]//div[1]//div[2]//div[2]//a[1]//span[1]"), 30);
	}
	public WebElement getContinueShopingBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[@title=\"Continue shopping\"]"), 30);
	}
}
