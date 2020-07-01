import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class PracticeTest {

    private WebDriver driver;
    protected Women women;
    protected TShirts tShirts;
    protected HomePage homepage;
    protected Actions action;
    protected Dresses dresses;
    protected Cart cart;
    protected ShoppingActions shoppingActions;
    //protected CartSummary summary;
    ChromeOptions options = new ChromeOptions();
    Duration duration = Duration.ofSeconds(5);

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        action = new Actions(driver);
        women = new Women(driver);
        dresses = new Dresses(driver);
        tShirts = new TShirts(driver);
        cart = new Cart(driver);
        shoppingActions = new ShoppingActions(driver);
        //summary = new CartSummary(driver);
        homepage = new HomePage(driver);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        String baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    //@After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void CheckNumbOfItem() {
        //Check and add 1 woman item to cart
        Assert.assertTrue(women.getWomenBtn().isDisplayed());
        action.moveToElement(women.getWomenBtn()).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        women.getWomenBtn().click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Assert.assertEquals(women.getWomenCount().size(),7);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(women.getWomanProduct(2)).perform();
        Assert.assertTrue(women.getWomanProduct(2).isDisplayed());
        action.moveToElement(shoppingActions.getWomanAddToCartBtn()).perform();
        Assert.assertTrue(shoppingActions.getWomanAddToCartBtn().isDisplayed());
        action.click(shoppingActions.getWomanAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();
        //Check and add 1 dress item to cart
        Assert.assertTrue(dresses.getDressesBtn().isDisplayed());
        action.moveToElement(dresses.getDressesBtn()).perform();
        dresses.getDressesBtn().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(dresses.getDressesCount().size(), 5);
        action.moveToElement(dresses.getDressesProduct(1)).perform();
        Assert.assertTrue(dresses.getDressesProduct(1).isDisplayed());
        action.moveToElement(shoppingActions.getDressAddToCartBtn()).perform();
        Assert.assertTrue(shoppingActions.getDressAddToCartBtn().isDisplayed());
        action.click(shoppingActions.getDressAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();
        ////Check and add 1 tshirt item to cart
        action.moveToElement(tShirts.getTShirtsBtn()).perform();
        tShirts.getTShirtsBtn().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(tShirts.getTShirtsCount().size(),1);
        action.moveToElement(tShirts.getTShirtsProduct(1)).perform();
        action.moveToElement(shoppingActions.getTShirtAddToCartBtn()).perform();
        Assert.assertTrue(shoppingActions.getTShirtAddToCartBtn().isDisplayed());
        action.click(shoppingActions.getTShirtAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();
        //Check items in cart
        action.moveToElement(cart.getCartTab()).perform();
        Assert.assertEquals(women.getWomenProductAttribute().getText(), "Blouse");
        Assert.assertEquals(dresses.getDressesProductAttribute().getText(), "Printed Dress");
        Assert.assertEquals(tShirts.getTShirtProductAttribute().getText(), "Faded Shor...");
        //Delete item from cart
        action.click(cart.getCartProductDeleteX(1)).build().perform();
        action.moveToElement(homepage.getSearchField()).perform();
        action.click(homepage.getSearchField()).sendKeys("Blouse").build().perform();
        action.click(homepage.getSearchItem()).build().perform();

    }


}


