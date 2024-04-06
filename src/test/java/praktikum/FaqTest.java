package praktikum;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.Pages.MainPage;

import static praktikum.Pages.EnvConfig.BASE_URL;
import static praktikum.Pages.FaqTest.*;

@RunWith(Parameterized.class)
public class FaqTest {
    private WebDriver driver;
    private final String site = BASE_URL;
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
        return new Object[][]{
                {QUESTION_0, ANSWER_0, ITEM_ANSWER_0, TEXT_ANSWER_0},
                {QUESTION_1, ANSWER_1, ITEM_ANSWER_1, ITEM_ANSWER_1},
                {QUESTION_2, ANSWER_2, ITEM_ANSWER_2, ITEM_ANSWER_2},
                {QUESTION_3, ANSWER_3, ITEM_ANSWER_3, ITEM_ANSWER_3},
                {QUESTION_4, ANSWER_4, ITEM_ANSWER_4, ITEM_ANSWER_4},
                {QUESTION_5, ANSWER_5, ITEM_ANSWER_5, ITEM_ANSWER_5},
                {QUESTION_6, ANSWER_6, ITEM_ANSWER_6, ITEM_ANSWER_6},
                {QUESTION_7, ANSWER_7, ITEM_ANSWER_7, ITEM_ANSWER_7}};
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void checkQuestions() {
        (new MainPage(this.driver)).waitForLoadMainPage().scrollToQuestions().clickQuestion(this.question).waitLoadAfterClickQuestion(this.labelResult);
        String result = this.driver.findElement(this.answer).getText();
        Assert.assertEquals(this.expected, result);
    }
}
