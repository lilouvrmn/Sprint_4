package praktikum.Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageOrder {
    private final WebDriver driver;
    private final By headerPage = By.className("Order_Header__BZXOb");
    private final By fieldName = By.xpath(".//input[@placeholder = '* Имя']");
    private final By fieldLastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By adressOrder = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By metroStation = By.xpath(".//input[@placeholder = '* Станция метро']");
    private final By dropListMetroStation = By.className("select-search__select");
    private final By fieldPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.cssSelector(".Button_Middle__1CSJM");

    public OrderPageOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        this.driver.findElement(this.fieldName).sendKeys(name);
    }

    public void inputLastName(String lastName) {
        this.driver.findElement(this.fieldLastName).sendKeys(lastName);
    }

    public void inputAddress(String address) {
        this.driver.findElement(this.adressOrder).sendKeys(address);
    }

    public void inputMetroStation(String station) {
        this.driver.findElement(this.metroStation).sendKeys(station);
        this.driver.findElement(this.dropListMetroStation).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(dropListMetroStation));

        WebElement element = driver.findElement(By.xpath("//button[@value = '"+station+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//button[@value = '"+station+"']")).click();
    }

    public void inputTelephoneNumber(String phoneNumber) {
        this.driver.findElement(this.fieldPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickNext() {
        this.driver.findElement(this.buttonNext).click();
    }

    public void loadOrderPageOrder() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until((driver1) -> this.driver.findElement(this.headerPage).getText() != null && !this.driver.findElement(By.className("Order_Header__BZXOb")).getText().isEmpty());
    }
}
