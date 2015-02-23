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

public class CleanBD extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testCleanBD() throws Exception {    // Поехали уже, тестировать
    driver.get(baseUrl + "/php4dvd/");
    // Авторизация
    driver.findElement(By.xpath("//a[contains(@href, 'en_US')]")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//li[3]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Возвращаем в норму сортировки
    // Возвращаем сортировку по алфавиту
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='sort-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='sort-menu']/li[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='sort-menu']/li[1] | ]]
    // Возвращаем все категории
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='category-menu']/li[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='category-menu']/li[1] | ]]
    // Возвращаем значение по умолчанию - "все результаты на одной странице"
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='n-button']/span[2] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseDown | //*[@id='n-menu']/li[1] | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [mouseUp | //*[@id='n-menu']/li[1] | ]]
    // Чистим базу  1-------------------------------------------------------------!!!
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.title")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@onclick,'go=delete')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@onclick,'go=delete')]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Переходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Чистим базу 2
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.title")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@onclick,'go=delete')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@onclick,'go=delete')]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Переходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Чистим базу 3
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.title")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@onclick,'go=delete')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@onclick,'go=delete')]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Переходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Чистим базу 4
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.title")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@onclick,'go=delete')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@onclick,'go=delete')]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Переходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Чистим базу 5
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.title")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@onclick,'go=delete')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@onclick,'go=delete')]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Переходим на домашнюю страницу
    driver.findElement(By.xpath("//nav//li[1]/a")).click();
    // Чистим базу 6
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.title"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("div.title")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@onclick,'go=delete')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@onclick,'go=delete')]")).click();
    // Подтвердили что хотим удалить фильм
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Уходим
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,\"logout\")]"))) break; } catch (Exception e) {}
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