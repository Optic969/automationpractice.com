package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class Dresses {
	
	private WebDriver driver;
	
	public Dresses(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 30);
	}
	public WebElement getDressesProduct(int dressNum) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);
	}
	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
	}
	public WebElement getDressesProductAttribute(){
		//return Utils.waitForElementPresence(driver, By.xpath("//dt[@class='item']//span[@class='price']"),30);
		return Utils.waitForElementPresence(driver, By.xpath("//dt[@class='item']//a[@class='cart_block_product_name'][contains(text(),'Printed Dress')]"),30);
	}
}

