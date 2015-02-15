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

public class AddAndRmNewDvd extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testAddAndRmNewDvd() throws Exception {    // Проверка функционала добавления фильма в коллекцию
    // К началу теста мы должны быть авторизованы и на домашней странице
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    // Заполним поля формы
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Страшилка");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Киношка про тёмную тёную комнату...");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("5014");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("120");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("5");
    driver.findElement(By.id("own_no")).click();
    driver.findElement(By.id("seen_no")).click();
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("russian");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("russia");
    // Сохраним фильм
    driver.findElement(By.id("submit")).click();
    // Убедимся, что фильм сохранился
    assertEquals("Страшилка (5014)", driver.findElement(By.cssSelector("h2")).getText());
    driver.findElement(By.linkText("Home")).click();
    // Убедимся, что фильм виден на главной странице
    assertTrue(isElementPresent(By.xpath("//div[@id='results']/a/div")));
    assertEquals("Страшилка", driver.findElement(By.xpath("//a/div/div[2]")).getText());
    // Проверка функционала удаления фильма из коллекции
    // До начала теста мы должны быть авторизованы, фильм должен быть в коллекции, начало теста на домашней странице
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