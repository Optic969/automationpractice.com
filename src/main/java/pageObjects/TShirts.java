package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class TShirts {

    private WebDriver driver;

    public TShirts(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTShirtsBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 30);
    }
    public WebElement getTShirtsProduct(int tShirtsNum) {
        return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + tShirtsNum + "]"), 30);
    }
    public List<WebElement> getTShirtsCount() {
        return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
    }
    public WebElement getTShirtProductAttribute(){
        //return Utils.waitForElementPresence(driver, By.xpath("//dt[@class='last_item']//span[@class='price']"),30);
        return Utils.waitForElementPresence(driver, By.xpath("//dt[@class='last_item']//a[@class='cart_block_product_name'][contains(text(),'Faded Shor...')]"),30);
    }
}
