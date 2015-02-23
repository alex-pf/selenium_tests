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
    driver.get(baseUrl + "php4dvd");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'profile')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'profile')]")).click();
    // Убедились - в h2 страницы есть имя пользователя под которым мы вошли
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'admin')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Уходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Проверка функционала добавления фильма в коллекцию
    // К началу теста мы должны быть авторизованы и на домашней странице
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'go=add')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,'go=add')]")).click();
    // Ищем фильм в базе
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("imdbsearch"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//td[contains(text(),'1985')]/..//a[contains(text(),'Space')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//td[contains(text(),'1985')]/..//a[contains(text(),'Space')]")).click();
    // Выбрали фильм и сохранили
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.button a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.button a")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'Space (1985)')]"))) break; } catch (Exception e) {}
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
    driver.findElement(By.xpath("//*[@class='movie_box']/*[contains(text(),'Space')]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("a[onclick *= 'delete']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("a[onclick *= 'delete']")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Убедились - фильмов в коллекции нет, обновили данные, проверили ещё раз
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='results']/div"))) break; } catch (Exception e) {}
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
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//form[@id='loginform']"))) break; } catch (Exception e) {}
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