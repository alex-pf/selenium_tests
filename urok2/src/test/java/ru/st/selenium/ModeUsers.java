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

public class ModeUsers extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testModeUsers() throws Exception {    // Проверка функционала добавления, редактирования, удаления пользователей.
    driver.get(baseUrl + "/php4dvd/");
    // Добавляем двух пользователей, с правами редаетор  и гость
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("User management")).click();
    // Убедились - таких пользователей в базе нет
    assertFalse(isElementPresent(By.linkText("ed@ed.ru")));
    assertFalse(isElementPresent(By.linkText("gu@gu.ru")));
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("ed");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("ed@ed.ru");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("ed");
    driver.findElement(By.id("password2")).clear();
    driver.findElement(By.id("password2")).sendKeys("ed");
    new Select(driver.findElement(By.name("permission"))).selectByVisibleText("Editor");
    driver.findElement(By.name("submit")).click();
    assertEquals("ed@ed.ru", driver.findElement(By.xpath("//tr[2]/td[3]/a")).getText());
    assertEquals("Editor", driver.findElement(By.xpath("//tr[2]/td[4]")).getText());
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("gu");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("gu@gu.ru");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("gu");
    driver.findElement(By.id("password2")).clear();
    driver.findElement(By.id("password2")).sendKeys("gu");
    driver.findElement(By.name("submit")).click();
    assertEquals("gu@gu.ru", driver.findElement(By.xpath("//tr[3]/td[3]/a")).getText());
    assertEquals("Guest (view only)", driver.findElement(By.xpath("//tr[3]/td[4]")).getText());
    driver.findElement(By.linkText("Home")).click();
    // Редактируем пользователей
    driver.findElement(By.linkText("User management")).click();
    // Убедиличь - наши пользователи наместе
    assertTrue(isElementPresent(By.linkText("ed@ed.ru")));
    assertTrue(isElementPresent(By.linkText("gu@gu.ru")));
    driver.findElement(By.xpath("(//img[@alt='Edit'])[2]")).click();
    assertEquals("Edit ed", driver.findElement(By.cssSelector("h2")).getText());
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("ed@ed.ruuu");
    driver.findElement(By.name("submit")).click();
    assertTrue(isElementPresent(By.linkText("ed@ed.ruuu")));
    driver.findElement(By.xpath("(//img[@alt='Edit'])[2]")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("ed@ed.ru");
    driver.findElement(By.name("submit")).click();
    assertTrue(isElementPresent(By.linkText("ed@ed.ru")));
    driver.findElement(By.xpath("(//img[@alt='Edit'])[3]")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("gu");
    driver.findElement(By.id("password2")).clear();
    driver.findElement(By.id("password2")).sendKeys("gu");
    driver.findElement(By.name("submit")).click();
    assertEquals("User management", driver.findElement(By.cssSelector("h2")).getText());
    assertTrue(isElementPresent(By.linkText("ed@ed.ru")));
    assertTrue(isElementPresent(By.linkText("gu@gu.ru")));
    driver.findElement(By.linkText("Home")).click();
    // Удаляем пользователей
    driver.findElement(By.linkText("User management")).click();
    // Убедиличь - наши пользователи наместе
    assertTrue(isElementPresent(By.linkText("ed@ed.ru")));
    assertTrue(isElementPresent(By.linkText("gu@gu.ru")));
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    // Убедились - пользователей не стало
    assertFalse(isElementPresent(By.linkText("ed@ed.ru")));
    assertFalse(isElementPresent(By.linkText("gu@gu.ru")));
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//li[4]/a"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//li[4]/a")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
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