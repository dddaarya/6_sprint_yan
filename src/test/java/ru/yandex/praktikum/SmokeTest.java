package ru.yandex.praktikum;

import org.junit.jupiter.api.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openMainPageTest() {
        String title = driver.getTitle();
        System.out.println("Page title = " + title);
    }
}
