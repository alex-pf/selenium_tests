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

public class ModeEditorUser extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testModeEditorUser() throws Exception {    // Объявляем переменняе
    String uName = "editorUser";
    String uPass = "editorUser";
    String uMail = "editorUser@mail.ru";
    String uRole = "Editor";
    String uLocale = "en_US";
    String outMes = "Are you sure you want to log out?";
    String killMes = "Are you sure you want to remove this?";
    // Проверка функционала добавления, редактирования, удаления пользователей.
    // Авторизация
    driver.get(baseUrl + "/php4dvd/");
    // Вабрали язук приложения
    driver.findElement(By.xpath("//a[contains(@href, '" + uLocale + "')]")).click();
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

    driver.findElement(By.xpath("//li[3]/a")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("username"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Добавляем пользователя, с правами редаетор
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (!isElementPresent(By.xpath("//a[contains(text(),'" + uMail + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys(uName);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(uMail);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(uPass);
    driver.findElement(By.id("password2")).clear();
    driver.findElement(By.id("password2")).sendKeys(uPass);
    new Select(driver.findElement(By.name("permission"))).selectByVisibleText(uRole);
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'" + uMail + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//*[contains(text(),'" + uRole + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Редактируем пользователя
    driver.findElement(By.xpath("//a[contains(@href,'" + uMail + "')]/../..//a[contains(@href,\"go=user&id\")]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + uName + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("ed@ed.ruuu");
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[@href=\"mailto:ed@ed.ruuu\"]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[@href=\"mailto:ed@ed.ruuu\"]/../..//a[contains(@href,\"go=user&id\")]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h2[contains(text(),'" + uName + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(uMail);
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,'" + uMail + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(text(),'" + uMail + "')]/../../td[6]/a")).click();
    assertEquals(killMes, closeAlertAndGetItsText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(text(),'admin')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (!isElementPresent(By.xpath("//a[contains(text(),'" + uMail + "')]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Уходим
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[contains(@href,\"logout\")]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href,\"logout\")]")).click();
    assertEquals(outMes, closeAlertAndGetItsText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//form[@id='loginform']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//a[contains(@href, './?lang=en_US')]")).click();
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