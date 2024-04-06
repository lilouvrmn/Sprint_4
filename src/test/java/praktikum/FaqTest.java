package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.Pages.MainPage;

@RunWith(Parameterized.class)
public class FaqTest {
    private WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";
    private final By question;
    private final By answer;
    private final By labelResult;
    private final String expected;

    public FaqTest(By question, By answer, By labelResult, String expected) {
        this.question = question;
        this.answer = answer;
        this.labelResult = labelResult;
        this.expected = expected;
    }

    @Parameters
    public static Object[][] getParameters() {
        return new Object[][]{{praktikum.Pages.FaqTest.QUESTION_0, praktikum.Pages.FaqTest.ANSWER_0, praktikum.Pages.FaqTest.ITEM_ANSWER_0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."}, {praktikum.Pages.FaqTest.QUESTION_1, praktikum.Pages.FaqTest.ANSWER_1, praktikum.Pages.FaqTest.ITEM_ANSWER_1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}, {praktikum.Pages.FaqTest.QUESTION_2, praktikum.Pages.FaqTest.ANSWER_2, praktikum.Pages.FaqTest.ITEM_ANSWER_2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."}, {praktikum.Pages.FaqTest.QUESTION_3, praktikum.Pages.FaqTest.ANSWER_3, praktikum.Pages.FaqTest.ITEM_ANSWER_3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."}, {praktikum.Pages.FaqTest.QUESTION_4, praktikum.Pages.FaqTest.ANSWER_4, praktikum.Pages.FaqTest.ITEM_ANSWER_4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."}, {praktikum.Pages.FaqTest.QUESTION_5, praktikum.Pages.FaqTest.ANSWER_5, praktikum.Pages.FaqTest.ITEM_ANSWER_5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."}, {praktikum.Pages.FaqTest.QUESTION_6, praktikum.Pages.FaqTest.ANSWER_6, praktikum.Pages.FaqTest.ITEM_ANSWER_6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}, {praktikum.Pages.FaqTest.QUESTION_7, praktikum.Pages.FaqTest.ANSWER_7, praktikum.Pages.FaqTest.ITEM_ANSWER_7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}};
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkQuestions() {
        (new MainPage(this.driver)).waitForLoadMainPage().scrollToQuestions().clickQuestion(this.question).waitLoadAfterClickQuestion(this.labelResult);
        String result = this.driver.findElement(this.answer).getText();
        Assert.assertEquals(this.expected, result);
    }

    @After
    public void teardown() {
        this.driver.quit();
    }
}
