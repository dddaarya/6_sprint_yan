package ru.yandex.praktikum.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.yandex.praktikum.BaseTest;
import ru.yandex.praktikum.pageobject.MainPage;
import ru.yandex.praktikum.pageobject.OrderPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderScooterTest extends BaseTest {

    static Stream<Arguments> getOrderData() {
        return Stream.of(
                Arguments.of("Иван", "Иванов", "Москва, Тверская, 1",
                        "Сокольники", "+79991234567", "01.03.2026",
                        "сутки", "black", "Позвоните за час"),
                Arguments.of("Мария", "Петрова", "Санкт-Петербург, Невский, 5",
                        "Черкизовская", "+79997654321", "15.03.2026",
                        "двое суток", "grey", "Оставить у двери")
        );
    }

    @ParameterizedTest
    @MethodSource("getOrderData")
    public void shouldCreateOrderFromTopButton(String firstName, String lastName,
                                               String address, String metro,
                                               String phone, String date,
                                               String rental, String color,
                                               String comment) {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookieIfPresent();
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.fillFirstName(firstName);
        orderPage.fillLastName(lastName);
        orderPage.fillAddress(address);
        orderPage.selectMetro(metro);
        orderPage.fillPhone(phone);
        orderPage.clickNextButton();

        orderPage.fillDate(date);
        orderPage.selectRentalPeriod(rental);
        orderPage.selectColor(color);
        orderPage.fillComment(comment);
        orderPage.clickOrderButton();
        orderPage.confirmOrder();

        assertTrue(orderPage.isOrderSuccessDisplayed());
    }

    @ParameterizedTest
    @MethodSource("getOrderData")
    public void shouldCreateOrderFromBottomButton(String firstName, String lastName,
                                                  String address, String metro,
                                                  String phone, String date,
                                                  String rental, String color,
                                                  String comment) {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookieIfPresent();
        mainPage.scrollToBottomOrderButton();
        mainPage.clickBottomOrderButton();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.fillFirstName(firstName);
        orderPage.fillLastName(lastName);
        orderPage.fillAddress(address);
        orderPage.selectMetro(metro);
        orderPage.fillPhone(phone);
        orderPage.clickNextButton();

        orderPage.fillDate(date);
        orderPage.selectRentalPeriod(rental);
        orderPage.selectColor(color);
        orderPage.fillComment(comment);
        orderPage.clickOrderButton();
        orderPage.confirmOrder();

        assertTrue(orderPage.isOrderSuccessDisplayed());
    }
}
