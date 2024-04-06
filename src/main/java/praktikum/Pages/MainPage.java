//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package praktikum.Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final By homeHeader = By.cssSelector("[class*=Header_Logo__]");
    private final By questionsHeader = By.cssSelector("[class*=Header_Questions__]");
    private final By orderField = By.cssSelector(".Input_Input__1iN_Z");
    private final By orderStatusField = By.className("Header_Link__1TAG7");
    private final By goButton = By.cssSelector("[class*=Header_Button__]");
    private final By orderButton = By.cssSelector("[class*=Header_Button__]");
    private final By orderHeader = By.className("Order_Header__BZXOb");
    private final By buttonAcceptCookie = By.id("rcc-confirm-button");
    private final String cookieButton = "App_CookieButton__3cvqF";
    private final String ButtonForOrder = ".//button[@class='Button_Button__ra12g']";
    private final By midlButtonForOrder = By.cssSelector(".Button_Middle__1CSJM");
    private final By buttonOrderTop = By.xpath(".//div[starts-with(@class,'Header_Nav')]//button[text()='Заказать']");
    private final By buttonOrderBottom = By.xpath(".//div[contains(@class,'FinishButton')]//button[text()='Заказать']");
    private final By sectionFaq = By.xpath(".//div[starts-with(@class,'Home_FAQ')]");
    private final By accordionItem = By.className("accordion__item");
    private final By accordionButton = By.className("accordion__button");
    private final By accordionPanel = By.className("accordion__panel");
    private final By imageScooter = By.xpath(".//img[@alt = 'Scooter blueprint']");

    public void closeCookie() {
        this.driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    public StatusPage clickOnGo() {
        this.driver.findElement(this.goButton).click();
        return new StatusPage(this.driver);
    }

    public void enterOrderNumber(String orderNumber) {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until(ExpectedConditions.visibilityOfElementLocated(this.orderField));
        this.driver.findElement(this.orderField).sendKeys(new CharSequence[]{orderNumber});
    }

    public void open() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOnOrderStatus() {
        this.driver.findElement(this.orderStatusField).click();
    }

    public MainPage waitForLoadMainPage() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until(ExpectedConditions.textToBePresentInElementLocated(this.homeHeader, "expectedText"));
        return this;
    }

    public MainPage scrollToQuestions() {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{this.driver.findElement(this.questionsHeader)});
        return this;
    }

    public MainPage clickQuestion(By question) {
        ((WebElement)(new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until(ExpectedConditions.elementToBeClickable(question))).click();
        return this;
    }

    public MainPage waitLoadAfterClickQuestion(By labelResult) {
        (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until(ExpectedConditions.visibilityOfElementLocated(labelResult));
        return this;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadFaq() {
        WebElement faqElement = this.driver.findElement(this.sectionFaq);
        (new WebDriverWait(this.driver, Duration.ofSeconds(3L))).until(ExpectedConditions.visibilityOfElementLocated(this.sectionFaq));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{faqElement});
    }

    public void waitForLoadPage() {
        WebElement imageElement = this.driver.findElement(this.imageScooter);
        (new WebDriverWait(this.driver, Duration.ofSeconds(3L))).until(ExpectedConditions.visibilityOfElementLocated(this.imageScooter));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{imageElement});
    }

    public boolean isElementExist(By locatorBy) {
        try {
            this.driver.findElement(locatorBy);
            return true;
        } catch (NoSuchElementException var3) {
            return false;
        }
    }

    public List<WebElement> getFaqItems() {
        return this.driver.findElements(this.accordionItem);
    }

    public boolean isButtonClickable(WebElement faqElement) {
        try {
            (new WebDriverWait(this.driver, Duration.ofSeconds(2L))).until(ExpectedConditions.elementToBeClickable(faqElement.findElement(this.accordionButton)));
            return true;
        } catch (NoSuchElementException var3) {
            return false;
        }
    }

    public String getQuestion(WebElement faqElement) {
        return faqElement.findElement(this.accordionButton).getText();
    }

    public String getAnswer(WebElement faqElement) {
        return faqElement.findElement(this.accordionPanel).getText();
    }

    public void clickOrder(int indexButton) {
        switch (indexButton) {
            case 0:
                this.driver.findElement(this.buttonOrderTop).click();
                break;
            case 1:
                JavascriptExecutor js = (JavascriptExecutor)this.driver;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
                WebElement buttonOrder = this.driver.findElement(this.buttonOrderBottom);
                (new WebDriverWait(this.driver, Duration.ofSeconds(10L))).until((driver) -> {
                    return buttonOrder.isDisplayed();
                });
                buttonOrder.click();
        }

    }

    public void clickGetCookie() {
        if (this.isElementExist(this.buttonAcceptCookie)) {
            this.driver.findElement(this.buttonAcceptCookie).click();
        }

    }

    public void OrderButtonClick() {
        this.driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g']")).click();
    }

    public void MidlOrderButton() {
        WebElement element = this.driver.findElement(this.midlButtonForOrder);
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        this.driver.findElement(this.midlButtonForOrder).click();
    }
}









//
//package praktikum.Pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import praktikum.Pages.EnvConfig;
//
//import java.time.Duration;
//
//public class MainPage {
//
//    private final By orderField = By.cssSelector(".Input_Input__1iN_Z");
//    private final By orderStatusField = By.className("Header_Link__1TAG7");
//    private final By goButton = By.cssSelector("[class*=Header_Button__]");
//    private final WebDriver driver;
//
//    public MainPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public StatusPage clickOnGo() {
//        driver.findElement(goButton).click();
//
//        return new StatusPage(driver);
//    }
//
//    public void enterOrderNumber(String orderNumber) {
//        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
//                .until(ExpectedConditions.visibilityOfElementLocated(orderField));
//
//        driver.findElement(orderField).sendKeys(orderNumber);
//    }
//    public void open() {
//        driver.get(EnvConfig.BASE_URL);
//    }
//
//    public void clickOnOrderStatus() {
//        driver.findElement(orderStatusField).click();
//    }
//}
