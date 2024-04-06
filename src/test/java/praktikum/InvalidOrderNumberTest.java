package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.Pages.MainPage;
import praktikum.Pages.StatusPage;

public class InvalidOrderNumberTest {
    private final String INVALID_ORDER_NUMBER = "123";
    @Rule
    public DriverRule driverRule = new DriverRule();

    public InvalidOrderNumberTest() {
    }

    @Test
    public void invalidOrderNumber() {
        WebDriver driver = this.driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.clickOnOrderStatus();
        main.enterOrderNumber("123");
        StatusPage status = main.clickOnGo();
        status.checkNotFound();
    }
}
