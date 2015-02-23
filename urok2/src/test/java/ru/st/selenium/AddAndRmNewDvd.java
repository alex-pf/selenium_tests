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
  public void testAddAndRmNewDvd() throws Exception {    // Простая проверка авторизации
    driver.get(baseUrl + "php4dvd");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    // Проверка функционала добавления фильма в коллекцию
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Заполним поля формы
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("name"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

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
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'Страшилка (5014)')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Переходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Убедились - появилась плашка с фильмом
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Проверка функционала удаления фильма из коллекции
    driver.findElement(By.xpath("//*[@class='movie_box']/*[contains(text(),'Страшилка')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("a[onclick *= 'delete']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("a[onclick *= 'delete']")).click();
    // Подтвердили что хотим удалить фильм
    // Убедились - фильмов в коллекции нет, обновили данные, проверили ещё раз
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//*[@id='content']//a[@href=\"./?go=imdbupdate\"]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//*[@id='content']//a[@href=\"./?go=imdbupdate\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getElementIndex | //div[@id='results']/a/div | ]]
    // Проверка функционала выхода
    driver.findElement(By.xpath("//a[contains(@href,'profile')]")).click();
    // Убедились - мы авторизованы под admin
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'admin')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,\"logout\")]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (!isElementPresent(By.id("result"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

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