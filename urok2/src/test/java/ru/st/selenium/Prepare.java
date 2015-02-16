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

public class Prepare extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testPrepare() throws Exception {    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    // Добавим фильм " Космос: Далекие уголки"
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Космос: Далекие уголки")).click();
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    // Добавим фильм " Space"
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Space")).click();
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    // Добавим фильм " Космический джем"
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Космический джем")).click();
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    // Добавим фильм " Затерянные в космосе"
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Затерянные в космосе")).click();
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    // Добавим фильм "Space: 1999 "
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Space: 1999')]")).click();
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    // Добавим фильм " Dark Space"
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("space");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | selenium.browserbot.getCurrentWindow().scrollTo(100,800) | ]]
    driver.findElement(By.linkText("Dark Space")).click();
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Ну совсем тёмный глубокий и холодный");
    driver.findElement(By.cssSelector("img[alt=\"Save\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    // Уходим
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