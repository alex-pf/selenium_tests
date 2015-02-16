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

public class LoginAddDvdRmDvdLogout extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testLoginAddDvdRmDvdLogout() throws Exception {    // Простая проверка авторизации
    driver.get("http://192.168.2.1/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("My profile")).click();
    // Убедились - в h2 страницы есть имя пользователя под которым мы вошли
    assertEquals("Edit admin", driver.findElement(By.cssSelector("h2")).getText());
    // Уходим на домашнюю страницу
    driver.findElement(By.linkText("Home")).click();
    // Проверка функционала добавления фильма в коллекцию
    // К началу теста мы должны быть авторизованы и на домашней странице
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    // Ищем фильм в базе
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Space")).click();
    // Выбрали фильм и сохранили
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    // Переходим на домашнюю страницу
    driver.findElement(By.linkText("Home")).click();
    // Убедились - появилась плашка с фильмом
    assertTrue(isElementPresent(By.xpath("//div[@id='results']/a/div")));
    // Убедились - название фильма соответствует
    assertEquals("Space", driver.findElement(By.xpath("//a/div/div[2]")).getText());
    // Проверка функционала удаления фильма из коллекции
    // До начала теста мы должны быть авторизованы, фильм должен быть в коллекции, начало теста на домашней странице
    driver.findElement(By.linkText("Home")).click();
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
    // Проверка функционала выхода
    // На момент начала теста мы должны быть авторизованы под admin
    driver.findElement(By.linkText("My profile")).click();
    // Убедились - мы авторизованы под admin
    assertEquals("Edit admin", driver.findElement(By.xpath("//h2")).getText());
    driver.findElement(By.linkText("Log out")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
    driver.quit();
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