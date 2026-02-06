package ru.yandex.praktikum.tests;

import org.junit.jupiter.api.Test;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.OrderPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderScooterTest extends BaseTest {

    @Test
    public void canOpenOrderPageFromTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookieIfPresent();
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        assertTrue(orderPage.isOpened());
    }
}
