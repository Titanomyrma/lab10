package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.IkijiCartPage;
import pageobject_model.page.IkijiProductPage;

import java.time.Duration;

public class IkijiTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver= new ChromeDriver();
    }

    @Test
    public void increaseAmountOfItemByPlusButton(){
        new IkijiProductPage(driver)
                .openPage()
                .addToCart();

        String expectedProductAmount = new IkijiCartPage(driver)
                .plusButton()
                .getProductAmount();
        Assert.assertEquals(expectedProductAmount,"2","amount is not 2, its "+ expectedProductAmount);

    }

    @Test
    public void addProductToCart(){
        new IkijiProductPage(driver)
                .openPage()
                .addToCart();

        Boolean cartIsNotEmpty = new IkijiCartPage(driver)
                .isNotEmpty();
        Assert.assertTrue(cartIsNotEmpty);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
