package praktikum.Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageRent {
    private final WebDriver driver;
    private final By headerAboutRent = By.className("Order_Header__BZXOb");
    private final By calendar = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By rentDays = By.className("Dropdown-placeholder");
    private final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private final By buttonForOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By windowConfirmOrder = By.className("Order_Modal__YZ-d3");
    private final By buttonYes = By.xpath(".//*[text() = 'Да']");
    private final By orderComplite = By.xpath(".//*[text() = 'Заказ оформлен']");

    public OrderPageRent(WebDriver driver) {
        this.driver = driver;
    }

    public void loadOrderPageRent() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until((driver1) -> this.driver.findElement(this.headerAboutRent).getText() != null && !this.driver.findElement(By.className("Order_Header__BZXOb")).getText().isEmpty());
    }

    public void inputDateOrder(String dateOrder) {
        this.driver.findElement(this.calendar).sendKeys(dateOrder);
        this.driver.findElement(this.calendar).sendKeys(Keys.ENTER);
    }

    public void inputRentalPeriod(String rental) {
        this.driver.findElement(this.rentDays).click();
        this.driver.findElement(By.xpath("//*[text() = '" + rental + "']")).click();
    }

    public void inputColor(String color) {
        this.driver.findElement(By.id(color)).click();
    }

    public void inputComment(String comment) {
        this.driver.findElement(this.commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        this.driver.findElement(this.buttonForOrder).click();
    }

    public void waitOrderWindow() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until(ExpectedConditions.presenceOfElementLocated(this.windowConfirmOrder));
        this.driver.findElement(this.buttonYes).click();
    }

    public boolean isOrderCreated() {
        return this.driver.findElement(this.orderComplite).isDisplayed();
    }
}
