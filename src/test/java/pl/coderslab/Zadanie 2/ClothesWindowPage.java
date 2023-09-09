package pl.coderslab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopClothesWindowPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Hummingbird printed sweater')]")
    private WebElement newProductBtn;

    public ShopClothesWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseProperProduct() {
        newProductBtn.click();
    }
}