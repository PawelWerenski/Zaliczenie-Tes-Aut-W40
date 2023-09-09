package pl.coderslab.task2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopProperProductDetailsPage {

    private final WebDriver driver;

    @FindBy(name = "group[1]")
    private WebElement sizeBtn;

    @FindBy(name = "qty")
    private WebElement quantityField;

    @FindBy(css = "button.btn.btn-primary.add-to-cart")
    private WebElement addToCartBtn;

    public ShopProperProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSizeAndQuantity(String size) {
        Select sizeSelect = new Select(sizeBtn);
        sizeSelect.selectByVisibleText(size);
        addToCartBtn.click();
    }
}