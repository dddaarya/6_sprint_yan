package ru.yandex.praktikum.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pageobject.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FaqTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "0, Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "1, Пока что у нас так: один заказ — один самокат.",
            "2, Допустим, вы оформляете заказ на 8 мая."
    })
    public void faqAnswerIsShown(int index, String expectedTextPart) {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickQuestion(index);
        String actual = mainPage.getAnswerText(index);

        System.out.println("ANSWER " + index + " = " + actual);

        assertTrue(actual.contains(expectedTextPart),
                "Ответ не содержит ожидаемый текст: " + expectedTextPart);
    }

}
