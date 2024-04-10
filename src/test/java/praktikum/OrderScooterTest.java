package praktikum;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import praktikum.Pages.MainPage;
import praktikum.Pages.OrderPageOrder;
import praktikum.Pages.OrderPageRent;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderScooterTest {
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
    public DriverFactory driverFactory = new DriverFactory();

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
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Юлия", "Верман", "Большая Академическая", 75, "+79991112233", "01.05.2024", "2 суток", "чёрный жемчуг", "Спасибо"},
                {"Анастасия", "Осадченко", "Кутузовская", 24, "+79994445566", "10.05.2024", "3 суток", "серая безысходность", "Пожалуйста"}
    });}

        @Test
        public void orderScooter(){
            WebDriver driver = this.driverFactory.getDriver();
            MainPage main = new MainPage(driver);
            main.open();
            main.closeCookie();
            main.orderButtonClick();
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
    public void orderScooterMidlButton(){
        WebDriver driver = this.driverFactory.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.closeCookie();
        main.midlOrderButton();
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
