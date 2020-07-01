package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class Women {
    private WebDriver driver;

    public Women(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getWomenBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 30);
    }
    public WebElement getWomanProduct(int womanNum) {
        return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + womanNum + "]"), 30);
    }
    public List<WebElement> getWomenCount() {
        return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
    }
    public WebElement getWomenProductAttribute(){
        //return Utils.waitForElementPresence(driver, By.xpath("//dt[@class='first_item']//span[@class='price']"),30);
        return Utils.waitForElementPresence(driver, By.xpath("//dt[@class='first_item']//a[@class='cart_block_product_name'][contains(text(),'Blouse')]"),30);
        //dt[@class='first_item']//a[@class='cart_block_product_name'][contains(text(),'Blouse')]
    }
}
