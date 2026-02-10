package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private final WebDriver driver;

    private final By topOrderButton = By.xpath("//button[text()='Заказать' and contains(@class,'Button_Button')]");
    private final By bottomOrderButton = By.xpath("(//button[text()='Заказать'])[2]");
    private final By cookieButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCookieIfPresent() {
        List<WebElement> elements = driver.findElements(cookieButton);
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void scrollToBottomOrderButton() {
        WebElement element = driver.findElement(bottomOrderButton);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
