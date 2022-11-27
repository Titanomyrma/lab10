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
public class IkijiProductPage {
    private static final String HOMEPAGE_URL="https://store.ikiji.jp/products/tps-sweat-shirttps%E7%B8%AB%E8%A3%BD%E8%A3%8F%E8%B5%B7%E6%AF%9B%E3%82%B9%E3%82%A6%E3%82%A7%E3%83%83%E3%83%88%E3%82%B7%E3%83%A3%E3%83%84-br-22aw%E6%96%B0%E8%89%B2?variant=42814778572957";
    private WebDriver driver;


    @FindBy(xpath = "//button[@class=\"ProductForm__AddToCart Button Button--secondary Button--full\"]")
    private WebElement addToCartButton;

    public IkijiProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public IkijiProductPage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"ProductForm__AddToCart Button Button--secondary Button--full\"]")));

        return this;
    }

    public IkijiProductPage addToCart(){
        addToCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"Cart__Checkout Button Button--primary Button--full\"]")));
        return this;
    }
}
