package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstNameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropdown = By.xpath("//div[contains(@class,'Dropdown-placeholder')]");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    private final By confirmButton = By.xpath("//button[text()='Да']");

    private final By orderSuccessMessage = By.xpath("//div[contains(text(),'Заказ оформлен')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOpened() {
        return driver.getCurrentUrl().contains("/order");
    }

    public void fillFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetro(String metro) {
        driver.findElement(metroInput).click();
        By metroStation = By.xpath("//div[contains(@class,'select-search__option') and contains(text(),'" + metro + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(metroStation));
        driver.findElement(metroStation).click();
    }

    public void fillPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateInput));
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(dateInput).click(); // Закрыть календарь
    }

    public void selectRentalPeriod(String period) {
        driver.findElement(rentalPeriodDropdown).click();
        By periodOption = By.xpath("//div[@class='Dropdown-option' and text()='" + period + "']");
        wait.until(ExpectedConditions.elementToBeClickable(periodOption));
        driver.findElement(periodOption).click();
    }

    public void selectColor(String color) {
        By colorCheckbox = By.xpath("//input[@id='" + color + "']");
        driver.findElement(colorCheckbox).click();
    }


    public void fillComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        driver.findElement(confirmButton).click();
    }

    public boolean isOrderSuccessDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMessage));
        return driver.findElement(orderSuccessMessage).isDisplayed();
    }
}
