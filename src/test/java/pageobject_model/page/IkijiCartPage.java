package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IkijiCartPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"updates_42814778572957:2fe52fcb631dd3ae648b16da3b2b023d\"]")
    private WebElement productAmount;

    @FindBy(xpath = "//*[@id=\"shopify-section-cart-template\"]/section/div/div/form/div/div[2]/div[3]/div/div/a[2]")
    private WebElement plusButton;

    public IkijiCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public IkijiCartPage plusButton(){
        plusButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updates_42814778572957:2fe52fcb631dd3ae648b16da3b2b023d\"]")));
        return this;
    }

    public String getProductAmount(){
        return productAmount.getAttribute("value");
    }

    public boolean isNotEmpty()
    {
        return driver.findElements(By.xpath("//button[@class=\"Cart__Checkout Button Button--primary Button--full\"]")).size() != 0;
    }
}
