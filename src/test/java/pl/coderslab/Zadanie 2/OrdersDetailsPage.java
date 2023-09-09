package pl.coderslab.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopOrdersDetailsPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Dawid Dziedzic']")
    private WebElement accountBtn;

    @FindBy(xpath = "//a[@id='history-link']//span[@class='link-item']")
    private WebElement orderHistoryAndDetailsBtn;

    @FindBy(xpath = "//tbody/tr[1]/td[4]/span[1]")
    private WebElement orderStatusField;

    public ShopOrdersDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAccountPage() {
        accountBtn.click();
    }

    public void goToOrderHistoryAndDetailsPage() {
        orderHistoryAndDetailsBtn.click();
    }

//    public boolean checkWhetherOrderStatusIsTheSame() {
//        String orderStatus = orderStatusField.getText();
//        if (orderStatus.equals("Awaiting check payment")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}