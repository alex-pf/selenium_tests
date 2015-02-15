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

public class AddDvd extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testAddDvd() throws Exception {    // Проверка функционала добавления фильма в коллекцию
    // К началу теста мы должны быть авторизованы и на домашней странице
    driver.get(baseUrl + "/php4dvd/");
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