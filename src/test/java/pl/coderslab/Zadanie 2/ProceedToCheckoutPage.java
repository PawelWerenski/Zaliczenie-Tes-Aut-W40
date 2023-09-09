package pl.coderslab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopProceedToCheckoutPage {

    private final WebDriver driver;

    @FindBy(xpath = "//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/i[1]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement lastCheckoutBtn;

    public ShopProceedToCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }

    public void lastCheckout() {
        lastCheckoutBtn.click();
    }
}