package pl.coderslab.task2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.task1.MyStoreLoginPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ShoppingSteps {

    private WebDriver driver;
    private ShopClothesWindowPage clothesWindowPage;

    @Given("I'm on shop login page")
    public void imOnMyStoreLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @And("I login using {string} and {string}")
    public void iLoginUsing(String email, String password) {
        MyStoreLoginPage loginPage = new MyStoreLoginPage(driver);
        loginPage.loginAs("mhgwrsdzokmeyjvcha@cazlp.com", "haslo");
    }

    @And("I go to the clothes window")
    public void iGoToClothesWindow() {
        ShopLoginPage myAccountPage = new ShopLoginPage(driver);
        myAccountPage.goToClothesWindowPage();
        clothesWindowPage = new ShopClothesWindowPage(driver);
    }

    @Then("I choose proper product")
    public void iChooseProperProduct() {
        clothesWindowPage.chooseProperProduct();
    }

    @And("I choose the size {string}, quantity {string} and add products to the basket")
    public void iChooseSizeAndQuantity(String size, String quantity) {
        ShopProperProductDetailsPage newProductDetailsPage = new ShopProperProductDetailsPage(driver);
        newProductDetailsPage.chooseSizeAndQuantity(size);
    }

    @And("I go to basket to proceeded to checkout")
    public void iGoToBasketToProceedToCheckout() {
        ShopProceedToCheckoutPage proceedToCheckoutPage = new ShopProceedToCheckoutPage(driver);
        proceedToCheckoutPage.proceedToCheckout();
        proceedToCheckoutPage.lastCheckout();
    }

    @When("I confirm address, shipping method, payment and place order")
    public void iConfirmPersonalInformation() {
        ShopPersonalInformationPage personalInformationPage = new ShopPersonalInformationPage(driver);
        personalInformationPage.address();
        personalInformationPage.shippingMethod();
        personalInformationPage.shippingMethodConfirmationBtn();
        personalInformationPage.paymentMethod();
        personalInformationPage.termsAndRules();
        personalInformationPage.placeOrder();
    }

    @Then("I take a screenshot with order confirmation message, amount")
    public void iTakeScreenshotWithConfirmedMessage() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Users\\polky\\Desktop\\Przypadki testowe\\screen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @And("I go to orders history and details")
    public void iGoToOrdersHistoryAndDetails() {
        ShopOrdersDetailsPage ordersHistoryAndDetailsPage = new ShopOrdersDetailsPage(driver);
        ordersHistoryAndDetailsPage.goToAccountPage();
        ordersHistoryAndDetailsPage.goToOrderHistoryAndDetailsPage();
    }

    @And("I verify whether the order has {string} status")
    public void iCheckOrderStatusAndCheckAmount(String orderStatus) {
        WebElement orderStatusOnPage = driver.findElement
                (By.xpath("//tbody/tr[1]/td[4]/span[1]"));
        Assertions.assertEquals(orderStatus, orderStatusOnPage.getText());
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}