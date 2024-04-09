package praktikum.Pages;
import org.openqa.selenium.By;

public class FaqTest {
    public static final By[] QUESTIONS = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };

    public static final By[] ANSWERS = {
            By.id("accordion__panel"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };

    public static final By[] ITEM_ANSWERS = {
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-0']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-1']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-2']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-3']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-4']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-5']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-6']"),
            By.xpath(".//*[@data-accordion-component='AccordionItemPanel' and @aria-labelledby='accordion__heading-7']")
    };

    public static final String[] TEXT_ANSWERS = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
}