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
        Object[][] parameters = new Object[QUESTIONS.length][4];

        for (int i = 0; i < QUESTIONS.length; i++) {
            parameters[i][0] = QUESTIONS[i];
            parameters[i][1] = ANSWERS[i];
            parameters[i][2] = ITEM_ANSWERS[i];
            parameters[i][3] = TEXT_ANSWERS[i];
        }

        return parameters;
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
