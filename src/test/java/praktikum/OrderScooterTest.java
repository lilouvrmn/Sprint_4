package praktikum;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.Pages.MainPage;
import praktikum.Pages.OrderPageOrder;
import praktikum.Pages.OrderPageRent;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private ChromeDriver driver;
    private final String name;
    private final String lastname;
    private final String address;
    private final int station;
    private final String phoneNumber;
    private final String dateOrder;
    private final String rental;
    private final String color;
    private final String comment;
    @Rule
    public DriverRule driverRule = new DriverRule();

    public OrderScooterTest(String name, String lastname, String address, int station, String phoneNumber, String dateOrder, String rental, String color, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.rental = rental;
        this.color = color;
        this.comment = comment;
    }

    @Parameters
    public static Object[][] data() {
        return new Object[][]{{"Юлия", "Верман", "Большая Академическая", 75, "+79991112233", "01.05.2024", "чёрный жемчуг", "Спасибо"}, {"Анастасия", "Осадченко", "Кутузовская", 24, "+79994445566", "10.05.2024", "серая безысходность", "Пожалуйста"}};
    }

    @Test
    public void OrderScooter() {
        WebDriver driver = this.driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.closeCookie();
        main.OrderButtonClick();
        OrderPageOrder order = new OrderPageOrder(driver);
        order.loadOrderPageOrder();
        order.inputName(this.name);
        order.inputLastName(this.lastname);
        order.inputAddress(this.address);
        order.inputMetroStation(String.valueOf(this.station));
        order.inputTelephoneNumber(this.phoneNumber);
        order.clickNext();
        OrderPageRent rent = new OrderPageRent(driver);
        rent.loadOrderPageRent();
        rent.inputDateOrder(this.dateOrder);
        rent.inputRentalPeriod(this.rental);
        rent.inputColor(this.color);
        rent.inputComment(this.comment);
        rent.clickOrderButton();
        rent.waitOrderWindow();
        rent.isOrderCreated();
        Assert.assertTrue("Заказ не оформлен", rent.isOrderCreated());
    }

    @Test
    public void OrderScooterMidlButton() {
        WebDriver driver = this.driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.closeCookie();
        main.MidlOrderButton();
        OrderPageOrder order = new OrderPageOrder(driver);
        order.loadOrderPageOrder();
        order.inputName(this.name);
        order.inputLastName(this.lastname);
        order.inputAddress(this.address);
        order.inputMetroStation(String.valueOf(this.station));
        order.inputTelephoneNumber(this.phoneNumber);
        order.clickNext();
        OrderPageRent rent = new OrderPageRent(driver);
        rent.loadOrderPageRent();
        rent.inputDateOrder(this.dateOrder);
        rent.inputRentalPeriod(this.rental);
        rent.inputColor(this.color);
        rent.inputComment(this.comment);
        rent.clickOrderButton();
        rent.waitOrderWindow();
        rent.isOrderCreated();
        Assert.assertTrue("Заказ не оформлен", rent.isOrderCreated());
    }
}
