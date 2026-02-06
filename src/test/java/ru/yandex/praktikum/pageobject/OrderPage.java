package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpened() {
        return driver.getCurrentUrl().contains("/order");
    }
}
