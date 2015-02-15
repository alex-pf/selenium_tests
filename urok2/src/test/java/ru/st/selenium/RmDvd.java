package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RmDvd extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testRmDvd() throws Exception {    // Проверка функционала удаления фильма из коллекции
    // До начала теста мы должны быть авторизованы, фильм должен быть в коллекции, начало теста на домашней странице
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.xpath("//a/div/div/div")).click();
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Вернулись на домашнюю страницу
    driver.findElement(By.linkText("Home")).click();
    // Убедились - фильмов в коллекции нет, обновили данные, проверили ещё раз
    // ERROR: Caught exception [ERROR: Unsupported command [getElementIndex | //div[@id='results']/a/div | ]]
    driver.findElement(By.cssSelector("img[alt=\"Update all\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getElementIndex | //div[@id='results']/a/div | ]]
    driver.findElement(By.linkText("Home")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}